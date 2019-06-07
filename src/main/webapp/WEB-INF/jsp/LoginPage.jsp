<%--
  Created by IntelliJ IDEA.
  User: zomas
  Date: 2019/5/4
  Time: 23:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">

</head>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.3.js"></script>
    <script type="text/javascript">
        //报错原因：1.ajax进行异步请求表单提交按钮不能用submit应该用button进行提交
        //        2.ajax回调函数的不执行是因为Type类型直接大写JSON应该写成"json"，否则回调函数不会执行
        // //        3.Type类型应该跟请求头有关系，因为不写“json”也没有任何问题
        $(function () {
           $("#messageInfo").click(function () {
               // var message = $(this).attr("message");
               var email = $("input:text").val();
               var password = $("input:password").val();
               console.log("进入ajax之前");
               $.post("user/verifyLoginInfo",{email:email,password:password},function (data) {
                   console.log(data);
                   console.log("进入ajax之后");
                       if(data.status==1){
                           alert(data.msg);
                           console.log("www:"+data.msg);
                       }else{
                           window.location.href = "${pageContext.request.contextPath}/product/main";
                       }
               },"json");
           });
        });

    </script>
<body>
    <form action="user/verifyLoginInfo" method="post" >
        <%--<form:input path="email"/>--%>
        邮箱：<input type="text" name="email"><br>
        密码：<input type="password" name="password"><br>
        <%--<form:input path="password"/>--%>
            <%--name="${message}" onclick="fs(this)"--%>
    </form>
        <button id="messageInfo" >登录</button>
</body>
</html>
