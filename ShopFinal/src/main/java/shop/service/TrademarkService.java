/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shop.service;

import java.util.List;
import shop.model.TrademarkModel;

/**
 *
 * @author LENOVO
 */
public interface TrademarkService {
    // create

    public int create(TrademarkModel object);

    // update
    public int update(TrademarkModel object);

    // delete
    public int delete(TrademarkModel object);

    // find by id
    public TrademarkModel findById(int trademarkId);

    // load list category
    public List<TrademarkModel> getAll();
    // find by name

    public List<TrademarkModel> findByName(String trademarkName);

    public List<TrademarkModel> getListTrandemarkByPageIndex(int page);

    public Integer countTrademark();
}
