package Service;

import Entity.Product;
import Entity.Random;
import Entity.Shop;

import java.util.List;

/**
 * @author lxxxxxxy
 * @time 2019/4/9 15:03
 */
public interface UserProductService {
    String getProductList(String userId);
    void putProduct(Product product);
    void deleteProduct(String productId);
    String getIndexCarouselProduct();
    String getIndexProduct();
    String getProductById(String productId);
    String getProductListByCategory(Integer productCategoryId);
    String getProductListBySearch(String productName);
    String getShopNameByProductUserId(String shopUserId);
    void updateRemaining(Product product);
}
