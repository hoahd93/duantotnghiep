/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shop.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import shop.model.Cart;
import shop.model.ProductCart;
import shop.model.UsersModel;
import shop.service.ProductCartService;

/**
 *
 * @author binh8
 */
@Controller
@RequestMapping(value = "")
public class CartController {
    @Autowired
    private ProductCartService productCartService;

    @SuppressWarnings("unchecked")
    @RequestMapping(value = "addCart/{productModelId}", method = RequestMethod.GET)
    public String viewAdd(ModelMap mm, HttpSession session, @PathVariable("productModelId") int productModelId) {
        HashMap<Integer, Cart> cartItems = (HashMap<Integer, Cart>) session.getAttribute("myCartItems");
        if (cartItems == null) {
            cartItems = new HashMap<>();
        }
        ProductCart productCart = new ProductCart();
        productCart = productCartService.getProduct(productModelId);
        if (productCart != null) {
            if (cartItems.containsKey(productModelId)) {
                Cart item = cartItems.get(productModelId);
                item.setProduct(productCart);
                item.setQuantity(item.getQuantity() + 1);
                cartItems.put(productModelId, item);
            } else {
                Cart item = new Cart();
                item.setProduct(productCart);
                item.setQuantity(1);
                cartItems.put(productModelId, item);
            }
        }
        session.setAttribute("myCartItems", cartItems);
        session.setAttribute("myCartTotal", totalPrice(cartItems));
        session.setAttribute("myCartNum", cartItems.size());

        return "";
    }

    @SuppressWarnings("unchecked")
    @RequestMapping(value = "subCart/{productModelId}", method = RequestMethod.GET)
    public String viewUpdate(ModelMap mm, HttpSession session, @PathVariable("productId") int productModelId) {
        HashMap<Integer, Cart> cartItems = (HashMap<Integer, Cart>) session.getAttribute("myCartItems");
        if (cartItems == null) {
            cartItems = new HashMap<>();
        }
        session.setAttribute("myCartItems", cartItems);
        return "";
    }

    @SuppressWarnings("unchecked")
    @RequestMapping(value = "removeCart/{productId}", method = RequestMethod.GET)
    public String viewRemove(ModelMap mm, HttpSession session, @PathVariable("productModelId") int productModelId) {
        HashMap<Integer, Cart> cartItems = (HashMap<Integer, Cart>) session.getAttribute("myCartItems");
        if (cartItems == null) {
            cartItems = new HashMap<>();
        }
        if (cartItems.containsKey(productModelId)) {
            cartItems.remove(productModelId);
        }
        session.setAttribute("myCartItems", cartItems);
        session.setAttribute("myCartTotal", totalPrice(cartItems));
        session.setAttribute("myCartNum", cartItems.size());
        return "";
    }

    @SuppressWarnings({ "unchecked" })
    @RequestMapping(value = "checkout", method = RequestMethod.POST)
    public String checkOut(ModelMap mm, HttpSession session) {
        Map<Integer, Cart> cartItems = (HashMap<Integer, Cart>) session.getAttribute("myCartItems");
        UsersModel user = (UsersModel) session.getAttribute("user");
        List<Cart> listCart = new ArrayList<Cart>(cartItems.values());
        session.setAttribute("listCart", listCart);
        session.setAttribute("cart", new Cart());
        session.setAttribute("user", user);
        return "checkout";
    }

    public double totalPrice(HashMap<Integer, Cart> cartItems) {
        int count = 0;
        for (Map.Entry<Integer, Cart> list : cartItems.entrySet()) {
            count += list.getValue().getProduct().getPrice() * list.getValue().getQuantity();
        }
        return count;
    }

}
