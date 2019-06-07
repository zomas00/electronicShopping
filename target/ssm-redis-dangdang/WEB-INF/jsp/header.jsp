<%--
  Created by IntelliJ IDEA.
  User: zomas
  Date: 2019/5/8
  Time: 9:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
</head>
<!-- 路径没有问题 -->
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.3.js"></script>

<script type="text/javascript">
    <%--$(function () {--%>
        <%--$("#login").click(function () {--%>
            <%--window.open("${pageContext.request.contextPath}/user/login");--%>
        <%--});--%>
    <%--});--%>
    <%--$(function () {--%>
        <%--$("#regist").click(function () {--%>
            <%--window.open("${pageContext.request.contextPath}/user/regist");--%>
        <%--});--%>
    <%--});--%>
    //登录函数
    $(function () {
        if (${sessionScope.currentUser!=null}){
            $("#heads").html("${sessionScope.currentUser.email}"+
                "<button><a href=\"user/logout\">注销</a></button>");
            console.log("${sessionScope.currentUser.email}");
        }
    })
</script>
<body>
<div id="heads">
    <button ><a href="user/login">登录</a></button>
    <button ><a href="user/registForm">注册</a></button>
</div>
<button><a href="${pageContext.request.contextPath}/cart/show">我的购物车</a></button>
</body>
</html>
