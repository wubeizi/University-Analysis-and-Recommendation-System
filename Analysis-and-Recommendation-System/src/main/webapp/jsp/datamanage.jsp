<%--
  Created by IntelliJ IDEA.
  User: 22751
  Date: 2023-07-17
  Time: 9:05
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>数据管理</title>
    <link rel="stylesheet" href="../css/datamanage.css">
</head>
<body>
<div id="tabs">
    <iframe name="tabs" width="100%" height="50px" src="/jsp/tabs.jsp" style="border: 0px none" ></iframe>
</div>
<div id="contents">
    <iframe name="content" width="100%" src="/jsp/manageschool.jsp" height="100%" style="border: 0px none"></iframe>
</div>

</body>
<script>

</script>
<style>
    *{           /*清除所有标签的初始内外边距*/
        padding:0;
        margin:0;
    }
</style>
<script>

    var contents = document.getElementById("contents");
    var pageHeight = document.documentElement.clientHeight;

    // 设置初始高度
    contents.style.height = pageHeight-110 + "px";

    // 监听窗口大小变化事件
    window.addEventListener("resize", function() {
        // 获取更新后的页面高度
        var updatedPageHeight = document.documentElement.clientHeight;
        // 更新div的高度
        contents.style.height = updatedPageHeight-110 + "px";
    });
</script>
</html>
