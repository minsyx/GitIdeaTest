<%--
  Created by IntelliJ IDEA.
  User: UserJ
  Date: 2021/7/12
  Time: 13:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  %>
<html>
<head>
    <title>登陆页面</title>
</head>
<body>

<div align="center">
    <h1>登陆</h1>

    <hr>
    <input type="radio" name="r" onclick="location.href='index.jsp'" />普通用户登陆
    <input type="radio" name="r" onclick="location.href='index2.jsp'" checked/>管理员登陆
    <form action="main.jsp" method="post">
        <br>
        用户名：<input type="text" name="username"/><br><br>
        密&nbsp;&nbsp;&nbsp;码：<input type="password" name="passwd"/><br><br>
        <input type="submit" value="登陆">&nbsp;&nbsp;&nbsp;&nbsp;
        <input type="reset" value="取消">
    </form>
</div>

</body>

</html>
