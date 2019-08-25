package Service;

import Entity.UserCheck;

/**
 * @author lxxxxxxy
 * @time 2019/4/3 21:21
 */
public interface UserCheckService {
    UserCheck login(UserCheck userCheck);
    void updatePassword(UserCheck userCheck);
}
