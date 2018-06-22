<%--
  Created by IntelliJ IDEA.
  User: liangchengyue
  Date: 2018/6/21 021
  Time: 22:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>订单管理</title>
    <script>
        function deleteOrder(id) {
            if (window.confirm("确认删除吗？")) {
                window.location.href="deleteOrder?id="+id;
            }
        }
    </script>
</head>
<body>
<table border="1px" style="border-collapse:collapse;">
    <tr>
        <th>厂商</th>
        <th>型号</th>
        <th>图片</th>
        <th>单价</th>
        <th>数量</th>
        <th>状态</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${order}" var="item">
        <tr>
            <td>${item.mobile.vendor}</td>
            <td>${item.mobile.model}</td>
            <td><img style="width: 100px" src="img/${item.mobile.image}"></td>
            <td>${item.mobile.price}</td>
            <td>${item.number}</td>
            <td><c:if test="${item.pay}">已支付</c:if><c:if test="${!item.pay}">未支付</c:if></td>
            <td><a href="javascript:;" onclick="deleteOrder(${item.id})">删除</a>
            </td>
        </tr>
    </c:forEach>
</table>
<a href="manager.jsp">返回管理界面</a>
</body>
</html>
