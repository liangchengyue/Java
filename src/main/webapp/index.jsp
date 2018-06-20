
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>手机商城</title>
</head>
<body>
<C:if test="${user==null}">
<a href="login.jsp">登录</a>&nbsp;<a href="add_user.jsp">注册</a>
</C:if>
<C:if test="${user!=null}">
<span>${user.username}</span>&nbsp;<a href="logout">注销</a>
</C:if>
</body>
</html>
