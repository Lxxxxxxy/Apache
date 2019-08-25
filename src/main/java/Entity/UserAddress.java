package Entity;

/**
 * @author lxxxxxxy
 * @time 2019/4/5 10:32
 */
public class UserAddress {
    private String userAddressId;
    private String userAddressUserId;
    private String userAddressName;
    private String userAddressPhone;
    private String userAddressAddress;

    @Override
    public String toString() {
        return "UserAddress{" +
                "userAddressId=" + userAddressId +
                ", userAddressUserId='" + userAddressUserId + '\'' +
                ", userAddressName='" + userAddressName + '\'' +
                ", userAddressPhone='" + userAddressPhone + '\'' +
                ", userAddressAddress='" + userAddressAddress + '\'' +
                '}';
    }

    public String getUserAddressId() {
        return userAddressId;
    }

    public void setUserAddressId(String userAddressId) {
        this.userAddressId = userAddressId;
    }

    public String getUserAddressUserId() {
        return userAddressUserId;
    }

    public void setUserAddressUserId(String userAddressUserId) {
        this.userAddressUserId = userAddressUserId;
    }

    public String getUserAddressName() {
        return userAddressName;
    }

    public void setUserAddressName(String userAddressName) {
        this.userAddressName = userAddressName;
    }

    public String getUserAddressPhone() {
        return userAddressPhone;
    }

    public void setUserAddressPhone(String userAddressPhone) {
        this.userAddressPhone = userAddressPhone;
    }

    public String getUserAddressAddress() {
        return userAddressAddress;
    }

    public void setUserAddressAddress(String userAddressAddress) {
        this.userAddressAddress = userAddressAddress;
    }

    public UserAddress(String userAddressId, String userAddressUserId, String userAddressName, String userAddressPhone, String userAddressAddress) {
        this.userAddressId = userAddressId;
        this.userAddressUserId = userAddressUserId;
        this.userAddressName = userAddressName;
        this.userAddressPhone = userAddressPhone;
        this.userAddressAddress = userAddressAddress;
    }

    public UserAddress() {
    }
}
