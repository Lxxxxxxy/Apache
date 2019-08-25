package Service;

import Entity.Shop;
import Entity.UserCheck;
import Entity.UserInfo;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.util.List;

/**
 * @author lxxxxxxy
 * @time 2019/4/1 08:45
 */
public interface UserInfoService {
    Integer insertUser(UserInfo userInfo, UserCheck usercheck, CommonsMultipartFile userInfoHeadImg);
    UserInfo selectUser(String userId);
    Integer applyShop(String userId);
    void initShop(Shop shop);
    void updateUserByApplyShop(String userId);
    void activationById(String userId);
    void updateDefaultAddress(UserInfo userInfo);
}
