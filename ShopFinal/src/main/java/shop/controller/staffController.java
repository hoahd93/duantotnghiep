/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shop.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;
import shop.model.UsersModel;
import shop.service.UsersService;

/**
 *
 * @author staff
 */
@Controller
@RequestMapping("/manager/staff")
public class staffController {

    Date date = new Date();
    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    @Autowired
    private UsersService usersService;

    @InitBinder
    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
        binder.registerCustomEditor(byte[].class, new ByteArrayMultipartFileEditor());
    }
//---------   TRANG CHỦ STAFF  ---------//

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String staffHome() {
        return "staffHome";
    }

//------Thông Tin Cá Nhân nhân viên
    @RequestMapping(value = "/mypro/{email}", method = RequestMethod.GET)
    public String myprofile(Model m) {
        Authentication authentication = SecurityContextHolder.getContext().
                getAuthentication();
        String email = authentication.getName();
        UsersModel staff = usersService.findByEmail(email);
        m.addAttribute("staff", staff);
        return "myPro";
    }
    //--------Update Thông Tin nhân viên

    @RequestMapping(value = "/mypro/save", method = RequestMethod.POST)
    public String editsave(@Validated @ModelAttribute("staff") UsersModel staff) {
        staff.setUpdateDate(date);
        usersService.update(staff);
        return "myPro";
    }
    //---------   FEEDBACK  ---------//

    @RequestMapping(value = "/feedback", method = RequestMethod.GET)
    public String feedback() {
        return "listFeedback";
    }
    
    @RequestMapping(value = "/checkEmail")
    @ResponseBody
    public boolean checkEmail(@RequestParam("email") String email) {
        boolean a;
        UsersModel modelus = usersService.findByEmail(email);
        if (modelus != null) {
            a = true;
        } else {
            a = false;
        }
        return a;
    }
}
