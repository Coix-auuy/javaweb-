package pers.auuy.service.impl;

import pers.auuy.dao.UserDAO;
import pers.auuy.dao.impl.UserDAOImpl;
import pers.auuy.pojo.User;
import pers.auuy.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDAO userDAO = new UserDAOImpl();

    @Override
    public void registerUser(User user) {
        userDAO.saveUser(user);
    }

    @Override
    public User login(User user) {
        return userDAO.queryUserByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    @Override
    public boolean existsUsername(String username) {
        if (userDAO.queryUserByUsername(username) == null)
            return false;
        return true;
    }
}
