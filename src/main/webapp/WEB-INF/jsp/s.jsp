<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zomas
  Date: 2019/6/4
  Time: 17:06
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
<body>
<div class="Box1" id="ActiveCode">
    <div class="listTablebox" id="listTablebox" style="overflow-y: scroll;height: 350px;width: 100%;">
        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="listTable" id="listTable"
               style="height: 380px;text-align: center;">
            <tr>
                <th>日期</th>
                <th>时间</th>
                <c:if test="${ManagerFlag != 0}">
                    <th>客户经理工号</th>
                    <th>客户经理姓名</th>
                </c:if>
                <th>客户姓名</th>
                <th>发卡机编号</th>
                <th>卡箱号</th>
                <th>卡号</th>
                <th>业务类型</th>
                <th>交易状态</th>
            </tr>
            <c:forEach items="${listcart}" var="map" varStatus="status">
                <tr>
                    <td>${map.productId}</td>
                    <td>${map.productName}</td>
                    <td>${map.dangPrice}</td>
                    <td>${map.number}</td>
                    <td>${map.productPic}</td>
                </tr>
            </c:forEach>
        </table>
        <c:if test="${empty listcart}">
            <table width="100%" border="0" cellpadding="0" cellspacing="0" class="submitTablePrivate">
                <tr>
                    <td align="center">查询无记录</td>
                </tr>
            </table>
        </c:if>
    </div>
</div>
</body>
</html>
