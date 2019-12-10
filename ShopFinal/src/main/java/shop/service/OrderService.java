/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shop.service;

import java.util.List;

import shop.model.OrdersModel;

/**
 *
 * @author LENOVO
 */
public interface OrderService {
    /**
     * 
     * @param orderId
     * @return
     */
    public OrdersModel getOrderById(Integer orderId);

    /**
     * 
     * @param object
     * @return
     */
    public Integer createOrder(OrdersModel object);

    /**
     * 
     * @param object
     * @return
     */
    public Integer updateOrder(OrdersModel object);

    /**
     * 
     * @param object
     * @return
     */
    public Integer deteleOrder(OrdersModel object);

    /**
     * 
     * @return
     */
    public List<OrdersModel> findAll();

    /**
     * 
     * @param customerId
     * @return
     */
    public List<OrdersModel> findByCustomerId(Integer customerId);

    /**
     * 
     * @param code
     * @return
     */
    public OrdersModel getOrderByCode(String code);

    /**
     * 
     * @return
     */
    public String autoGenOrderCode();

    /**
    * 
    * @param code
    * @return
    */
    public Boolean checkCodeExist(String code);
}
