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
import shop.dao.InvoiceDetailDao;
import shop.model.InvoiceDetail;

/**
 *
 * @author LENOVO
 */
@Service
@Transactional
public class InvoiceDetailServiceImpl implements InvoiceDetailService {

    @Autowired
    private InvoiceDetailDao invoiceDetailDao;

    @Override
    public List<InvoiceDetail> getInvoiceDetailByDay(String day) {
        return invoiceDetailDao.getInvoiceDetailByDay(day);
    }

    @Override
    public List<InvoiceDetail> getInvoiceDetailByMonth(String month, String year) {
        return invoiceDetailDao.getInvoiceDetailByMonth(month, year);
    }

}
