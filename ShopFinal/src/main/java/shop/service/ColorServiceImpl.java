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
import shop.dao.ColorDAO;
import shop.model.ColorModel;

/**
 *
 * @author LENOVO
 */
@Service
@Transactional
public class ColorServiceImpl implements ColorService {

    @Autowired
    private ColorDAO colorDAO;

    @Override
    public int create(ColorModel object) {
        return colorDAO.create(object);
    }

    @Override
    public int update(ColorModel object) {
        return colorDAO.update(object);
    }

    @Override
    public int delete(ColorModel object) {
        return colorDAO.delete(object);
    }

    @Override
    public ColorModel findById(int colorId) {
        return colorDAO.findById(colorId);
    }

    @Override
    public List<ColorModel> getAll() {
        return colorDAO.getAll();
    }

    @Override
    public List<ColorModel> findByName(String nameColor) {
        return colorDAO.findByName(nameColor);
    }
    
    @Override
    public List<ColorModel> getListColorByPageIndex(int page){
        int firstIndex = (page * 5) - 5 + 1;
        int secondIndex = firstIndex + 5 - 1;
        return colorDAO.getListColorByPageIndex(firstIndex, secondIndex);
    }
    
    @Override
    public Integer countColor() {
        return colorDAO.countColor();
    }
}
