package Entity;

import java.util.Date;

/**
 * @author lxxxxxxy
 * @time 2019/3/31 22:37
 */
/*
* user_id	int
user_name	varchar
user_phone	varchar
user_head_image	varchar
user_default_address	int
user_status	int
user_type	int
user_createtime	datetime
user_last_edit_time	datetime
* */
public class UserInfo {
    private String userId;
    private String userName;
    private String userPhone;
    private String userEmail;
    private String userHeadImage;
    private Integer userDefaultAddress;
    private Integer userStatus;
    private Integer userApplyShop;
    private Integer userType;
    private Date userCreatetime;
    private Date userLastEditTime;

    @Override
    public String toString() {
        return "UserInfo{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userHeadImage='" + userHeadImage + '\'' +
                ", userDefaultAddress=" + userDefaultAddress +
                ", userStatus=" + userStatus +
                ", userApplyShop=" + userApplyShop +
                ", userType=" + userType +
                ", userCreatetime=" + userCreatetime +
                ", userLastEditTime=" + userLastEditTime +
                '}';
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserHeadImage() {
        return userHeadImage;
    }

    public void setUserHeadImage(String userHeadImage) {
        this.userHeadImage = userHeadImage;
    }

    public Integer getUserDefaultAddress() {
        return userDefaultAddress;
    }

    public void setUserDefaultAddress(Integer userDefaultAddress) {
        this.userDefaultAddress = userDefaultAddress;
    }

    public Integer getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    public Integer getUserApplyShop() {
        return userApplyShop;
    }

    public void setUserApplyShop(Integer userApplyShop) {
        this.userApplyShop = userApplyShop;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public Date getUserCreatetime() {
        return userCreatetime;
    }

    public void setUserCreatetime(Date userCreatetime) {
        this.userCreatetime = userCreatetime;
    }

    public Date getUserLastEditTime() {
        return userLastEditTime;
    }

    public void setUserLastEditTime(Date userLastEditTime) {
        this.userLastEditTime = userLastEditTime;
    }

    public UserInfo(String userId, String userName, String userPhone, String userEmail, String userHeadImage, Integer userDefaultAddress, Integer userStatus, Integer userApplyShop, Integer userType, Date userCreatetime, Date userLastEditTime) {
        this.userId = userId;
        this.userName = userName;
        this.userPhone = userPhone;
        this.userEmail = userEmail;
        this.userHeadImage = userHeadImage;
        this.userDefaultAddress = userDefaultAddress;
        this.userStatus = userStatus;
        this.userApplyShop = userApplyShop;
        this.userType = userType;
        this.userCreatetime = userCreatetime;
        this.userLastEditTime = userLastEditTime;
    }

    public UserInfo() {
    }
}
