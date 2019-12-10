/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shop.service;

import java.util.List;
import shop.model.InvoiceDetail;

/**
 *
 * @author LENOVO
 */
public interface InvoiceDetailService {

    public List<InvoiceDetail> getInvoiceDetailByDay(String day);

    public List<InvoiceDetail> getInvoiceDetailByMonth(String month, String year);
}
