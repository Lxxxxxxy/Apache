package Entity;

import java.util.Date;

/**
 * @author lxxxxxxy
 * @time 2019/4/7 23:16
 */
public class Shop {
    /*
    shop_id	int
shop_user_id	int
shop_category	int
shop_name	varchar
shop_desc	text
shop_address	varchar
shop_phone	varchar
shop_image	varchar
shop_status	int
shop_createtime	datetime
shop_last_edit_time	datetime
shop_priority	int
shop_level	int

    * */
    private Integer shopId;
    private String shopUserId;
    private Integer shopCategory;
    private String shopName;
    private String shopDesc;
    private String shopAddress;
    private String shopPhone;
    private String shopImage;
    private Integer shopStatus;
    private Date shopCreatetime;
    private Date shopLastEditTime;
    private Integer shopPriority;
    private Integer shopLevel;

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public String getShopUserId() {
        return shopUserId;
    }

    public void setShopUserId(String shopUserId) {
        this.shopUserId = shopUserId;
    }

    public Integer getShopCategory() {
        return shopCategory;
    }

    public void setShopCategory(Integer shopCategory) {
        this.shopCategory = shopCategory;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopDesc() {
        return shopDesc;
    }

    public void setShopDesc(String shopDesc) {
        this.shopDesc = shopDesc;
    }

    public String getShopAddress() {
        return shopAddress;
    }

    public void setShopAddress(String shopAddress) {
        this.shopAddress = shopAddress;
    }

    public String getShopPhone() {
        return shopPhone;
    }

    public void setShopPhone(String shopPhone) {
        this.shopPhone = shopPhone;
    }

    public String getShopImage() {
        return shopImage;
    }

    public void setShopImage(String shopImage) {
        this.shopImage = shopImage;
    }

    public Integer getShopStatus() {
        return shopStatus;
    }

    public void setShopStatus(Integer shopStatus) {
        this.shopStatus = shopStatus;
    }

    public Date getShopCreatetime() {
        return shopCreatetime;
    }

    public void setShopCreatetime(Date shopCreatetime) {
        this.shopCreatetime = shopCreatetime;
    }

    public Date getShopLastEditTime() {
        return shopLastEditTime;
    }

    public void setShopLastEditTime(Date shopLastEditTime) {
        this.shopLastEditTime = shopLastEditTime;
    }

    public Integer getShopPriority() {
        return shopPriority;
    }

    public void setShopPriority(Integer shopPriority) {
        this.shopPriority = shopPriority;
    }

    public Integer getShopLevel() {
        return shopLevel;
    }

    public void setShopLevel(Integer shopLevel) {
        this.shopLevel = shopLevel;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "shopId=" + shopId +
                ", shopUserId='" + shopUserId + '\'' +
                ", shopCategory=" + shopCategory +
                ", shopName='" + shopName + '\'' +
                ", shopDesc='" + shopDesc + '\'' +
                ", shopAddress='" + shopAddress + '\'' +
                ", shopPhone='" + shopPhone + '\'' +
                ", shopImage='" + shopImage + '\'' +
                ", shopStatus=" + shopStatus +
                ", shopCreatetime=" + shopCreatetime +
                ", shopLastEditTime=" + shopLastEditTime +
                ", shopPriority=" + shopPriority +
                ", shopLevel=" + shopLevel +
                '}';
    }

    public Shop(Integer shopId, String shopUserId, Integer shopCategory, String shopName, String shopDesc, String shopAddress, String shopPhone, String shopImage, Integer shopStatus, Date shopCreatetime, Date shopLastEditTime, Integer shopPriority, Integer shopLevel) {
        this.shopId = shopId;
        this.shopUserId = shopUserId;
        this.shopCategory = shopCategory;
        this.shopName = shopName;
        this.shopDesc = shopDesc;
        this.shopAddress = shopAddress;
        this.shopPhone = shopPhone;
        this.shopImage = shopImage;
        this.shopStatus = shopStatus;
        this.shopCreatetime = shopCreatetime;
        this.shopLastEditTime = shopLastEditTime;
        this.shopPriority = shopPriority;
        this.shopLevel = shopLevel;
    }

    public Shop() {
    }
}
