<%--
  Created by IntelliJ IDEA.
  User: nightmare
  Date: 2020/5/26
  Time: 13:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme() + "://"
            + request.getServerName()
            + ":"
            + request.getServerPort()
            + request.getContextPath()
            +"/";
    pageContext.setAttribute("basePath",basePath);
%>
<%--<%=basePath%>--%>
<!--base标签永远固定相对路径的跳转结果-->
<base href="<%=basePath%>">
<!--引入favicon -->
<link rel="shortcut icon" href="static/img/favicon.png" />
<!--引入初始化样式-->
<link type="text/css" rel="stylesheet" href="static/css/base.css">
<!--引入公共样式-->
<link type="text/css" rel="stylesheet" href="static/css/common.css">
<!--引入 jQuery-->
<script type="text/javascript" src="static/script/jquery-1.7.2.js"></script>
