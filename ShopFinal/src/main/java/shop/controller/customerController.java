/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shop.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import shop.dao.ProductDetailDAO;
import shop.model.ColorModel;
import shop.model.ProductAllModel;
import shop.model.ProductModel;
import shop.model.ProductShow;
import shop.model.SizeModel;
import shop.model.UsersModel;
import shop.service.ColorService;
import shop.service.ProductDetailService;
import shop.service.ProductService;
import shop.service.SizeService;
import shop.service.UsersService;

/**
 *
 * @author KimAnh
 */
@Controller
@RequestMapping(value = "/")
public class customerController {

    Date date = new Date();
    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    @Autowired
    private UsersService usersService;
    @Autowired
    private ProductService productService;

    @Autowired
    private ProductDetailService productDetailService;

    @Autowired
    private SizeService sizeService;

    @Autowired
    private ColorService colorService;

    @Autowired
    private ProductDetailDAO productDetailsDAO;

    @InitBinder
    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
        binder.registerCustomEditor(byte[].class, new ByteArrayMultipartFileEditor());
    }

    /**
     * Home Page Customer
     *
     * @param m
     * @param session
     * @param users
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String customerHome(Model m, HttpSession session, @Validated UsersModel users) {
        Authentication authentication = SecurityContextHolder.getContext().
                getAuthentication();
        String email = authentication.getName();
        List<ProductAllModel> listprod = productService.getAll();
        List<ProductShow> listProductShow = productDetailService.getProductShows();
        Map<Integer, List<ProductShow>> product = new HashMap<>();
        if (email == "anonymousUser") {
            for (ProductAllModel productModel : listprod) {
                List<ProductShow> listShow = new ArrayList<>();
                for (ProductShow productShow : listProductShow) {
                    if (productModel.getProductId().equals(productShow.getProductId())) {
                        listShow.add(productShow);
                    }
                }
                product.put(productModel.getProductId(), listShow);
            }
            m.addAttribute("listProShow", product);
            return "customerHome";
        }
        if (!email.equals("")) {
            users = usersService.findByEmail(email);
            System.out.println("Email : " + email);
            session.setAttribute("user", users);
//            session.setAttribute("fullname", users.getFullName());
//            session.setAttribute("role", users.getRoleId());
//            session.setAttribute("image", users.getImage());
            if (users.getRoleId().equals(1) || users.getRoleId().equals(2)) {
                return "redirect:/manager/staff";
            } else {

                return "redirect:/myprofile";
            }
        }
        return "redirect/";
    }

    /**
     * ADD Customer
     *
     * @param customer
     * @param binding
     * @param model
     * @param session
     * @param password
     * @return
     */
    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration() {
        return "registration";
    }

    @RequestMapping(value = "/add-customer", method = RequestMethod.POST)
    public String addCustormer(
            @RequestParam("pass") String password,
            @RequestParam("email") String email,
            @Validated @ModelAttribute("customer") UsersModel customer, BindingResult binding,
            HttpSession session, Model model, RedirectAttributes redir
    ) {
        customer.setPassWord(passwordEncoder.encode(password));
        customer.setEmail(email);
        customer.setRoleId(3);
        customer.setCreateDate(date);
        customer.setDelFlg(0);
        usersService.create(customer);
        redir.addFlashAttribute("susscess", "Đăng ký thành công!");
        return "redirect:/login";

    }
//------Check Trùng Email

    @RequestMapping(value = "/email", method = RequestMethod.GET)
    @ResponseBody
    public boolean checkEmail(@RequestParam("email") String email) {
        boolean check = false;
        try {
            UsersModel customer = usersService.findByEmail(email);
            if (customer == null) {
                check = false;
                return check;
            } else {
                check = true;
                return check;
            }
        } catch (Exception e) {
            check = true;
            return check;
        }

    }

