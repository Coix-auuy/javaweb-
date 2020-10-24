<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>注册页面</title>
    <%--静态包含 base 标签，css 样式，jQuery 文件，favicon 等--%>
    <%@ include file="/pages/common/head.jsp"%>
    <!--引入样式-->
    <link type="text/css" rel="stylesheet" href="static/css/login_register.css">
    <script type="text/javascript">
        //页面加载完成后
        $(function () {
            // 点击验证码切换
            $("#kaptch").click(function () {
                this.src="${basePath}kaptcha.jpg";
            });
            //给注册按钮绑定单击事件
            $("#sub_btn").click(function () {
                //用户名 数字、字母、下划线组成的5~12位字符串
                var username = $("#username").val();
                var usernameAndPasswordPattern = /^\w{5,12}$/;
                if(!usernameAndPasswordPattern.test(username)) {
                    $("#errorMsg").text("用户名格式不合法！");
                    return false;
                }
                //密码 数字、字母、下划线组成的5~12位字符串
                var password1 = $("#password1").val();
                if(!usernameAndPasswordPattern.test(password1)) {
                    $("#errorMsg").text("密码格式不合法！");
                    return false;
                }

                //确认密码
                var password2 = $("#password2").val();
                if(password1 != password2) {
                    $("#errorMsg").text("确认密码和密码不一致！");
                    return false;
                }
                //邮箱
                var email = $("#email").val();
                var emailPatt = /^[a-z\d]+(\.[a-z\d]+)*@([\da-z](-[\da-z])?)+(\.{1,2}[a-z]+)+$/;
                if(!emailPatt.test(email)) {
                    $("#errorMsg").text("邮箱不合法！");
                    return false;
                }
                //验证码
                //去掉验证码前后空格
                var code = $("#code").val();
                code = $.trim(code);

                if(code == null || code == "") {
                    $("#errorMsg").text("验证码不能为空！");
                    return false;
                }
                // 注册邀请码
                var register_code = $("#register_code").val();
                register_code = $.trim(register_code);
                if(register_code == null || register_code == "") {
                    $("#errorMsg").text("注册邀请码不能为空！");
                    return false;
                }
                $("#errorMsg").text("");
            });
            // 给去登录按钮绑定onclick事件
            $("#login_btn").click(function () {
                window.location.href="pages/user/login.jsp"
            });
        });
    </script>
</head>
<body>
    <div class="w" >
        <%--静态包含头部内容--%>
        <%@ include file="/pages/common/header.jsp"%>
        <div class="area">
            <h1 class="login_register_H1">注册</h1>
            <div class="login_register_form">
                <form action="userServlet" method="post">
                    <input type="hidden" name="action" value="register" />
                    <ul>
                        <li>
                            <label>用户账号:</label>
                            <input type="text" class = "inp" placeholder="请输入账号" autocomplete="off"
                                   tabindex="1" name="username" id="username" value="${requestScope.username}">
                        </li>
                        <li>
                            <label >用户密码:</label>
                            <input type="password" class = "inp" placeholder="请输入密码" autocomplete="off" tabindex="1" name="password" id="password1">
                        </li>
                        <li>
                            <label >确认密码:</label>
                            <input type="password" class = "inp"  placeholder="确认密码" autocomplete="off" tabindex="1" name="reppassword" id="password2">
                        </li>
                        <li>
                            <label >邮箱地址:</label>
                            <input type="eamil" class="inp" placeholder="请输入邮箱地址" autocomplete="off"
                                   tabindex="1" name="email" id="email" value="${requestScope.email}">
                        </li>
                        <li>
                            <label >注册密令:</label>
                            <input type="password" class="inp" placeholder="请输入注册邀请码" autocomplete="off" tabindex="1" name="register_code" id="register_code">
                        </li>
                        <li>
                            <label>验证码：</label>
                            <input  type="text" style="width: 150px;"class="inp" autocomplete="off" tabindex="1" name="code" id="code">
                            <img src="kaptcha.jpg" style="width: 90px;height: 30px;" alt="验证码" id="kaptch">
                        </li>
                        <span id="errorMsg">${requestScope.msg}</span>
                        <li class="submit">
                            <input type="button" value="去登录" class="login_register_btn" id="login_btn">
                            <input type="submit" value="注册" class="login_register_btn" id="sub_btn">
                        </li>

                    </ul>
                </form>

            </div>
        </div>
        <%--静态包含页脚内容--%>
        <%@ include file="/pages/common/footer.jsp"%>
    </div>
</body>
</html>