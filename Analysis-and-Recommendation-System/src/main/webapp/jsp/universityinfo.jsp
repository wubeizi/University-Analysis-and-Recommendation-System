<%--
  Created by IntelliJ IDEA.
  User: 22751
  Date: 2023-07-18
  Time: 18:11
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <link href="../css/universityright.css" type="text/css" rel="stylesheet" />
</head>
<style>

    .container{
        padding: 15px;
    }
    .title{
        color: #818396;
    }
    .block{
        width: calc(100% - 30px);
        color: #818396;
        padding: 10px;
    }
    .divider{
        border: none;
        border-top: 1px solid #565865;
        margin: 20px 0;
    }
    .schoolicon{
        margin-left: 20px;
        border-radius: 100px;
        width: 70px;
        height: 70px;
    }
    .table-container {
        width: 100%;
    }
    .table-container table {
        width: 100%;
        border-collapse: collapse;
        color: #818396;
    }
    .table-container td {
        border: none;
        padding: 10px;
        text-align: left;
    }
</style>
<body>
<div style="overflow:hidden;display: flex">
  <div style="width: calc(100% - 30px)" id="infocontainer">
      <div class="container">
          <div style="width: 100%;height: 100%;">
              <h1 class="title">大学基本信息</h1>
              <hr class="divider">
              <div class="block">
                  <h2>基本信息</h2>
                  <div style="margin-top: 10px;padding: 8px;display: flex">
                      <div>
                          <img src="${school.logo}" class="schoolicon">
                      </div>
                      <div class="table-container" style="margin-left: 20px">
                          <table style="width: 100%">
                              <tr>
                                  <td><strong>学校名称：</strong></td>
                                  <td>${school.name}</td>
                                  <td><strong>学校类型:</strong></td>
                                  <td>${school.type}</td>
                              </tr>
                              <tr>
                                  <td><strong>电话：</strong></td>
                                  <td>${school.telephone}</td>
                                  <td><strong>位置：</strong></td>
                                  <td>${school.location}</td>
                              </tr>
                          </table>
                      </div>
                  </div>
                  <div>
                  </div>
              </div>
              <hr class="divider">
              <div class="block">
                  <h2>学校简介</h2>
                  <p style="line-height: 1.5;text-indent:4ch ">${school.introduction}</p>
              </div>
              <hr class="divider">
              <div class="block">
                  <h2>特色专业</h2>
                  <p style="line-height: 1.5;text-indent:4ch ">学校的特色专业有：
                      <c:forEach items="${majorlist}" var="item">
                          ${item}
                      </c:forEach>
                  </p>
              </div>
          </div>
      </div>
  </div>
  <div style="float:right;width: 30px;    position: fixed;right: 0;" id="tabs">
      <div style="width: 30px;height: 100%">

      <%--导航栏主体--%>
      <a style="text-decoration: none" href="universityinfo.jsp"><div class="vertical-text flex3 tabs" >
          <span>基本信息</span>
      </div></a>
      <a style="text-decoration: none" href="universityenroll.jsp"><div class="vertical-text flex3 tabs" style="margin-top: 0.3vh">
          <span>招生信息</span>
      </div></a>
      <a style="text-decoration: none" href="universityanalysis.jsp"><div class="vertical-text flex3 tabs" style="margin-top: 0.3vh">
          <span>对比分析</span>
      </div></a>
  </div>
  </div>
</div>

</body>
<script>
    // 获取当前页面的高度
    var pageHeight = document.documentElement.clientHeight;

    // 获取要设置高度的div元素
    var tabElement = document.getElementById("tabs");
    var infoElement = document.getElementById("infocontainer");

    // 设置初始高度
    tabElement.style.height = pageHeight+ "px";
    infoElement.style.height = pageHeight+ "px";

    // 监听窗口大小变化事件
    window.addEventListener("resize", function() {
        // 获取更新后的页面高度
        var updatedPageHeight = document.documentElement.clientHeight;

        // 更新div的高度
        tabElement.style.height = updatedPageHeight+ "px";
        infoElement.style.height = updatedPageHeight+ "px";
    });
</script>
</html>
