/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shop.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import shop.model.CategoryModel;

/**
 *
 * @author LENOVO
 */
@Repository
public class CategoryDAOImpl implements CategoryDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int create(CategoryModel object) {
        String sql = " INSERT INTO [dbo].[MCategory] ([name_category], [parent_id], [image], [create_date], [del_flg]) VALUES ( ?, ?, ?, ?, ?) ";
        return jdbcTemplate.update(sql, new Object[]{object.getNameCategory(), object.getParentId(), object.getImage(), object.getCreateDate(), object.getDelFlg()});
    }

    @Override
    public int update(CategoryModel object) {
        String sql = " UPDATE [dbo].[MCategory] SET [name_category]=?, [parent_id]=?, [image]=?, [update_date]=? WHERE [category_id]=? ";
        return jdbcTemplate.update(sql, new Object[]{object.getNameCategory(), object.getParentId(), object.getImage(), object.getUpdateDate(), object.getCategoryId()});
    }

    @Override
    public int delete(CategoryModel object) {
        String sql = " UPDATE [dbo].[MCategory] SET [del_flg]=?  WHERE [category_id] =? ";
        return jdbcTemplate.update(sql, new Object[]{object.getDelFlg(), object.getCategoryId()});
    }

    @Override
    public CategoryModel findById(int categoryId) {
        String sql = " SELECT * FROM [dbo].[MCategory] WHERE [category_id] = ? ";
        return jdbcTemplate.queryForObject(sql, new Object[]{categoryId}, new RowMapper<CategoryModel>() {
            @Override
            public CategoryModel mapRow(ResultSet rs, int rowNum) throws SQLException {
                  CategoryModel cat = new CategoryModel();
                cat.setCategoryId(rs.getInt(1));
                cat.setNameCategory(rs.getString(2));
                cat.setParentId(rs.getInt(3));
                cat.setImage(rs.getString(4));
                cat.setCreateDate(rs.getDate(5));
                cat.setUpdateDate(rs.getDate(6));
                cat.setDelFlg(rs.getInt(7));
                return cat;
            }
        });
    }

    @Override
    public List<CategoryModel> getAll() {
        String sql = " SELECT * FROM [dbo].[MCategory] WHERE [del_flg]= 0";
        return jdbcTemplate.query(sql, new RowMapper<CategoryModel>() {
            @Override
            public CategoryModel mapRow(ResultSet rs, int i) throws SQLException {
                CategoryModel cat = new CategoryModel();
                cat.setCategoryId(rs.getInt(1));
                cat.setNameCategory(rs.getString(2));
                cat.setParentId(rs.getInt(3));
                cat.setImage(rs.getString(4));
                cat.setCreateDate(rs.getDate(5));
                cat.setUpdateDate(rs.getDate(6));
                cat.setDelFlg(rs.getInt(7));
                return cat;
            }
        });
    }
        public List<CategoryModel> getAllAo(){
        String sql = " SELECT * FROM [dbo].[MCategory] WHERE [parent_id]=1 AND [del_flg]= 0 ";
        return jdbcTemplate.query(sql, new RowMapper<CategoryModel>() {
            @Override
            public CategoryModel mapRow(ResultSet rs, int rowNum) throws SQLException {
            CategoryModel cat = new CategoryModel();
                cat.setCategoryId(rs.getInt(1));
                cat.setNameCategory(rs.getString(2));
                cat.setParentId(rs.getInt(3));
                cat.setImage(rs.getString(4));
                cat.setCreateDate(rs.getDate(5));
                cat.setUpdateDate(rs.getDate(6));
                cat.setDelFlg(rs.getInt(7));
                return cat;
            }
        });
    }

    @Override
    public List<CategoryModel> findByName(String nameCategory) {
        String sql = " SELECT [category_id] , [name_category], [parent_id], [image], [create_date], [update_date]  FROM [dbo].[MCategory]"
                + " WHERE [del_flg]=0 AND [name_category] like N'%" + nameCategory + "%'";
        return jdbcTemplate.query(sql, new RowMapper<CategoryModel>() {
            @Override
            public CategoryModel mapRow(ResultSet rs, int rowNum) throws SQLException {
                CategoryModel catemodel = new CategoryModel();
                catemodel.setCategoryId(rs.getInt("category_id"));
                catemodel.setNameCategory(rs.getString("name_category"));
                catemodel.setParentId(rs.getInt("parent_id"));
                catemodel.setImage(rs.getString("image"));
                catemodel.setCreateDate(rs.getDate("create_date"));
                catemodel.setUpdateDate(rs.getDate("update_date"));
                return catemodel;
            }
        });
    }

}
