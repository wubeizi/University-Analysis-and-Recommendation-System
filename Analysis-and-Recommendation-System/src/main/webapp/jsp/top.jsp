<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2023/7/14
  Time: 15:18
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>智慧高校大数据</title>
    <link href="../css/top.css" type="text/css" rel="stylesheet" />
</head>
<body>
<div class="nav">
    <ul class="ul_top">
        <li><p class="top_text1">智慧高校大数据<c:if test="${isadmin}">管理端</c:if></p></li>
        <li><p class="top_text2">高校分析推荐系统</p></li>
    </ul>
</div>
</body>
</html>
