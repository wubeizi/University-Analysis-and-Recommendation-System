<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 22751
  Date: 2023-07-19
  Time: 11:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<style>
    *{
        margin: 0;
        padding: 0;
    }
    .container{
        padding: 40px 40px 0  40px
    }
    .paradivide{
        border: none;
        margin: 10px 0;
    }
    .note{
        font-size: xx-small;
        color: #646975;
    }
    table{
        color: white;
        width: 100%;
        border-collapse: collapse;
    }
    td{
        padding: 10px 20px;
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
    .tablebody:hover{
        border-left: 2px solid #714146;
    }
    .emit{
        font-size: small;
        color:#5e6c7e ;
    }
</style>
<body>
<div class="container">
    <h1 style="color: white">已处理用户反馈</h1>
    <hr class="paradivide">
    <p class="note">此处查看所有已解决的用户反馈</p>
    <hr class="paradivide">
    <div style="width: 100%">
        <table>
            <tr class="tablehead">
                <td style="width: 40px"><img src="../images/菜单.svg" width="30px" height="30px"></td>
                <td>用户昵称</td>
                <td >反馈内容</td>
                <td >处理方式</td>
            </tr>
            <c:forEach items="${solvedList}" var="item">
                <tr class="tablebody">
                    <td><img src="../images/反馈.svg" width="30px" height="30px"></td>
                    <td>${item.username}</td>
                    <td class="emit">${item.feedback}</td>
                    <td class="emit">${item.method}</td>
                </tr>
            </c:forEach>
        </table>
    </div>

</div>
</body>
</html>
