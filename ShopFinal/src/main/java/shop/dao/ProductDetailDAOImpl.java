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
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import shop.model.ProductDetailModel;
import shop.model.ProductModel;
import shop.model.ProductShow;

/**
 *
 * @author LENOVO
 */
@Repository
public class ProductDetailDAOImpl implements ProductDetailDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int create(ProductDetailModel object2) {
        String sql = "INSERT INTO [dbo].[TProduct_model]([product_id],[color_id],[size_id],[stock],[price],[create_date],[update_date],[del_flg]) VALUES(?,?,?,?,?,?,?,?)";
        return jdbcTemplate.update(sql, new Object[]{object2.getProductId(), object2.getColorId(), object2.getSizeId(), object2.getStock(), object2.getPrice(), object2.getCreateDate(), object2.getUpdateDate(), object2.getDelFlg()});
    }

    @Override
    public int update(ProductDetailModel object2) {
        String sql = " UPDATE [dbo].[TProduct_model]\n"
                + "   SET [product_id] = ?,[color_id] = ?,[size_id] = ?,[stock] = ?,[price] = ?,[update_date] = ? WHERE [product_model_id]=? ";
        return jdbcTemplate.update(sql, new Object[]{object2.getProductId(), object2.getColorId(), object2.getSizeId(), object2.getStock(), object2.getPrice(), object2.getUpdateDate(), object2.getProductDetailId()});

    }

    @Override
    public int delete(ProductDetailModel object2) {
        String sql = " UPDATE [dbo].[TProduct_model]\n"
                + "   SET [del_flg]=? WHERE [product_model_id]=? ";
        return jdbcTemplate.update(sql, new Object[]{object2.getDelFlg(), object2.getProductDetailId()});
    }

    @Override
    public ProductDetailModel findById(int productModelId) {
        String sql = " SELECT [product_model_id],[product_id],[color_id],[size_id],[stock],[price],[create_date],[update_date] FROM [dbo].[TProduct_model] WHERE [product_model_id]=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{productModelId}, new RowMapper<ProductDetailModel>() {

            @Override
            public ProductDetailModel mapRow(ResultSet rs, int i) throws SQLException {
                ProductDetailModel pm = new ProductDetailModel();
                pm.setProductDetailId(rs.getInt("product_model_id"));
                pm.setProductId(rs.getInt("product_id"));
                pm.setColorId(rs.getInt("color_id"));
                pm.setSizeId(rs.getInt("size_id"));
                pm.setStock(rs.getInt("stock"));
                pm.setPrice(rs.getDouble("price"));
                pm.setCreateDate(rs.getDate("create_date"));
                pm.setUpdateDate(rs.getDate("update_date"));
                return pm;
            }
        });
    }

    @Override
    public List<ProductDetailModel> getAll() {
        String sql = " SELECT [product_model_id],[product_id],[color_id],[size_id],[stock],[price],[create_date],[update_date] FROM [dbo].[TProduct_model] WHERE [del_flg]= 0";
        return jdbcTemplate.query(sql, new RowMapper<ProductDetailModel>() {

            @Override
            public ProductDetailModel mapRow(ResultSet rs, int i) throws SQLException {
                ProductDetailModel pm = new ProductDetailModel();
                pm.setProductDetailId(rs.getInt("product_model_id"));
                pm.setProductId(rs.getInt("product_id"));
                pm.setColorId(rs.getInt("color_id"));
                pm.setSizeId(rs.getInt("size_id"));
                pm.setStock(rs.getInt("stock"));
                pm.setPrice(rs.getDouble("price"));
                pm.setCreateDate(rs.getDate("create_date"));
                pm.setUpdateDate(rs.getDate("update_date"));
                return pm;
            }
        });
    }

    @Override
    public List<ProductDetailModel> findByproductId(int productId) {
        String sql = " SELECT [product_model_id],[product_id],[color_id],[size_id],[stock],[price],[create_date],[update_date] FROM [dbo].[TProduct_model] WHERE [product_id]="+productId;
        return jdbcTemplate.query(sql, new RowMapper<ProductDetailModel>() {

            @Override
            public ProductDetailModel mapRow(ResultSet rs, int i) throws SQLException {
                ProductDetailModel pm = new ProductDetailModel();
                pm.setProductDetailId(rs.getInt("product_model_id"));
                pm.setProductId(rs.getInt("product_id"));
                pm.setColorId(rs.getInt("color_id"));
                pm.setSizeId(rs.getInt("size_id"));
                pm.setStock(rs.getInt("stock"));
                pm.setPrice(rs.getDouble("price"));
                pm.setCreateDate(rs.getDate("create_date"));
                pm.setUpdateDate(rs.getDate("update_date"));
                return pm;
            }
        });
    }

