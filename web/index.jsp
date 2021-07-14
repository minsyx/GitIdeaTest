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
  <script type="text/javascript">
    function checkForm(){
      var flag=true;
      var message=form1.message.value;
      if(message!='null'){
        alert(message);
        flag=false;
      }
      return flag;
    }

  </script>
</head>
<body onload="checkForm()">

<div align="center">
  <h1>登陆</h1>
  <hr>
  <input type="radio" name="r" onclick="location.href='index.jsp'" checked/>普通用户登陆
  <input type="radio" name="r" onclick="location.href='index2.jsp'" />管理员登陆
  <form action="ulogin" method="post">
    <br>
    用户名：<input type="text" name="username"/><br><br>
    密&nbsp;&nbsp;&nbsp;码：<input type="password" name="passwd"/><br><br>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="登陆">&nbsp;&nbsp;&nbsp;&nbsp;
    <input type="reset" value="取消">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <a href="register.jsp">注册</a>

  </form>
</div>

</body>

</html>
