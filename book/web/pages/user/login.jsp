<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>登录页面</title>
    <%--静态包含 base 标签，css 样式，jQuery 文件，favicon 等--%>
    <%@ include file="/pages/common/head.jsp"%>
    <!--引入样式-->
    <link type="text/css" rel="stylesheet" href="static/css/login_register.css">

    <script type="text/javascript">
        $(function () {
            // 点击验证码切换
            $("#kaptch").click(function () {
                // 每次生成时给予不同的参数，以此来避免浏览器缓存造成的无法切换问题
                this.src="${basePath}kaptcha.jpg?d"+new Date();
            });
            // 给去注册按钮绑定onlick事件
            $("#register_btn").click(function () {
                window.location.href="pages/user/register.jsp"
            });
           $("#sub_btn").click(function () {
               // 检查用户名
               var username = $("#username").val();
               if(username == null || username == "") {
                   $("#errorMsg").text("用户名不能为空！");
                   return false;
               }
               // 检查密码
               var password = $("#password").val();
               if(password == null || password == "") {
                   $("#errorMsg").text("密码不能为空！");
                   return false;
               }
               // 检查验证码
               var code = $("#code").val();
               code = $.trim(code);
               if(code == null || code == "") {
                   $("#errorMsg").text("验证码不能为空！");
                   return false;
               }
               $("#errorMsg").text("");
           });

        });
    </script>
</head>
<body>
    <div class="w" >
        <%--静态包含头部内容--%>
        <%@ include file="/pages/common/header.jsp"%>
        <div class="area">
            <h1 class="login_register_H1">登录</h1>
            <div class="login_register_form">
                <form action="userServlet" method="post">
                    <input type="hidden" name="action" value="login" />
                    <ul>
                        <li>
                            <label>用户账号:</label>
                            <input type="text" class = "inp" placeholder="请输入账号" autocomplete="off"
                                   tabindex="1" name="username" id="username"
                                   value="${requestScope.username}">
                        </li>
                        <li>
                            <label >用户密码:</label>
                            <input type="password" class = "inp" placeholder="请输入密码" autocomplete="off"
                                   tabindex="1" name="password" id="password" >
                        </li>
                        <li>
                            <label>验证码：</label>
                            <input  type="text" style="width: 150px;"class="inp" autocomplete="off" tabindex="1" name="code" id="code">
                            <img src="kaptcha.jpg" style="width: 90px;height: 30px;" alt="验证码" id="kaptch">
                        </li>
                        <span id="errorMsg">
                            ${requestScope.msg}
                        </span>
                        <li class="submit">
                            <input type="button" value="去注册" class="login_register_btn" id="register_btn">
                            <input type="submit" value="登录" class="login_register_btn" id="sub_btn">
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