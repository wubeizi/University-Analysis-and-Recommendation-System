<%--
  Created by IntelliJ IDEA.
  User: 22751
  Date: 2023-07-18
  Time: 11:03
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>编辑用户信息</title>
    <link href="../css/edit.css" type="text/css" rel="stylesheet" />
</head>
<body>
<div class="form-container" >
    <h1 style="color: white;margin-top: 10px;margin-bottom: 10px;margin-left: 10px" >编辑用户信息</h1>
    <% String errorMessage = (String) request.getAttribute("errorMessage"); %>
    <% if (errorMessage != null) { %>
    <div style="color:white;font-size: xx-small;display: flex;justify-content: center;">
        <span>
            <%= errorMessage %>
        </span>
    </div>
    <% } %>
    <form action="/register" method="post">
        <table>
            <tr>
                <th style="color: white"><label for="username">用户昵称</label></th>
                <td><input type="text" id="username" name="username" required ></td>
            </tr>
            <tr>
                <th style="color: white"><label for="password">密码:</label></th>
                <td><input type="text" id="password" name="password"  required ></td>
            </tr>
            <input type="text" value="admin" hidden name="option">
        </table>
        <div class="center-div">
            <button type="submit" class="submit-button">提交</button>
        </div>
    </form>
</div>
</body>
</html>

