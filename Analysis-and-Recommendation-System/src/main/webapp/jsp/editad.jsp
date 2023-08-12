<%--
  Created by IntelliJ IDEA.
  User: 22751
  Date: 2023-07-17
  Time: 10:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>编辑广告</title>
    <link href="../css/edit.css" type="text/css" rel="stylesheet" />
</head>
<body>
<div class="form-container" >
    <h1 style="color: white;margin-top: 10px;margin-bottom: 10px;margin-left: 10px" >编辑广告</h1>
    <form action="/updatead" method="post">
        <table>
            <tr>
                <th style="color: white"><label for="title">标题:</label></th>
                <td><input type="text" id="title" name="title" required value="${advertisement.title}" readonly></td>
            </tr>
            <tr>
                <th style="color: white"><label for="school">学校名称:</label></th>
                <td><input type="text" id="school" name="school" required value="${advertisement.name}" readonly></td>
            </tr>
            <tr>
                <th style="color: white"><label for="content">广告内容:</label></th>
                <td><textarea id="content" name="content" rows="4" required style="height: 300px;">${advertisement.contenttext}</textarea></td>
            </tr>
        </table>
        <div class="center-div">
            <button type="submit" class="submit-button">提交</button>
        </div>
    </form>
</div>
</body>
</html>
