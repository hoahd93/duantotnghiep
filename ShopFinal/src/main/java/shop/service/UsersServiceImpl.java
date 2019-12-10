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
import shop.dao.UsersDAO;
import shop.model.UsersModel;

/**
 *
 * @author admin
 */
@Service
@Transactional
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersDAO usersDAO;

    @Override
    public int create(UsersModel object) {
        return usersDAO.create(object);
    }

    @Override
    public int update(UsersModel object) {
        return usersDAO.update(object);
    }
    
    @Override
    public int updatePass(UsersModel object) {
        return usersDAO.updatePass(object);
    }

    @Override
    public int delete(UsersModel object) {
        return usersDAO.delete(object);
    }
    @Override
    public List<UsersModel> getAll() {
        return usersDAO.getAll();
    }

    @Override
    public List<UsersModel> findByName(String fullName) {
        return usersDAO.findByName(fullName);
    }

    @Override
    public UsersModel findById(int userId) {
        return usersDAO.findById(userId);
    }

    @Override
    public UsersModel findByEmail(String email) {
        return usersDAO.findByEmail(email);
    }

    @Override
    public Integer countUsers() {
        return usersDAO.countUsers();
    }

    @Override
    public List<UsersModel> getListUserByPageIndex(int page) {
        int firstIndex = (page * 5) - 5 + 1;
        int secondIndex = firstIndex + 5 -1;
        return usersDAO.getListUserByPageIndex(firstIndex, secondIndex);
    }

    @Override
    public int changePassword(UsersModel object) {
        return usersDAO.changePassword(object);
    }
}
