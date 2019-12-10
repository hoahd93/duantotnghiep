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
import shop.model.TrademarkModel;
import shop.service.TrademarkService;

/**
 *
 * @author Admin
 */
@Controller
@RequestMapping(value = "/manager/staff")
public class trademarkController {

    Date date = new Date();

    @InitBinder
    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
    @Autowired
    private TrademarkService tradeService;

    @RequestMapping(value = "/trademark", method = RequestMethod.GET)
    public String listtrademark(Model m) {
        // Get List Trademark
        List<TrademarkModel> list = tradeService.getListTrandemarkByPageIndex(1);
        // Get count Trademark
        int count = tradeService.countTrademark();

        m.addAttribute("list", list);
        m.addAttribute("count", count);
        return "listTrademark";
    }
//-------------THÊM THƯƠNG HIỆU-------------//

    @RequestMapping(value = "/addtrademark", method = RequestMethod.POST)
    @ResponseBody
    public TrademarkModel addtrademark(@RequestParam String nameTrademark, TrademarkModel trademarkModel) {
        try {
            trademarkModel.setTrademarkName(nameTrademark);
            trademarkModel.setCreateDate(date);
            trademarkModel.setDelFlg(0);
            if (tradeService.create(trademarkModel) != 0) {
                return trademarkModel;
            } else {
                return trademarkModel;
            }
        } catch (Exception e) {
            return trademarkModel;
        }
    }

//-------------SỬA THƯƠNG HIỆU-------------//     
    @RequestMapping(value = "/edittrademark", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public TrademarkModel edittrademark(@RequestParam int idTrademark, @RequestParam String trademarkName, TrademarkModel trademarkModel) {
        try {
            trademarkModel.setTrademarkId(idTrademark);
            trademarkModel.setTrademarkName(trademarkName);
            trademarkModel.setUpdateDate(date);
            if (tradeService.update(trademarkModel) != 0) {
                tradeService.findById(idTrademark);
                return trademarkModel;
            } else {
                return trademarkModel;
            }
        } catch (Exception e) {
            return trademarkModel;
        }
    }

    //-------------XÓA THƯƠNG HIỆU-------------// 
    @RequestMapping(value = "/deletetrade", method = RequestMethod.GET)
    @ResponseBody
    public boolean deleteTrade(@RequestParam int idTrandemark, TrademarkModel trademarkModel) {
        try {
            trademarkModel = tradeService.findById(idTrandemark);
            trademarkModel.setDelFlg(1);
            return tradeService.delete(trademarkModel) != 0;
        } catch (Exception e) {
            return false;
        }
    }

    @RequestMapping(value = "/searchTrade", method = RequestMethod.POST)
    public String searchTrade(@RequestParam("search_trade") String trademarkName, HttpServletRequest request, Model m) {
        List<TrademarkModel> listTrad = tradeService.findByName(trademarkName);
        if (listTrad.isEmpty()) {
            m.addAttribute("list", tradeService.getAll());
        } else {
            m.addAttribute("list", listTrad);
            m.addAttribute("trademark", new TrademarkModel());
        }
        return "listTrademark";
    }

    @RequestMapping(value = "/get_trademark")
    @ResponseBody
    public List<TrademarkModel> paginationTrademark(@RequestParam("page") int page) {
        return tradeService.getListTrandemarkByPageIndex(page);

    }
}
