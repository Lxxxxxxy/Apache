package Dao;

import Entity.Shop;

import java.util.List;

/**
 * @author lxxxxxxy
 * @time 2019/4/7 23:20
 */
public interface UserShopDao {
    Shop getShop(String userId);
    List<Shop> getAllShop();
    void deleteShop(Integer shopId);
    void deleteProductByShopId(String userId);
}
