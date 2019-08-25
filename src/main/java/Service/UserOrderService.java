package Service;

import Entity.UserOrder;

/**
 * @author lxxxxxxy
 * @time 2019/4/15 08:49
 */
public interface UserOrderService {
    void insertOrder(UserOrder order);
    void addLogistics(UserOrder userOrder);
    void confirmOrder(String orderId);
}
