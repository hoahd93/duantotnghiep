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
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import shop.model.SizeModel;
import shop.service.SizeService;

/**
 *
 * @author admin
 */
@Controller
@RequestMapping(value = "/manager/staff")
public class sizeController {

    Date date = new Date();

    @InitBinder
    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @Autowired
    private SizeService sizeService;

    @RequestMapping(value = "/size", method = RequestMethod.GET)
    public String listSize(Model m) {
        //get list size
        List<SizeModel> list = sizeService.getListSizeByPageIndex(1);
        //get count size
        int count = sizeService.countSize();

        m.addAttribute("listSize", list);
        m.addAttribute("count", count);
        return "listSize";
    }

    @RequestMapping(value = "/addsize", method = RequestMethod.POST)
    @ResponseBody
    public SizeModel addSize(@RequestParam String nameSize, SizeModel sizeModel) {
        try {
            sizeModel.setSizeName(nameSize);
            sizeModel.setCreateDate(date);
            sizeModel.setDelFlg(0);
            if (sizeService.create(sizeModel) != 0) {
                return sizeModel;
            } else {
                return sizeModel;
            }
        } catch (Exception e) {
            return sizeModel;
        }
    }

    @RequestMapping(value = "/editsize", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public SizeModel editSize(@RequestParam String Sizename, @RequestParam int size_id, SizeModel size) {
        try {
//            size = sizeService.findById(size_id);
            size.setSizeId(size_id);
            size.setSizeName(Sizename);
            size.setUpdateDate(date);
            if (sizeService.update(size) != 0) {
                size = sizeService.findById(size_id);
                return size;
            } else {
                return size;
            }
        } catch (Exception e) {
            return size;
        }
    }

    //Xoa//
    @RequestMapping(value = "/deletesize", method = RequestMethod.GET)
    @ResponseBody
    public boolean deletesize(@RequestParam int idSize, SizeModel sizemodel) {
        try {
            sizemodel = sizeService.findById(idSize);
            sizemodel.setDelFlg(1);
            return sizeService.delete(sizemodel) != 0;
        } catch (Exception e) {
            return false;
        }

    }

    //Tìm kiếm
    @RequestMapping(value = "/searchSize", method = RequestMethod.POST)
    public String searchSize(@RequestParam("search_size") String sizeName, HttpServletRequest request, Model m) {
        List<SizeModel> listS = sizeService.findByName(sizeName);
        int count = sizeService.countSize();
        if (listS.isEmpty()) {
            m.addAttribute("listSize", sizeService.getListSizeByPageIndex(1));
        } else {
            m.addAttribute("listSize", listS);
            m.addAttribute("count", count);
        }
        return "listSize";
    }
    //check trùng tên kích thước khi thêm mới
    @RequestMapping(value = "/checknameSize_Insert")
    @ResponseBody
    public boolean checknameSize_Insert(@RequestParam("sizeName") String sizeName) {
        boolean a;
        SizeModel modelsize = sizeService.findByNameSize(sizeName);
        if (modelsize != null) {
            a = true;
        } else {
            a = false;
        }
        return a;
    }
    
    //check trùng tên kích thước khi cập nhật
    @RequestMapping(value = "/checknameSize_Update")
    @ResponseBody
    public boolean checknameSize_Update(@RequestParam("size_name") String size_name) {
        boolean b;
        SizeModel modelsize = sizeService.findByNameSize(size_name);
        if (modelsize != null) {
            b = true;
        } else {
            b = false;
        }
        return b;
    }
    
    @RequestMapping(value = "/get_size")
    @ResponseBody
    public List<SizeModel> paginationSize (@RequestParam("page") int page){
       return sizeService.getListSizeByPageIndex(page);
    }
}
