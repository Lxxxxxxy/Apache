package Dao;

import Entity.Product;
import Entity.Random;
import Entity.Shop;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lxxxxxxy
 * @time 2019/4/9 15:00
 */
public interface UserProductDao {
    List<Product> getProductList(String userId);
    void putProduct(Product product);
    void deleteProduct(String productId);
    List<Product> getIndexCarouselProduct(Random random);
    List<Product> getIndexProduct(Random random);
    Product getProductById(String productId);
    List<Product> getProductListByCategory(Integer productCategoryId);
    List<Product> getProductListBySearch(@Param("productName") String productName);
    Shop getShopNameByProductUserId(String shopUserId);
    void updateRemaining(Product product);
    Integer getCountProduct();
}
