package dao;

import Dao.UserCheckDao;
import Dao.UserInfoDao;
import Entity.UserCheck;
import Entity.UserInfo;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author lxxxxxxy
 * @time 2019/3/31 22:48
 */
public class userInfoDaoTest extends baseDao {

    @Resource
    private UserInfoDao userInfoDao;

    @Resource
    private UserCheckDao userCheckDao;

    @Test
    public void testInsertUserInfo(){
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName("yyy");
        userInfo.setUserPhone("111");
        userInfo.setUserDefaultAddress(1);
        userInfo.setUserStatus(0);
        userInfo.setUserType(2);
        userInfo.setUserHeadImage("test1");
        userInfo.setUserCreatetime(new Date());
        userInfo.setUserLastEditTime(new Date());
        Integer i = userInfoDao.insertUser(userInfo);
        if(i==null){
            System.out.println("插入失败！");
            return;
        }
        UserCheck userCheck = new UserCheck();
        userCheck.setUserId(userInfo.getUserId());
        userCheck.setUserUsername("lxxxxxxy");
        userCheck.setUserPassword("123");
        Integer row = userCheckDao.saveUser(userCheck);
        if(row!=null){
            System.out.println("插入成功！");
        }
    }

    @Test
    public void testSelectUser(){
        UserInfo userInfos = userInfoDao.selectUser("");
        System.out.println(userInfos);
    }

}
