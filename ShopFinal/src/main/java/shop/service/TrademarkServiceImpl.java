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
import shop.dao.TrademarkDAO;
import shop.model.TrademarkModel;

/**
 *
 * @author Admin
 */
@Service
@Transactional
public class TrademarkServiceImpl implements TrademarkService {

    @Autowired
    private TrademarkDAO tradeDAO;

    @Override
    public int create(TrademarkModel object) {
        return tradeDAO.create(object);
    }

    @Override
    public int update(TrademarkModel object) {
        return tradeDAO.update(object);
    }

    @Override
    public int delete(TrademarkModel object) {
        return tradeDAO.delete(object);
    }

    @Override
    public TrademarkModel findById(int trademarkId) {
        return tradeDAO.findById(trademarkId);
    }

    @Override
    public List<TrademarkModel> getAll() {
        return tradeDAO.getAll();
    }

    @Override
    public List<TrademarkModel> findByName(String trademarkName) {
        return tradeDAO.findByName(trademarkName);
    }

    @Override
    public List<TrademarkModel> getListTrandemarkByPageIndex(int page) {
        int firstIndex = (page * 5) - 5 + 1;
        int secondIndex = firstIndex + 5 - 1;
        return tradeDAO.getListTrandemarkByPageIndex(firstIndex, secondIndex);
    }

    @Override
    public Integer countTrademark() {
        return tradeDAO.countTrademark();
    }

}
