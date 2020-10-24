package pers.auuy.test;

import org.junit.Test;
import pers.auuy.pojo.User;
import pers.auuy.service.UserService;
import pers.auuy.service.impl.UserServiceImpl;

import static org.junit.Assert.*;

public class UserServiceTest {
    UserService userService = new UserServiceImpl();
    @Test
    public void registerUser() {
        userService.registerUser(new User(null,"user1","123456","168@qq.com"));
    }

    @Test
    public void login() {
        System.out.println(userService.login(new User(null,"user1","123456","168@qq.com")));
    }

    @Test
    public void existsUsername() {
        System.out.println(userService.existsUsername("admin3423"));
    }
}