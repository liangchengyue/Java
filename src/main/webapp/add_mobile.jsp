<%--
  Created by IntelliJ IDEA.
  User: liangchengyue
  Date: 2018/6/21 021
  Time: 13:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加手机</title>
</head>
<body>
<form action="addMobile"  method="post" enctype="multipart/form-data">
<table>
    <tr>
        <th>厂商</th>
        <td><input type="text" name="vendor"></td>
    </tr>
    <tr>
        <th>型号</th>
        <td><input type="text" name="model"></td>
    </tr>
    <tr>
        <th>图片</th>
        <td><input type="file" name="image"></td>
    </tr>
    <tr>
        <th>单价</th>
        <td><input type="number" name="price"></td>
    </tr>
    <tr>
        <th></th>
        <td><input type="reset" value="重置">&nbsp;<input type="submit" value="提交"></td>
    </tr>
</table>
</form>


</body>
</html>
