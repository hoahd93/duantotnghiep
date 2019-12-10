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
import shop.model.ColorModel;
import shop.service.ColorService;

/**
 *
 * @author Admin
 */
@Controller
@RequestMapping(value = "/manager/staff")
public class colorController {

    //------------Controller Color----------- //
    Date date = new Date();

    @InitBinder
    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @Autowired
    private ColorService colorService;

    @RequestMapping(value = "/color", method = RequestMethod.GET)
    public String listColor(Model m) {
        // Get List Color
        List<ColorModel> list = colorService.getListColorByPageIndex(1);
        // Get count color
        int count = colorService.countColor();

        m.addAttribute("list", list);
        m.addAttribute("count", count);
        return "listColor";
    }

//-------------THÊM MÀU SẮC-------------//
    @RequestMapping(value = "/addcolor", method = RequestMethod.POST)
    @ResponseBody
    public ColorModel addColor(@RequestParam String name, ColorModel color) {
        try {
            color.setNameColor(name);
            color.setCreateDate(date);
            color.setDelFlg(0);
            if (colorService.create(color) != 0) {
                return color;
            } else {
                return color;
            }
        } catch (Exception e) {
            return color;
        }
    }
//-------------SỬA MÀU SẮC-------------//     

    @RequestMapping(value = "/editcolor", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ColorModel editColor(@RequestParam String nameColor, ColorModel color, @RequestParam int idColor) {

        try {
//            color = colorService.findById(idColor);
            color.setColorId(idColor);
            color.setNameColor(nameColor);
            color.setUpdateDate(date);
            if (colorService.update(color) != 0) {
                color = colorService.findById(idColor);
                return color;
            } else {
                return color;
            }
        } catch (Exception e) {
            return color;
        }
    }
    //-------------XÓA MÀU SẮC-------------//   

    @RequestMapping(value = "/deletecolor", method = RequestMethod.GET)
    @ResponseBody
    public boolean deleteColor(@RequestParam int colorId
    ) {
        try {
            ColorModel color = colorService.findById(colorId);
            color.setDelFlg(1);
            if (colorService.delete(color) != 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @RequestMapping(value = "/searchColor", method = RequestMethod.POST)
    public String searchColor(@RequestParam("search_color") String nameColor, HttpServletRequest request,
            Model m
    ) {
        List<ColorModel> listC = colorService.findByName(nameColor);
        if (listC.isEmpty()) {
            m.addAttribute("list", colorService.getAll());
        } else {
            m.addAttribute("list", listC);
            m.addAttribute("color", new ColorModel());
        }
        return "listColor";
    }

    @RequestMapping(value = "/get_color")
    @ResponseBody
    public List<ColorModel> paginationColor(@RequestParam("page") int page) {
        return colorService.getListColorByPageIndex(page);

    }
}
