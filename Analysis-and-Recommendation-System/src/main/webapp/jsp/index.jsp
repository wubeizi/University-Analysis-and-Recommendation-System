<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>智慧高校大数据</title>
</head>
<body style="background-color: #232736;">

<div>
  <iframe name="topFrame" src="/jsp/top.jsp" borders="NO" width=100% height="110px" style="border: 1px none;"></iframe>
</div>
<div style="overflow:hidden;">
<div style="float: left; width: 175px; height: calc(100% - 110px)" id="leftframe">
  <iframe name="leftFrame" src="/jsp/left.jsp" onresize borders="NO" height=100% style="border: 1px none;"></iframe>
</div>
<div style="float: left; width: calc(100% - 175px)" id="mainframe">
  <iframe name="mainFrame" src="/jsp/main.jsp" onresize borders="NO" width=100% height="100%" style="border: 1px none;"></iframe>
</div>
  <div class="logout" style="position: fixed;bottom: 20px;left: 20px">
    <a href="/logout" style="text-decoration: none;color: white" target="">登出</a>
  </div>
</div>


</body>

<style>
  *{           /*清除所有标签的初始内外边距*/
    padding:0;
    margin:0;
  }
</style>

<script>
  // 获取当前页面的高度
  var pageHeight = document.documentElement.clientHeight;

  // 获取要设置高度的div元素
  var divElement = document.getElementById("leftframe");
  var mainElement = document.getElementById("mainframe")

  // 设置初始高度
  divElement.style.height = pageHeight-110 + "px";
  mainElement.style.height = pageHeight-110 + "px";

  // 监听窗口大小变化事件
  window.addEventListener("resize", function() {
    // 获取更新后的页面高度
    var updatedPageHeight = document.documentElement.clientHeight;

    // 更新div的高度
    divElement.style.height = updatedPageHeight-110 + "px";
    mainElement.style.height = updatedPageHeight-110 + "px";
  });

</script>

</html>