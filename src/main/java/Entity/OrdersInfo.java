package Entity;

/**
 * @author lxxxxxxy
 * @time 2019/4/15 15:39
 */
public class OrdersInfo {
    private String orderId;
    private String productName;
    private Double orderPaymentAmount;
    private String orderLogistics;
    private Integer orderStatus;
    private String orderUserAddress;
    private Integer orderComment;

    @Override
    public String toString() {
        return "OrdersInfo{" +
                "orderId='" + orderId + '\'' +
                ", productName='" + productName + '\'' +
                ", orderPaymentAmount=" + orderPaymentAmount +
                ", orderLogistics='" + orderLogistics + '\'' +
                ", orderStatus=" + orderStatus +
                ", orderUserAddress='" + orderUserAddress + '\'' +
                ", orderComment=" + orderComment +
                '}';
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getOrderPaymentAmount() {
        return orderPaymentAmount;
    }

    public void setOrderPaymentAmount(Double orderPaymentAmount) {
        this.orderPaymentAmount = orderPaymentAmount;
    }

    public String getOrderLogistics() {
        return orderLogistics;
    }

    public void setOrderLogistics(String orderLogistics) {
        this.orderLogistics = orderLogistics;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderUserAddress() {
        return orderUserAddress;
    }

    public void setOrderUserAddress(String orderUserAddress) {
        this.orderUserAddress = orderUserAddress;
    }

    public Integer getOrderComment() {
        return orderComment;
    }

    public void setOrderComment(Integer orderComment) {
        this.orderComment = orderComment;
    }

    public OrdersInfo(String orderId, String productName, Double orderPaymentAmount, String orderLogistics, Integer orderStatus, String orderUserAddress, Integer orderComment) {
        this.orderId = orderId;
        this.productName = productName;
        this.orderPaymentAmount = orderPaymentAmount;
        this.orderLogistics = orderLogistics;
        this.orderStatus = orderStatus;
        this.orderUserAddress = orderUserAddress;
        this.orderComment = orderComment;
    }

    public OrdersInfo() {
    }
}