//------Thông Tin Cá Nhân
    @RequestMapping(value = "/myprofile", method = RequestMethod.GET)
    public String myprofile(Model m) {
        Authentication authentication = SecurityContextHolder.getContext().
                getAuthentication();
        String email = authentication.getName();
        UsersModel customer = usersService.findByEmail(email);
        System.out.println(">>>>>" + email);
        m.addAttribute("customer", customer);
        return "myProfile";
    }
    //--------Update Thông Tin Khách Hàng

    @RequestMapping(value = "/myprofile/save", method = RequestMethod.POST)
    public String editsave(@Validated
            @ModelAttribute("customer") UsersModel customer
    ) {
        customer.setUpdateDate(date);
        usersService.update(customer);
        return "myProfile";
    }

    @RequestMapping(value = "/introduce", method = RequestMethod.GET)
    public String introduceShop() {
        return "introduce";
    }

    @RequestMapping(value = "/contact", method = RequestMethod.GET)
    public String contactShop() {
        return "contact";
    }

    @RequestMapping(value = "/SanphamMoi", method = RequestMethod.GET)
    public String listNew(Model m
    ) {
        List<ProductAllModel> listprod = productService.getAll();
        List<ProductShow> listProductShow = productDetailService.getProductShows();
        Map<Integer, List<ProductShow>> product = new HashMap<>();
        for (ProductAllModel productModel : listprod) {
            List<ProductShow> listShow = new ArrayList<>();
            for (ProductShow productShow : listProductShow) {
                if (productModel.getProductId().equals(productShow.getProductId())) {
                    listShow.add(productShow);
                }
            }
            product.put(productModel.getProductId(), listShow);
        }
        m.addAttribute("listProShow", product);
        return "listNew";
    }

    @RequestMapping(value = "/DanhSachAo", method = RequestMethod.GET, produces = "application/x-www-form-urlencoded;charset=UTF-8")
    public String AoShop(Model m
    ) {
        List<ProductModel> listProduct = productService.getAllAo();
        List<ProductShow> listProductShow = productDetailService.getProductShows();
        Map<Integer, List<ProductShow>> product = new HashMap<>();
        for (ProductModel productModel : listProduct) {
            List<ProductShow> listShow = new ArrayList<>();
            for (ProductShow productShow : listProductShow) {
                if (productModel.getProductId().equals(productShow.getProductId())) {
                    listShow.add(productShow);
                }
            }
            product.put(productModel.getProductId(), listShow);
        }
        m.addAttribute("listProShow", product);
        m.addAttribute("ProAo", new ProductShow());
        return "listAo";
    }

    @RequestMapping(value = "/DanhSachGiay", method = RequestMethod.GET)
    public String listGiay(Model m) {
        List<ProductModel> listProduct = productService.getAllGiay();
        List<ProductShow> listProductShow = productDetailService.getProductShows();
        Map<Integer, List<ProductShow>> product = new HashMap<>();
        for (ProductModel productModel : listProduct) {
            List<ProductShow> listShow = new ArrayList<>();
            for (ProductShow productShow : listProductShow) {
                if (productModel.getProductId().equals(productShow.getProductId())) {
                    listShow.add(productShow);
                }
            }
            product.put(productModel.getProductId(), listShow);
        }
        m.addAttribute("listProShow", product);
        m.addAttribute("ProGiay", new ProductShow());
        return "listGiay";
    }

    @RequestMapping(value = "/DanhSachNonMu", method = RequestMethod.GET)
    public String listNonMu(Model m
    ) {
        List<ProductModel> listProduct = productService.getAllNon();
        List<ProductShow> listProductShow = productDetailService.getProductShows();
        Map<Integer, List<ProductShow>> product = new HashMap<>();
        for (ProductModel productModel : listProduct) {
            List<ProductShow> listShow = new ArrayList<>();
            for (ProductShow productShow : listProductShow) {
                if (productModel.getProductId().equals(productShow.getProductId())) {
                    listShow.add(productShow);
                }
            }
            product.put(productModel.getProductId(), listShow);
        }
        m.addAttribute("listProShow", product);
        m.addAttribute("ProNon", new ProductShow());
        return "listNonMu";
    }

    @RequestMapping(value = "/DanhSachQuan", method = RequestMethod.GET)
    public String listQuan(Model m
    ) {
        List<ProductModel> listProduct = productService.getAllQuan();
        List<ProductShow> listProductShow = productDetailService.getProductShows();
        Map<Integer, List<ProductShow>> product = new HashMap<>();
        for (ProductModel productModel : listProduct) {
            List<ProductShow> listShow = new ArrayList<>();
            for (ProductShow productShow : listProductShow) {
                if (productModel.getProductId().equals(productShow.getProductId())) {
                    listShow.add(productShow);
                }
            }
            product.put(productModel.getProductId(), listShow);
        }
        m.addAttribute("listProShow", product);
        m.addAttribute("ProQuan", new ProductShow());
        return "listQuan";
    }

    @RequestMapping(value = "/DanhSachTuiXach", method = RequestMethod.GET)
    public String listTuiXach(Model m
    ) {
        List<ProductModel> listProduct = productService.getAllTuiXach();
        List<ProductShow> listProductShow = productDetailService.getProductShows();
        Map<Integer, List<ProductShow>> product = new HashMap<>();
        for (ProductModel productModel : listProduct) {
            List<ProductShow> listShow = new ArrayList<>();
            for (ProductShow productShow : listProductShow) {
                if (productModel.getProductId().equals(productShow.getProductId())) {
                    listShow.add(productShow);
                }
            }
            product.put(productModel.getProductId(), listShow);
        }

        m.addAttribute("listProShow", product);
        m.addAttribute("ProTui", new ProductShow());
        return "listTuiXach";
    }

    @RequestMapping(value = "/sanPhamChiTiet/{productModelId}", method = RequestMethod.GET)
    public String sanPhamDetail(@PathVariable("productModelId") int productModelId, Model m
    ) {
        List<ProductShow> listProduct = productDetailService.getProductShowById(productModelId);
        List<ColorModel> listColor = new ArrayList<>();
        List<SizeModel> listSize = new ArrayList<>();
        for (ProductShow product : listProduct) {
            ColorModel color = new ColorModel(product.getColorId(), product.getColorName(), null, null, null);
            if (!listColor.contains(color)) {
                listColor.add(color);
            }
            SizeModel size = new SizeModel(product.getSizeId(), product.getSizeName(), null, null, null);
            if (!listSize.contains(size)) {
                listSize.add(size);
            }
        }

        m.addAttribute("listProductShow", listProduct);
        m.addAttribute("listColor", listColor);
        m.addAttribute("listSize", listSize);
        m.addAttribute("Product", new ProductShow());
        return "sanPhamChiTiet";
    }
}
