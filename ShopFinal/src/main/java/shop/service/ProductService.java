/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shop.service;

import java.util.List;
import shop.model.ProductAllModel;
import shop.model.ProductDetailModel;
import shop.model.ProductModel;

/**
 *
 * @author LENOVO
 */
public interface ProductService {
    // create

    public ProductAllModel create(ProductModel object1, ProductDetailModel object2);

    // update
    public void update(ProductModel object1, ProductDetailModel object2);

    // delete
    public void delete(ProductModel object1, ProductDetailModel object2);

    // find by id
    public ProductModel findById(int productId);
    
    // find by code
    public ProductModel findByCode(String productCode);
    
    // find list by name
    public List<ProductAllModel> findByName(String productName);

    // load list category
    public List<ProductAllModel> getAll();

    // load list ProductModel
    public List<ProductModel> getAllQuan();
    // load list ProductModel

    public List<ProductModel> getAllTuiXach();

    // load list ProductModel
    public List<ProductModel> getAllGiay();
    // load list ProductModel

    public List<ProductModel> getAllAo();
    // load list ProductModel

    public List<ProductModel> getAllNon();
        // load list ProductModel

    public List<ProductModel> getAllNB();
    
    public Integer countProduct();
    
    public List<ProductAllModel> getListProductByPageIndex(int page);

}
