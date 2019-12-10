package shop.model;

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
public class Cart {
    private ProductCart productCart;
    private int quantity;

    public Cart() {
    }

    public Cart(ProductCart productCart, int quantity) {
        this.productCart = productCart;
        this.quantity = quantity;
    }

    public ProductCart getProduct() {
        return productCart;
    }

    public void setProduct(ProductCart productCart) {
        this.productCart = productCart;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
