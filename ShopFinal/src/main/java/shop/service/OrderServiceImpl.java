/////////////////////////////////////////////////////////////////////////////
//
// � 2019 andro Japan. All right reserved.
//
/////////////////////////////////////////////////////////////////////////////

package shop.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shop.dao.OrderDAO;
import shop.model.OrdersModel;

/**
 * [OVERVIEW] XXXXX.
 *
 * @author: HoaHD
 * @version: 1.0
 * @History
 * [NUMBER]  [VER]     [DATE]          [USER]             [CONTENT]
 * --------------------------------------------------------------------------
 * 001       1.0       2019/10/10      HoaHD       Create new
*/
@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDAO orderDao;

    @Override
    public OrdersModel getOrderById(Integer orderId) {
        return orderDao.findById(orderId);
    }

    @Override
    public Integer createOrder(OrdersModel object) {
        return orderDao.create(object);
    }

    @Override
    public Integer updateOrder(OrdersModel object) {
        return orderDao.update(object);
    }

    @Override
    public Integer deteleOrder(OrdersModel object) {
        return orderDao.delete(object);
    }

    @Override
    public List<OrdersModel> findAll() {
        return orderDao.getAll();
    }

    @Override
    public String autoGenOrderCode() {
        String orderCode = null;
        Random rd = new Random();
        StringBuilder code = new StringBuilder();
        for (int i = 0; i < 12; i++) {
            code.append(rd.nextInt(10));
        }
        orderCode = code.toString();
        return orderCode;
    }

    @Override
    public Boolean checkCodeExist(String code) {
        return orderDao.checkCodeExist(code);
    }

    @Override
    public OrdersModel getOrderByCode(String code) {
        return orderDao.getOrderByCode(code);
    }

    @Override
    public List<OrdersModel> findByCustomerId(Integer customerId) {
        return orderDao.getByCustomerId(customerId);
    }
}
