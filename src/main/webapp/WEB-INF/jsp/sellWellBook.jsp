<%--
  Created by IntelliJ IDEA.
  User: zomas
  Date: 2019/4/26
  Time: 11:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/sellwell.css"/>
</head>
<body>
<c:forEach var="x" items="${productListSell}">
    <div class="sellWellBooks">
        <div class="sellWellBook-img">
            <img src="${pageContext.request.contextPath}/images/productImages/${x.productPic}"
                 width="60px" height="100px"/><br>
        </div>
        <div class="sellWellBook-info">
            书名:${x.productName}<br>
            定价:${x.fixedPrice}<br/>
            当当价:${x.dangPrice}<br>
        </div>
    </div>
</c:forEach>
</body>
