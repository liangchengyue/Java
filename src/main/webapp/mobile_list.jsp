<%--
  Created by IntelliJ IDEA.
  User: liangchengyue
  Date: 2018/6/21 021
  Time: 12:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>手机管理</title>
    <script>
        function deleteMobile(id) {
            if (window.confirm("确认删除吗？")) {
                window.location.href="deleteMobile?id="+id;
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
        <th>操作</th>
    </tr>
<c:forEach items="${mobile}" var="item">
    <tr>
        <td>${item.vendor}</td>
        <td>${item.model}</td>
        <td><img style="width: 100px" src="img/${item.image}"></td>
        <td>${item.price}</td>
        <td><a href="findMobileById?id=${item.id}">修改</a>&nbsp;|&nbsp;<a href="javascript:;" onclick="deleteMobile(${item.id})">删除</a></td>
    </tr>
</c:forEach>
</table>
<a href="add_mobile.jsp">添加手机</a>&nbsp;<a href="manager.jsp">返回管理界面</a>
</body>
</html>
