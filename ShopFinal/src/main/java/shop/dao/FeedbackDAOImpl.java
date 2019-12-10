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
import shop.model.FeedbackModel;

/**
 *
 * @author LENOVO
 */
public class FeedbackDAOImpl implements FeedbackDAO{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    public int create(FeedbackModel object){
        String sql = " INSERT INTO [dbo].[TFeedback] ([customer_id], [product_id], [description], [created_at]) VALUES (?, ?, ?, ?)";
        return jdbcTemplate.update(sql, new Object[]{object.getCustomerId(), object.getProductId(), object.getDescription(), object.getCreatedAt()});
    }
    
    public int update (FeedbackModel object){
        String sql = " UPDATE [dbo].[TFeedback] SET [customer_id]=?, [product_id]=?, [description]=?, [created_at]=? WHERE [feedback_id]=?";
        return jdbcTemplate.update(sql, new Object[]{object.getCustomerId(), object.getProductId(), object.getDescription(), object.getCreatedAt(), object.getFeedbackId()});
    }
    
    public int delete(FeedbackModel object){
        String sql =" DELETE FROM [dbo].[TFeedback] WHERE [feedback_id]=?";
        return jdbcTemplate.update(sql);
    }
    
    public List<FeedbackModel> getAll() {
        String sql = " SELECT * FROM [TFeedback] ";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<FeedbackModel>(FeedbackModel.class));
    }

    @Override
    public FeedbackModel findById(int categoryId) {
       String sql = " SELECT * FROM [dbo].[TFeedback] WHERE [feedback_id]=?";
       return jdbcTemplate.queryForObject(sql, new Object[categoryId], new BeanPropertyRowMapper<FeedbackModel>(FeedbackModel.class));
    }
}
