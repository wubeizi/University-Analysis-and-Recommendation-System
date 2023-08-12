<%--
  Created by IntelliJ IDEA.
  User: mashuo
  Date: 2023/7/17
  Time: 16:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改密码界面</title>
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
            var newPassword = document.getElementById("newPassword").value;
            var confirmNewPassword = document.getElementById("confirmNewPassword").value;

            if (newPassword !== confirmNewPassword) {
                alert("新密码和确认新密码不一致，请重新输入。");
                return false;
            }
            return true;
        }
    </script>
</head>
<body>
<div class="container">
    <div class="animation-container">
        <img src="../images/图片%20MO8v82f.svg" class="animated-image" style="width: 80px; height: 80px;">
    </div>
    <form action="/login" method="post" onsubmit="return validateForm();">
        <div class="form-group" style="padding: 0 10px; background-color: rgba(255, 255, 255, 0.5);">
            <img src="../images/密码.svg" style="width: 15px; height: 15px;">
            <input type="password" id="password" name="password" required placeholder="旧密码">
        </div>
        <div class="form-group" style="padding: 0 10px; background-color: rgba(255, 255, 255, 0.5);">
            <img src="../images/密码.svg" style="width: 15px; height: 15px;">
            <input type="password" id="newPassword" name="newPassword" required placeholder="新密码">
        </div>
        <div class="form-group" style="padding: 0 10px; background-color: rgba(255, 255, 255, 0.5);">
            <img src="../images/密码.svg" style="width: 15px; height: 15px;">
            <input type="password" id="confirmNewPassword" name="confirmNewPassword" required placeholder="确认新密码">
        </div>
        <div class="form-group">
            <input type="submit" value="修改密码" class="btn">
        </div>
    </form>
</div>
</body>
</html>
