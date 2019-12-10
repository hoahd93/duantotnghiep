/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shop.dao;

import java.util.List;
import shop.model.TrademarkModel;

/**
 *
 * @author admin
 */
public interface TrademarkDAO {

    // create
    public int create(TrademarkModel object);

    // update
    public int update(TrademarkModel object);

    // delete
    public int delete(TrademarkModel object);

    // find by id
    public TrademarkModel findById(int trademarkId);

    // load list trademark
    public List<TrademarkModel> getAll();
    // find by name

    public List<TrademarkModel> findByName(String trademarkName);

    public List<TrademarkModel> getListTrandemarkByPageIndex(int firstIndex, int secondIndex);

    public Integer countTrademark();
}
