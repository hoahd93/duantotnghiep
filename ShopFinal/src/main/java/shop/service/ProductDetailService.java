/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shop.service;

import java.util.List;
import shop.model.ProductDetailModel;
import shop.model.ProductModel;
import shop.model.ProductShow;

/**
 *
 * @author LENOVO
 */
public interface ProductDetailService {

    // create
    public int create(ProductDetailModel object);

    // update
    public int update(ProductDetailModel object);

    // delete
    public int delete(ProductDetailModel object);

    // find by id
    public ProductDetailModel findById(int productModelId);

    //find by id
    public List<ProductDetailModel> findByproductId(int productModelId);

    // get product by product detail id
    public ProductModel getProduct(int productModelId);

    // load list category
    public List<ProductDetailModel> getAll();

    // load list category
    public List<ProductDetailModel> getAllAo();

    public List<ProductShow> getProductShowById(Integer productModelId);

    public List<ProductShow> getProductShows();

//    public List<ProductShow> getProductDetail(List<ProductModel> listProduct);
}
