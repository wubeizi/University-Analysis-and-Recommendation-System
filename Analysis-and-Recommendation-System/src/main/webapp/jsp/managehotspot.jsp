<%--
  Created by IntelliJ IDEA.
  User: 22751
  Date: 2023-07-17
  Time: 15:46
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>热词信息库</title>
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
</style>
<body>
<div class="container">
    <button class="submit-button" style="float: right;"><a href="/jsp/addnewhotspot.jsp" style="text-decoration: none;color: white">添加</a></button>
    <div style="width:100%;">
        <table>
            <thead class="tablehead">
            <tr>
                <th style="width:150px;">学校名称</th>
                <th>热词</th>
                <th>出现比例</th>
                <th style="width: 50px">操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${hotspotList}" var="item">
                <tr class="tablebody">
                    <td class="emit">${item.name}</td>
                    <td>${item.word}</td>
                    <td class="highlight">${item.heatRatio}</td>
                    <td>
                        <button class="btn" style="background-color: #45a049"><a href="/gethotspotinfo?name=${item.name}&word=${item.word}" style="text-decoration: none; color: white;">编辑</a></button>
                        <button class="btn" style="background-color: red"><a href="/deletehotspot?name=${item.name}&word=${item.word}" style="text-decoration: none; color: white;">删除</a></button>
                    </td>
                </tr>
            </c:forEach>

            </tbody>
        </table>
    </div>
</div>

</body>
</html>
