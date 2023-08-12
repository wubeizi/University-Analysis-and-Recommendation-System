<%--
  Created by IntelliJ IDEA.
  User: 22751
  Date: 2023-07-19
  Time: 9:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="../css/edit.css" type="text/css" rel="stylesheet" />
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="form-container" >
    <h1 style="color: white;margin-top: 10px;margin-bottom: 10px;margin-left: 10px" >编辑广告信息</h1>
    <% String errorMessage = (String) request.getAttribute("errorMessage"); %>
    <% if (errorMessage != null) { %>
    <div style="color:white;font-size: xx-small;display: flex;justify-content: center;">
        <span>
            <%= errorMessage %>
        </span>
    </div>
    <% } %>
    <form action="/insertad" method="post">
        <table>
            <tr>
                <th style="color: white"><label for="name">学校名称:</label></th>
                <td><input type="text" id="name" name="name" required ></td>
            </tr>
            <tr>
                <th style="color: white"><label for="title">广告标题:</label></th>
                <td><input type="text" id="title" name="title" required ></td>
            </tr>
            <tr>
                <th style="color: white"><label for="content">广告内容:</label></th>
                <td><textarea id="content" name="content" rows="4" required style="height: 300px;"></textarea></td>
            </tr>
        </table>
        <div class="center-div">
            <button type="submit" class="submit-button">提交</button>
        </div>
    </form>
</div>
</body>
</html>
