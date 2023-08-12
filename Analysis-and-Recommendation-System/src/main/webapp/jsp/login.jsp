<%--
  Created by IntelliJ IDEA.
  User: mashuo
  Date: 2023/7/14
  Time: 14:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录界面</title> <!-- 设置页面标题为"登录界面" -->
    <link rel="stylesheet" href="../css/authentication.css">
    <style>
        body {
        background-image: url('../images/bg.jpg'); /* 设置背景图片 */
        background-size: cover; /* 背景图片大小自适应屏幕 */
        background-repeat: no-repeat; /* 背景图片不重复 */
        height: 100vh; /* 设置body高度为屏幕高度 */
        display: flex; /* 使用弹性布局 */
        align-items: center; /* 垂直居中对齐 */
        justify-content: center; /* 水平居中对齐 */
    }
    </style>
</head>
<body>
<div class="container">
    <div class="animation-container">
        <img src="../images/图片%20MO8v82f.svg" class="animated-image" style="width: 80px; height: 80px;">
    </div>
    <form action="/login" method="post">

        <div class="form-group" style="padding: 0 10px; background-color: rgba(255, 255, 255, 0.5);">
            <img src="../images/用户.svg" style="width: 15px; height: 15px;">
            <input type="text" id="username" name="name" required placeholder="用户名">
        </div>

        <div class="form-group" style="padding: 0 10px; background-color: rgba(255, 255, 255, 0.5);">
            <img src="../images/密码.svg" style="width: 15px; height: 15px;">
            <input type="password" id="password" name="password" required placeholder="密码">
        </div>

        <div class="form-group">
            <input type="submit" value="登录" class="btn">
        </div>

        <div class="help-links">
<%--            <div style="width: 40px">--%>
<%--                <input type="checkbox" id="isAdminister" name="role" value="admin">--%>
<%--                <!--<span id="isAdministerSlider" class="toggle-slider"></span>-->--%>
<%--                <span id="isAdministerSlider" class="toggle-slider"></span>--%>
<%--            </div>--%>
            <div class="toggle-switch" style="width: 40px">
                <input type="checkbox" id="isAdminister" name="role" value="admin">
                <span id="isAdministerSlider" class="toggle-slider"></span>
            </div>
            <label style="display: flex; align-items: flex-start; margin-left: 0px;">管理员</label>

            <div class="toggle-switch" style="width: 40px">
                <input type="checkbox" id="remember" name="remember">
                <span id="rememberSlider" class="toggle-slider"></span>
            </div>
            <label style="display: flex; align-items: flex-start; margin-left: 0px;">记住密码</label>
        </div>
        <div class="help-links">
            <a href="../jsp/forgotpassword.jsp" style="color: white; text-decoration: none;">忘记密码</a>
            <a href="../jsp/register.jsp" style="color: white; text-decoration: none;">注册账号</a>
        </div>
    </form>
</div>
<script>
    //必须放在body最后 不能在head中就执行
    const isAdministerSlider = document.getElementById('isAdministerSlider');//滑块点
    const isAdministerCheckbox = document.getElementById('isAdminister');//隐藏的复选框

    isAdministerSlider.addEventListener('click', function() {
        isAdministerSlider.checked = !isAdministerSlider.checked;
        isAdministerCheckbox.checked = !isAdministerCheckbox.checked;
    });

    const rememberSlider = document.getElementById('rememberSlider');
    const rememberCheckbox = document.getElementById('remember');

    rememberSlider.addEventListener('click', function() {
        rememberSlider.checked=!rememberSlider.checked;
        rememberCheckbox.checked = !rememberCheckbox.checked;
    });
</script>
</body>
</html>
