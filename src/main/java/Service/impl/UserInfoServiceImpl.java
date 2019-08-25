package Service.impl;

import Dao.UserCheckDao;
import Dao.UserInfoDao;
import Entity.Shop;
import Entity.UserCheck;
import Entity.UserInfo;
import Util.ImageUtil;
import Util.PathUtil;
import Service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.util.List;

/**
 * @author lxxxxxxy
 * @time 2019/4/1 08:47
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoDao UserInfoDao;

    @Autowired
    private UserCheckDao userCheckDao;

    @Override
    public Integer insertUser(UserInfo UserInfo, UserCheck usercheck, CommonsMultipartFile UserInfoHeadImg) {
        if (UserInfoHeadImg == null) {
            UserInfo.setUserHeadImage("/images/head/default.png");
        } else {
            addHeadImg(UserInfo,UserInfoHeadImg);
        }
        Integer insertUserRow = UserInfoDao.insertUser(UserInfo);
        if (insertUserRow == null) {
            return null;
        }
        usercheck.setUserId(UserInfo.getUserId());
        Integer saveUserRow = userCheckDao.saveUser(usercheck);
        if (saveUserRow == null) {
            return null;
        }
        return 1;
    }

    @Override
    public UserInfo selectUser(String userId) {
        if (userId == null) {
            return null;
        }
        UserInfo UserInfos = UserInfoDao.selectUser(userId);
        return UserInfos;
    }

    @Override
    public Integer applyShop(String userId) {
        if (userId == null) {
            return null;
        }
        Integer is_applyShop = UserInfoDao.applyShop(userId);
        return is_applyShop;
    }

    @Override
    public void initShop(Shop shop) {
        if (shop == null) {
            return;
        }
        UserInfoDao.initShop(shop);
    }

    @Override
    public void updateUserByApplyShop(String userId) {
        if(userId==null){
            return;
        }
        UserInfoDao.updateUserByApplyShop(userId);
    }

    @Override
    public void activationById(String userId) {
        if(userId==null){
            return;
        }
        UserInfoDao.activationById(userId);
    }

    @Override
    public void updateDefaultAddress(UserInfo userInfo) {
        if (userInfo == null) {
            throw new RuntimeException("设置默认地址失败！");
        }
        UserInfoDao.updateDefaultAddress(userInfo);
    }

    public void addHeadImg(UserInfo UserInfo, CommonsMultipartFile userInfoHeadImg) {
        String dest = PathUtil.getUserImgPath(UserInfo.getUserId());
        String UserHeadImgAddr = ImageUtil.generateThumbnail(userInfoHeadImg, dest);
        UserInfo.setUserHeadImage(UserHeadImgAddr);
    }
}