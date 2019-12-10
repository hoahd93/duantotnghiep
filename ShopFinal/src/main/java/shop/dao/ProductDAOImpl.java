/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import shop.model.ProductModel;
import shop.model.ProductAllModel;

/**
 *
 * @author LENOVO
 */
@Repository
public class ProductDAOImpl implements ProductDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int create(ProductModel object1) {
        String sqlProduct = " INSERT INTO [dbo].[TProduct] ([name]\n"
                + "           ,[product_code]\n"
                + "           ,[discount_rate]\n"
                + "           ,[description_short]\n"
                + "           ,[description]\n"
                + "           ,[category_id]\n"
                + "           ,[img_main]\n"
                + "           ,[img1]\n"
                + "           ,[img2]\n"
                + "           ,[img3]\n"
                + "           ,[img4]\n"
                + "           ,[trademark_id]\n"
                + "           ,[created_at]\n"
                + "           ,[del_flg]) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        GeneratedKeyHolder holder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement statement = con.prepareStatement(sqlProduct, Statement.RETURN_GENERATED_KEYS);
                statement.setString(1, object1.getName());
                statement.setString(2, object1.getProductCode());
                statement.setInt(3, object1.getDiscountRate());
                statement.setString(4, object1.getDescriptionShort());
                statement.setString(5, object1.getDescription());
                statement.setInt(6, object1.getCategoryId());
                statement.setString(7, object1.getImgMain());
                statement.setString(8, object1.getImg1());
                statement.setString(9, object1.getImg2());
                statement.setString(10, object1.getImg3());
                statement.setString(11, object1.getImg4());
                statement.setInt(12, object1.getTrademarkId());
                statement.setDate(13, new java.sql.Date(object1.getCreatedAt().getTime()));
                statement.setInt(14, object1.getDelFlg());
                return statement;
            }
        }, holder);
        return Integer.parseInt(holder.getKey().toString());
    }

    @Override
    public int update(ProductModel object1) {
        String sql = " UPDATE [dbo].[TProduct] SET [name]=?, [product_code]=?, [discount_rate]=?, [description_short]=?, [description]=?, [category_id]=?,"
                + " [img_main]=?, [img1]=?, [img2]=?, [img3]=?, [img4]=?, [trademark_id]=?, [update_date]=? WHERE [product_id]=?";
        return jdbcTemplate.update(sql, new Object[]{object1.getName(), object1.getProductCode(),
            object1.getDiscountRate(), object1.getDescriptionShort(), object1.getDescription(), object1.getCategoryId(),
            object1.getImgMain(), object1.getImg1(), object1.getImg2(), object1.getImg3(), object1.getImg4(),
            object1.getTrademarkId(), object1.getUpdateDate(), object1.getProductId()});
    }

    @Override
    public int delete(ProductModel object1) {
        String sql = " UPDATE [dbo].[TProduct] SET [del_flg]=? WHERE [product_id]=?";
        return jdbcTemplate.update(sql, new Object[]{object1.getDelFlg(), object1.getProductId()});
    }

    @Override
    public ProductModel findById(int productId) {
        String sql = " SELECT * FROM [dbo].[TProduct] WHERE [product_id]=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{productId}, new RowMapper<ProductModel>() {
            @Override
            public ProductModel mapRow(ResultSet rs, int rowNum) throws SQLException {

                ProductModel productmodel = new ProductModel();
                productmodel.setProductId(rs.getInt(1));
                productmodel.setName(rs.getString(2));
                productmodel.setProductCode(rs.getString(3));
                productmodel.setDiscountRate(rs.getInt(4));
                productmodel.setDescriptionShort(rs.getString(5));
                productmodel.setDescription(rs.getString(6));
                productmodel.setCategoryId(rs.getInt(7));
                productmodel.setImgMain(rs.getString(8));
                productmodel.setImg1(rs.getString(9));
                productmodel.setImg2(rs.getString(10));
                productmodel.setImg3(rs.getString(11));
                productmodel.setImg4(rs.getString(12));
                productmodel.setTrademarkId(rs.getInt(13));
                productmodel.setCreatedAt(rs.getDate(14));
                productmodel.setUpdateDate(rs.getDate(15));
                productmodel.setDelFlg(rs.getInt(16));
                return productmodel;
            }
        });
    }

    @Override
    public List<ProductAllModel> getAll() {
        String sql = " select pd.[product_id], pd.[name], pd.[product_code], pd.[discount_rate],\n"
                + "pd.[description_short], pd.[category_id], pd.[img_main], pd.[trademark_id],\n"
                + "pd.[created_at], pd.[update_date], pdm.product_model_id, pdm.color_id, pdm.size_id, pdm.stock, pdm.price\n"
                + "from [dbo].[TProduct] pd\n"
                + "inner join [dbo].[TProduct_model] pdm\n"
                + "on pd.product_id = pdm.product_id\n"
                + "where pd.del_flg = 0 and pdm.del_flg = 0";
        return jdbcTemplate.query(sql, new RowMapper<ProductAllModel>() {
            @Override
            public ProductAllModel mapRow(ResultSet rs, int rowNum) throws SQLException {

                ProductAllModel productAllModel = new ProductAllModel();
                productAllModel.setProductId(rs.getInt("product_id"));
                productAllModel.setName(rs.getString("name"));
                productAllModel.setProductCode(rs.getString("product_code"));
                productAllModel.setDiscountRate(rs.getInt("discount_rate"));
                productAllModel.setDescriptionShort(rs.getString("description_short"));
                productAllModel.setCategoryId(rs.getInt("category_id"));
                productAllModel.setImgMain(rs.getString("img_main"));
                productAllModel.setTrademarkId(rs.getInt("trademark_id"));
                productAllModel.setCreatedAt(rs.getDate("created_at"));
                productAllModel.setUpdateDate(rs.getDate("update_date"));
                productAllModel.setProductModelId(rs.getInt("product_model_id"));
                productAllModel.setColorId(rs.getInt("color_id"));
                productAllModel.setSizeId(rs.getInt("size_id"));
                productAllModel.setStock(rs.getInt("stock"));
                productAllModel.setPrice(rs.getDouble("price"));
                return productAllModel;
            }
        });
    }

    @Override
    public List<ProductModel> getAllAo() {
        String sql = "SELECT TProduct.product_id, TProduct.name,TProduct.img_main"
                + " FROM [dbo].[TProduct]"
                + " INNER JOIN [dbo].[MCategory] ON"
                + " TProduct.category_id = MCategory.category_id"
                + " WHERE MCategory.name_category like 'áo'";
        return jdbcTemplate.query(sql, new RowMapper<ProductModel>() {
            @Override
            public ProductModel mapRow(ResultSet rs, int rowNum) throws SQLException {

                ProductModel productmodel = new ProductModel();
                productmodel.setProductId(rs.getInt("product_id"));
                productmodel.setName(rs.getString("name"));
                productmodel.setImgMain(rs.getString("img_main"));
                return productmodel;
            }
        });
    }

    @Override
    public List<ProductModel> getAllQuan() {
        String sql = " SELECT TProduct.product_id, TProduct.name,TProduct.img_main"
                + " FROM [dbo].[TProduct]"
                + " INNER JOIN [dbo].[MCategory] ON"
                + " TProduct.category_id = MCategory.category_id"
                + " WHERE MCategory.name_category like 'qu_n'";
        return jdbcTemplate.query(sql, new RowMapper<ProductModel>() {
            @Override
            public ProductModel mapRow(ResultSet rs, int rowNum) throws SQLException {

                ProductModel productmodel = new ProductModel();
                productmodel.setProductId(rs.getInt("product_id"));
                productmodel.setName(rs.getString("name"));
                productmodel.setImgMain(rs.getString("img_main"));
                return productmodel;
            }
        });
    }

