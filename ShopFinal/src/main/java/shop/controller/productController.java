/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shop.controller;

import java.io.File;
import java.io.IOException;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import shop.model.ColorModel;
import shop.model.ProductAllModel;
import shop.model.ProductDetailModel;
import shop.model.ProductModel;
import shop.model.SizeModel;
import shop.service.CategoryService;
import shop.service.ColorService;
import shop.service.ProductDetailService;
import shop.service.ProductService;
import shop.service.SizeService;
import shop.service.TrademarkService;

/**
 *
 * @author Admin
 */
@Controller
@RequestMapping(value = "/manager/staff")
public class productController {

    @Autowired
    private ProductService serviceProduct;
    @Autowired
    private CategoryService serviceCategory;
    @Autowired
    private TrademarkService serviceTrademark;
    @Autowired
    private ColorService colorService;
    @Autowired
    private SizeService sizeService;
    @Autowired
    private ProductDetailService productmodelService;

    Date date = new Date();

    @InitBinder
    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public String listandaddproduct(Model m) {
        m.addAttribute("listProduct", serviceProduct.getListProductByPageIndex(1));
//        m.addAttribute("listProduct", serviceProduct.getAll());
        m.addAttribute("cate", serviceCategory.getAll());
        m.addAttribute("trade", serviceTrademark.getAll());
        List<ColorModel> listColor = colorService.getAll();
        m.addAttribute("listColor", listColor);
        List<SizeModel> listSize = sizeService.getAll();
        m.addAttribute("listSize", listSize);
        int count = serviceProduct.countProduct();
        m.addAttribute("count", count);
        return "product";
    }

    @RequestMapping(value = "/addproduct", method = RequestMethod.POST)
    @ResponseBody
    public ProductAllModel addproduct(
//            @RequestParam("productName") String productName,
//            @RequestParam("productCode") String productCode,
//            @RequestParam("discoutRate") int discoutRate,
//            @RequestParam("descriptionShort") String descriptionShort,
//            @RequestParam("description") String description,
//            @RequestParam("categoryId") int categoryId,
//            @RequestParam("trademarkId") int trademarkId,
////            @RequestPart("imageMain") MultipartFile imageMain,
////            @RequestPart("image1") MultipartFile image1,
////            @RequestPart("image2") MultipartFile image2,
////            @RequestPart("image3") MultipartFile image3,
////            @RequestPart("image4") MultipartFile image4,
//            @RequestParam("color_Id") int color_Id,
//            @RequestParam("size_Id") int size_Id,
//            @RequestParam("productmodel_stork") int productmodel_stork,//            @RequestParam("productmodel_price") double productmodel_price,
           
            MultipartHttpServletRequest  request) {
        
        ProductModel productModel = new ProductModel();
        productModel.setName(request.getParameter("productName"));
        productModel.setProductCode(request.getParameter("productCode"));
        System.out.println("============== dhdhdh ======"+request.getParameter("discoutRate"));
        productModel.setDiscountRate(Integer.parseInt(request.getParameter("discoutRate")));
        productModel.setDiscountRate(0);
        productModel.setDescription(request.getParameter("description"));
        productModel.setDescriptionShort(request.getParameter("descriptionShort"));
        productModel.setCategoryId(Integer.parseInt(request.getParameter("categoryId")));
        productModel.setTrademarkId(Integer.parseInt(request.getParameter("trademarkId")));
        try {
            File fileDir = new File(request.getServletContext().getRealPath("\\WEB-INF\\resources\\upload"));
            System.out.println("HELLO FILE OUTPUT STREAM" + request.getServletContext().getContextPath());
            if (!fileDir.exists()) {
                fileDir.mkdir();
            }
            if (!"".equals(request.getFile("imageMain").getOriginalFilename())) {
                request.getFile("imageMain").transferTo(new File(fileDir + File.separator + request.getFile("imageMain").getOriginalFilename()));
                System.out.println("Upload file thành công!");
            }
//            if (!"".equals(request.getFile("image1").getOriginalFilename())) {
//                request.getFile("image1").transferTo(new File(fileDir + File.separator + request.getFile("image1").getOriginalFilename()));
//                System.out.println("Upload file thành công image 1!");
//            }
//            if (!"".equals(image2.getOriginalFilename())) {
//                image2.transferTo(new File(fileDir + File.separator + image2.getOriginalFilename()));
//                System.out.println("Upload file thành công image 2!");
//            }
//            if (!"".equals(image3.getOriginalFilename())) {
//                image3.transferTo(new File(fileDir + File.separator + image3.getOriginalFilename()));
//                System.out.println("Upload file thành công image 3!");
//            }
//            if (!"".equals(image4.getOriginalFilename())) {
//                image4.transferTo(new File(fileDir + File.separator + image4.getOriginalFilename()));
//                System.out.println("Upload file thành công image 4!");
//            }
            productModel.setImgMain(request.getFile("imageMain").getOriginalFilename());
//            productModel.setImg1(image1.getOriginalFilename());
//            productModel.setImg2(image2.getOriginalFilename());
//            productModel.setImg3(image3.getOriginalFilename());
//            productModel.setImg4(image4.getOriginalFilename());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Upload file thất bại!");
        }
        productModel.setCreatedAt(date);
        productModel.setDelFlg(0);
        ProductDetailModel productDetailModel = new ProductDetailModel();
        productDetailModel.setColorId(Integer.parseInt(request.getParameter("color_Id")));
        productDetailModel.setSizeId(Integer.parseInt(request.getParameter("size_Id")));
        productDetailModel.setStock(Integer.parseInt(request.getParameter("productmodel_stork")));
        productDetailModel.setPrice(Double.parseDouble(request.getParameter("productmodel_price")));
        productDetailModel.setCreateDate(date);
        productDetailModel.setDelFlg(0);
//        if (errors.hasErrors()) {
//            System.out.println("aaaaaaaaaaaaaaaaaaaaaa" + errors);
//            return "product";
//        } else {
            ProductAllModel productAllMode = serviceProduct.create(productModel, productDetailModel);
//            return "redirect:/manager/staff/product";
//        }

        
   
        return productAllMode;
    }

