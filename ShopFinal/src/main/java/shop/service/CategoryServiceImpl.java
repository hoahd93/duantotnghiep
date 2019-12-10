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
import shop.dao.CategoryDAO;
import shop.model.CategoryModel;

/**
 *
 * @author MauBV
 */
@Service

public class CategoryServiceImpl implements CategoryService{
    @Autowired
    private  CategoryDAO cdao;

    @Override
    public int create(CategoryModel object) {
        return cdao.create(object);
    }

    @Override
    public int update(CategoryModel object) {
        return cdao.update(object);
    }

    @Override
    public int delete(CategoryModel object) {
        return cdao.delete(object);
    }

    @Override
    public CategoryModel findById(int categoryId) {
        return cdao.findById(categoryId);
    }

    @Override
    public List<CategoryModel> getAll() {
        return cdao.getAll();
    }
        @Override
    public List<CategoryModel> getAllAo() {
        return cdao.getAllAo();
    }

    @Override
    public List<CategoryModel> findByName(String nameCategory) {
        return cdao.findByName(nameCategory);
    }
}
