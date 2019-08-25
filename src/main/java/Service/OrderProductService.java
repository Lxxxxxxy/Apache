package Service;

import Entity.OrderProduct;
import Entity.OrdersInfo;

import java.util.List;

/**
 * @author lxxxxxxy
 * @time 2019/4/15 09:13
 */
public interface OrderProductService {
    void insertOrderProduct(OrderProduct orderProduct);
    String getOrders(String userId);
    String getOrdersByShop(String userId);
}
