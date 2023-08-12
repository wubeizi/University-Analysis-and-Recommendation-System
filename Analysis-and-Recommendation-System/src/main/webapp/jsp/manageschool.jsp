<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 22751
  Date: 2023-07-17
  Time: 15:43
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学校信息库</title>
    <link rel="stylesheet" href="../css/manages.css">
</head>
<style>
    *{
        margin: 0;
        padding: 0;
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
    .highlight{
        font-weight: bold;
    }
    .emit{
        font-size: small;
        color:#5e6c7e ;
    }
    .note{
        font-size: xx-small;
        color: #646975;
    }
    .paradivide{
        border: none;
        margin: 10px 0;
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
    .container{
        padding: 40px 40px 0  40px
    }
    th{
        padding: 8px;
    }
    td{
        padding: 8px;
    }
</style>
<body>
<div class="container">
    <button class="submit-button" style=" width: 80px;
    float: right;">
        <a href="/jsp/addnewschool.jsp" style="text-decoration: none;color: white">添加</a>
    </button>
    <hr class="paradivide">
    <div style="width: 100%;">
        <table style="width: 100%;border: none">
            <tr class="tablehead">
                <th>学校名称</th>
                <th>学校级别</th>
                <th>学校类型</th>
                <th>搜索热度</th>
                <th>联系电话</th>
                <th>简介</th>
                <th>就业率</th>
                <th>出国率</th>
                <th>升学率</th>
                <th>男女比例</th>
                <th>所在地</th>
                <th>图标</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${schoolList}" var="schoolItem">
                <tr class="tablebody">
                    <td>${schoolItem.name}</td>
                    <td>${schoolItem.rank}</td>
                    <td>${schoolItem.type}</td>
                    <td>${schoolItem.heat}</td>
                    <td>${schoolItem.telephone}</td>
                    <td class="note">${schoolItem.introduction}</td>
                    <td>${schoolItem.employmentRatio}</td>
                    <td>${schoolItem.goAbroadRatio}</td>
                    <td>${schoolItem.enrollmentRatio}</td>
                    <td>${schoolItem.sexRatio}</td>
                    <td>${schoolItem.location}</td>
                    <td><img src="${schoolItem.logo}" width="40px" height="40px"></td>
                    <td>
                        <button class="btn" style="background-color: #45a049"><a href="/editschool?name=${schoolItem.name}" style="text-decoration: none; color: white;">编辑</a></button>
                        <button class="btn" style="background-color: red"><a href="/deleteschool?name=${schoolItem.name}" style="text-decoration: none; color: white;">删除</a></button>
                    </td>
                </tr>
            </c:forEach>

        </table>
    </div>
</div>
</body>
</html>
