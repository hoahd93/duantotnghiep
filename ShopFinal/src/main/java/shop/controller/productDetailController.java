/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shop.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import shop.model.ColorModel;
import shop.model.ProductAllModel;
import shop.model.ProductDetailModel;
import shop.model.ProductModel;
import shop.model.SizeModel;
import shop.service.ColorService;
import shop.service.ProductDetailService;
import shop.service.ProductService;
import shop.service.SizeService;

/**
 *
 * @author Admin
 */
@Controller
@RequestMapping(value = "/manager/staff")
public class productDetailController {
    Date date = new Date();
    @Autowired
    private ColorService colorService;
    @Autowired
    private SizeService sizeService;
    @Autowired
    private ProductDetailService productmodelService;
    @Autowired
    private ProductService productService;

    @InitBinder
    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @RequestMapping(value = "/productModel", method = RequestMethod.GET)
    public String addProductDetail(Model m) {
        List<ProductAllModel> listProduct = productService.getAll();
        m.addAttribute("listProduct", listProduct);
        List<ColorModel> listColor = colorService.getAll();
        m.addAttribute("listColor", listColor);
        List<SizeModel> listSize = sizeService.getAll();
        m.addAttribute("listSize", listSize);
        List<ProductDetailModel> listProductModel = productmodelService.getAll();
        m.addAttribute("listProductModel", listProductModel);
        m.addAttribute("productmodel", new ProductDetailModel());
        return "productModel";
    }

    @RequestMapping(value = "/productModel", method = RequestMethod.POST)
    public String addProductDetail(@Validated @ModelAttribute("productmodel") ProductDetailModel productmodel, BindingResult result, Model model) {
        productmodel.setCreateDate(date);
        productmodel.setDelFlg(0);
        if (result.hasErrors()) {
            System.out.println(result.getAllErrors());
            return "manager/staff/productModel";
        }
        productmodelService.create(productmodel);
        return "redirect:/manager/staff/productModel";
    }

    @RequestMapping(value = "/editproductmodel", method = RequestMethod.POST)
    public String editProductDetail(@Validated ProductDetailModel productDetailModel,
            @RequestParam("productModel_Id") int productModelId,
            @RequestParam("product_Id") int productId,
            @RequestParam("color_Id") int colorId,
            @RequestParam("size_Id") int sizeId,
            @RequestParam("productmodel_stork") int stork,
            @RequestParam("productmodel_price") double price,
            BindingResult result) {
        productDetailModel.setProductDetailId(productModelId);
        productDetailModel.setProductId(productId);
        productDetailModel.setColorId(colorId);
        productDetailModel.setSizeId(sizeId);
        productDetailModel.setStock(stork);
        productDetailModel.setPrice(price);
        productDetailModel.setUpdateDate(date);
        if (result.hasErrors()) {
            System.out.println(result.getAllErrors());
            return "redirect:/manager/staff/addcolor";
        }
        productmodelService.update(productDetailModel);
        return "redirect:/manager/staff/productModel";
    }
    @RequestMapping(value = "/deleteproductdetailmodel", method = RequestMethod.GET)
    @ResponseBody
    public String deleteCategory(@RequestParam("id") int id) {
        ProductDetailModel productDetailModel = productmodelService.findById(id);
        productDetailModel.setDelFlg(1);
        productmodelService.delete(productDetailModel);
        return "productModel";
    }
    
//    @RequestMapping(value = "/searchproductmodel", method = RequestMethod.POST)
//    public String search(@RequestParam("search_productmodel") String productName, HttpServletRequest request, Model m) {
//        m.addAttribute("productmodel", new ProductDetailModel());
//        List<ProductDetailModel> productDetailModels = productmodelService.findByNameProductModel(productName);
//        if (productDetailModels.isEmpty()) {
//            m.addAttribute("listProductModel", productmodelService.getAll());
//            m.addAttribute("listColor", colorService.getAll());
//            m.addAttribute("listSize", sizeService.getAll());
//            return "redirect:/admin/productModel";
//        } else {
//            m.addAttribute("listProductModel", productDetailModels);
//            m.addAttribute("listProduct", productService.getAll());
//            m.addAttribute("listColor", colorService.getAll());
//            m.addAttribute("listSize", sizeService.getAll());
//            return "productModel";
//        }   
//    }
}
