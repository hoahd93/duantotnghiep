/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shop.service;

import java.util.List;

import shop.model.OrderDetailModel;

/**
 *
 * @author LENOVO
 */
public interface OrderDetailService {
    /**
     * 
     * @param orderId
     * @return
     */
    public OrderDetailModel getOrderDetailById(Integer orderId);

    /**
     * 
     * @param object
     * @return
     */
    public Integer createOrderDetail(OrderDetailModel object);

    /**
     * 
     * @param object
     * @return
     */
    public Integer updateOrderDetail(OrderDetailModel object);

    /**
     * 
     * @param object
     * @return
     */
    public Integer deteleOrderDetail(OrderDetailModel object);

    /**
     * 
     * @return
     */
    public List<OrderDetailModel> findAll();

    /**
     * 
     * @param orderId
     * @return
     */
    public List<OrderDetailModel> getOrderDetailModelByOrderId(Integer orderId);

    /**
     * @param orderId
     * @return
     */
   public List<OrderDetailModel> getOrderDetailModelByListOrderId(List<Integer> orderId);
}