    @RequestMapping(value = "/editproduct123", method = RequestMethod.POST)
    public String editproduct(
            @RequestParam("pro_id") int productId,
            @RequestParam("pro_name") String productName,
            @RequestParam("pro_code") String productCode,
            @RequestParam("pro_rate") int discoutRate,
            @RequestParam("pro_short") String descriptionShort,
            @RequestParam("pro_des") String description,
            @RequestParam("pro_cate") int categoryId,
            @RequestParam("pro_image") MultipartFile imageMain,
            @RequestParam("image1") MultipartFile image1,
            @RequestParam("image2") MultipartFile image2,
            @RequestParam("image3") MultipartFile image3,
            @RequestParam("image4") MultipartFile image4,
            @RequestParam("pro_trade") int trademarkId,
            @RequestParam("pro_modelId") int productModelId,
            @RequestParam("pro_color") int colorId,
            @RequestParam("pro_size") int sizeId,
            @RequestParam("pro_stork") int stock,
            @RequestParam("pro_price") double price,
            @Validated ProductModel modelProduct, HttpServletRequest request, ProductDetailModel productDetailModel, BindingResult result, Model m) throws IOException {
        modelProduct = serviceProduct.findById(productId);
        productDetailModel = productmodelService.findById(productModelId);
        try {
            File fileDir = new File(request.getServletContext().getRealPath("\\WEB-INF\\resources\\upload"));
            System.out.println("HELLO FILE OUTPUT STREAM" + request.getServletContext().getContextPath());
            if (!fileDir.exists()) {
                fileDir.mkdir();
            }
            if (!"".equals(imageMain.getOriginalFilename())) {
                imageMain.transferTo(new File(fileDir + File.separator + imageMain.getOriginalFilename()));
                System.out.println("Upload file thành công!");
            }
            if (!"".equals(image1.getOriginalFilename())) {
                image1.transferTo(new File(fileDir + File.separator + image1.getOriginalFilename()));
                System.out.println("Upload file thành công image 1!");
            }
            if (!"".equals(image2.getOriginalFilename())) {
                image2.transferTo(new File(fileDir + File.separator + image2.getOriginalFilename()));
                System.out.println("Upload file thành công image 2!");
            }
            if (!"".equals(image3.getOriginalFilename())) {
                image3.transferTo(new File(fileDir + File.separator + image3.getOriginalFilename()));
                System.out.println("Upload file thành công image 3!");
            }
            if (!"".equals(image4.getOriginalFilename())) {
                image4.transferTo(new File(fileDir + File.separator + image4.getOriginalFilename()));
                System.out.println("Upload file thành công image 4!");
            }
            if (imageMain.getSize() > 0) {
                modelProduct.setImgMain(imageMain.getOriginalFilename());
            } else {
                modelProduct.setImgMain(modelProduct.getImgMain());
            }
            modelProduct.setImg1(image1.getOriginalFilename());
            modelProduct.setImg2(image2.getOriginalFilename());
            modelProduct.setImg3(image3.getOriginalFilename());
            modelProduct.setImg4(image4.getOriginalFilename());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Upload file thất bại!");
        }

        modelProduct.setProductId(productId);
        modelProduct.setName(productName);
        modelProduct.setProductCode(productCode);
        modelProduct.setDiscountRate(discoutRate);
        modelProduct.setDescriptionShort(descriptionShort);
        modelProduct.setDescription(description);
        modelProduct.setCategoryId(categoryId);
        modelProduct.setTrademarkId(trademarkId);
        modelProduct.setUpdateDate(date);
        productDetailModel.setProductDetailId(productModelId);
        productDetailModel.setColorId(colorId);
        productDetailModel.setSizeId(sizeId);
        productDetailModel.setStock(stock);
        productDetailModel.setPrice(price);
        productDetailModel.setUpdateDate(date);

        if (result.hasErrors()) {
            System.out.println(result.getAllErrors());
            return "redirect:/manager/staff/product";
        }
        serviceProduct.update(modelProduct, productDetailModel);
        return "redirect:/manager/staff/product";
    }

