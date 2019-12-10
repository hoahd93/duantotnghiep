/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shop.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import shop.model.UsersModel;

/**
 *
 * @author admin
 */
@Repository
public class UsersDAOImpl implements UsersDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int create(UsersModel object) {
        String sql = " INSERT INTO [dbo].[MUsers] ([email], [password],"
                + " [fullname], [birthday], [gender],  [phone_number], "
                + " [address], [role_id], [img_url], [token], [create_date],"
                + " [del_flg]) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        return jdbcTemplate.update(sql, new Object[]{ object.getEmail(), object.getPassWord(), object.getFullName(), object.getBirthDay(),
            object.getGender(), object.getPhoneNumber(), object.getAddress(), object.getRoleId(), object.getImage(),
            object.getToken(), object.getCreateDate(), object.getDelFlg()});
    }

    @Override
    public int update(UsersModel object) {
        String sql = "UPDATE [dbo].[MUsers] SET [email]=?,"
                + " [fullname]=?, [birthday]=?, [gender]=?,  [phone_number]=?, "
                + " [address]=?, [img_url]=?, [update_date]=?, [del_flg]=?"
                + "  WHERE [user_id]=?";
        return jdbcTemplate.update(sql, new Object[]{object.getEmail(), object.getFullName(), object.getBirthDay(),
            object.getGender(), object.getPhoneNumber(), object.getAddress(), object.getImage(),
             object.getUpdateDate(),object.getDelFlg(), object.getUserId()});
    }
    
    //Đổi mật khẩu khách hàng
    @Override
    public int updatePass(UsersModel object) {
        String sql = "UPDATE [dbo].[MUsers] SET [password]=?"
                + "  WHERE [email]=?";
        return jdbcTemplate.update(sql, new Object[]{object.getPassWord(), object.getEmail()});
    }
    //đổi mật khẩu nhân viên--Dành cho admin
    @Override
    public int changePassword(UsersModel object) {
        String sql = "UPDATE [dbo].[MUsers] set [password]= ? where [user_id] = ?";
        return jdbcTemplate.update(sql, new Object[]{object.getPassWord(), object.getUserId()});
    }

    @Override
    public int delete(UsersModel object) {
        String sql = " UPDATE [dbo].[MUsers] SET [del_flg]=?  WHERE [user_id]=?";
        return jdbcTemplate.update(sql, new Object[]{object.getDelFlg(), object.getUserId()});
    }

    @Override
    public List<UsersModel> getAll() {
        String sql = "SELECT [user_id], [email], [password],"
                + " [fullname], [birthday], [gender],  [phone_number], "
                + " [address], [role_id], [img_url], [token], [create_date],"
                + " [update_date], [del_flg]"
                + " FROM [dbo].[MUsers] WHERE [del_flg]=0 AND [role_id] = 2";
        return jdbcTemplate.query(sql, new RowMapper<UsersModel>() {
            @Override
            public UsersModel mapRow(ResultSet rs, int rowNum) throws SQLException {
                UsersModel u = new UsersModel();
                u.setUserId(rs.getInt("user_id"));
                u.setEmail(rs.getString("email"));
                u.setPassWord(rs.getString("password"));
                u.setFullName(rs.getString("fullname"));
                u.setBirthDay(rs.getDate("birthday"));
                u.setGender(rs.getInt("gender"));
                u.setPhoneNumber(rs.getString("phone_number"));
                u.setAddress(rs.getString("address"));
                u.setRoleId(rs.getInt("role_id"));
                u.setImage(rs.getString("img_url"));
                u.setToken(rs.getString("token"));
                u.setCreateDate(rs.getDate("create_date"));
                u.setUpdateDate(rs.getDate("update_date"));
                return u;
            }
        });
    }

    @Override
    public List<UsersModel> findByName(String fullName) {
//                StringBuilder sql = new StringBuilder("SELECT [user_id], [fullname], [birthday],");
//        sql.append("[gender], [email], [phone_number], [img_url], [address],");
//        sql.append(" [create_date], [update_date] FROM [dbo].[MUser]");
//        sql.append( " WHERE [del_flg] = 0 AND [fullname] LIKE '" + fullName + "%'");
//        String mssql = sql.toString();
        String sql = " SELECT [user_id], [fullname], [birthday],"
                + " [gender], [email], [phone_number], [img_url], [address],"
                + " [create_date], [update_date] FROM [dbo].[MUsers]"
                + " WHERE [del_flg] = 0 and [role_id]=2 AND [fullname] like N'%" + fullName + "%'";
        return jdbcTemplate.query(sql, new RowMapper<UsersModel>() {
            @Override
            public UsersModel mapRow(ResultSet rs, int rowNum) throws SQLException {
                UsersModel u = new UsersModel();
                u.setUserId(rs.getInt("user_id"));
                u.setFullName(rs.getString("fullname"));
                u.setBirthDay(rs.getDate("birthday"));
                u.setGender(rs.getInt("gender"));
                u.setEmail(rs.getString("email"));
                u.setPhoneNumber(rs.getString("phone_number"));
                u.setImage(rs.getString("img_url"));
                u.setAddress(rs.getString("address"));
                u.setCreateDate(rs.getDate("create_date"));
                u.setUpdateDate(rs.getDate("update_date"));
                return u;
            }
        });
    }

    @Override
    public UsersModel findById(int userId) {
        String sql = "SELECT [user_id], [email], [password],"
                + " [fullname], [birthday], [gender],  [phone_number], "
                + " [address], [role_id], [img_url], [token], [create_date],"
                + " [update_date], [del_flg]"
                + " FROM [dbo].[MUsers] WHERE [user_id]=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{userId}, new RowMapper<UsersModel>() {
            @Override
            public UsersModel mapRow(ResultSet rs, int rowNum) throws SQLException {
                UsersModel u = new UsersModel();
                u.setUserId(rs.getInt("user_id"));
                u.setEmail(rs.getString("email"));
                u.setPassWord(rs.getString("password"));
                u.setFullName(rs.getString("fullname"));
                u.setBirthDay(rs.getDate("birthday"));
                u.setGender(rs.getInt("gender"));
                u.setPhoneNumber(rs.getString("phone_number"));
                u.setAddress(rs.getString("address"));
                u.setRoleId(rs.getInt("role_id"));
                u.setImage(rs.getString("img_url"));
                u.setToken(rs.getString("token"));
                u.setCreateDate(rs.getDate("create_date"));
                u.setUpdateDate(rs.getDate("update_date"));
                u.setDelFlg(rs.getInt("del_flg"));
                return u;
            }
        });
    }

    @Override
    public UsersModel findByEmail(String email) {
        String sql = "SELECT [user_id], [email], [password],"
                + " [fullname], [birthday], [gender],  [phone_number], "
                + " [address], [role_id], [img_url], [token], [create_date],"
                + " [update_date], [del_flg]"
                + " FROM [dbo].[MUsers] WHERE [email]=?";
        try {
            return jdbcTemplate.queryForObject(sql, new Object[]{email}, new RowMapper<UsersModel>() {
            @Override
            public UsersModel mapRow(ResultSet rs, int rowNum) throws SQLException {
                UsersModel u = new UsersModel();
                u.setUserId(rs.getInt("user_id"));
                u.setEmail(rs.getString("email"));
                u.setPassWord(rs.getString("password"));
                u.setFullName(rs.getString("fullname"));
                u.setBirthDay(rs.getDate("birthday"));
                u.setGender(rs.getInt("gender"));
                u.setPhoneNumber(rs.getString("phone_number"));
                u.setAddress(rs.getString("address"));
                u.setRoleId(rs.getInt("role_id"));
                u.setImage(rs.getString("img_url"));
                u.setToken(rs.getString("token"));
                u.setCreateDate(rs.getDate("create_date"));
                u.setUpdateDate(rs.getDate("update_date"));
                u.setDelFlg(rs.getInt("del_flg"));
                return u;
            }
        });
        } catch (Exception e) {
            return null;
        }
        
    }
    
    @Override
    public List<UsersModel> getListUserByPageIndex(int firstIndex, int secondIndex) {
        String sql = "SELECT            [user_id]\n" +
"                               , 	[email]\n" +
"                               ,	[fullname]\n" +
"                               ,	[birthday]\n" +
"                               ,	[gender]\n" +
"				,	[phone_number]\n" +
"				,	[address]\n" +
"				,	[img_url]\n" +
"				,	[create_date]\n" +
"				,	[update_date]\n" +
"                            FROM\n" +
"                           (SELECT [user_id]\n" +
"                               , 	[email]\n" +
"                               ,	[fullname]\n" +
"                               ,	[birthday]\n" +
"				,	[gender]\n" +
"				,	[phone_number]\n" +
"				,	[address]\n" +
"				,	[img_url]\n" +
"				,	[create_date]\n" +
"				,	[update_date] \n" +
"                              	, 	ROW_NUMBER() OVER( ORDER BY [user_id] DESC)  AS number \n" +
"                             	FROM \n" +
"                            	[dbo].[MUsers]\n" +
"                              	WHERE [del_flg]= 0 and [role_id] = 2 \n" +
"                             ) AS temp \n" +
"                              WHERE \n" +
"                           number BETWEEN ? AND ?";
        return jdbcTemplate.query(sql, new Object[]{firstIndex, secondIndex}, new RowMapper<UsersModel>() {
            @Override
            public UsersModel mapRow(ResultSet rs, int i) throws SQLException {
                UsersModel usersmodel = new UsersModel();
                usersmodel.setUserId(rs.getInt("user_id"));
                usersmodel.setEmail(rs.getString("email"));
                usersmodel.setFullName(rs.getString("fullname"));
                usersmodel.setBirthDay(rs.getDate("birthday"));
                usersmodel.setGender(rs.getInt("gender"));
                usersmodel.setPhoneNumber(rs.getString("phone_number"));
                usersmodel.setAddress(rs.getString("address"));
                usersmodel.setImage(rs.getString("img_url"));
                usersmodel.setCreateDate(rs.getDate("create_date"));
                usersmodel.setUpdateDate(rs.getDate("update_date"));
                return usersmodel;
            }
        });
    }

    @Override
    public Integer countUsers() {
        String sql = " SELECT COUNT(*) FROM [dbo].[MUsers] WHERE [del_flg]=0";
        return (int) jdbcTemplate.queryForObject(sql, Integer.class);
    }

    
    
}
