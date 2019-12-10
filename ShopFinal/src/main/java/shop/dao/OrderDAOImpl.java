/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shop.dao;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import shop.model.OrdersModel;

/**
 *
 * @author LENOVO
 */
@Repository
public class OrderDAOImpl implements OrderDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int create(OrdersModel object) {
        String sql = " INSERT INTO [dbo].[TOrders] ([order_code], [customer_id], [total_price], [status_order], [fullname], [address], [phone_number], [created_at], [update_time], [del_flg]) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, new Object[] { object.getOrderCode(), object.getCustomerId(), object.getTotalPrice(), object.getStatus(),
                object.getFullName(), object.getAddress(), object.getPhoneNumber(), object.getCreatedAt(), object.getUpdateTime(), object.getDelFlg() });
    }

    public int update(OrdersModel object) {
        String sql = " UPDATE [dbo].[TOrders] SET [order_code]=?, [customer_id]=?, [total_price]=?, [status_order]=?, [fullname]=?, [address]=?, [phone_number]=?, [created_at]=?, [update_time]=?, [del_flg]=? WHERE [order_id]=?";
        return jdbcTemplate.update(sql,
                new Object[] { object.getOrderCode(), object.getCustomerId(), object.getTotalPrice(), object.getStatus(), object.getFullName(),
                        object.getAddress(), object.getPhoneNumber(), object.getCreatedAt(), object.getUpdateTime(), object.getDelFlg(), object.getOrderId() });
    }

    public int delete(OrdersModel object) {
        String sql = " DELETE FROM [dbo].[TOrders] WHERE [order_id]=?";
        return jdbcTemplate.update(sql);
    }

    public OrdersModel findById(int orderId) {
        String sql = " SELECT * FROM [dbo].[TOrders] WHERE [order_id]=? ";
        return jdbcTemplate.queryForObject(sql, new Object[] { orderId }, new BeanPropertyRowMapper<OrdersModel>(OrdersModel.class));
    }

    public List<OrdersModel> getAll() {
        String sql = " SELECT * FROM [dbo].[TOrders] ";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<OrdersModel>(OrdersModel.class));
    }

    @Override
    public Boolean checkCodeExist(String orderCode) {
        String sql = " SELECT * FROM [dbo].[TOrders] WHERE [order_code]=? ";
        OrdersModel result = jdbcTemplate.queryForObject(sql, new Object[] { orderCode }, new BeanPropertyRowMapper<OrdersModel>(OrdersModel.class));
        if (Objects.isNull(result)) {
            return false;
        } else
            return true;
    }

    @Override
    public OrdersModel getOrderByCode(String orderCode) {
        String sql = " SELECT * FROM [dbo].[TOrders] WHERE [order_code]=? ";
        return jdbcTemplate.queryForObject(sql, new Object[] { orderCode }, new BeanPropertyRowMapper<OrdersModel>(OrdersModel.class));
    }

    @Override
    public List<OrdersModel> getByCustomerId(Integer customerId) {
        String sql = " SELECT * FROM [dbo].[TOrders] WHERE [customer_id]=? ";
        return jdbcTemplate.query(sql, new Object[] { customerId }, new BeanPropertyRowMapper<OrdersModel>(OrdersModel.class));
    }

}
