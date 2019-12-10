/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shop.dao;

import java.util.List;
import shop.model.CategoryModel;

/**
 *
 * @author admin
 */
public interface CategoryDAO {
     // create
    public int create(CategoryModel object);

    // update
    public int update(CategoryModel object);

    // delete
    public int delete(CategoryModel object);

    // find by id
    public CategoryModel findById(int categoryId);

    // load list category
    public List<CategoryModel> getAll();
        // load list category == áo
    public List<CategoryModel> getAllAo();
                // find by name
     public List<CategoryModel> findByName(String nameCategory);
}
