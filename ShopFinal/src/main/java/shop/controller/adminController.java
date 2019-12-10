/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shop.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import shop.model.UsersModel;
import shop.service.UsersService;

/**
 *
 * @author admin
 */
@Controller
@RequestMapping(value = "/manager/admin")
public class adminController {

    @Autowired
    private UsersService usersService;
    Date date = new Date();
    //MÃ HÓA BCryptPasswordEncoderDE
    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @InitBinder
    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

//---------   QUẢN LÝ NHÂN VIÊN   ---------//
    //-----List Nhân Viên-----//
    @RequestMapping(value = "/staff", method = RequestMethod.GET)
    public String staffManager(Model m) {
        //get list users
        List<UsersModel> list = usersService.getListUserByPageIndex(1);
        list.forEach(user->{
            if (Objects.isNull(user.getImage())) {
                user.setImage("userLogin.png");
            }
        });
        //get count user
        int count = usersService.countUsers();

        m.addAttribute("listUser", list);
        m.addAttribute("count", count);
        return "staffManager";
    }

    //-----ADD Nhân Viên-----//
    @RequestMapping(value = "/addstaff", method = RequestMethod.POST)
    @ResponseBody
    public UsersModel addUser(
            @RequestParam Date birthDay,
            MultipartHttpServletRequest request) {
        UsersModel users = new UsersModel();
        users.setEmail(request.getParameter("email"));
        users.setFullName(request.getParameter("fullName"));
        users.setGender(Integer.parseInt(request.getParameter("gender")));
        users.setPhoneNumber(request.getParameter("phoneNumber"));
        users.setBirthDay(birthDay);
        users.setAddress(request.getParameter("address"));
        try {
            File fileDir = new File(request.getServletContext().getRealPath("\\WEB-INF\\resources\\upload"));
            System.out.println("HELLO FILE OUTPUT STREAM" + request.getServletContext().getContextPath());
            if (!fileDir.exists()) {
                fileDir.mkdir();
            }
            if (!"".equals(request.getFile("image").getOriginalFilename())) {
                request.getFile("image").transferTo(new File(fileDir + File.separator + request.getFile("image").getOriginalFilename()));
                System.out.println("upload success");
            }
            users.setImage(request.getFile("image").getOriginalFilename());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("upload error");
        }

        users.setPassWord(passwordEncoder.encode(request.getParameter("passWord")));
//        users.setImage(nameFile);
        users.setCreateDate(date);
        users.setRoleId(2);
        users.setDelFlg(0);
        usersService.create(users);
//        if (binding.hasErrors()) {
//            System.out.println(binding.getAllErrors());
//            return users;
//        }

        return users;
    }

    //-----EDIT Nhân Viên-----//
    @RequestMapping(value = "/editstaff", method = RequestMethod.POST)
    @ResponseBody
    public UsersModel editUser(@RequestParam Date user_birthday, MultipartHttpServletRequest request) {
        UsersModel usermodel = new UsersModel();
        usermodel.setUserId(Integer.parseInt(request.getParameter("user_id")));
        usermodel.setEmail(request.getParameter("user_email"));
//        usermodel.setPassWord(passwordEncoder.encode(request.getParameter("user_password")));
        usermodel.setFullName(request.getParameter("user_fullname"));
        usermodel.setBirthDay(user_birthday);
        usermodel.setGender(Integer.parseInt(request.getParameter("user_gender")));
        usermodel.setPhoneNumber(request.getParameter("user_phone"));
        usermodel.setAddress(request.getParameter("user_address"));
        try {
            File fileDir = new File(request.getServletContext().getRealPath("\\WEB-INF\\resources\\upload"));
            System.out.println("hello image" + request.getServletContext().getContextPath());
            if (!fileDir.exists()) {
                fileDir.mkdir();
            }
            if (!"".equals(request.getFile("user_image").getOriginalFilename())) {
                request.getFile("user_image").transferTo(new File(fileDir + File.separator + request.getFile("user_image").getOriginalFilename()));
                System.out.println("upload file success");
            }
            
            usermodel.setImage(request.getFile("user_image").getOriginalFilename());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("upload file error");
        }
        usermodel.setUpdateDate(date);
        usermodel.setDelFlg(0);
        usersService.update(usermodel);
        return usermodel;
    }
    
    //-----ĐỔI MẬT KHẨU NHÂN VIÊN-----//
    @RequestMapping(value = "/change-password", method = RequestMethod.POST)
    @ResponseBody
    public UsersModel changePassword(@RequestParam int id, @RequestParam String changePassword, UsersModel user){
        try {
            user.setUserId(id);
            user.setPassWord(passwordEncoder.encode(changePassword));
            if (usersService.changePassword(user) != 0) {
                user = usersService.findById(id);
                return user;
            } else {
                return user;
            }
        } catch (Exception e) {
            return user;
        }
    }

    //-----DELETE Nhân Viên-----//
    @RequestMapping(value = "/deleteuser", method = RequestMethod.GET)
    @ResponseBody
    public boolean deleteUser(@RequestParam int id, UsersModel usersmodel) {
        try {
            usersmodel = usersService.findById(id);
            usersmodel.setDelFlg(1);
            return usersService.delete(usersmodel) != 0;
        } catch (Exception e) {
            return false;
        }
    }

    //-----SEARCH Nhân Viên-----//
    @RequestMapping(value = "/searchUser", method = RequestMethod.POST)
    public String searchUser(@RequestParam("search_user") String fullName, HttpServletRequest request, Model m) {
        List<UsersModel> modelUser = usersService.findByName(fullName);
        if (modelUser.isEmpty()) {
            m.addAttribute("listUser", usersService.getAll());
            return "redirect:/manager/admin/staff";
        } else {
            m.addAttribute("listUser", modelUser);
            m.addAttribute("user", new UsersModel());
            return "staffManager";
        }
    }

//---------   THỐNG KÊ DOANH THU   ---------// 
    @RequestMapping(value = "/revenue", method = RequestMethod.GET)
    public String thongKeDoanhThu() {
        return "revenue";
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

    @RequestMapping(value = "/checkEmailup")
    @ResponseBody
    public boolean checkEmailup(@RequestParam("user_email") String user_email) {
        boolean b;
        UsersModel modelus = usersService.findByEmail(user_email);
        if (modelus != null) {
            b = true;
        } else {
            b = false;
        }
        return b;
    }

    @RequestMapping(value = "/get_users")
    @ResponseBody
    public List<UsersModel> paginationUsers(@RequestParam("page") int page) {
        return usersService.getListUserByPageIndex(page);
    }
}
