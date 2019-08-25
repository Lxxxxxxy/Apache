package Dao;

import Entity.UserOrder;

/**
 * @author lxxxxxxy
 * @time 2019/4/15 08:46
 */
public interface UserOrderDao {
    void insertOrder(UserOrder order);
    void addLogistics(UserOrder userOrder);
    void confirmOrder(String orderId);
}
