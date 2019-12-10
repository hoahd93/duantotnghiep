/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shop.dao;

import java.util.List;
import shop.model.ProductAllModel;
import shop.model.ProductModel;

/**
 *
 * @author admin
 */
public interface ProductDAO {
    // create

    public int create(ProductModel object1);

    // update
    public int update(ProductModel object1);

    // delete
    public int delete(ProductModel object1);

    // find by id
    public ProductModel findById(int categoryId);
    
    // find by code
    public ProductModel findByCode(String productCode);

    // load list ProductModel
    public List<ProductAllModel> getAll();

    // load list ProductModel
    public List<ProductModel> getAllAo();
    // load list ProductModel

    public List<ProductModel> getAllQuan();
    // load list ProductModel

    public List<ProductModel> getAllTuiXach();
    // load list ProductModel

    public List<ProductModel> getAllGiay();
    // load list ProductModel

    public List<ProductModel> getAllNon();
    
    public List<ProductModel> getAllNB();
    
    public List<ProductModel> getAllAVT();
    // find list by name
    public List<ProductAllModel> findByName(String productName);
    
    public Integer countProduct();
    
    public List<ProductAllModel> getListProductByPageIndex(int firstIndex, int secondIndex);
    
}
