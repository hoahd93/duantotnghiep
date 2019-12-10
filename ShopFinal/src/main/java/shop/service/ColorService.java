/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shop.service;

import java.util.List;
import shop.model.ColorModel;


/**
 *
 * @author LENOVO
 */
public interface ColorService {
 
     // create
    public int create(ColorModel object);

    // update
    public int update(ColorModel object);

    // delete
    public int delete(ColorModel object);

    // find by id
    public ColorModel findById(int colorId);

    // load list category
    public List<ColorModel> getAll();
            // find by name
   public List<ColorModel> findByName(String nameColor);
   
   public List<ColorModel> getListColorByPageIndex(int page);
   
   public Integer countColor();
}
