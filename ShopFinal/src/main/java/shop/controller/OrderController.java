/////////////////////////////////////////////////////////////////////////////
//
// � 2019 andro Japan. All right reserved.
//
/////////////////////////////////////////////////////////////////////////////

package shop.controller;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import shop.model.Cart;
import shop.model.OrderDetailModel;
import shop.model.OrdersModel;
import shop.model.UsersModel;
import shop.service.OrderDetailService;
import shop.service.OrderService;
import shop.service.UsersService;

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
@Controller
@RequestMapping(value = "/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderDetailService orderDetailService;
    @Autowired
    private UsersService usersService;

    @RequestMapping(value = "admin/list", method = RequestMethod.GET)
    public String listAllOrders(Model m) {
        List<OrdersModel> listOrders = orderService.findAll();
        m.addAttribute("ListOrders", listOrders);
        m.addAttribute("Order", new OrdersModel());
        return "listOrdersAdmin";
    }

    @RequestMapping(value = "/customer/list", method = RequestMethod.GET)
    public String listOrders(Model m, HttpSession session) {
        Authentication authentication = SecurityContextHolder.getContext().
                getAuthentication();
        String email = authentication.getName();
        UsersModel customer = usersService.findByEmail(email);
        List<OrdersModel> listOrders = orderService.findByCustomerId(customer.getUserId());
        m.addAttribute("ListOrders", listOrders);
        m.addAttribute("order", new OrdersModel());
        return "listOrdersCustomer";
    }

    @RequestMapping(value = "customer/{orderCode}", method = RequestMethod.GET)
    public String getOrderById(Model m, @PathVariable("orderId") String orderCode, HttpSession session) throws Exception {
        UsersModel user = (UsersModel) session.getAttribute("user");
        OrdersModel order = orderService.getOrderByCode(orderCode);
        if (user.getUserId() == order.getCustomerId()) {
            if (Objects.isNull(order)) {
                throw new NullPointerException("Không có order này");
            }
            List<OrderDetailModel> orderDetail = orderDetailService.getOrderDetailModelByOrderId(order.getOrderId());
            m.addAttribute("detail", orderDetail);
            m.addAttribute("OrderDetail", new OrderDetailModel());
        } else {
            throw new NullPointerException("Không có order này");
        }
        return "getOrder";
    }

    @RequestMapping(value = "admin/{orderId}", method = RequestMethod.GET)
    public String getOrderByIdAdmin(Model m, @PathVariable("orderId") Integer orderId) throws Exception {
        OrdersModel order = orderService.getOrderById(orderId);
        if (Objects.isNull(order)) {
            throw new NullPointerException("Không có order này");
        }
        List<OrderDetailModel> orderDetail = orderDetailService.getOrderDetailModelByOrderId(orderId);
        Map<OrdersModel, List<OrderDetailModel>> orderMap = new HashMap<OrdersModel, List<OrderDetailModel>>();
        orderMap.put(order, orderDetail);
        m.addAttribute("OrderMap", orderMap);
        m.addAttribute("Order", new OrdersModel());
        m.addAttribute("OrderDetail", new OrderDetailModel());
        return "getOrder";
    }

    @SuppressWarnings("unchecked")
    @RequestMapping(value = "customer/add", method = RequestMethod.POST)
    public String addOrders(Model m, HttpSession session) {
        HashMap<Long, Cart> cartItems = (HashMap<Long, Cart>) session.getAttribute("myCartItems");
        UsersModel user = (UsersModel) session.getAttribute("user");
        if (cartItems == null) {
            cartItems = new HashMap<>();
        }
        OrdersModel order = new OrdersModel();
        OrderDetailModel orderDetail = new OrderDetailModel();
        String code = orderService.autoGenOrderCode();
        while (orderService.checkCodeExist(orderService.autoGenOrderCode())) {
            code = orderService.autoGenOrderCode();
        }
        order.setOrderCode(code);
        order.setStatus(1);
        order.setAddress(user.getAddress());
        order.setCustomerId(user.getUserId());
        order.setFullName(user.getFullName());
        order.setPhoneNumber(user.getPhoneNumber());
        order.setCreatedAt(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()));
        orderService.createOrder(order);
        Double total = 0.0;
        for (Map.Entry<Long, Cart> entry : cartItems.entrySet()) {
            orderDetail.setOrderId(orderService.getOrderByCode(code).getOrderId());
            orderDetail.setQuantity(entry.getValue().getQuantity());
            orderDetail.setPrice(entry.getValue().getProduct().getPrice());
            total += entry.getValue().getProduct().getPrice();
            orderDetail.setProductModelId(entry.getValue().getProduct().getProductId());
            orderDetail.setProductName(entry.getValue().getProduct().getProductName());
            Date createdAt = Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant());
            orderDetail.setCreatedAt(createdAt);
            orderDetailService.createOrderDetail(orderDetail);
        }
        order.setTotalPrice(total);
        orderService.updateOrder(order);
        return "addOrders";
    }

    @RequestMapping(value = "/cancel{orderId}", method = RequestMethod.POST)
    public String cancelOrder(Model m, HttpSession session, @PathVariable("orderId") Integer orderId) throws Exception {
        OrdersModel order = orderService.getOrderById(orderId);
        UsersModel user = (UsersModel) session.getAttribute("user");
        if (user.getUserId() == order.getCustomerId()) {
            if (order.getStatus()== 1) {
                order.setStatus(2);
            } else {
                throw new Exception("Đơn hàng không thể hủy!");
            }
        }
        return "cancelOrder";
    }
}
