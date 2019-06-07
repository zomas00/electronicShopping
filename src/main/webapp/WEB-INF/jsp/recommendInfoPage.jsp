<%--
  Created by IntelliJ IDEA.
  User: zomas
  Date: 2019/4/24
  Time: 22:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/recommend.css"/>
</head>
<body>
<c:forEach var="x" items="${productList}">
    <div class="recommends">
        <div class="recommend-img">
            <img src="${pageContext.request.contextPath}/images/productImages/${x.productPic}"
                 width="60px" height="100px"/><br>
        </div>
        <div class="recommend-info">
                书名:${x.productName}<br>
                定价:${x.fixedPrice}&nbsp;
                当当价:${x.dangPrice}<br>
                作者:${x.book.author}<br>
                出版社:${x.book.publishing}<br>
                简介:${x.description}
        </div>
    </div>
</c:forEach>
</body>

