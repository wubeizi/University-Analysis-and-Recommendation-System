<%--
  Created by IntelliJ IDEA.
  User: 22751
  Date: 2023-07-18
  Time: 14:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>忘记密码</title>
</head>
<body>
<%--
  Created by IntelliJ IDEA.
  User: mashuo
  Date: 2023/7/15
  Time: 23:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>找回密码界面</title>
  <link rel="stylesheet" href="../css/authentication.css">
  <style>
    body {
      background-image: url('../images/数据大屏背景/bg.jpg'); /* 设置背景图片 */
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

  <% String password = (String) request.getAttribute("password"); %>
  <% if (password != null) { %>
  <div style="color:white;font-size: xx-small;display: flex;justify-content: center;">
        <span>
            你的密码为：<%= password %>
        </span>
  </div>
  <% } %>

  <div class="animation-container">
    <img src="../images/图片%20MO8v82f.svg" class="animated-image">
  </div>

  <form action="/getpassword" method="post">

    <div class="form-group" style="padding: 0 10px; background-color: rgba(255, 255, 255, 0.5);">
      <img src="../images/用户.svg" style="width: 15px; height: 15px;">
      <input type="text" id="username" name="username" required placeholder="用户名">
    </div>

    <div class="form-group" style="padding: 0 10px; background-color: rgba(255, 255, 255, 0.5);">
      <img src="../images/生日.svg" style="width: 15px; height: 15px;">
      <input type="text" id="birthday" name="birthday" required placeholder="生日">
    </div>

    <div class="form-group" style="padding: 0 10px; background-color: rgba(255, 255, 255, 0.5);">
      <img src="../images/性别.svg" style="width: 15px; height: 15px;">
      <select id="sex" name="sex" required style="padding: 6px; width: 100%; height: 100%; background-color: rgba(255, 255, 255, 0); color: white; font-size: 0.8em; border: none; border-radius: 20px; outline: none;">
        <option value="" disabled selected style="color: black;">选择性别</option>
        <option value="male" style="color: #bfbfbf;">男</option>
        <option value="female" style="color: #bfbfbf;">女</option>
      </select>
    </div>

    <div class="form-group">
      <input type="submit" value="找回密码" class="btn">
    </div>
  </form>
  <div class="form-group" style="margin-top: 8px;">
    <button class="btn" style="background-color: #45a049">
      <a href="/jsp/login.jsp" style="text-decoration: none; color: white">返回登录</a>
    </button>
  </div>
</div>

<!-- 引入jQuery和jQuery UI库 -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://code.jquery.com/ui/1.13.1/jquery-ui.min.js"></script>

<!-- 引入jQuery UI CSS（用于样式） -->
<link rel="stylesheet" href="https://code.jquery.com/ui/1.13.1/themes/smoothness/jquery-ui.css">

<script>
  $(document).ready(function () {//文档就绪
    // 初始化日期选择框
    $('#birthday').datepicker({
      dateFormat: 'yy-mm-dd',
      maxDate: '0',
      changeYear: true,
      changeMonth: true,
      language: 'zh-CN' // 设置语言为中文，确保正确的语言文件被加载
    });
  });
</script>

</body>
</html>
</body>
</html>
