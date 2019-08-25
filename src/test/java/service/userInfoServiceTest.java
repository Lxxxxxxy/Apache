package service;

import Entity.UserInfo;
import Service.impl.UserInfoServiceImpl;
import dao.baseDao;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author lxxxxxxy
 * @time 2019/4/1 08:53
 */
public class userInfoServiceTest extends baseDao {

    @Resource
    private UserInfoServiceImpl userinfoserviceimpl;

    @Test
    public void testInsertUserInfo(){

        UserInfo userInfo = new UserInfo();
        userInfo.setUserName("yyy");
        userInfo.setUserPhone("111111");
        userInfo.setUserDefaultAddress(1);
        userInfo.setUserStatus(0);
        userInfo.setUserType(2);
        userInfo.setUserHeadImage("test1");
        userInfo.setUserCreatetime(new Date());
        userInfo.setUserLastEditTime(new Date());
//        Integer row = userinfoserviceimpl.insertUser(userInfo, "123", "123");
//        if(row!=null){
//            System.out.println("成功！");
//        }else{
//            System.out.println("失败！");
//        }
    }
}
