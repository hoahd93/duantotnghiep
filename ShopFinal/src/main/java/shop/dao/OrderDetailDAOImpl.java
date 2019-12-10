/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shop.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import shop.model.OrderDetailModel;

/**
 *
 * @author LENOVO
 */
@Repository
public class OrderDetailDAOImpl implements OrderDetailDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int create(OrderDetailModel object) {
        String sql = " INSERT INTO [dbo].[TOrders_detail] ([order_id], [product_model_id], [price], [quantity], [discount_rate], [created_at]) VALUES (?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, new Object[] { object.getOrderId(), object.getProductModelId(), object.getPrice(), object.getQuantity(),
                object.getDiscountRate(), object.getCreatedAt() });
    }

    @Override
    public int update(OrderDetailModel object) {
        String sql = " UPDATE [dbo].[TOrders_detail] SET [order_id]=?, [product_model_id]=?, [price]=?, [quantity]=?, [discount_rate]=?, [created_at]=? WHERE [id]=?";
        return jdbcTemplate.update(sql, new Object[] { object.getOrderId(), object.getProductModelId(), object.getPrice(), object.getQuantity(),
                object.getDiscountRate(), object.getCreatedAt(), object.getId() });
    }

    @Override
    public int delete(OrderDetailModel object) {
        String sql = "DELETE FROM [dbo].[TOrders_detail] WHERE [id]=?";
        return jdbcTemplate.update(sql);
    }

    @Override
    public OrderDetailModel findById(int categoryId) {
        String sql = " SELECT * FROM [dbo].[TOrders_detail] WHERE [id]=?";
        return jdbcTemplate.queryForObject(sql, new Object[categoryId], new BeanPropertyRowMapper<OrderDetailModel>(OrderDetailModel.class));
    }

    @Override
    public List<OrderDetailModel> getAll() {
        String sql = " SELECT * FROM [dbo].[TOrders_detail]";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<OrderDetailModel>(OrderDetailModel.class));
    }

    @Override
    public List<OrderDetailModel> getOrderDetailByOrderId(Integer orderId) {
        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT * FROM [dbo].[TOrders_detail] WHERE [order_id] =?");
        return jdbcTemplate.query(sql.toString(), new Object[orderId], new BeanPropertyRowMapper<OrderDetailModel>(OrderDetailModel.class));
    }

    @Override
    public List<OrderDetailModel> getOrderDetailByListOrderId(List<Integer> orderId) {
        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT * FROM [dbo].[TOrders_detail] WHERE [order_id] IN ?");
        return jdbcTemplate.query(sql.toString(), new Object[] { orderId }, new BeanPropertyRowMapper<OrderDetailModel>(OrderDetailModel.class));
    }
}
