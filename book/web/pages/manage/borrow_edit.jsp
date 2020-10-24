<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nightmare
  Date: 2020/5/29
  Time: 21:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改/借书</title>
    <%--静态包含 base 标签，css 样式，jQuery 文件，favicon 等--%>
    <%@ include file="/pages/common/head.jsp" %>
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
                    <li><a href="manage/borrowServlet?action=page">返回</a> </li>
                </ul>
            </div>
            <form action="manage/borrowServlet" method=get >
                <input type="hidden" name="action" value="add">
                <table class="table">
                    <tr>
                        <th>学号</th>
                        <th>图书号</th>
                        <th>操作</th>
                    </tr>
                    <tr>
                        <td><input name="readerID" type="text" value="${requestScope.borrow.readerID}"/></td>
                        <td><input name="bookID" type="text" value="${requestScope.borrow.bookID}"/></td>
                        <td><input type="submit" value="提交"/></td>
                    </tr>
                </table>
            </form>
        </div>
        <%--静态包含页脚内容--%>
        <%@ include file="/pages/common/footer.jsp"%>
    </div>
</body>
</html>
