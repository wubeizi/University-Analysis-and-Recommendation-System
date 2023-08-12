<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2023/7/15
  Time: 9:50
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
    <link href="../css/main.css" type="text/css" rel="stylesheet" />
</head>
<style>
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
    .emit{
        font-size: small;
        color:#5e6c7e ;
    }
</style>
<body>
<div style="color:white;padding: 40px">
    <h1>广告</h1>
    <hr class="paradivide">
    <p class="note">在这里，你可以查阅不同学校的广告...</p>
    <hr class="paradivide">
    <c:if test="${isadmin}">
        <div style="text-align: right">
            <a href="/jsp/addnewad.jsp"><input class="submit-button" style="width: 80px" value="添加"></a>
        </div>
    </c:if>
    <div style="width: 100%">
        <!--<div class="search-container" style="width: 170px;float: right;">
            <input type="search" name="keyword" id="keyword" class="search-input">
            <button onclick="searchByName()" class="searchbtn">搜索</button>
        </div>-->
    <table style="margin-top: 20px">
        <tr class="tablehead">
            <th class="school-col">学校</th>
            <th class="title-col">标题</th>
            <th class="content-col">内容</th>
            <th class="action-col">操作</th>
        </tr>
        <c:forEach items="${advertisementList}" var="aditem">
            <tr class="tablebody">
                <td class="school-col">${aditem.name}</td>
                <td class="title-col highlight">${aditem.title}</td>
                <td class="content-col emit">${aditem.contenttext}</td>
                <td class="action-col">
                    <c:if test="${isadmin}">
                        <button class="edit-button"><a href="/getadinfo?title=${aditem.title}" style="text-decoration: none; color: white;">编辑</a></button>
                        <button class="delete-button"><a href="/deleteadinfo?title=${aditem.title}&name=${aditem.name}" style="text-decoration: none; color: white;">删除</a></button>
                    </c:if>
                    <c:if test="${!isadmin}">
                        <p class="emit">无权限操作！</p>
                    </c:if>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</div>
</body>
<script>

</script>
</html>
