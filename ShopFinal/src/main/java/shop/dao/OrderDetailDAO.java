/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shop.dao;

import java.util.List;
import shop.model.OrderDetailModel;

/**
 *
 * @author MauBV
 */
public interface OrderDetailDAO {
    
      // create
    public int create(OrderDetailModel object);

    // update
    public int update(OrderDetailModel object);

    // delete
    public int delete(OrderDetailModel object);

    // find by id
    public OrderDetailModel findById(int categoryId);

    // load list category
    public List<OrderDetailModel> getAll();
    //
    public List<OrderDetailModel> getOrderDetailByOrderId(Integer orderId);

    /**
     * @param orderId
     * @return
     */
   public List<OrderDetailModel> getOrderDetailByListOrderId(List<Integer> orderId);
}