//    @Override
//    public List<ProductModel> getAllTuiXach() {
//        String sql = " SELECT TProduct.product_id, TProduct.name,TProduct.img_main"
//                + " FROM [dbo].[TProduct]"
//                + " INNER JOIN [dbo].[MCategory] ON"
//                + " TProduct.category_id = MCategory.category_id"
//                + " WHERE MCategory.name_category like 'túi xách'";
//        return jdbcTemplate.query(sql, new RowMapper<ProductModel>() {
//            @Override
//            public ProductModel mapRow(ResultSet rs, int rowNum) throws SQLException {
//
//                ProductModel productmodel = new ProductModel();
//                productmodel.setProductId(rs.getInt("product_id"));
//                productmodel.setProductName(rs.getString("name"));
//                productmodel.setImageMain(rs.getString("img_main"));
//                return productmodel;
//            }
//        });
//    }
    @Override
    public List<ProductModel> getAllTuiXach() {
        String sql = " SELECT * FROM [dbo].[TProduct] WHERE [del_flg] = 0 AND [category_id]=5";
        return jdbcTemplate.query(sql, new RowMapper<ProductModel>() {
            @Override
            public ProductModel mapRow(ResultSet rs, int rowNum) throws SQLException {

                ProductModel productmodel = new ProductModel();
                productmodel.setProductId(rs.getInt(1));
                productmodel.setName(rs.getString(2));
                productmodel.setProductCode(rs.getString(3));
                productmodel.setDiscountRate(rs.getInt(4));
                productmodel.setDescriptionShort(rs.getString(5));
                productmodel.setDescription(rs.getString(6));
                productmodel.setCategoryId(rs.getInt(7));
                productmodel.setImgMain(rs.getString(8));
                productmodel.setImg1(rs.getString(9));
                productmodel.setImg2(rs.getString(10));
                productmodel.setImg3(rs.getString(11));
                productmodel.setImg4(rs.getString(12));
                productmodel.setTrademarkId(rs.getInt(13));
                productmodel.setCreatedAt(rs.getDate(14));
                productmodel.setUpdateDate(rs.getDate(15));
                productmodel.setDelFlg(rs.getInt(16));
                return productmodel;
            }
        });
    }

    @Override
    public List<ProductModel> getAllGiay() {
        String sql = " SELECT TProduct.product_id, TProduct.name,TProduct.img_main"
                + " FROM [dbo].[TProduct]"
                + " INNER JOIN [dbo].[MCategory] ON"
                + " TProduct.category_id = MCategory.category_id"
                + " WHERE MCategory.name_category like 'giày'";
        return jdbcTemplate.query(sql, new RowMapper<ProductModel>() {
            @Override
            public ProductModel mapRow(ResultSet rs, int rowNum) throws SQLException {

                ProductModel productmodel = new ProductModel();
                productmodel.setProductId(rs.getInt("product_id"));
                productmodel.setName(rs.getString("name"));
                productmodel.setImgMain(rs.getString("img_main"));
                return productmodel;
            }
        });
    }

    @Override
    public List<ProductModel> getAllNon() {
        String sql = " SELECT TProduct.product_id, TProduct.name,TProduct.img_main"
                + " FROM [dbo].[TProduct]"
                + " INNER JOIN [dbo].[MCategory] ON"
                + " TProduct.category_id = MCategory.category_id"
                + " WHERE MCategory.name_category like 'nón'";
        return jdbcTemplate.query(sql, new RowMapper<ProductModel>() {
            @Override
            public ProductModel mapRow(ResultSet rs, int rowNum) throws SQLException {

                ProductModel productmodel = new ProductModel();
                productmodel.setProductId(rs.getInt("product_id"));
                productmodel.setName(rs.getString("name"));
                productmodel.setImgMain(rs.getString("img_main"));
                return productmodel;
            }
        });
    }

    //sản phẩm nổi bật
    @Override
    public List<ProductModel> getAllNB() {
        String sql = " SELECT product_id, name, img_main"
                + " FROM [dbo].[TProduct] WHERE [del_flg] = 0 AND [product_code] LIKE 'NB%'";
        return jdbcTemplate.query(sql, new RowMapper<ProductModel>() {
            @Override
            public ProductModel mapRow(ResultSet rs, int rowNum) throws SQLException {

                ProductModel productmodel = new ProductModel();
                productmodel.setProductId(rs.getInt("product_id"));
                productmodel.setName(rs.getString("name"));
                productmodel.setImgMain(rs.getString("img_main"));
                return productmodel;
            }
        });
    }

    //slideshow-index
    @Override
    public List<ProductModel> getAllAVT() {
        String sql = " SELECT * FROM [dbo].[TProduct] WHERE [del_flg] = 0 AND [product_code] LIKE 'NB%'";
        return jdbcTemplate.query(sql, new RowMapper<ProductModel>() {
            @Override
            public ProductModel mapRow(ResultSet rs, int rowNum) throws SQLException {

                ProductModel productmodel = new ProductModel();
                productmodel.setProductId(rs.getInt(1));
                productmodel.setName(rs.getString(2));
                productmodel.setProductCode(rs.getString(3));
                productmodel.setDiscountRate(rs.getInt(4));
                productmodel.setDescriptionShort(rs.getString(5));
                productmodel.setDescription(rs.getString(6));
                productmodel.setCategoryId(rs.getInt(7));
                productmodel.setImgMain(rs.getString(8));
                productmodel.setImg1(rs.getString(9));
                productmodel.setImg2(rs.getString(10));
                productmodel.setImg3(rs.getString(11));
                productmodel.setImg4(rs.getString(12));
                productmodel.setTrademarkId(rs.getInt(13));
                productmodel.setCreatedAt(rs.getDate(14));
                productmodel.setUpdateDate(rs.getDate(15));
                productmodel.setDelFlg(rs.getInt(16));
                return productmodel;
            }
        });
    }

    @Override
    public ProductModel findByCode(String productCode) {
        String sql = " SELECT [product_id], [name], [product_code], [discount_rate],"
                + " [description_short], [category_id], [img_main], [trademark_id],"
                + "[created_at], [update_date] FROM [dbo].[TProduct] WHERE [product_code] LIKE ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{productCode}, new RowMapper<ProductModel>() {
            @Override
            public ProductModel mapRow(ResultSet rs, int rowNum) throws SQLException {
                ProductModel productmodel = new ProductModel();
                productmodel.setProductId(rs.getInt("product_id"));
                productmodel.setName(rs.getString("name"));
                productmodel.setProductCode(rs.getString("product_code"));
                productmodel.setDiscountRate(rs.getInt("discount_rate"));
                productmodel.setDescriptionShort(rs.getString("description_short"));
                productmodel.setCategoryId(rs.getInt("category_id"));
                productmodel.setImgMain(rs.getString("img_main"));
                productmodel.setTrademarkId(rs.getInt("trademark_id"));
                productmodel.setCreatedAt(rs.getDate("created_at"));
                productmodel.setUpdateDate(rs.getDate("update_date"));
                return productmodel;
            }
        });
    }

    //tìm kiếm theo tên/admin
    @Override
    public List<ProductAllModel> findByName(String productName) {
        String sql = " select pd.[product_id], pd.[name], pd.[product_code], pd.[discount_rate],\n"
                + "               pd.[description_short], pd.[category_id], pd.[img_main], pd.[trademark_id],\n"
                + "                pd.[created_at], pd.[update_date], pdm.product_model_id, pdm.color_id, pdm.size_id, pdm.stock, pdm.price\n"
                + "                from [dbo].[TProduct] pd\n"
                + "                inner join [dbo].[TProduct_model] pdm\n"
                + "                on pd.product_id = pdm.product_id\n"
                + "                where pd.del_flg = 0 and pdm.del_flg = 0 and pd.name like '%" + productName + "%'";
        return jdbcTemplate.query(sql, new RowMapper<ProductAllModel>() {
            @Override
            public ProductAllModel mapRow(ResultSet rs, int i) throws SQLException {
                ProductAllModel productAllModel = new ProductAllModel();
                productAllModel.setProductId(rs.getInt("product_id"));
                productAllModel.setName(rs.getString("name"));
                productAllModel.setProductCode(rs.getString("product_code"));
                productAllModel.setDiscountRate(rs.getInt("discount_rate"));
                productAllModel.setDescriptionShort(rs.getString("description_short"));
                productAllModel.setCategoryId(rs.getInt("category_id"));
                productAllModel.setImgMain(rs.getString("img_main"));
                productAllModel.setTrademarkId(rs.getInt("trademark_id"));
                productAllModel.setCreatedAt(rs.getDate("created_at"));
                productAllModel.setUpdateDate(rs.getDate("update_date"));
                productAllModel.setProductModelId(rs.getInt("product_model_id"));
                productAllModel.setColorId(rs.getInt("color_id"));
                productAllModel.setSizeId(rs.getInt("size_id"));
                productAllModel.setStock(rs.getInt("stock"));
                productAllModel.setPrice(rs.getDouble("price"));
                return productAllModel;
            }
        });
    }

    @Override
    public Integer countProduct() {
        String sql = "select COUNT(*) from [dbo].[TProduct] pd\n" +
"                inner join [dbo].[TProduct_model] pdm\n" +
"                on pd.product_id = pdm.product_id\n" +
"                where pd.del_flg = 0 and pdm.del_flg = 0";
        return (int)jdbcTemplate.queryForObject(sql,Integer.class);
    }

    @Override
    public List<ProductAllModel> getListProductByPageIndex(int firstIndex, int secondIndex) {
        String sql = "select [product_id], [name], [product_code], [discount_rate],\n" +
"                [description_short], [category_id], [img_main], [trademark_id],\n" +
"                [created_at], [update_date], product_model_id, color_id, size_id, stock, price\n" +
"				\n" +
"                from(\n" +
"				select pd.[product_id], pd.[name], pd.[product_code], pd.[discount_rate],\n" +
"                pd.[description_short], pd.[category_id], pd.[img_main], pd.[trademark_id],\n" +
"                pd.[created_at], pd.[update_date], pdm.product_model_id, pdm.color_id, pdm.size_id, pdm.stock, pdm.price,\n" +
"				ROW_NUMBER() OVER( ORDER BY pd.[name] ASC)  AS number \n" +
"                from [dbo].[TProduct] pd\n" +
"                inner join [dbo].[TProduct_model] pdm\n" +
"                on pd.product_id = pdm.product_id\n" +
"                where pd.del_flg = 0 and pdm.del_flg = 0\n" +
"				) AS temp \n" +
"				WHERE \n" +
"                	number BETWEEN ? AND ?";
        return jdbcTemplate.query(sql,new Object[]{firstIndex,secondIndex}, new RowMapper<ProductAllModel>() {
            @Override
            public ProductAllModel mapRow(ResultSet rs, int i) throws SQLException {
                ProductAllModel productAllModel = new ProductAllModel();
                productAllModel.setProductId(rs.getInt("product_id"));
                productAllModel.setName(rs.getString("name"));
                productAllModel.setProductCode(rs.getString("product_code"));
                productAllModel.setDiscountRate(rs.getInt("discount_rate"));
                productAllModel.setDescriptionShort(rs.getString("description_short"));
                productAllModel.setCategoryId(rs.getInt("category_id"));
                productAllModel.setImgMain(rs.getString("img_main"));
                productAllModel.setTrademarkId(rs.getInt("trademark_id"));
                productAllModel.setCreatedAt(rs.getDate("created_at"));
                productAllModel.setUpdateDate(rs.getDate("update_date"));
                productAllModel.setProductModelId(rs.getInt("product_model_id"));
                productAllModel.setColorId(rs.getInt("color_id"));
                productAllModel.setSizeId(rs.getInt("size_id"));
                productAllModel.setStock(rs.getInt("stock"));
                productAllModel.setPrice(rs.getDouble("price"));
                return productAllModel;
            }
        });
    }

}
