package pers.auuy.web;

import pers.auuy.pojo.User;
import pers.auuy.service.UserService;
import pers.auuy.service.impl.UserServiceImpl;
import pers.auuy.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

public class UserServlet extends BaseServlet {

    UserService userService = new UserServiceImpl();

    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.获取请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String code = req.getParameter("code");
        String token = (String)req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);
        // 检测验证码
        if(token!= null && token.equalsIgnoreCase(code)) {
            // 检查账号密码是否正确
            User user = new User(null, username, password, null);
            if(userService.login(user)!= null) {
                // 保存用户信息到 session 域中
                req.getSession().setAttribute("user",user);
                // 跳转到首页
                req.getRequestDispatcher("/pages/manage/manage.jsp").forward(req,resp);
            } else {
                // 把错误信息保存到 request 域中
                req.setAttribute("msg","用户名或密码错误！");
                req.setAttribute("username",username);
                // 跳回
                req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
            }
        } else {
            // 跳回
            // 把错误信息保存到 request 域中
            req.setAttribute("msg","验证码错误！");
            req.setAttribute("username",username);
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
        }
    }
    protected void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.获取请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");
        String register_code = req.getParameter("register_code");
        String token = (String)req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);
        // 1.检查验证码是否正确
//        User user = WebUtils.copyParaToBean(req.getParameterMap(),new User());
//        System.out.println(user);
        if (token!= null && token.equalsIgnoreCase(code)) {
            // 检查注册邀请码是否正确
            if (register_code.equals("admin")) {
                // (1).检查用户名是否可用
                if (userService.existsUsername(username)) {
                    // 用户名不可用
                    req.setAttribute("msg", "用户名已存在！");
                    req.setAttribute("username", username);
                    req.setAttribute("email", email);
                    req.getRequestDispatcher("/pages/user/register.jsp").forward(req, resp);
                } else {
                    // 用户名可用
                    // (1)调用service保存
                    User user = new User(null, username, password, email);
                    userService.registerUser(user);
                    // 保存到 session
                    req.getSession().setAttribute("user",user);
                    // (2)跳转到首页
                    req.getRequestDispatcher("/pages/manage/manage.jsp").forward(req, resp);
                }
            } else {
                // 把回显信息保存到 request 域中
                req.setAttribute("msg", "注册邀请码错误！");
                req.setAttribute("username", username);
                req.setAttribute("email", email);
                // 跳回注册页面
                req.getRequestDispatcher("/pages/user/register.jsp").forward(req, resp);
            }
        } else {
            // 把回显信息保存到 request 域中
            req.setAttribute("msg", "验证码错误！");
            req.setAttribute("username", username);
            req.setAttribute("email", email);
            // 跳回注册页面
            req.getRequestDispatcher("/pages/user/register.jsp").forward(req, resp);
        }
    }
}
