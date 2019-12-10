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
import shop.model.ColorModel;

/**
 *
 * @author LENOVO
 */
@Repository
public class ColorDAOImpl implements ColorDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int create(ColorModel object) {
        String sql = "INSERT INTO [dbo].[MColor]([name_color],[create_date],[del_flg]) values(?,?,?)";
        return jdbcTemplate.update(sql, new Object[]{object.getNameColor(), object.getCreateDate(), object.getDelFlg()});
    }

    // @Override
    public int update(ColorModel object) {
        String sql = " UPDATE [dbo].[MColor] SET [name_color]=?,[update_date]=? WHERE [color_id]=?";
        return jdbcTemplate.update(sql, new Object[]{object.getNameColor(), object.getUpdateDate(), object.getColorId()});
    }

    //@Override
    public int delete(ColorModel object) {
        String sql = " UPDATE [dbo].[MColor] SET [del_flg]=? WHERE [color_id]=?";
        return jdbcTemplate.update(sql, new Object[]{object.getDelFlg(), object.getColorId()});
    }

    @Override
    public ColorModel findById(int colorId) {
        String sql = " SELECT color_id,name_color,create_date,update_date FROM [dbo].[MColor] WHERE [color_id]=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{colorId}, new RowMapper<ColorModel>() {
            @Override
            public ColorModel mapRow(ResultSet rs, int rowNum) throws SQLException {
                ColorModel color = new ColorModel();
                color.setColorId(rs.getInt("color_id"));
                color.setNameColor(rs.getString("name_color"));
                color.setCreateDate(rs.getDate("create_date"));
                color.setUpdateDate(rs.getDate("update_date"));
                return color;
            }
        });
    }

    @Override
    public List<ColorModel> getAll() {
        String sql = " SELECT [color_id], [name_color] , [create_date], [update_date] FROM [dbo].[MColor] WHERE [del_flg]= 0";
        return jdbcTemplate.query(sql, new RowMapper<ColorModel>() {
            @Override
            public ColorModel mapRow(ResultSet rs, int i) throws SQLException {
                ColorModel colormodel = new ColorModel();
                colormodel.setColorId(rs.getInt("color_id"));
                colormodel.setNameColor(rs.getString("name_color"));
                colormodel.setCreateDate(rs.getDate("create_date"));
                colormodel.setUpdateDate(rs.getDate("update_date"));
                return colormodel;
            }
        });
    }

    @Override
    public List<ColorModel> findByName(String nameColor) {
        String sql = " SELECT [color_id], [name_color] , [create_date], [update_date]  FROM [dbo].[MColor] WHERE [del_flg]=0 AND [name_color] like N'%" + nameColor + "%'";
        return jdbcTemplate.query(sql, new RowMapper<ColorModel>() {
            @Override
            public ColorModel mapRow(ResultSet rs, int rowNum) throws SQLException {
                ColorModel colormodel = new ColorModel();
                colormodel.setColorId(rs.getInt("color_id"));
                colormodel.setNameColor(rs.getString("name_color"));
                colormodel.setCreateDate(rs.getDate("create_date"));
                colormodel.setUpdateDate(rs.getDate("update_date"));
                return colormodel;
            }
        });
    }
    
    @Override
    public List<ColorModel> getListColorByPageIndex(int firstIndex, int secondIndex){
        String sql = " SELECT " +
                "	[color_id]" +
                ", 	[name_color]" +
                ",	[create_date]" +
                ",	[update_date]" +
                "FROM" +
                "(" +
                "	SELECT " +
                "		[color_id]" +
                "	, 	[name_color]" +
                "	,	[create_date]" +
                "	,	[update_date] " +
                "	, 	ROW_NUMBER() OVER( ORDER BY [name_color] ASC)  AS number " +
                "	FROM " +
                "		[dbo].[MColor] " +
                "	WHERE [del_flg]= 0 " +
                ") AS temp " +
                "WHERE " +
                "	number BETWEEN ? AND ?";
        return jdbcTemplate.query(sql,new Object[]{firstIndex,secondIndex}, new RowMapper<ColorModel>() {
            @Override
            public ColorModel mapRow(ResultSet rs, int i) throws SQLException {
                ColorModel colormodel = new ColorModel();
                colormodel.setColorId(rs.getInt("color_id"));
                colormodel.setNameColor(rs.getString("name_color"));
                colormodel.setCreateDate(rs.getDate("create_date"));
                colormodel.setUpdateDate(rs.getDate("update_date"));
                return colormodel;
            }
        });
    }

    @Override
    public Integer countColor() {
        String sql = " SELECT COUNT(*) FROM [dbo].[MColor] WHERE [del_flg]=0";
        return (int)jdbcTemplate.queryForObject(sql,Integer.class);
    }
}
