package pers.auuy.dao;

import pers.auuy.pojo.User;

public interface UserDAO {

    /**
     * 根据用户名查询用户信息
     *
     * @param username 用户名
     * @return 返回 null 说明没有用户信息
     */
    public User queryUserByUsername(String username);

    /**
     * 根据用户名和密码查询用户信息
     *
     * @param username
     * @param password
     * @return 返回 null 说明用户名或密码错误
     */
    public User queryUserByUsernameAndPassword(String username, String password);

    /**
     * 保存用户信息
     *
     * @param user
     * @return 保存失败返回-1，其他是sql语句影响的行数
     */
    public int saveUser(User user);
}
