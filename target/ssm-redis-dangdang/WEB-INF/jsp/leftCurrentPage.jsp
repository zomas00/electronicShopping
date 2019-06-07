<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zomas
  Date: 2019/5/13
  Time: 23:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<script>
    $(function () {
        $(".caetegoryCurrent").click(function () {
            console.log(54341323213123);
            var catVal = $(this).attr("catId");
            var curPage = $(this).attr("curPage");
            // console.log(catVal);
            $.get("category/pagingquery",{CatId:catVal,CurPage:curPage},function (data) {
                console.log(32565756534534534);
                $("#fenye").html(data);
            });
        });
    });
</script>
<body>
<ul><h2><a class="caetegoryCurrent" href="javascript:;" catId="${category.id}"  curPage="1">${category.name}</a></h2>
    <c:forEach var="clist" items="${category.categoryList}">
        <a  class="caetegoryCurrent" href="javascript:;" catId="${clist.id}"  curPage="1"><li>${clist.name}</li></a>
    </c:forEach>
</ul>
</body>
</html>
