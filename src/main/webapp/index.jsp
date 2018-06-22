
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>手机商城</title>
    <script>
        function shop(id,isLogin) {
            if (isLogin==false){
                alert("请先登录！");
                return;
            }
            window.location.href="addOrder?id="+id;
        }
    </script>
</head>
<body>
<c:if test="${user==null}">
<a href="login.jsp">登录</a>&nbsp;<a href="add_user.jsp">注册</a>
</c:if>
<c:if test="${user!=null}">
<span>${user.username}</span>&nbsp;<a href="logout">注销</a>&nbsp;<a href="orderList" >查看订单</a>
</c:if>
<table border="1px" style="border-collapse:collapse;">
    <tr>
        <th>厂商</th>
        <th>型号</th>
        <th>图片</th>
        <th>单价</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${mobile}" var="item">
        <tr>
            <td>${item.vendor}</td>
            <td>${item.model}</td>
            <td><img style="width: 100px" src="img/${item.image}"></td>
            <td>${item.price}</td>
            <td><a href="javascript:;" onclick="shop(${item.id},${user!=null})">购买</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