    @RequestMapping(value = "/deleteproduct", method = RequestMethod.GET)
    @ResponseBody
    public String delete(@RequestParam("idProduct") int productId,
            @RequestParam("idProductModel") int productModelId
    ) {
        ProductModel modelProduct = serviceProduct.findById(productId);
        modelProduct.setDelFlg(1);

        ProductDetailModel productDetailModel = productmodelService.findById(productModelId);
        productDetailModel.setDelFlg(1);

        serviceProduct.delete(modelProduct, productDetailModel);

        return "redirect:/manager/staff/product";
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String search(@RequestParam("search_product") String productName, Model m
    ) {
        List<ProductAllModel> modelProduct = serviceProduct.findByName(productName);
        if (modelProduct.isEmpty()) {
            m.addAttribute("listProduct", serviceProduct.getAll());
            m.addAttribute("cate", serviceCategory.getAll());
            m.addAttribute("trade", serviceTrademark.getAll());
            return "redirect:/manager/staff/product";
        } else {
            m.addAttribute("listProduct", modelProduct);
            m.addAttribute("cate", serviceCategory.getAll());
            m.addAttribute("trade", serviceTrademark.getAll());
            return "product";
        }

    }

    @RequestMapping(value = "/checkProductCode")
    @ResponseBody
    public boolean checkProductCode(@RequestParam("productCode") String productCode
    ) {

        boolean a;
        ProductModel modelProduct1 = serviceProduct.findByCode(productCode);
        if (modelProduct1 != null) {
            a = true;
        } else {
            a = false;
        }
        return a;
    }
    @RequestMapping(value = "/get_product")
    @ResponseBody
    public List<ProductAllModel> paginationProduct(@RequestParam("page") int page) {
        return serviceProduct.getListProductByPageIndex(page);
    }
}
