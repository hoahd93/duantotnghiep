/////////////////////////////////////////////////////////////////////////////
//
// © 2019 andro Japan. All right reserved.
//
/////////////////////////////////////////////////////////////////////////////

package shop.service;

import shop.model.ProductCart;

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
public interface ProductCartService {
    //get ProductCart by productDetailId
    public ProductCart getProduct(int productDetailId);
}
