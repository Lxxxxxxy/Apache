package Service.impl;

import Dao.UserCheckDao;
import Dao.UserInfoDao;
import Entity.UserCheck;
import Service.UserCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lxxxxxxy
 * @time 2019/4/3 21:21
 */
@Service
public class UserCheckServiceImpl implements UserCheckService {

    @Autowired
    private UserCheckDao userCheckDao;

    @Override
    public UserCheck login(UserCheck userCheck) {
        if (userCheck == null) {
            return null;
        }
        UserCheck user = userCheckDao.login(userCheck);
        return user;
    }

    @Override
    public void updatePassword(UserCheck userCheck) {
        if (userCheck == null) {
            throw new RuntimeException("修改密码失败！");
        }
        userCheckDao.updatePassword(userCheck);
    }
}