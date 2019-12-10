/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shop.dao;

import java.util.List;
import shop.model.Invoice;

/**
 *
 * @author MauBV
 */
public interface InvoiceDao {
    public List<Invoice> getInvoiceByDay(Integer month);

    public List<Invoice> getInvoiceByMonth(Integer year);
}
