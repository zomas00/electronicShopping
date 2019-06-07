<%--
  Created by IntelliJ IDEA.
  User: zomas
  Date: 2019/4/26
  Time: 9:06
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
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css"/>
    <%--<style type="text/css">--%>
        <%----%>
    <%--</style>--%>
</head>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.3.js"></script>
<script>
    $(function () {
       $(".categoryUl").click(function () {
           // console.log(1111111111111111111111);
                var catVal = $(this).attr("catId");
           // console.log(catVal);
          $.get("category/leftCurrentDirectory",{CatId:catVal},function (data) {
              // console.log(222222);
             $("#left").html(data);
          });
       });
    });
    //分页局部刷新
    $(function () {
        $(".categoryUl").click(function () {
            console.log(1111111111111111111111);
            var catVal = $(this).attr("catId");
            var curPage = $(this).attr("curPage");
            // console.log(catVal);
            $.get("category/pagingquery",{CatId:catVal,CurPage:curPage},function (data) {
                console.log(222222);
                $("#fenye").html(data);
            });
        });
    });

</script>
<body>
<div id="head">
    <div>
        <div class="loginRegist">
            <jsp:include page="/user/header"/>
        </div>
    </div>
</div>
<div id="middle">
    <div id="left">
        <jsp:include page="/category/hierarchicaldirectory"/>
    </div>
    <div id="fenye" >
        <div id="center">
            <div id="center_head">
                <div>
                    <span>编辑推荐</span>
                    <span style="float:right;">更多>></span>
                </div>
                <jsp:include page="/product/recommend"/>
            </div>
            <div id="center_middle">
                <div>
                    <span>热销图书推荐</span>
                    <span style="float:right;">更多>></span>
                </div>
                <jsp:include page="/product/sellwell"/>
            </div>
            <div id="center_foot">
                <div>
                    <span>最新上架图书推荐</span>
                    <span style="float:right;">更多>></span>
                </div>
                <jsp:include page="/product/newarrival"/>
            </div>
        </div>
        <div id="right">右</div>
    </div>
</div>
<div id="foot">下</div>
</body>
</html>
