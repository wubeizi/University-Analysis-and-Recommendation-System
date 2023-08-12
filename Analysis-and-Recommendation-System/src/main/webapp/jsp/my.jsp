<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2023/7/15
  Time: 16:30
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<style>
    .submitbtn{
        background-color: #515195;
        text-decoration: none;
        width: 150px;
        height: 50px;
        border-radius: 999px;
        color: white;
        font-size: xx-small;
        font-weight: bold;
    }
</style>
<head>
    <title>个人信息</title>
    <link rel="stylesheet" href="../css/my.css">
    <style>
        *{
            padding: 0;
            margin: 0;
        }
        .container {
            padding: 40px;

        }
        .note{
            font-size: xx-small;
            color: #646975;
        }
        .paradivide{
            border: none;
            margin: 10px 0;
        }
        .divider{
            border: none;
            border-top: 1px solid #333846;
            margin: 20px 0;
        }
        .formgroup td{
            padding: 8px;
        }

        .custom-select {
            position: relative;
            display: inline-block;
            background-color: #2d2f3e;
            border-radius: 10px;
            border: 2px solid #393d4c;
            color: white;
            cursor: pointer;
            padding: 10px;
            width: 100%;
        }

        .custom-select select option {
            background-color: #2d2f3e;
            color: white;
        }

        .inputtitle{
            font-size: small;
            font-weight: bold;
            color: white;
        }
        .submit-button{
            background-color: #515195;
            color: white;
            border-radius: 100px;
            padding: 10px 20px;
            border: none;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: small;
            font-weight: bold;
            cursor: pointer;
        }
        .tablehead{
            background-color: #323d51;
            color: #5e6c7e;
            height: 20px;
            font-size: small;
        }
        .tablebody{
            background-color: #283142;

        }
        .tablegruop:hover{
            border-left: 2px solid #714146;
        }
        .resulttable td{
            padding: 10px 20px;;
        }
        .highlight{
            font-weight: bold;
        }
        .emit{
            font-size: small;
            color:#5e6c7e ;
        }
        .btn{
            border: none;
            border-radius: 5px;
            padding: 5px 10px;
            margin: 3px 0;
            color: white;
            font-weight: bold;
            width: 100%;
            text-align: center;
            vertical-align: middle;
        }
    </style>
</head>
<body>
<div class="container">
    <h1 style="color: white">修改个人信息</h1>
    <hr class="paradivide">
    <p class="note">在这里，你可以修改你的信息...</p>
    <hr class="paradivide">
    <div style="width: 100%">
        <form action="/modifyuserinfo" method="post" enctype="multipart/form-data">
            <table style="width: 100%;color: white;border-collapse: collapse;" class="formgroup">
                <tr>
                    <td colspan="2" class="inputtitle" style="width: 50%;">昵称</td>
                    <td colspan="2" class="inputtitle">生日</td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="text" value="${user.username}" required readonly class="custom-select">
                    </td>
                    <td colspan="2">
                        <input type="date" value="${user.birthday}" required class="custom-select" name="birthday">
                    </td>
                </tr>
                <tr>
                    <td class="inputtitle" style="width: 25%">密码</td>
                    <td class="inputtitle">性别</td>
                    <td class="inputtitle" style="width: 25%">头像</td>
                    <td class="inputtitle">预览</td>
                </tr>
                <tr>
                    <td>
                        <input type="text" value="${user.password}" required class="custom-select" name="password">
                    </td>
                    <td>
                        <select id="gender" name="gender" class="custom-select">
                            <c:if test="${user.sex == '男'}">
                                <option value="male" selected>男</option>
                                <option value="female">女</option>
                            </c:if>
                            <c:if test="${user.sex == '女'}">
                                <option value="male">男</option>
                                <option value="female" selected>女</option>
                            </c:if>
                        </select>
                    </td>
                    <td>
                        <input type="file" id="avatar" name="avatar" accept="image/*" onchange="previewAvatar(event)" class="custom-select" required/>
                    </td>
                    <td>
                        <img id="avatarPreview" src="${user.userimgurl}" style="width: 70px; height: 70px; border-radius: 50px">
                    </td>
                </tr>
            </table>
            <hr class="paradivide">
            <div style="text-align: right">
                <input class="submit-button" type="submit" value="提交">
            </div>
        </form>
    </div>


</div>

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
</body>
</html>