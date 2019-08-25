package Service;

import Entity.Shop;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lxxxxxxy
 * @time 2019/4/7 23:23
 */
@Service
public interface UserShopService {
    String getShop(String userId);
    String getAllShop();
    void deleteShop(Integer shopId,String userId);
}
