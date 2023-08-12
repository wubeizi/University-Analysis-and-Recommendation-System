<%--
  Created by IntelliJ IDEA.
  User: 22751
  Date: 2023-07-17
  Time: 15:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>tabs</title>
  <link rel="stylesheet" href="../css/datamanage.css">
</head>
<body>
<div class="tabs" style="height: 50px;padding: 0">
  <div class="tab active" onclick="showContent(1)" id="tab1"><a href="/getschoollist" target="content" style="text-decoration: none;color:white;">学校信息库</a></div>
  <div class="tab" onclick="showContent(2)" id="tab2"><a href="/geolist" target="content" style="text-decoration: none;color:white;">地理信息库</a></div>
  <div class="tab" onclick="showContent(3)" id="tab3"><a href="/enrolllist" target="content" style="text-decoration: none;color:white;">招生信息库</a></div>
  <div class="tab" onclick="showContent(4)" id="tab4"><a href="/majorlist" target="content" style="text-decoration: none;color:white;">专业信息库</a></div>
  <div class="tab" onclick="showContent(5)" id="tab5"><a href="/majorschlist" target="content" style="text-decoration: none;color:white;">专业分布库</a></div>
  <div class="tab" onclick="showContent(6)" id="tab6"><a href="/hotspotlist" target="content" style="text-decoration: none;color:white;">热词信息表</a></div>
</div>
</body>
<style>
  *{           /*清除所有标签的初始内外边距*/
    padding:0;
    margin:0;
  }
</style>
<script>
  function showContent(tabIndex) {

    var tabs = document.getElementsByClassName("tab");
    for (var i = 0; i < tabs.length; i++) {
      tabs[i].setAttribute("class","tab");
    }


    var selectedTab = document.getElementById("tab" + tabIndex);
    selectedTab.setAttribute("class","tab active");
  }
</script>
</html>
