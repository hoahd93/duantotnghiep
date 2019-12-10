/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shop.dao;

import java.util.List;
import shop.model.ProductDetailModel;
import shop.model.ProductModel;
import shop.model.ProductShow;

/**
 *
 * @author MauBV
 */
public interface ProductDetailDAO {

    // create
    public int create(ProductDetailModel object2);

    // update
    public int update(ProductDetailModel object2);

    // delete
    public int delete(ProductDetailModel object2);

    // find by id
    public ProductDetailModel findById(int productModelId);

    //find by id
    public List<ProductDetailModel> findByproductId(int productId);

    // load list category
    public List<ProductDetailModel> getAll();

    // load list ProductModel
    public List<ProductDetailModel> getAllAo();

    //get product by product detail
    public ProductModel getProduct(int productModelId);

       public List<ProductShow> getProductShowById(Integer productModelId);

    public List<ProductShow> getProductShows();
}
