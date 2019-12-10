/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shop.service;

import java.util.List;
import shop.model.SizeModel;

/**
 *
 * @author LENOVO
 */
public interface SizeService {
    // create
    public int create(SizeModel object);

    // update
    public int update(SizeModel object);

    // delete
    public int delete(SizeModel object);

    // find by id
    public SizeModel findById(int size_id);

    // load list size
    public List<SizeModel> getAll(); 
        // find by name
   public List<SizeModel> findByName(String sizeName);
   
   public SizeModel findByNameSize(String sizeName);
   
    public List<SizeModel> getListSizeByPageIndex(int page);

    public Integer countSize();
    
}
