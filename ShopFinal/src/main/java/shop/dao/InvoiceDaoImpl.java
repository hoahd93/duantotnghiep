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
import shop.model.Invoice;
/**
 *
 * @author LENOVO
 */
@Repository
public class InvoiceDaoImpl implements InvoiceDao {
@Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public List<Invoice> getInvoiceByDay(Integer month) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ");
        sql.append("  orders.created_at, ");
        sql.append("  SUM(orderdetail.quantity) as quantity, ");
        sql.append("  SUM(orders.total_price) as total_price ");
        sql.append("  FROM ");
        sql.append("  TOrders orders INNER JOIN TOrders_detail orderdetail ");
        sql.append("  ON orders.order_id = orderdetail.order_id ");
        sql.append("  WHERE ");
        sql.append("  MONTH(orders.created_at) = ");
        sql.append(month);
        sql.append("  AND orders.del_flg = 0");
        sql.append("  GROUP BY ");
        sql.append("  orders.created_at");
        return jdbcTemplate.query(sql.toString(), new RowMapper<Invoice>() {
            @Override
            public Invoice mapRow(ResultSet rs, int rowNum) throws SQLException {
                Invoice invoice = new Invoice();
                invoice.setDateTime(rs.getDate("created_at").toString());
                invoice.setQuantity(rs.getInt("quantity"));
                invoice.setTotalPrice(rs.getDouble("total_price"));
                return invoice;
            }
        });
    }

    @Override
    public List<Invoice> getInvoiceByMonth(Integer year) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ");
        sql.append("  MONTH(orders.created_at) as month, ");
        sql.append("  SUM(orderdetail.quantity) as quantity, ");
        sql.append("  SUM(orders.total_price) as total_price ");
        sql.append("  FROM ");
        sql.append("  TOrders orders INNER JOIN TOrders_detail orderdetail ");
        sql.append("  ON orders.order_id = orderdetail.order_id ");
        sql.append("  WHERE ");
        sql.append("  YEAR(orders.created_at) = ");
        sql.append(year);
        sql.append("  AND orders.del_flg = 0");
        sql.append("  GROUP BY ");
        sql.append("  orders.created_at");
        return jdbcTemplate.query(sql.toString(), new RowMapper<Invoice>() {
            @Override
            public Invoice mapRow(ResultSet rs, int rowNum) throws SQLException {
                Invoice invoice = new Invoice();
                invoice.setDateTime(Integer.toString(rs.getInt("month")));
                invoice.setQuantity(rs.getInt("quantity"));
                invoice.setTotalPrice(rs.getDouble("total_price"));
                return invoice;
            }
        });
    }



}
