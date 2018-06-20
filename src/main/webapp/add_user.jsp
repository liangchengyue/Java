<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户注册</title>
    <script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="js/jquery.validate.js"></script>
</head>
<body>
<form action="addUser" method="post">
    <table>
        <tr>
            <th>昵称：</th>
            <td><input type="text" name="nickname" required minlength="3"></td>
        </tr>
        <tr>
            <th>用户名：</th>
            <td><input type="text" name="username" required minlength="3"></td>
        </tr>
        <tr>
            <th>密码：</th>
            <td><input type="password" name="password" required></td>
        </tr>
        <tr>
            <th>确认密码：</th>
            <td><input type="password" name="password1" required></td>
        </tr>
        <tr>
            <th>年龄：</th>
            <td><input type="number" name="age" required></td>
        </tr>
        <tr>
            <th>性别：</th>
            <td><input type="radio" name="sex" checked value="男">男&nbsp;<input type="radio" name="sex" value="女">女</td>
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
