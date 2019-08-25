package Service.impl;

import Dao.OrderProductDao;
import Entity.OrderProduct;
import Entity.OrdersInfo;
import Service.OrderProductService;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lxxxxxxy
 * @time 2019/4/15 09:13
 */
@Service
public class OrderProductServiceImpl implements OrderProductService {

    @Autowired
    private OrderProductDao orderProductDao;

    @Override
    public void insertOrderProduct(OrderProduct orderProduct) {
        if (orderProduct == null) {
            throw new RuntimeException("提交订单失败！");
        }
        orderProductDao.insertOrderProduct(orderProduct);
    }

    @Override
    public String getOrders(String userId) {
        if (userId == null) {
            throw new RuntimeException("获取订单失败！");
        }
        List<OrdersInfo> orders = orderProductDao.getOrders(userId);
        JSONArray json = JSONArray.fromObject(orders);
        String ordersJson = json.toString();
        return ordersJson;
    }

    @Override
    public String getOrdersByShop(String userId) {
        if (userId == null) {
            throw new RuntimeException("获取订单失败！");
        }
        List<OrdersInfo> orders = orderProductDao.getOrdersByShop(userId);
        JSONArray json = JSONArray.fromObject(orders);
        String ordersJson = json.toString();
        return ordersJson;
    }
}
