<%--
  Created by IntelliJ IDEA.
  User: nightmare
  Date: 2020/5/27
  Time: 8:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改/添加图书</title>
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
                    <li><a href="manage/readerServlet?action=page">读者管理</a></li>
                    <li><a href="manage/borrowServlet?action=page">借还书管理</a></li>
                    <li><a href="manage/bookServlet?action=page">返回</a> </li>
                </ul>
            </div>
            <form action="manage/bookServlet" method=get >
                <input type="hidden" name="pageNo" value="${param.pageNo}">
<%--                判断当前请求中是否包含 id 参数，如果有说明是修改操作--%>
                <input type="hidden" name="action" value="${empty param.id?"add":"update"}">
                <input type="hidden" name="id" value="${param.id}">
                <table class="table">
                    <tr>
                        <th>名称</th>
                        <th>作者</th>
                        <th>类别</th>
                        <th>出版社</th>
                        <th colspan="2">操作</th>
                    </tr>
                        <tr>
                            <td><input name="name" type="text" value="${requestScope.book.name}"/></td>
                            <td><input name="author" type="text" value="${requestScope.book.author}"/></td>
                            <td><input name="category" type="text" value="${requestScope.book.category}"/></td>
                            <td><input name="publish" type="text" value="${requestScope.book.publish}"/></td>
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
