package Entity;

/**
 * @author lxxxxxxy
 * @time 2019/4/1 08:18
 */
/*
* user_id	int
user_username	varchar
user_password	varchar

* */
public class UserCheck {
    private String userId;
    private String userUsername;
    private String userPassword;

    @Override
    public String toString() {
        return "userCheck{" +
                "userId=" + userId +
                ", userUsername='" + userUsername + '\'' +
                ", userPassword='" + userPassword + '\'' +
                '}';
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserUsername() {
        return userUsername;
    }

    public void setUserUsername(String userUsername) {
        this.userUsername = userUsername;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public UserCheck(String userId, String userUsername, String userPassword) {
        this.userId = userId;
        this.userUsername = userUsername;
        this.userPassword = userPassword;
    }

    public UserCheck() {
    }
}
