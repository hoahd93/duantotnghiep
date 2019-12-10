/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shop.dao;

import java.util.List;
import shop.model.FeedbackModel;

/**
 *
 * @author MauBV
 */
public interface FeedbackDAO {
      // create
    public int create(FeedbackModel object);

    // update
    public int update(FeedbackModel object);

    // delete
    public int delete(FeedbackModel object);

    // find by id
    public FeedbackModel findById(int categoryId);

    // load list category
    public List<FeedbackModel> getAll();
}
