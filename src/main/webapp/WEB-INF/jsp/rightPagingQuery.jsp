<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zomas
  Date: 2019/5/15
  Time: 16:18
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
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.3.js"></script>

<script>
    /*分页查询的局部刷新*/
    $(function(){
        $(".cur").click(function(){
            var	value = $(this).attr("catId");
            var page = $(this).attr("curPage");
            //请求资源路径，请求参数，回调函数，响应的数据类型
            $.get("category/pagingquery",{CatId:value,CurPage:page},function(data){
                $("#fenye").html(data);
            });
        });
    });
    //加入购物车的局部刷新
    $(function(){
       $(".cart").click(function () {
          var productId = $(this).attr("productId");
         $.get("cart/add",{productId:productId},function (data) {
         })
       });
    });
</script>
<body>
${curPage}<br>
${allPage}<br>
<c:if test="${curPage>1}">
    <%--<a class="cur" href="${pageContext.request.contextPath}/category/pagingquery?CatId=${category.id}&CurPage=${curPage-1}">上一页</a>--%>
    <a class="cur" href="javascript:;" catId=${category.id} curPage=${curPage-1}>上一页</a>
</c:if>
    第${curPage}页/共${allPage}页
<c:if test="${curPage<allPage}">
    <a class="cur" href="javascript:;" catId=${category.id} curPage=${curPage+1}>下一页</a></c:if><br>
${category.name}<br>
<c:forEach var="product" items="${category.productList}">
    ${product.productName}<br>
    ${product.author}<br>
    ${product.productPic}<br>
    <a href="javascript:;" productId=${product.id} class="cart">加入购物车</a>
</c:forEach>

</body>
</html>
