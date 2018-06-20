<%--
  Created by IntelliJ IDEA.
  User: 11231
  Date: 2018/6/20
  Time: 15:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>用户列表</title>
    <script src="js/jquery-3.3.1.min.js"></script>
    <script>
        function deleteUser(id) {
            if (window.confirm("确认删除吗？")) {
                window.location.href="deleteUser?id="+id;
            }

        }
    </script>
</head>
<body>
    <table style="border: 1px saddlebrown solid;">
        <tr>
            <th>编号</th>
            <th>登录名</th>
            <th>性别</th>
            <th>昵称</th>
            <th>年龄</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${userList}" var="item" varStatus="status">
        <tr>
            <td>${status.index+1}</td>
            <td>${item.username}</td>
            <td>${item.nickname}</td>
            <td>${item.age}</td>
            <td>${item.sex}</td>
            <td><a href="findUserById?id=${item.id}">修改</a>|<a href="javascript:;" onclick="deleteUser(${item.id})">删除</a></td>
        </tr>
        </c:forEach>

    </table>
</body>
</html>
