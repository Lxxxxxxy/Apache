package Dao;

import Entity.UserAddress;

import java.util.List;

/**
 * @author lxxxxxxy
 * @time 2019/4/5 10:41
 */
public interface UserAddressDao {
    List<UserAddress> getUserAddressList(String userId);
    UserAddress getUserAddressById(UserAddress userAddress);
    void updateUserAddress(UserAddress userAddress);
    void deleteUserAddress(UserAddress userAddress);
    void insertAddress(UserAddress userAddress);
}
