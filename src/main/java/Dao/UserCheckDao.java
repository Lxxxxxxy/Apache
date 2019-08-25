package Dao;

import Entity.UserCheck;

/**
 * @author lxxxxxxy
 * @time 2019/4/1 08:27
 */
public interface UserCheckDao {
    Integer saveUser(UserCheck userCheck);
    UserCheck login(UserCheck userCheck);
    void updatePassword(UserCheck userCheck);
}
