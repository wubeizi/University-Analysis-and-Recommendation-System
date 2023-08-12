<%--
  Created by IntelliJ IDEA.
  User: 22751
  Date: 2023-07-17
  Time: 15:44
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>招生信息库</title>
</head>
<style>
    *{
        margin: 0;
        padding: 0;
    }
    table {
        width: 100%;
        border-collapse: collapse;
        font-size: 16px;
        color: white;
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
        width: 80px;
    }
    .container{
        padding: 40px 40px 0  40px
    }
    button {
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
    th{
        padding: 8px;
    }
    td{
        padding: 8px;
    }
    button {
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
<body>
<div class="container">
    <button class="submit-button" style="float: right;" ><a href="/jsp/addnewenroll.jsp" style="text-decoration: none;color: white">添加</a></button>
    <div style="width:100%;">
        <table>
            <thead class="tablehead">
            <tr>
                <th style="width:150px;">学校名称</th>
                <th>省份</th>
                <th>2020分数线</th>
                <th>2021分数线</th>
                <th>2022分数线</th>
                <th>2020招生人数</th>
                <th>2021招生人数</th>
                <th>2022招生人数</th>
                <th style="width:50px;">操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${enrollList}" var="item">
                <tr class="tablebody">
                    <td>${item.name}</td>
                    <td class="emit">${item.province}</td>
                    <td class="emit">${item.score2020}</td>
                    <td class="emit">${item.score2021}</td>
                    <td class="emit">${item.score2022}</td>
                    <td class="emit">${item.enrollmentNumber2020}</td>
                    <td class="emit">${item.enrollmentNumber2021}</td>
                    <td class="emit">${item.enrollmentNumber2022}</td>
                    <td>
                        <button class="btn" style="background-color: #45a049"><a href="/getenrollinfo?name=${item.name}&province=${item.province}" style="text-decoration: none; color: white;">编辑</a></button>
                        <button class="btn" style="background-color: red"><a href="/deleteenroll?name=${item.name}&province=${item.province}" style="text-decoration: none; color: white;">删除</a></button>
                    </td>
                </tr>
            </c:forEach>

            </tbody>
        </table>
    </div>
</div>


</body>
</html>
