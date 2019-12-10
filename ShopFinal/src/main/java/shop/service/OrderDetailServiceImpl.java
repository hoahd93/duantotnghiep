/////////////////////////////////////////////////////////////////////////////
//
// � 2019 andro Japan. All right reserved.
//
/////////////////////////////////////////////////////////////////////////////

package shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shop.dao.OrderDetailDAO;
import shop.model.OrderDetailModel;

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
public class OrderDetailServiceImpl implements OrderDetailService {

    @Autowired
    private OrderDetailDAO orderDetailDao;

    @Override
    public OrderDetailModel getOrderDetailById(Integer orderId) {
        return orderDetailDao.findById(orderId);
    }

    @Override
    public Integer createOrderDetail(OrderDetailModel object) {
        return orderDetailDao.create(object);
    }

    @Override
    public Integer updateOrderDetail(OrderDetailModel object) {
        return orderDetailDao.update(object);
    }

    @Override
    public Integer deteleOrderDetail(OrderDetailModel object) {
        return orderDetailDao.delete(object);
    }

    @Override
    public List<OrderDetailModel> findAll() {
        return orderDetailDao.getAll();
    }

    @Override
    public List<OrderDetailModel> getOrderDetailModelByOrderId(Integer orderId) {
        return orderDetailDao.getOrderDetailByOrderId(orderId);
    }

    @Override
    public List<OrderDetailModel> getOrderDetailModelByListOrderId(List<Integer> orderId) {
        return orderDetailDao.getOrderDetailByListOrderId(orderId);
    }

}
