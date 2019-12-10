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
import shop.dao.ProductDAO;
import shop.dao.ProductDetailDAO;
import shop.model.ProductAllModel;
import shop.model.ProductDetailModel;
import shop.model.ProductModel;

/**
 *
 * @author Admin
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDAO productdao;
    @Autowired
    private ProductDetailDAO productDetailDAO;

    @Override
    @Transactional
    public ProductAllModel create(ProductModel object1, ProductDetailModel object2) {
        int result = productdao.create(object1);
        System.out.print("result:" + result);
        object2.setProductId(result);
        productDetailDAO.create(object2);
        ProductAllModel productAllModel = new ProductAllModel();
        return productAllModel;
    }

    @Override
    @Transactional
    public void update(ProductModel object1, ProductDetailModel object2) {
        productdao.update(object1);
        productDetailDAO.update(object2);
    }

    @Override
    @Transactional
    public void delete(ProductModel object1, ProductDetailModel object2) {
        productdao.delete(object1);
        productDetailDAO.delete(object2);
    }

    @Override
    public ProductModel findById(int productId) {
        return productdao.findById(productId);
    }

    @Override
    public List<ProductAllModel> getAll() {
        return productdao.getAll();
    }

    @Override
    public List<ProductModel> getAllAo() {
        return productdao.getAllAo();
    }

    @Override
    public List<ProductModel> getAllQuan() {
        return productdao.getAllQuan();
    }

    @Override
    public List<ProductModel> getAllTuiXach() {
        return productdao.getAllTuiXach();
    }

    @Override
    public List<ProductModel> getAllGiay() {
        return productdao.getAllGiay();
    }

    @Override
    public List<ProductModel> getAllNon() {
        return productdao.getAllNon();
    }
    @Override
    public List<ProductModel> getAllNB() {
        return productdao.getAllNB();
    }

    @Override
    public ProductModel findByCode(String productCode) {
        return productdao.findByCode(productCode);
    }

    @Override
    public List<ProductAllModel> findByName(String productName) {
        return productdao.findByName(productName);
    }

    @Override
    public Integer countProduct() {
        return productdao.countProduct();
    }

    @Override
    public List<ProductAllModel> getListProductByPageIndex(int page) {
        int firstIndex = (page * 5) - 5 + 1;
        int secondIndex = firstIndex + 5 - 1;
        return productdao.getListProductByPageIndex(firstIndex, secondIndex);
    }
}
