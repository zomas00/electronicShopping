<%--
  Created by IntelliJ IDEA.
  User: zomas
  Date: 2019/5/13
  Time: 22:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
</head>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.3.js"></script>

<body>
    <h2>分类浏览</h2>

    <c:forEach var="cat" items="${category}">
    <ul><a href="javascript:;" class="categoryUl" catId="${cat.id}" curPage=1>${cat.name}</a>
        <c:forEach var="catTwo" items="${cat.categoryList}">
            <li>&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:;" class="categoryUl" catId="${cat.id}" curPage=1>${catTwo.name}</a></li>
        </c:forEach>
        </ul>
    </c:forEach>
</body>
</html>
