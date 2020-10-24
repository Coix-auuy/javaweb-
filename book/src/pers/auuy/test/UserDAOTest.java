package pers.auuy.test;

import org.junit.Test;
import pers.auuy.dao.UserDAO;
import pers.auuy.dao.impl.UserDAOImpl;
import pers.auuy.pojo.User;

import static org.junit.Assert.*;

public class UserDAOTest {
    UserDAO userDAO = new UserDAOImpl();
    @Test
    public void queryUserByUsername() {

        if(userDAO.queryUserByUsername("admin123") == null) {
            System.out.println("用户名可用！");
        } else {
            System.out.println("用户名已存在！");
        }
    }

    @Test
    public void queryUserByUsernameAndPassword() {
        if(userDAO.queryUserByUsernameAndPassword("admin1","admin") == null) {
            System.out.println("用户名或密码错误，登陆失败！");
        } else {
            System.out.println("登录成功！");
        }
    }

    @Test
    public void saveUser() {
        System.out.println(userDAO.saveUser(new User(null,"hzx123","123456","hzx@qq.com")));
    }
}