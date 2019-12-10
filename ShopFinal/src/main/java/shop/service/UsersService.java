/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shop.service;

import java.util.List;
import shop.model.UsersModel;

/**
 *
 * @author admin
 */
public interface UsersService {
    // create

    public int create(UsersModel object);

    // update
    public int update(UsersModel object);

    // update pass
    public int updatePass(UsersModel object);
    
    //ĐỔI MẬT KHẨU NHÂN VIÊN
    public int changePassword(UsersModel object);

    // delete
    public int delete(UsersModel object);

    // find by id
    public UsersModel findById(int userId);

    // load list user
    public List<UsersModel> getAll();
    // find list by name

    public List<UsersModel> findByName(String fullName);

    // find by email
    public UsersModel findByEmail(String email);
    
    public Integer countUsers();
    
    public List<UsersModel> getListUserByPageIndex(int page);

}
