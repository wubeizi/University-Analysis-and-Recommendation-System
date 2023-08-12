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
</head>
<body>
<div class="form-container" >
    <h1 style="color: white;margin-top: 10px;margin-bottom: 10px;margin-left: 10px" >编辑用户信息</h1>
    <form action="/updateuser" method="post">
        <table>
            <tr>
                <th style="color: white"><label for="username">用户昵称</label></th>
                <td><input type="text" id="username" name="username" required value="${userInfo.name}" readonly></td>
            </tr>
            <tr>
                <th style="color: white"><label for="password">密码:</label></th>
                <td><input type="text" id="password" name="password"  required value="${userInfo.rank}" ></td>
            </tr>
            <tr>
                <th style="color: white"><label for="birthday">生日:</label></th>
                <td><input type="date" id="birthday" name="birthday"  required value="${userInfo.birthday}" ></td>
            </tr>
            <tr>
                <th style="color: white"><label for="sex">性别:</label></th>
                <td><input type="text" id="sex" name="sex"  required value="${userInfo.sex}" ></td>
            </tr>
        </table>
        <div class="center-div">
            <button type="submit" class="submit-button">提交</button>
        </div>
    </form>
</div>
</body>
<script>
    function previewAvatar(event) {
        var input = event.target;
        if (input.files && input.files[0]) {
            var reader = new FileReader();
            reader.onload = function (e) {
                document.getElementById("avatarPreview").src = e.target.result;
            };
            reader.readAsDataURL(input.files[0]);
        }
    }
</script>
</html>
