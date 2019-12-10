/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shop.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import shop.model.UsersModel;
import shop.service.UsersService;

/**
 *
 * @author admin
 */
@Controller
public class loginController {

    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    //-------- LOGIN CUSTOMER
    @Autowired
    private UsersService usersService;

    @Autowired
    private MailSender mailSender;

    @RequestMapping(value = "/login")
    public String login(@RequestParam(value = "error", required = false) final String error, final Model model, HttpSession session, @Validated UsersModel users) {

        if (error != null) {
            model.addAttribute("message", "Đăng nhập thất bại!");
        }
        model.addAttribute("customer", new UsersModel());
        return "login";
    }

    @RequestMapping("/logout")
    public String logout(final Model model, HttpSession session) {
        model.addAttribute("customer", new UsersModel());
        return "login";
    }

    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String accessDenied() {
        return "403";
    }

    //----------Quên Mật Khẩu
    //    CheckEmail
    @RequestMapping(value = "/checkemail", method = RequestMethod.GET)
    public String checkEmail() {
        return "checkEmail";
    }

    @RequestMapping(value = "/checkemail", method = RequestMethod.POST)
    public String check(@RequestParam("email") String email, UsersModel user, HttpSession session, RedirectAttributes redirect,HttpServletRequest request) throws EmptyResultDataAccessException {
        try {
            user = usersService.findByEmail(email);
            if (user.getEmail().equalsIgnoreCase(email) && !email.equals("")) {
                CsrfToken token = new HttpSessionCsrfTokenRepository().loadToken(request);
                System.out.println(">>>>>>"+token);
                SimpleMailMessage emailObj = new SimpleMailMessage();
                emailObj.setTo(email);
                String code = user.randomAlphaNumeric(6);
                emailObj.setText("Mã xác nhận của bạn là: "+token);
                mailSender.send(emailObj);
                session.setAttribute("token", token);
                redirect.addFlashAttribute("emailsuscess", "Vui lòng nhập mã xác nhận trong hộp thư email!");
                return "checkToken";
            } else {
                session.setAttribute("email", email);
                redirect.addFlashAttribute("fail", "Email không đúng. Vui lòng thử lại!");
                return "redirect:/checkemail";
            }
        } catch (NullPointerException e) {
            session.setAttribute("email", email);
            redirect.addFlashAttribute("fail", "Email không đúng. Vui lòng thử lại!");
            return "redirect:/checkemail";
        }
    }

// Check Mã Xác Nhận
    @RequestMapping(value = "/checktoken", method = RequestMethod.GET)
    public String checkToken() {
        return "checkToken";
    }

    @RequestMapping(value = "/checkToken", method = RequestMethod.POST)
    public String checkCode(@RequestParam("token1") String token1,
            @RequestParam("token2") String token2, UsersModel user, RedirectAttributes redirect
    ) {
        try {
            if (token1.equals(token2)) {
                return "resetPass";
            } else {
                redirect.addFlashAttribute("codefail", "Mã xác nhận không đúng!");
                return "redirect:/checktoken";

            }
        } catch (Exception e) {
            String out = "Không được";
            System.out.println(out);
            return out;
        }
    }
//ResetPassword

    @RequestMapping(value = "/resetpass", method = RequestMethod.GET)
    public String resetpass() {
        return "resetPass";
    }

    @RequestMapping(value = "/reset", method = RequestMethod.POST)
    public String resetpass(@RequestParam("email") String email,
            @RequestParam("pass1") String pass1,
            @RequestParam("pass2") String pass2, UsersModel user,
            Model model
    ) {
        try {
            user = usersService.findByEmail(email);
            if (pass1.equals(pass2)) {
                user.setEmail(email);
                user.setPassWord(passwordEncoder.encode(pass1));
                usersService.updatePass(user);
                model.addAttribute("customer", new UsersModel());
                return "login";
            } else {
                return "redirect:/reset";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/reset";
        }
    }
}
