<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nightmare
  Date: 2020/5/28
  Time: 10:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改/添加读者</title>
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
                    <li><a href="manage/borrowServlet?action=page">借还书管理</a></li>
                    <li><a href="manage/readerServlet?action=page">返回</a> </li>
                </ul>
            </div>
            <form action="manage/readerServlet" method=get >
                <input type="hidden" name="pageNo" value="${param.pageNo}">
                <%--判断当前请求中是否包含 id 参数，如果有说明是修改操作--%>
                <input type="hidden" name="action" value="${empty param.id?"add":"update"}">
                <c:if test="${empty param.id == false}">
                    <input type="hidden" name="id" value="${param.id}">
                </c:if>
                <table class="table">
                    <tr>
                        <c:if test="${empty param.id}">
                            <th>学号</th>
                        </c:if>
                        <th>姓名</th>
                        <th>性别</th>
                        <th>专业</th>
                        <th colspan="2">操作</th>
                    </tr>
                    <tr>
                        <c:if test="${empty param.id}">
                            <td><input name="id" type="text" value="${requestScope.reader.id}"/></td>
                        </c:if>
                        <td><input name="name" type="text" value="${requestScope.reader.name}"/></td>
                        <td><input name="sex" type="text" value="${requestScope.reader.sex}"/></td>
                        <td><input name="major" type="text" value="${requestScope.reader.major}"/></td>
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
