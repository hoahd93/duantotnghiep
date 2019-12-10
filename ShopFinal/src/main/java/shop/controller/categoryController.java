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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import shop.model.CategoryModel;
import shop.service.CategoryService;

/**
 *
 * @author Admin
 */
@Controller
@RequestMapping(value = "/manager/staff")
public class categoryController {

    Date date = new Date();

    @InitBinder
    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/category", method = RequestMethod.GET)
    public String listCategory(Model m) {
        List<CategoryModel> list = categoryService.getAll();
        m.addAttribute("listCategory", list);
        m.addAttribute("category", new CategoryModel());
        return "listCategory";
    }

    @RequestMapping(value = "/category", method = RequestMethod.POST)
    public String addCategory(
            @RequestParam("imagea") MultipartFile cateImage,
            @RequestParam("nameCategory") String namecategory,
            HttpServletRequest request,
            @Validated @ModelAttribute("category") CategoryModel category123, BindingResult result,
            Model model) throws Exception {
        String nameFile = cateImage.getOriginalFilename();
        System.out.println(nameFile);
        if (!"".equals(nameFile)) {
            String dirFile = request.getServletContext().getRealPath("\\WEB-INF\\resources\\upload");
            System.out.println(dirFile);
            File fileDir = new File(dirFile);
            if (!fileDir.exists()) {
                fileDir.mkdir();
            }
            try {
                cateImage.transferTo(new File(fileDir + File.separator + nameFile));
                category123.setImage(nameFile);
                System.out.println("Upload file thành công!");
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Upload file thất bại!");
            }
        }
        category123.setNameCategory(namecategory);
         
        category123.setCreateDate(date);
        category123.setDelFlg(0);
        if (result.hasErrors()) {
            System.out.println(result.getAllErrors());
            return "redirect:/manager/staff/category";
        }
        categoryService.create(category123);
        return "redirect:/manager/staff/category";
    }

    @RequestMapping(value = "/editcategory", method = RequestMethod.POST)
    public String editUser(
            HttpServletRequest request,
            @RequestParam("category_id") int categoryId,
            @RequestParam("category_name") String nameCategory,
            @RequestParam("parent_id") int parentId,
            @RequestParam("pro_image") MultipartFile fileNew,
            CategoryModel category, BindingResult binding) throws Exception {
        category = categoryService.findById(categoryId);
        category.setNameCategory(nameCategory);
        category.setParentId(parentId);
        String nameFile = fileNew.getOriginalFilename();
        System.out.println(nameFile);
        if (!"".equals(nameFile)) {
            String dirFile = request.getSession().getServletContext().getRealPath("\\WEB-INF\\resources\\upload");
            System.out.println(dirFile);
            File fileDir = new File(dirFile);
            if (!fileDir.exists()) {
                fileDir.mkdir();
            }
            try {
                fileNew.transferTo(new File(fileDir + File.separator + nameFile));
                category.setImage(nameFile);
                System.out.println("Upload file thành công!");
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Upload file thất bại!");
            }
        }
        category.setUpdateDate(date);
        if (binding.hasErrors()) {
            System.out.println(binding.getAllErrors());
            return "redirect:/manager/staff/category";
        }
        categoryService.update(category);
        return "redirect:/manager/staff/category";
    }

    @RequestMapping(value = "/deletecategory", method = RequestMethod.GET)
    @ResponseBody
    public String deleteCategory(@RequestParam("id") int id) {
        CategoryModel category = categoryService.findById(id);
        category.setDelFlg(1);
        categoryService.delete(category);
        return "redirect:/manager/staff/category";
    }

    @RequestMapping(value = "/searchCate", method = RequestMethod.POST)
    public String searchCate(@RequestParam("search_cate") String nameCategory, HttpServletRequest request, Model m) {
        List<CategoryModel> listC = categoryService.findByName(nameCategory);
        if (listC.isEmpty()) {
            m.addAttribute("listCategory", categoryService.getAll());
        } else {
            m.addAttribute("listCategory", listC);
            m.addAttribute("category", new CategoryModel());
        }
        return "listCategory";
    }
}
