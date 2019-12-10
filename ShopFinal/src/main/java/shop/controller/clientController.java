///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package shop.controller;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.List;
//import javax.servlet.http.HttpServletRequest;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.propertyeditors.CustomDateEditor;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.ServletRequestDataBinder;
//import org.springframework.web.bind.annotation.InitBinder;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//import shop.model.UsersModel;
//import shop.service.CustomerService;
//
///**
// *
// * @author admin
// */
//@Controller
//@RequestMapping(value = "/admin")
//public class clientController {
//    Date date = new Date();
//
//    @InitBinder
//    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) {
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        dateFormat.setLenient(false);
//        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
//    }
//    @Autowired
//    private CustomerService customerService;
//
//    @RequestMapping(value = "/client", method = RequestMethod.GET)
//    public String listcustomer(Model m) {
//        List<UsersModel> list = customerService.getAll();
//        m.addAttribute("listCus", list);
//        m.addAttribute("customer", new UsersModel());
//        return "listClient";
//    }
//
//    @RequestMapping(value = "/client", method = RequestMethod.POST)
//    public String addcustomer(@Validated @ModelAttribute("customer") UsersModel customer,
//            BindingResult result, Model model) {
//        customer.setCreateDate(date);
//        customer.setDelFlg(0);
//        if (result.hasErrors()) {
//            System.out.println(result.getAllErrors());
//            return "listClient";
//        }
//        customerService.create(customer);
//        return "redirect:/admin/client";
//    }
//
//    @RequestMapping(value = "/editcustomer", method = RequestMethod.POST)
//    public String editcustomer(@Validated @RequestParam("cus_id") int customerId,
//            @RequestParam("cus_mail") String email,
//            @RequestParam("cus_password") String passWord,
//            @RequestParam("cus_fullname") String fullName,
//            @RequestParam("cus_birthday") Date birthDay,
//            @RequestParam("cus_gender") int gender,
//            @RequestParam("cus_phone") String phoneNumber,
//            @RequestParam("cus_address") String address,            
//            @RequestParam("cus_token") String token,
//            UsersModel modelCustomer,  BindingResult result) {
//        modelCustomer = customerService.findById(customerId);
//        modelCustomer.setCustomerId(customerId);
//        modelCustomer.setEmail(email);
//        modelCustomer.setPassword(passWord);
//        modelCustomer.setFullName(fullName);
//        modelCustomer.setBirthday(birthDay);
//        modelCustomer.setGender(gender);
//        modelCustomer.setPhoneNumber(phoneNumber);
//        modelCustomer.setAddress(address);
//        modelCustomer.setToken(token);
//        modelCustomer.setUpdateDate(date);
//         if (result.hasErrors()) {
//            System.out.println(result.getAllErrors());
//            return "redirect:/admin/client";
//        }         
//        customerService.update(modelCustomer);
//        return "redirect:/admin/client";
//    }
//    
//    @RequestMapping(value = "/deletecustomer", method = RequestMethod.GET)
//    @ResponseBody
//    public String delete(@RequestParam("id") int id) {
//        UsersModel modelCustomer = customerService.findById(id);
//        modelCustomer.setDelFlg(1);
//        customerService.delete(modelCustomer);
//        return "redirect:/admin/client";
//    }
//}
