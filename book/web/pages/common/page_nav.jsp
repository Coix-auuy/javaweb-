<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nightmare
  Date: 2020/5/28
  Time: 8:58
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--分页条的开始--%>
<div id="page_nav">
    <c:if test="${requestScope.page.pageNo > 1}">
        <a href="${requestScope.page.url}&pageNo=1">首页</a>
        <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo -1}">上一页</a>
    </c:if>
    <%--页码输出的开始--%>
    <c:choose>
        <%--页码总数小于等于5--%>
        <c:when test="${requestScope.page.pageTotal <= 5}">
            <c:set var="begin" value="1" />
            <c:set var="end" value="${requestScope.page.pageTotal}" />
        </c:when>
        <%--页码数大于5的情况--%>
        <c:when test="${requestScope.page.pageTotal > 5}">
            <c:choose>
                <%--                            当前页码 <= 3--%>
                <c:when test="${requestScope.page.pageNo <= 3}">
                    <c:set var="begin" value="1"/>
                    <c:set var="end" value="5"/>
                </c:when>
                <%--                            当前页码 > total - 3--%>
                <c:when test="${requestScope.page.pageNo > requestScope.page.pageTotal -3}">
                    <c:set var="begin" value="${requestScope.page.pageTotal - 4}"/>
                    <c:set var="end" value="${requestScope.page.pageTotal}"/>
                </c:when>
                <c:otherwise>
                    <c:set var="begin" value="${requestScope.page.pageNo - 2}"/>
                    <c:set var="end" value="${requestScope.page.pageNo + 2}"/>
                </c:otherwise>
            </c:choose>
        </c:when>
    </c:choose>
    <%--输出页码--%>
    <c:forEach begin="${begin}" end="${end}" var="i">
        <c:if test="${i == requestScope.page.pageNo}">
            【${i}】
        </c:if>
        <c:if test="${i != requestScope.page.pageNo}">
            <a href="${requestScope.page.url}&pageNo=${i}">${i}</a>
        </c:if>
    </c:forEach>
    <%--页码输出的结束--%>
    <c:if test="${requestScope.page.pageNo < requestScope.page.pageTotal}">
        <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo +1}">下一页</a>
        <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageTotal}">末页</a>
    </c:if>
    共${requestScope.page.pageTotal}页，${requestScope.page.pageTotalCount}条记录 到第<input value="${requestScope.page.pageNo}" name="pn" id="pn_input"/>页
    <input type="button" value="确定" id="searchPageBtn">
    <script type="text/javascript">
        $(function () {
            // 给跳转页码按钮绑定单机事件
            $("#searchPageBtn").click(function () {
                var pageNo = $("#pn_input").val();
                // 数据边界判断 可被越过
                <%--if(pageNo < 0 || pageNo > ${requestScope.page.pageTotal}) {--%>
                <%--    alert("跳转页码非法！");--%>
                <%--    return false;--%>
                <%--}--%>

                // javascript 提供了一个 location 地址对象
                // 他有一个 href 属性可以获取浏览器地址栏里的地址
                // href 属性可读可写
                location.href ="${pageScope.pagePath}${requestScope.page.url}&pageNo="+pageNo;
            });
        });
    </script>
</div>

<%--分页条的结束--%>