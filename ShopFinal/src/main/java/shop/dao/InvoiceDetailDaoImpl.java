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
import shop.model.InvoiceDetail;

/**
 *
 * @author LENOVO
 */
@Repository
public class InvoiceDetailDaoImpl implements InvoiceDetailDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<InvoiceDetail> getInvoiceDetailByDay(String day) {

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ");
        sql.append("  product.name, ");
        sql.append("  SUM(orderdetail.quantity) as quantity, ");
        sql.append("  productmodel.price, ");
        sql.append("  SUM(orderdetail.quantity)*productmodel.price as total_price ");
        sql.append("  FROM ");
        sql.append("  TOrders orders ");
        sql.append("  INNER JOIN TOrders_detail orderdetail ");
        sql.append("  ON orders.order_id = orderdetail.order_id ");
        sql.append("  INNER JOIN TProduct_model productmodel ");
        sql.append("  ON orderdetail.product_model_id = productmodel.product_model_id ");
        sql.append("  INNER JOIN TProduct product ");
        sql.append("  ON product.product_id = productmodel.product_id AND productmodel.del_flg = product.del_flg ");
        sql.append("  WHERE ");
        sql.append("  orders.created_at = ");
        sql.append("'");
        sql.append(day);
        sql.append("'");
        sql.append("  AND orders.del_flg = 0");
        sql.append("  GROUP BY ");
        sql.append("  orders.created_at, product.name, productmodel.price");
        return jdbcTemplate.query(sql.toString(), new RowMapper<InvoiceDetail>() {
            @Override
            public InvoiceDetail mapRow(ResultSet rs, int rowNum) throws SQLException {
                InvoiceDetail invoiceDetail = new InvoiceDetail();
                invoiceDetail.setProductName(rs.getString("name"));
                invoiceDetail.setQuantity(rs.getInt("quantity"));
                invoiceDetail.setPrice(rs.getDouble("price"));
                invoiceDetail.setTotalPrice(rs.getDouble("total_price"));
                return invoiceDetail;
            }
        });
    }

    @Override
    public List<InvoiceDetail> getInvoiceDetailByMonth(String month, String year) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ");
        sql.append("  product.name, ");
        sql.append("  SUM(orderdetail.quantity) as quantity, ");
        sql.append("  productmodel.price, ");
        sql.append("  SUM(orderdetail.quantity)*productmodel.price as total_price ");
        sql.append("  FROM ");
        sql.append("  TOrders orders ");
        sql.append("  INNER JOIN TOrders_detail orderdetail ");
        sql.append("  ON orders.order_id = orderdetail.order_id ");
        sql.append("  INNER JOIN TProduct_model productmodel ");
        sql.append("  ON orderdetail.product_model_id = productmodel.product_model_id ");
        sql.append("  INNER JOIN TProduct product ");
        sql.append("  ON product.product_id = productmodel.product_id AND productmodel.del_flg = product.del_flg ");
        sql.append("  WHERE ");
        sql.append("  MONTH(orders.created_at) = ");
        sql.append("'");
        sql.append(month);
        sql.append("'");
        sql.append("  AND YEAR(orders.created_at) = ");
        sql.append("'");
        sql.append(year);
        sql.append("'");
        sql.append("  AND orders.del_flg = 0");
        sql.append("  GROUP BY ");
        sql.append("  orders.created_at, product.name, productmodel.price");
        return jdbcTemplate.query(sql.toString(), new RowMapper<InvoiceDetail>() {
            @Override
            public InvoiceDetail mapRow(ResultSet rs, int rowNum) throws SQLException {
                InvoiceDetail invoiceDetail = new InvoiceDetail();
                invoiceDetail.setProductName(rs.getString("name"));
                invoiceDetail.setQuantity(rs.getInt("quantity"));
                invoiceDetail.setPrice(rs.getDouble("price"));
                invoiceDetail.setTotalPrice(rs.getDouble("total_price"));
                return invoiceDetail;
            }
        });
    }

}
