<%--
  Created by IntelliJ IDEA.
  User: mashuo
  Date: 2023/7/15
  Time: 22:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册界面</title>
    <link rel="stylesheet" href="../css/authentication.css">
    <style>
        body {
            background-image: url('../images/数据大屏背景/bg.jpg');
            background-size: cover;
            background-repeat: no-repeat;
            height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
        }
    </style>
    <script>
        function validateForm() {
            var password = document.getElementById("password").value;
            var confirmPassword = document.getElementById("confirmPassword").value;

            if (password !== confirmPassword) {
                alert("密码和确认密码不一致，请重新输入。");
                return false;
            }
            return true;
        }
    </script>
</head>
<body>
<div class="container">
    <% String errorMessage = (String) request.getAttribute("errorMessage"); %>
    <% if (errorMessage != null) { %>
    <div class="error-message" style="color:white;font-size: xx-small;display: flex;justify-content: center;">
        <span>
            <%= errorMessage %>
        </span>
    </div>
    <% } %>
    <div class="animation-container">
        <img src="../images/图片%20MO8v82f.svg" class="animated-image" style="width: 80px; height: 80px;">
    </div>
    <form action="/register" method="post" onsubmit="return validateForm();">

        <div class="form-group" style="padding: 0 10px; background-color: rgba(255, 255, 255, 0.5);">
            <img src="../images/用户.svg" style="width: 15px; height: 15px;">
            <input type="text" id="username" name="username" required placeholder="用户名">
        </div>

        <div class="form-group" style="padding: 0 10px; background-color: rgba(255, 255, 255, 0.5);">
            <img src="../images/密码.svg" style="width: 15px; height: 15px;">
            <input type="password" id="password" name="password" required placeholder="密码">
        </div>

        <div class="form-group" style="padding: 0 10px; background-color: rgba(255, 255, 255, 0.5);">
            <img src="../images/密码.svg" style="width: 15px; height: 15px;">
            <input type="password" id="confirmPassword" name="confirmPassword" required placeholder="确认密码">
        </div>
        <input name="option" value="用户操作" hidden type="text">

        <div class="form-group">
            <input type="submit" value="注册" class="btn">
        </div>
    </form>
</div>
</body>
</html>
