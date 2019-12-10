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
import shop.model.SizeModel;

/**
 *
 * @author LENOVO
 */
@Repository
public class SizeDAOImpl implements SizeDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int create(SizeModel object) {
        String sql = " INSERT INTO [dbo].[MSize] ([size_name], [create_date], [del_flg]) VALUES (?, ?, ?)";
        return jdbcTemplate.update(sql, new Object[]{object.getSizeName(), object.getCreateDate(), object.getDelFlg()});
    }

    @Override
    public int update(SizeModel object) {
        String sql = " UPDATE [dbo].[MSize] SET [size_name]=?, [update_date]=? WHERE [size_id]=? ";
        return jdbcTemplate.update(sql, new Object[]{object.getSizeName(), object.getUpdateDate(), object.getSizeId()});
    }

    @Override
    public int delete(SizeModel object) {
        String sql = " UPDATE [dbo].[MSize] SET [del_flg]=? WHERE [size_id]=? ";
        return jdbcTemplate.update(sql, new Object[]{object.getDelFlg(), object.getSizeId()});
    }

    @Override
    public SizeModel findById(int size_id) {
        String sql = " SELECT [size_id], [size_name], [create_date], [update_date] FROM [dbo].[MSize] WHERE [size_id]=? ";
        return jdbcTemplate.queryForObject(sql, new Object[]{size_id}, new RowMapper<SizeModel>() {
            @Override
            public SizeModel mapRow(ResultSet rs, int rowNum) throws SQLException {
                SizeModel sizemodel = new SizeModel();
                sizemodel.setSizeId(rs.getInt("size_id"));
                sizemodel.setSizeName(rs.getString("size_name"));
                sizemodel.setCreateDate(rs.getDate("create_date"));
                sizemodel.setUpdateDate(rs.getDate("update_date"));
                return sizemodel;
            }
        });
    }

    @Override
    public List<SizeModel> getAll() {
        String sql = " SELECT [size_id], [size_name], [create_date], [update_date]  FROM [dbo].[MSize] WHERE [del_flg]=0";
        return jdbcTemplate.query(sql, new RowMapper<SizeModel>() {
            @Override
            public SizeModel mapRow(ResultSet rs, int rowNum) throws SQLException {
                SizeModel sizemodel = new SizeModel();
                sizemodel.setSizeId(rs.getInt("size_id"));
                sizemodel.setSizeName(rs.getString("size_name"));
                sizemodel.setCreateDate(rs.getDate("create_date"));
                sizemodel.setUpdateDate(rs.getDate("update_date"));
                return sizemodel;
            }
        });
    }

    @Override
    public List<SizeModel> findByName(String sizeName) {
        String sql = " SELECT [size_id], [size_name], [create_date], [update_date]  FROM [dbo].[MSize] WHERE [del_flg]=0 AND [size_name] LIKE N'%" + sizeName + "%'";
        return jdbcTemplate.query(sql, new RowMapper<SizeModel>() {
            @Override
            public SizeModel mapRow(ResultSet rs, int rowNum) throws SQLException {
                SizeModel sizemodel = new SizeModel();
                sizemodel.setSizeId(rs.getInt("size_id"));
                sizemodel.setSizeName(rs.getString("size_name"));
                sizemodel.setCreateDate(rs.getDate("create_date"));
                sizemodel.setUpdateDate(rs.getDate("update_date"));
                return sizemodel;
            }
        });
    }

    @Override
    public List<SizeModel> getListSizeByPageIndex(int firstIndex, int secondIndex) {
        String sql = "SELECT size_id\n"
                + "                , 	size_name\n"
                + "                ,	create_date\n"
                + "                ,	update_date\n"
                + "                FROM\n"
                + "                (SELECT size_id\n"
                + "                	, 	size_name\n"
                + "                	,	create_date\n"
                + "                	,	update_date \n"
                + "                	, 	ROW_NUMBER() OVER( ORDER BY size_id DESC)  AS number \n"
                + "                	FROM \n"
                + "                	[dbo].[MSize]\n"
                + "                	WHERE [del_flg]= 0 \n"
                + "                ) AS temp \n"
                + "               WHERE \n"
                + "               number BETWEEN ? AND ?";
        return jdbcTemplate.query(sql, new Object[]{firstIndex, secondIndex}, new RowMapper<SizeModel>() {
            @Override
            public SizeModel mapRow(ResultSet rs, int i) throws SQLException {
                SizeModel Sizemodel = new SizeModel();
                Sizemodel.setSizeId(rs.getInt("size_id"));
                Sizemodel.setSizeName(rs.getString("size_name"));
                Sizemodel.setCreateDate(rs.getDate("create_date"));
                Sizemodel.setUpdateDate(rs.getDate("update_date"));
                return Sizemodel;
            }
        });
    }

    @Override
    public Integer countSize() {
        String sql = " SELECT COUNT(*) FROM [dbo].[MSize] WHERE [del_flg]=0";
        return (int) jdbcTemplate.queryForObject(sql, Integer.class);
    }

    //check trung ten kich thuoc
    @Override
    public SizeModel findByNameSize(String sizeName) {
        String sql = "SELECT        [size_id],\n"
                + "                 [size_name], \n"
                + "                 [create_date],\n"
                + "                 [update_date], [del_flg]\n"
                + "               FROM [dbo].[MSize] WHERE [size_name]=?";
        return jdbcTemplate.queryForObject(sql,new Object[]{sizeName}, new RowMapper<SizeModel>() {
            @Override
            public SizeModel mapRow(ResultSet rs, int i) throws SQLException {
                SizeModel sizemodel = new SizeModel();
                sizemodel.setSizeId(rs.getInt("size_id"));
                sizemodel.setSizeName(rs.getString("size_name"));
                sizemodel.setCreateDate(rs.getDate("create_date"));
                sizemodel.setUpdateDate(rs.getDate("update_date"));
                return sizemodel;
            }
        });
    }

}
