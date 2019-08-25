package Service;

import Entity.UserAddress;

import java.util.List;

/**
 * @author lxxxxxxy
 * @time 2019/4/5 10:42
 */
public interface UserAddressService {
    String getUserAddressList(String userId);
    String getUserAddressById(UserAddress userAddress);
    void updateUserAddress(UserAddress userAddress);
    void deleteUserAddress(UserAddress userAddress);
    void insertAddress(UserAddress userAddress);
}
