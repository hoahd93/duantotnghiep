/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shop.dao;

import java.util.List;
import shop.model.OrdersModel;

/**
 *
 * @author admin
 */
public interface OrderDAO {

    // create
    public int create(OrdersModel object);

    // update
    public int update(OrdersModel object);

    // delete
    public int delete(OrdersModel object);

    // find by id
    public OrdersModel findById(int categoryId);

    // load list category
    public List<OrdersModel> getAll();

    /**
     * 
     * @param customerId
     * @return
     */
    public List<OrdersModel> getByCustomerId(Integer customerId);

    /**
     * 
     * @param code
     * @return
     */
    public Boolean checkCodeExist(String code);

    /**
     * 
     * @param code
     * @return
     */
    public OrdersModel getOrderByCode(String code);
}
