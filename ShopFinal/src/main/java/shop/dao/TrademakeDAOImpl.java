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
import shop.model.TrademarkModel;

/**
 *
 * @author LENOVO
 */
@Repository
public class TrademakeDAOImpl implements TrademarkDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int create(TrademarkModel object) {
        String sql = " INSERT INTO [dbo].[MTrademark] ([trademark_name], [create_date], [del_flg]) VALUES ( ?, ?, ?)";
        return jdbcTemplate.update(sql, new Object[]{object.getTrademarkName(), object.getCreateDate(), object.getDelFlg()});
    }

    @Override
    public int update(TrademarkModel object) {
        String sql = " UPDATE [dbo].[MTrademark] SET [trademark_name]=?, [update_date]=? WHERE [trademark_id] =?";
        return jdbcTemplate.update(sql, new Object[]{object.getTrademarkName(), object.getUpdateDate(), object.getTrademarkId()});
    }

    @Override
    public int delete(TrademarkModel object) {
        String sql = " UPDATE  [dbo].[MTrademark] SET [del_flg]=?  WHERE [trademark_id]=?";
        return jdbcTemplate.update(sql, new Object[]{object.getDelFlg(), object.getTrademarkId()});
    }

    @Override
    public TrademarkModel findById(int trademarkId) {
        String sql = "SELECT * FROM [dbo].[MTrademark] WHERE [trademark_id]=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{trademarkId}, new RowMapper<TrademarkModel>() {
            @Override
            public TrademarkModel mapRow(ResultSet rs, int rowNum) throws SQLException {
                TrademarkModel trade = new TrademarkModel();
                trade.setTrademarkId(rs.getInt(1));
                trade.setTrademarkName(rs.getString(2));
                trade.setCreateDate(rs.getDate(3));
                trade.setUpdateDate(rs.getDate(4));
                trade.setDelFlg(rs.getInt(5));
                return trade;
            }
        });
    }

    @Override
    public List<TrademarkModel> getAll() {
        String sql = " SELECT * FROM [dbo].[MTrademark] WHERE [del_flg]=0";
        return jdbcTemplate.query(sql, new RowMapper<TrademarkModel>() {
            @Override
            public TrademarkModel mapRow(ResultSet rs, int rowNum) throws SQLException {
                TrademarkModel trade = new TrademarkModel();
                trade.setTrademarkId(rs.getInt(1));
                trade.setTrademarkName(rs.getString(2));
                trade.setCreateDate(rs.getDate(3));
                trade.setUpdateDate(rs.getDate(4));
                trade.setDelFlg(rs.getInt(5));
                return trade;
            }
        });
    }

    @Override
    public List<TrademarkModel> findByName(String trademarkName) {
        String sql = " SELECT [trademark_id], [trademark_name], [create_date], [update_date] FROM [dbo].[MTrademark] WHERE [del_flg] = 0AND [trademark_name] LIKE N'%" + trademarkName + "%'";
        return jdbcTemplate.query(sql, new RowMapper<TrademarkModel>() {
            @Override
            public TrademarkModel mapRow(ResultSet rs, int rowNum) throws SQLException {
                TrademarkModel trade = new TrademarkModel();
                trade.setTrademarkId(rs.getInt("trademark_id"));
                trade.setTrademarkName(rs.getString("trademark_name"));
                trade.setCreateDate(rs.getDate("create_date"));
                trade.setUpdateDate(rs.getDate("update_date"));
                return trade;
            }
        });
    }

    @Override
    public List<TrademarkModel> getListTrandemarkByPageIndex(int firstIndex, int secondIndex) {
        String sql = "SELECT trademark_id\n"
                + "                , 	trademark_name\n"
                + "                ,	create_date\n"
                + "                ,	update_date\n"
                + "                FROM\n"
                + "                (SELECT trademark_id\n"
                + "                	, 	trademark_name\n"
                + "                	,	create_date\n"
                + "                	,	update_date \n"
                + "                	, 	ROW_NUMBER() OVER( ORDER BY trademark_name ASC)  AS number \n"
                + "                	FROM \n"
                + "                	[dbo].[MTrademark]\n"
                + "                	WHERE [del_flg]= 0 \n"
                + "                ) AS temp \n"
                + "               WHERE \n"
                + "               number BETWEEN ? AND ?";
        return jdbcTemplate.query(sql, new Object[]{firstIndex, secondIndex}, new RowMapper<TrademarkModel>() {
            @Override
            public TrademarkModel mapRow(ResultSet rs, int i) throws SQLException {
                TrademarkModel trademarkmodel = new TrademarkModel();
                trademarkmodel.setTrademarkId(rs.getInt("trademark_id"));
                trademarkmodel.setTrademarkName(rs.getString("trademark_name"));
                trademarkmodel.setCreateDate(rs.getDate("create_date"));
                trademarkmodel.setUpdateDate(rs.getDate("update_date"));
                return trademarkmodel;
            }
        });
    }

    @Override
    public Integer countTrademark() {
        String sql = " SELECT COUNT(*) FROM [dbo].[MTrademark] WHERE [del_flg]=0";
        return (int) jdbcTemplate.queryForObject(sql, Integer.class);
    }
}