//    @Override
//    public List<ProductDetailModel> getAllAo() {
//        String sql = " SELECT TProduct_model.product_model_id, TProduct_model.price"
//                + "from TProduct_model  "
//                + "inner join TProduct "
//                + "on TProduct.product_id = TProduct_model.product_id "
//                + "inner join MCategory "
//                + "on TProduct.category_id = MCategory.category_id "
//                + "where TProduct_model.del_flg=0 and "
//                + "MCategory.name_category like 'áo'";
//        return jdbcTemplate.query(sql, new RowMapper<ProductDetailModel>() {
//            @Override
//            public ProductDetailModel mapRow(ResultSet rs, int rowNum) throws SQLException {
//                
//                ProductDetailModel detailModel = new ProductDetailModel();
//                detailModel.setProductModelId(rs.getInt("product_model_id"));
//                detailModel.setPrice(rs.getDouble("price"));
//                return detailModel;
//            }
//        });
//    }
    @Override
    public List<ProductDetailModel> getAllAo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<ProductDetailModel> findByNameProductModel(String productModelName) {
        String sql = "select TProduct_model.product_model_id, TProduct_model.product_id, TProduct_model.color_id, TProduct_model.size_id, TProduct_model.stock, TProduct_model.price, TProduct_model.create_date, TProduct_model.update_date \n"
                + "from TProduct_model\n"
                + "inner join TProduct\n"
                + "on TProduct_model.product_id = TProduct.product_id\n"
                + "where TProduct_model.del_flg = 0 and TProduct.name like N'%" + productModelName + "%'";
//        String sql = " SELECT * FROM [dbo].[TProduct] WHERE [del_flg] = 0 AND FREETEXT([name],'" + productName + ""')";
        return jdbcTemplate.query(sql, new RowMapper<ProductDetailModel>() {
            @Override
            public ProductDetailModel mapRow(ResultSet rs, int i) throws SQLException {
                ProductDetailModel productDetailModel = new ProductDetailModel();
                productDetailModel.setProductDetailId(rs.getInt(1));
                productDetailModel.setProductId(rs.getInt(2));
                productDetailModel.setColorId(rs.getInt(3));
                productDetailModel.setSizeId(rs.getInt(4));
                productDetailModel.setStock(rs.getInt(5));
                productDetailModel.setPrice(rs.getDouble(6));
                productDetailModel.setCreateDate(rs.getDate(7));
                productDetailModel.setUpdateDate(rs.getDate(8));
                return productDetailModel;
            }
        });
    }

    //SAI SQL...!!!!!!!!
    @Override
    public ProductModel getProduct(int productModelId) {
        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT ");
        sql.append("  pro.product_id,");
        sql.append("  pro.name,");
        sql.append("  pro.[product_code],");
        sql.append("  pro.[discount_rate],");
        sql.append("  pro.[description_short],");
        sql.append("  pro.[description],");
        sql.append("  pro.[category_id],");
        sql.append("  pro.[img_main],");
        sql.append(" pro.img1,");
        sql.append("  pro.img2,");
        sql.append("  pro.img3,");
        sql.append("  pro.img4,");
        sql.append("  pro.[trademark_id],");
        sql.append("  pro.[created_at],");
        sql.append("  pro.[update_date]");
        sql.append(" FROM [dbo].[TProduct] as pro INNER JOIN [dbo].[TProduct_model] as prom ON pro.[product_id] = prom.[product_id ]");
        sql.append(" WHERE prom.[product_model_id] = ?");
        return jdbcTemplate.queryForObject(sql.toString(), new Object[]{productModelId}, new RowMapper<ProductModel>() {
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
                return productmodel;
            }
        });
    }

    @Override
    public List<ProductShow> getProductShows() {
        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT ");
        sql.append("  prom.[product_model_id],");
        sql.append("  pro.[product_id],");
        sql.append("  pro.name,");
        sql.append("  pro.[product_code],");
        sql.append("  pro.[category_id], ");
        sql.append("  cate.[name_category], ");
        sql.append("  prom.[color_id],");
        sql.append("  color.[name_color],");
        sql.append("  prom.[size_id],");
        sql.append("  size.[size_name],");
        sql.append("  prom.stock,");
        sql.append("  prom.[price],");
        sql.append("  pro.discount_rate,");
        sql.append("  pro.[description_short],");
        sql.append("  pro.[description],");
        sql.append("  pro.img_main,");
        sql.append(" pro.img1,");
        sql.append("  pro.img2,");
        sql.append("  pro.img3,");
        sql.append("  pro.img4,");
        sql.append("  pro.[trademark_id]");
        sql.append(" FROM [dbo].[TProduct_model] prom INNER JOIN [dbo].[TProduct] pro ON pro.[product_id] = prom.product_id AND prom.del_flg = pro.del_flg ");
        sql.append(" INNER JOIN [dbo].[MCategory] cate ON pro.[category_id] = cate.category_id AND pro.del_flg = cate.del_flg ");
        sql.append(" INNER JOIN [dbo].[MColor] color ON prom.[color_id] = color.color_id AND prom.del_flg = color.del_flg ");
        sql.append(" INNER JOIN [dbo].[MSize] size ON prom.[size_id] = size.size_id AND prom.del_flg = size.del_flg ");
        sql.append("WHERE prom.del_flg = 0");
        return jdbcTemplate.query(sql.toString(), new RowMapper<ProductShow>() {
            @Override
            public ProductShow mapRow(ResultSet rs, int rowNum) throws SQLException {
                ProductShow pm = new ProductShow();
                pm.setProductModelId(rs.getInt("product_model_id"));
                pm.setProductId(rs.getInt("product_id"));
                pm.setName(rs.getString("name"));
                pm.setProductCode(rs.getString("product_code"));
                pm.setCategoryId(rs.getInt("category_id"));
                pm.setCategoryName(rs.getString("name_category"));
                pm.setColorId(rs.getInt("color_id"));
                pm.setColorName(rs.getString("name_color"));
                pm.setSizeId(rs.getInt("size_id"));
                pm.setSizeName(rs.getString("size_name"));
                pm.setStock(rs.getInt("stock"));
                pm.setPrice(rs.getDouble("price"));
                pm.setDiscountRate(rs.getInt("discount_rate"));
                pm.setDescriptionShort(rs.getString("description_short"));
                pm.setDescription(rs.getString("description"));
                pm.setImgMain(rs.getString("img_main"));
                pm.setImg1(rs.getString("img1"));
                pm.setImg2(rs.getString("img2"));
                pm.setImg3(rs.getString("img3"));
                pm.setImg4(rs.getString("img4"));
                pm.setTrademarkId(rs.getInt("trademark_id"));
                return pm;
            }
        });
    }
    
     @Override
    public List<ProductShow> getProductShowById(Integer productModelId) {
        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT ");
        sql.append("  prom.[product_model_id],");
        sql.append("  pro.[product_id],");
        sql.append("  pro.name,");
        sql.append("  pro.[product_code],");
        sql.append("  pro.[category_id], ");
        sql.append("  cate.[name_category], ");
        sql.append("  prom.[color_id],");
        sql.append("  color.[name_color],");
        sql.append("  prom.[size_id],");
        sql.append("  size.[size_name],");
        sql.append("  prom.stock,");
        sql.append("  prom.[price],");
        sql.append("  pro.discount_rate,");
        sql.append("  pro.[description_short],");
        sql.append("  pro.[description],");
        sql.append("  pro.img_main,");
        sql.append(" pro.img1,");
        sql.append("  pro.img2,");
        sql.append("  pro.img3,");
        sql.append("  pro.img4,");
        sql.append("  pro.[trademark_id]");
        sql.append(" FROM [dbo].[TProduct_model] prom INNER JOIN [dbo].[TProduct] pro ON pro.[product_id] = prom.product_id AND prom.del_flg = pro.del_flg ");
        sql.append(" INNER JOIN [dbo].[MCategory] cate ON pro.[category_id] = cate.category_id AND pro.del_flg = cate.del_flg ");
        sql.append(" INNER JOIN [dbo].[MColor] color ON prom.[color_id] = color.color_id AND prom.del_flg = color.del_flg ");
        sql.append(" INNER JOIN [dbo].[MSize] size ON prom.[size_id] = size.size_id AND prom.del_flg = size.del_flg ");
        sql.append("WHERE prom.del_flg = 0 AND prom.product_model_id = ?");
        return jdbcTemplate.query(sql.toString(), new Object[]{productModelId}, new RowMapper<ProductShow>() {
            @Override
            public ProductShow mapRow(ResultSet rs, int rowNum) throws SQLException {
                ProductShow pm = new ProductShow();
                pm.setProductModelId(rs.getInt("product_model_id"));
                pm.setProductId(rs.getInt("product_id"));
                pm.setName(rs.getString("name"));
                pm.setProductCode(rs.getString("product_code"));
                pm.setCategoryId(rs.getInt("category_id"));
                pm.setCategoryName(rs.getString("name_category"));
                pm.setColorId(rs.getInt("color_id"));
                pm.setColorName(rs.getString("name_color"));
                pm.setSizeId(rs.getInt("size_id"));
                pm.setSizeName(rs.getString("size_name"));
                pm.setStock(rs.getInt("stock"));
                pm.setPrice(rs.getDouble("price"));
                pm.setDiscountRate(rs.getInt("discount_rate"));
                pm.setDescriptionShort(rs.getString("description_short"));
                pm.setDescription(rs.getString("description"));
                pm.setImgMain(rs.getString("img_main"));
                pm.setImg1(rs.getString("img1"));
                pm.setImg2(rs.getString("img2"));
                pm.setImg3(rs.getString("img3"));
                pm.setImg4(rs.getString("img4"));
                pm.setTrademarkId(rs.getInt("trademark_id"));
                return pm;
            }
        });
    }
}
