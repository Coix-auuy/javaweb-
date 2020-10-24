<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nightmare
  Date: 2020/5/26
  Time: 21:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>读者管理</title>
    <%--静态包含 base 标签，css 样式，jQuery 文件，favicon 等--%>
    <%@ include file="/pages/common/head.jsp"%>
    <!--引入样式-->
    <link type="text/css" rel="stylesheet" href="static/css/manage.css">

    <script type="text/javascript">
        $(function () {
            // 给删除绑定点击事件，用于删除的确定提示操作
            $("a.deleteClass").click(function () {
                // 在事件的 function 函数中有一个 this 对象，是当前正在响应事件的 dom 对象。
                /**
                 * confirm
                 * 返回 true 表示点击了确认。
                 */
                return confirm("删除【"+$(this).parent().parent().find("td:first").text()+"】?");
                // return false; 取消元素的默认行为 == 不提交请求
            });
        });
    </script>
</head>
<body>
    <div class="w">
        <%--静态包含头部内容--%>
        <%@ include file="/pages/common/header.jsp"%>
        <div class="area" >
            <div class="manage_area">
                <form action="manage/readerServlet" method="get">
                    <input type="hidden" name="action" value="pageByReaderID">
                    学号：<input type="text" name="id" value="${param.id}">
                    <input type="submit" value="查询" class="sBtn">
                </form>
                <ul>
                    <li><a href="manage/bookServlet?action=page">图书管理</a></li>
                    <li><a href="manage/borrowServlet?action=page">借还书管理</a></li>
                    <li><a href="pages/manage/manage.jsp">返回</a> </li>
                </ul>
            </div>
            <table>
                <tr>
                    <th>学号</th>
                    <th>姓名</th>
                    <th>性别</th>
                    <th>专业</th>
                    <th colspan="2" class="operate">操作</th>
                </tr>
                <c:forEach items="${requestScope.page.items}" var="reader">
                    <tr>
                        <td>${reader.id}</td>
                        <td>${reader.name}</td>
                        <td>${reader.sex}</td>
                        <td>${reader.major}</td>
                        <td>
                            <a href="manage/readerServlet?action=getReader&id=${reader.id}&pageNo=${requestScope.page.pageNo}">修改</a>
                        </td>
                        <td>
                            <a href="manage/readerServlet?action=delete&id=${reader.id}&pageNo=${requestScope.page.pageNo}" class="deleteClass">删除</a>
                        </td>
                    </tr>
                </c:forEach>
                <tr>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td colspan="2"><a href="pages/manage/reader_edit.jsp?pageNo=${requestScope.page.pageTotal}">添加</a></td>
                </tr>
            </table>
            <%--静态包含分页条--%>
            <%@ include file="/pages/common/page_nav.jsp"%>
        </div>

    </div>
        <%--静态包含页脚内容--%>
        <%@ include file="/pages/common/footer.jsp"%>
    </div>
</body>
</html>
