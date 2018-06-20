<%--
  Created by IntelliJ IDEA.
  User: liangchengyue
  Date: 2018/6/20 020
  Time: 17:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<form action="login" method="post">
    <table>
        <tr>
            <th>用户名：</th>
            <td><input type="text" name="username" required minlength="3"></td>
        </tr>
        <tr>
            <th>密码：</th>
            <td><input type="password" name="password" required></td>
        </tr>
        <tr>
            <th>用户类型：</th>
            <td><select name="isAdmin">
                <option value="普通用户">普通用户</option>
                <option value="管理员">管理员</option>
            </select>&nbsp;&nbsp;&nbsp;<a href="add_user.jsp">注册</a></td>
        </tr>
        <tr>
            <th></th>
            <td><input type="reset" value="重置">&nbsp;
                <input type="submit" value="提交"></td>
        </tr>
    </table>
</form>
</body>
</html>
