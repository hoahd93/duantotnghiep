/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shop.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.dao.InvoiceDao;
import shop.model.Invoice;
import shop.model.InvoiceDetail;

/**
 *
 * @author LENOVO
 */
@Service
@Transactional
public class InvoiceServiceImpl implements InvoiceService {
@Autowired
private InvoiceDao invoiceDao;

    @Override
    public List<Invoice> getInvoiceByDay(Integer month) {
        return invoiceDao.getInvoiceByDay(month);
    }

    @Override
    public List<Invoice> getInvoiceByMonth(Integer year) {
        return invoiceDao.getInvoiceByMonth(year);
    }
    
}
