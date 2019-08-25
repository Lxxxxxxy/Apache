package Service.impl;

import Dao.UserShopDao;
import Entity.Shop;
import Service.UserShopService;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author lxxxxxxy
 * @time 2019/4/7 23:26
 */
@Service
public class UserShopServiceImpl implements UserShopService {

    @Autowired
    private UserShopDao userShopDao;

    @Autowired
    private UserInfoServiceImpl userInfoServiceimpl;

    @Override
    public String getShop(String userId) {
        if (userId == null) {
            return null;
        }
        Shop shopJson = userShopDao.getShop(userId);
        JSONObject jsonObject = JSONObject.fromObject(shopJson);
        String shop = jsonObject.toString();
        return shop;
    }

    @Override
    public String getAllShop() {
        List<Shop> shopJson = userShopDao.getAllShop();
        JSONArray json = JSONArray.fromObject(shopJson);
        String s = json.toString();
        return s;
    }

    @Override
    public void deleteShop(Integer shopId,String userId) {
        if (shopId == null) {
            throw new RuntimeException("删除店铺失败！");
        }
        userShopDao.deleteShop(shopId);
        userShopDao.deleteProductByShopId(userId);
    }
}
