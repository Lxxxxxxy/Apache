package Dao;

import Entity.Shop;
import Entity.UserCheck;
import Entity.UserInfo;

import java.util.List;

/**
 * @author lxxxxxxy
 * @time 2019/3/31 22:44
 */
public interface UserInfoDao {
    Integer insertUser(UserInfo userInfo);
    UserInfo selectUser(String userId);
    Integer applyShop(String userId);
    void initShop(Shop shop);
    void updateUserByApplyShop(String userId);
    void activationById(String userId);
    void updateDefaultAddress(UserInfo userInfo);
}
