<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>管理页面</title>
    <%--静态包含 base 标签，css 样式，jQuery 文件，favicon 等--%>
    <%@ include file="/pages/common/head.jsp"%>
    <!--引入样式-->
    <link type="text/css" rel="stylesheet" href="static/css/manage.css">
</head>
<body>
    <div class="w">
        <%--静态包含头部内容--%>
        <%@ include file="/pages/common/header.jsp"%>
        <div class="area" >
            <div class="manage_area">
                <ul>
                    <li><a href="manage/bookServlet?action=page">图书管理</a></li>
                    <li><a href="manage/readerServlet?action=page">读者管理</a></li>
                    <li><a href="manage/borrowServlet?action=page">借还书管理</a></li>
                </ul>
            </div>
        </div>
        <%--静态包含页脚内容--%>
        <%@ include file="/pages/common/footer.jsp"%>
    </div>
</body>
</html>