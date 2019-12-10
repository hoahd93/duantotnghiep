/////////////////////////////////////////////////////////////////////////////
//
// � 2019 andro Japan. All right reserved.
//
/////////////////////////////////////////////////////////////////////////////

package shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shop.model.ProductCart;
import shop.model.ProductDetailModel;
import shop.model.ProductModel;

/**
 * [OVERVIEW] XXXXX.
 *
 * @author: HoaHD
 * @version: 1.0
 * @History
 * [NUMBER]  [VER]     [DATE]          [USER]             [CONTENT]
 * --------------------------------------------------------------------------
 * 001       1.0       2019/10/02      HoaHD       Create new
*/
@Service
@Transactional
public class ProductCartServiceImpl implements ProductCartService {

    @Autowired
    private ProductDetailService productDetailService;

    @Override
    public ProductCart getProduct(int productDetailId) {
        ProductDetailModel productDetail = productDetailService.findById(productDetailId);
        ProductModel product = productDetailService.getProduct(productDetailId);
        ProductCart productCart = new ProductCart();
        productCart.setProductId(productDetail.getProductId());
        productCart.setProductModelId(productDetailId);
        productCart.setProductName(product.getName());
        productCart.setCategoryId(product.getCategoryId());
        productCart.setColorId(productDetail.getColorId());
        productCart.setDescription(product.getDescription());
        productCart.setDescriptionShort(product.getDescriptionShort());
        productCart.setDiscountRate(product.getDiscountRate());
//        productCart.setImageMain(product.getImgMain());
        productCart.setPrice(productDetail.getPrice());
        return productCart;

    }

}
