package Dao;

import Entity.OrderProduct;
import Entity.OrdersInfo;
import org.springframework.core.annotation.Order;

import java.util.List;

/**
 * @author lxxxxxxy
 * @time 2019/4/15 09:10
 */
public interface OrderProductDao {
    void insertOrderProduct(OrderProduct orderProduct);
    List<OrdersInfo> getOrders(String userId);
    List<OrdersInfo> getOrdersByShop(String userId);
}
