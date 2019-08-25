package Entity;

import java.util.Date;

/**
 * @author lxxxxxxy
 * @time 2019/4/15 08:42
 */
public class UserOrder {
    /*
    order_id	varchar
order_ payment_amount	double
order_createtime	datetime
order_status	int
order_ logistics	varchar
order_user_id	int

    * */
    private String orderId;
    private Double orderPaymentAmount;
    private Date orderCreatetime;
    private Integer orderStatus;
    private String orderLogistics;
    private String orderUserId;
    private String orderUserAddress;

    @Override
    public String toString() {
        return "UserOrder{" +
                "orderId='" + orderId + '\'' +
                ", orderPaymentAmount=" + orderPaymentAmount +
                ", orderCreatetime=" + orderCreatetime +
                ", orderStatus=" + orderStatus +
                ", orderLogistics='" + orderLogistics + '\'' +
                ", orderUserId='" + orderUserId + '\'' +
                ", orderUserAddress='" + orderUserAddress + '\'' +
                '}';
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Double getOrderPaymentAmount() {
        return orderPaymentAmount;
    }

    public void setOrderPaymentAmount(Double orderPaymentAmount) {
        this.orderPaymentAmount = orderPaymentAmount;
    }

    public Date getOrderCreatetime() {
        return orderCreatetime;
    }

    public void setOrderCreatetime(Date orderCreatetime) {
        this.orderCreatetime = orderCreatetime;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderLogistics() {
        return orderLogistics;
    }

    public void setOrderLogistics(String orderLogistics) {
        this.orderLogistics = orderLogistics;
    }

    public String getOrderUserId() {
        return orderUserId;
    }

    public void setOrderUserId(String orderUserId) {
        this.orderUserId = orderUserId;
    }

    public String getOrderUserAddress() {
        return orderUserAddress;
    }

    public void setOrderUserAddress(String orderUserAddress) {
        this.orderUserAddress = orderUserAddress;
    }

    public UserOrder(String orderId, Double orderPaymentAmount, Date orderCreatetime, Integer orderStatus, String orderLogistics, String orderUserId, String orderUserAddress) {
        this.orderId = orderId;
        this.orderPaymentAmount = orderPaymentAmount;
        this.orderCreatetime = orderCreatetime;
        this.orderStatus = orderStatus;
        this.orderLogistics = orderLogistics;
        this.orderUserId = orderUserId;
        this.orderUserAddress = orderUserAddress;
    }

    public UserOrder() {
    }
}
