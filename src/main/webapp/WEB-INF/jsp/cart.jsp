<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zomas
  Date: 2019/6/3
  Time: 11:34
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
        $(".number").change(function () {
                var productId = $(this).attr("productId");
                var number = $(this).val();
            $.get("cart/editNumber",{productId: productId,number:number},function (data) {
                    $(".cart").html(data);
            })
        })
    })
    $(function () {
        $(".all").click(function () {
            var check = $(".all").prop('checked');
            if (check==true){
                $(":checkbox").prop("checked",true);
            }
            if(check==false){
                $(":checkbox").prop("checked",false);
            }
        })
    })
    $(function () {
        $(".goods").click(function () {
            var xiaoji = parseInt($(this).attr("xiaoji"));
            var allPrice = 0;
            if ($(this).prop("checked")) {
                allPrice = parseInt(allPrice+xiaoji);
                $(".allPrice").html(allPrice);
            }else{
                allPrice = parseInt(allPrice-xiaoji);
                if(allPrice<=0){
                    allPrice = 0;
                    $(".allPrice").html(allPrice);
                }

            }
        })
    })
</script>
<body>
    <div class="cart">
        <%--<input type="checkbox" class="all"/><br/>--%>
        <%--<c:forEach var="cart" items="${listcart}">--%>
         <%--&lt;%&ndash;<c:forEach var="" items="cart">&ndash;%&gt;--%>
             <%--&lt;%&ndash;&ndash;%&gt;--%>
         <%--&lt;%&ndash;</c:forEach>&ndash;%&gt;--%>
         <%--<input type="checkbox" class="goods" value="${cart.productId}" xiaoji="${cart.dangPrice*cart.number}"/>--%>
         <%--商品名称：${cart.productName}&nbsp;&nbsp;--%>
         <%--价格：${cart.dangPrice}&nbsp;&nbsp;--%>
         <%--小计：${cart.dangPrice*cart.number}--%>
         <%--商品图片：${cart.productPic}&nbsp;&nbsp;--%>
         <%--数量：<input type="text" value="${cart.number}" class="number" productId="${cart.productId}"/><br>--%>
     <%--</c:forEach>--%>
    </div>
    总价：<em><span class="allPrice"></span></em>
</body>
</html>
