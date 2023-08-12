<%--
  Created by IntelliJ IDEA.
  User: 22751
  Date: 2023-07-14
  Time: 13:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
<%--登陆页面--%>
<form action="/login" method="post">
  用户名：<input type="text" name="name"><br>
  密码：<input type="password" name="password"><br>
  <button type="submit">登录</button>
  <button><a href="../jsp/registertest.jsp">去注册</a></button>
</form>
</body>
</html>
