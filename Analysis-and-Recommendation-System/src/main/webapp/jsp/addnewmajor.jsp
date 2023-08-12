<%--
  Created by IntelliJ IDEA.
  User: 22751
  Date: 2023-07-18
  Time: 6:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>添加专业</title>
  <link href="../css/edit.css" type="text/css" rel="stylesheet" />
</head>
<body>
<div class="form-container" >
  <h1 style="color: white;margin-top: 10px;margin-bottom: 10px;margin-left: 10px" >编辑专业</h1>
  <% String errorMessage = (String) request.getAttribute("errorMessage"); %>
  <% if (errorMessage != null) { %>
  <div style="color:white;font-size: xx-small;display: flex;justify-content: center;">
        <span>
            <%= errorMessage %>
        </span>
  </div>
  <% } %>
  <form action="/insertmajor" method="post">
    <table>
      <tr>
        <th style="color: white"><label for="major">专业名称:</label></th>
        <td><input type="text" id="major" name="major" required ></td>
      </tr>
    </table>
    <div class="center-div">
      <button type="submit" class="submit-button">提交</button>
    </div>
  </form>
</div>
</body>
</html>
