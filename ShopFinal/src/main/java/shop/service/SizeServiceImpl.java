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
import shop.dao.SizeDAO;
import shop.model.SizeModel;

/**
 *
 * @author admin
 */
@Service
@Transactional
public class SizeServiceImpl implements SizeService {

    @Autowired
    private SizeDAO sizeDAO;

    @Override
    public int create(SizeModel object) {
        return sizeDAO.create(object);
    }

    @Override
    public int update(SizeModel object) {
        return sizeDAO.update(object);
    }

    @Override
    public int delete(SizeModel object) {
        return sizeDAO.delete(object);
    }

    @Override
    public SizeModel findById(int size_id) {
        return sizeDAO.findById(size_id);
    }

    @Override
    public List<SizeModel> getAll() {
        return sizeDAO.getAll();
    }

    @Override
    public List<SizeModel> findByName(String sizeName) {

        return sizeDAO.findByName(sizeName);
    }

    @Override
    public Integer countSize() {
        return sizeDAO.countSize();
    }

    @Override
    public List<SizeModel> getListSizeByPageIndex(int page) {
        int firstIndex = (page * 5) - 5 + 1;
        int secondIndex = firstIndex + 5 - 1;
        return sizeDAO.getListSizeByPageIndex(firstIndex, secondIndex);
    }

    @Override
    public SizeModel findByNameSize(String sizeName) {
        return sizeDAO.findByNameSize(sizeName);
    }

}
