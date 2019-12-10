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
import shop.model.ProductDetailModel;
import shop.dao.ProductDetailDAO;
import shop.model.ProductModel;
import shop.model.ProductShow;

/**
 *
 * @author admin
 */
@Service
@Transactional
public class ProductDetailServiceImpl implements ProductDetailService {

    @Autowired
    private ProductDetailDAO productmodelDAO;

    @Override
    public int create(ProductDetailModel object) {
        return productmodelDAO.create(object);
    }

    @Override
    public int update(ProductDetailModel object) {
        return productmodelDAO.update(object);
    }

    @Override
    public int delete(ProductDetailModel object) {
        return productmodelDAO.delete(object);
    }

    @Override
    public ProductDetailModel findById(int productModelId) {
        return productmodelDAO.findById(productModelId);
    }

    @Override
    public List<ProductDetailModel> getAll() {
        return productmodelDAO.getAll();
    }

    @Override
    public List<ProductDetailModel> findByproductId(int productId) {
        return productmodelDAO.findByproductId(productId);
    }

    @Override
    public List<ProductDetailModel> getAllAo() {
        return productmodelDAO.getAllAo();
    }

    @Override
    public ProductModel getProduct(int productModelId) {
        return productmodelDAO.getProduct(productModelId);
    }
    
     @Override
    public List<ProductShow> getProductShowById(Integer productModelId) {
        return productmodelDAO.getProductShowById(productModelId);
    }

    @Override
    public List<ProductShow> getProductShows() {
        return productmodelDAO.getProductShows();
    }

//    @Override
//    public List<ProductShow> getProductDetail(List<ProductModel> listProduct) {
//        List<ProductShow> listProductDetail = new ArrayList<ProductShow>();
//        for (ProductModel productModel : listProduct) {
//            try {
//                listProductDetail.addAll(productmodelDAO.getProductDetailByProductId(productModel.getProductId()));
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        return listProductDetail;
//    }

}
