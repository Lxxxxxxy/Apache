package Service.impl;

import Dao.UserOrderDao;
import Entity.UserOrder;
import Service.UserOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author lxxxxxxy
 * @time 2019/4/15 08:50
 */
@Service
public class UserOrderServiceImpl implements UserOrderService {

    @Autowired
    private UserOrderDao UserOrderDao;

    @Override
    public void insertOrder(UserOrder order) {
        if (order == null) {
            throw new RuntimeException("提交订单失败！");
        }
        order.setOrderCreatetime(new Date());
        String a= (Math.round(Math.random() * 99999))+"";
        order.setOrderId(System.currentTimeMillis() + a);
        order.setOrderStatus(1);
        UserOrderDao.insertOrder(order);
    }

    @Override
    public void addLogistics(UserOrder userOrder) {
        if (userOrder == null) {
            throw new RuntimeException("添加物流信息失败！");
        }
        UserOrderDao.addLogistics(userOrder);
    }

    @Override
    public void confirmOrder(String orderId) {
        if (orderId == null) {
            throw new RuntimeException("确认收货失败！");
        }
        UserOrderDao.confirmOrder(orderId);
    }
}
