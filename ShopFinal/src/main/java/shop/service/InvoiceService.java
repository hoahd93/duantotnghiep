/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shop.service;

import java.util.List;
import shop.model.Invoice;

/**
 *
 * @author LENOVO
 */
public interface InvoiceService {
   public List<Invoice> getInvoiceByDay(Integer month);

    public List<Invoice> getInvoiceByMonth(Integer year);
}
