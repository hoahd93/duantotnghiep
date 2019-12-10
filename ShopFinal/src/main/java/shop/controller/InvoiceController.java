/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shop.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import shop.model.Invoice;
import shop.service.InvoiceDetailService;
import shop.service.InvoiceService;

/**
 *
 * @author LENOVO
 */
@Controller
@RequestMapping(value = "/manager/admin")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;
    @Autowired
    private InvoiceDetailService invoiceDetailService;

    @RequestMapping(value = "/invoice-day", method = RequestMethod.GET)
    public String getInvoiceByDay(Model m) {
        List<Invoice> listInvoice = invoiceService.getInvoiceByDay(1);
        System.out.println("==================" + listInvoice.size());
        for (Invoice invoice : listInvoice) {
            System.out.println("============" + invoice.getDateTime());
            System.out.println("============" + invoice.getTotalPrice());
            System.out.println("============" + invoice.getQuantity());
        }
        System.out.println("============");
        m.addAttribute("listInvoice", listInvoice);
        m.addAttribute("Invoice", new Invoice());
        return "revenueByDay";
    }

    @RequestMapping(value = "/invoice-day/{month}")
    public String getInvoiceByDay(@PathVariable("month") Integer month, Model m) {
        List<Invoice> listInvoice = invoiceService.getInvoiceByDay(month);
        m.addAttribute("listInvoice", listInvoice);
        m.addAttribute("Invoice", new Invoice());
        return "revenueByDay";
    }
//    @RequestMapping(value="/invoice-day/detail/{day}",method = RequestMethod.GET)
//    public String getInvoiceByDay( Model m){
//        List<Invoice> listInvoice = invoiceDetailService.getInvoiceDetailByDay(day);
//        System.out.println("=================="+listInvoice.size());
//        for (Invoice invoice : listInvoice) {
//            System.out.println("============"+invoice.getDateTime());
//            System.out.println("============"+invoice.getTotalPrice());
//            System.out.println("============"+invoice.getQuantity());
//        }
//        System.out.println("============");
//        m.addAttribute("listInvoice",listInvoice);
//        m.addAttribute("Invoice", new Invoice());
//        return "revenueByDay";
//    }

    @RequestMapping(value = "/invoice-month", method = RequestMethod.GET)
    public String getInvoiceByMonths(Model m) {
        List<Invoice> listInvoiceMonths = invoiceService.getInvoiceByMonth(2019);
        System.out.println("==================" + listInvoiceMonths.size());
        for (Invoice invoice : listInvoiceMonths) {
            System.out.println("============" + invoice.getDateTime());
            System.out.println("============" + invoice.getTotalPrice());
            System.out.println("============" + invoice.getQuantity());
        }
        System.out.println("============");
        m.addAttribute("listInvoiceByMonths", listInvoiceMonths);
        m.addAttribute("Invoice", new Invoice());
        return "revenueByMonth";
    }
    
     @RequestMapping(value = "/invoice-month/{years}")
    public String getInvoiceByMonth(@PathVariable("years") Integer month, Model m) {
        List<Invoice> listInvoice = invoiceService.getInvoiceByDay(month);
        m.addAttribute("listInvoice", listInvoice);
        m.addAttribute("Invoice", new Invoice());
        return "revenueByMonth";
    }
}
