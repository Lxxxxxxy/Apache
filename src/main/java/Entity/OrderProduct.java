package Entity;

/**
 * @author lxxxxxxy
 * @time 2019/4/15 09:09
 */
public class OrderProduct {
    /*
    order_id	int
product_id	int

    * */
    private String orderId;
    private Integer productId;

    @Override
    public String toString() {
        return "OrderProduct{" +
                "orderId='" + orderId + '\'' +
                ", productId=" + productId +
                '}';
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public OrderProduct(String orderId, Integer productId) {
        this.orderId = orderId;
        this.productId = productId;
    }

    public OrderProduct() {
    }
}
