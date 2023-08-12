<%--
  Created by IntelliJ IDEA.
  User: 22751
  Date: 2023-07-17
  Time: 21:35
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加地理信息</title>
  <link href="../css/edit.css" type="text/css" rel="stylesheet" />
</head>
<body>
<div class="form-container" >
  <h1 style="color: white;margin-top: 10px;margin-bottom: 10px;margin-left: 10px" >编辑地理信息</h1>
  <% String errorMessage = (String) request.getAttribute("errorMessage"); %>
  <% if (errorMessage != null) { %>
  <div style="color:white;font-size: xx-small;display: flex;justify-content: center;">
        <span>
            <%= errorMessage %>
        </span>
  </div>
  <% } %>
  <form action="/insertgeo" method="post">
    <table>
      <tr>
        <th style="color: white"><label for="name">学校名称:</label></th>
        <td><input type="text" id="name" name="name" required ></td>
      </tr>
      <tr>
        <th style="color: white"><label for="address">学校地址:</label></th>
        <td><input type="text" id="address" name="address" required ></td>
      </tr>
    </table>
    <div class="center-div">
      <button type="submit" class="submit-button">提交</button>
    </div>
  </form>
</div>
</body>
</html>
