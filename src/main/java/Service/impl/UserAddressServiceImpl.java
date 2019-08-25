package Service.impl;

import Dao.UserAddressDao;
import Entity.UserAddress;
import Service.UserAddressService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lxxxxxxy
 * @time 2019/4/5 10:42
 */
@Service
public class UserAddressServiceImpl implements UserAddressService {

    @Autowired
    private UserAddressDao userAddressDao;

    @Override
    public String getUserAddressList(String userId) {
        if (userId == null) {
            return null;
        }
        List<UserAddress> userAddressList = userAddressDao.getUserAddressList(userId);
        String userAddressJson = JSONArray.fromObject(userAddressList).toString();
        return userAddressJson;
    }

    @Override
    public String getUserAddressById(UserAddress userAddress) {
        if (userAddress == null) {
            return null;
        }
        UserAddress userAddressById = userAddressDao.getUserAddressById(userAddress);
        JSONObject jsonObject = JSONObject.fromObject(userAddressById);
        String userAddressJson = jsonObject.toString();
        return userAddressJson;
    }

    @Override
    public void updateUserAddress(UserAddress userAddress) {
        if (userAddress == null) {
            throw new RuntimeException("更新地址失败！");
        }
        userAddressDao.updateUserAddress(userAddress);
    }

    @Override
    public void deleteUserAddress(UserAddress userAddress) {
        if (userAddress == null) {
            throw new RuntimeException("删除地址失败！");
        }
        userAddressDao.deleteUserAddress(userAddress);
    }

    @Override
    public void insertAddress(UserAddress userAddress) {
        if (userAddress == null) {
            throw new RuntimeException("添加地址失败！");
        }
        userAddressDao.insertAddress(userAddress);
    }
}
