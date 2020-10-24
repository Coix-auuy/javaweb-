package pers.auuy.service;

import pers.auuy.pojo.User;

public interface UserService {
    /**
     * 注册用户
     * @param user
     */
    public void registerUser(User user);

    /**
     * 登录
     * @param user
     * @return 返回 null 说明登录失败
     */
    public User login(User user);

    /**
     * 检查用户名是否可用
     * @param username
     * @return 返回 true 表示用户名已存在，返回 false 表现用户名可用
     */
    public boolean existsUsername(String username);
}
