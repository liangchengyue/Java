<%--
  Created by IntelliJ IDEA.
  User: liangchengyue
  Date: 2018/6/20 020
  Time: 23:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员界面</title>
</head>
<body>
<span>${user.username}</span>&nbsp;<a href="logout">注销</a>
<ul>
    <li>
        <a href="listUser">用户管理</a>
    </li>
    <li>
        <a href="/listOrder">订单管理</a>
    </li>
    <li>
        <a href="/listMobile">手机管理</a></li>
</ul>
</body>
</html>
