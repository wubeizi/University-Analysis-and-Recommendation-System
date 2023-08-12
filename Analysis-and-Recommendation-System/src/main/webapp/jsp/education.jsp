
<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2023/7/16
  Time: 13:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>选择大学</title>
    <link href="../css/education.css" type="text/css" rel="stylesheet" />
</head>
<style>
    *{
        padding: 0;
        margin: 0;
    }
    .container {
        padding: 40px;

    }
    .note{
        font-size: xx-small;
        color: #646975;
    }
    .paradivide{
        border: none;
        margin: 10px 0;
    }
    .divider{
        border: none;
        border-top: 1px solid #333846;
        margin: 20px 0;
    }
    .formgroup td{
        padding: 8px;
    }

    .custom-select {
        position: relative;
        display: inline-block;
        background-color: #2d2f3e;
        border-radius: 10px;
        border: 2px solid #393d4c;
        color: white;
        cursor: pointer;
        padding: 10px;
        width: 100%;
    }

    .custom-select select option {
        background-color: #2d2f3e;
        color: white;
    }

    .inputtitle{
        font-size: small;
        font-weight: bold;
        color: white;
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
    .tablehead{
        background-color: #323d51;
        color: #5e6c7e;
        height: 20px;
        font-size: small;
    }
    .tablebody{
        background-color: #283142;

    }
    .tablegruop:hover{
        border-left: 2px solid #714146;
    }
    .resulttable td{
        padding: 10px 20px;;
    }
    .highlight{
        font-weight: bold;
    }
    .emit{
        font-size: small;
        color:#5e6c7e ;
    }
    .btn{
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
    <h1 style="color: white">筛选大学</h1>
    <hr class="paradivide">
    <p class="note">根据你的选择为你智能推荐大学</p>
    <hr class="paradivide">
    <div style="width: 100%">
        <form action="/getschollform" method="post">
            <table style="width: 100%;border-collapse: collapse;" class="formgroup">
                <tr>
                    <td class="inputtitle">就读地区</td>
                    <td class="inputtitle">大学类型</td>
                    <td class="inputtitle">高考分数</td>
                </tr>
                <tr style="height: 40px">
                    <td>
                        <div style="width: 100%;">
                            <select class="custom-select" name="province">
                                <option value="北京">北京</option>
                                <option value="天津">天津</option>
                                <option value="上海">上海</option>
                                <option value="重庆">重庆</option>
                                <option value="河北">河北</option>
                                <option value="山西">山西</option>
                                <option value="辽宁">辽宁</option>
                                <option value="吉林">吉林</option>
                                <option value="黑龙江">黑龙江</option>
                                <option value="四川">四川</option>
                                <option value="江苏">江苏</option>
                                <option value="浙江">浙江</option>
                                <option value="安徽">安徽</option>
                                <option value="福建">福建</option>
                                <option value="江西">江西</option>
                                <option value="山东">山东</option>
                                <option value="河南">河南</option>
                                <option value="湖北">湖北</option>
                                <option value="湖南">湖南</option>
                                <option value="广东">广东</option>
                                <option value="广西">广西</option>
                                <option value="海南">海南</option>
                                <option value="贵州">贵州</option>
                                <option value="云南">云南</option>
                                <option value="陕西">陕西</option>
                                <option value="甘肃">甘肃</option>
                                <option value="青海">青海</option>
                                <option value="内蒙古">内蒙古</option>
                                <option value="西藏">西藏</option>
                                <option value="宁夏">宁夏</option>
                                <option value="新疆">新疆</option>
                            </select>
                        </div>
                    </td>
                    <td>
                        <div style="width: 100%;">
                            <select class="custom-select" name="type">
                                <option value="all">全部</option>
                                <option value="综合类">综合类</option>
                                <option value="语言类">语言类</option>
                                <option value="财经类">财经类</option>
                                <option value="农林类">农林类</option>
                                <option value="理工类">理工类</option>
                                <option value="师范类">师范类</option>
                                <option value="军事类">军事类</option>
                                <option value="政法类">政法类</option>
                                <option value="医药类">医药类</option>
                                <option value="民族类">民族类</option>
                                <option value="艺术类">艺术类</option>
                                <option value="体育类">体育类</option>
                            </select>
                        </div>
                    </td>
                    <td>
                        <div style="width: 100%">
                            <input type="number" name="score" class="custom-select" value="600">
                        </div>
                    </td>
                </tr>
            </table>
            <hr class="paradivide">
            <div style="text-align: right">
                <input class="submit-button" type="submit" value="提交">
            </div>
        </form>
    </div>
    <hr class="divider">
    <% String errorMessage = (String) request.getAttribute("errorMessage"); %>
    <% if (errorMessage != null) { %>
    <div style="color:white;font-size: xx-small;display: flex;justify-content: center;">
        <span>
            <%= errorMessage %>
        </span>
    </div>
    <% } %>
    <div>
        <table style="width: 100%;color: white;padding: 8px;border-spacing: 0;border: none" class="resulttable">

            <tr class="tablehead" >
                <td style="width: 210px" colspan="3">招生学校</td>
                <td>历年</td>
                <td>2022</td>
                <td>2021</td>
                <td>2020</td>
                <td>操作</td>
            </tr>

            <c:forEach items="${applicationitem}" var="item">
                <div class="tablegruop">
                    <tr class="tablebody">
                        <td rowspan="2">
                            <img src="${item.logo}" height="70px" width="70px" style="border-radius: 999px">
                        </td>
                        <td colspan="2" class="highlight">${item.name}</td>
                        <td class="emit">分数线</td>
                        <td>${item.score2022}</td>
                        <td>${item.score2021}</td>
                        <td>${item.score2020}</td>
                        <td rowspan="2">
                            <a href="/getschoolInfo?name=${item.name}"><button class="btn" style="background-color: #515195">查看学校</button></a>
                        </td>
                    </tr>
                    <tr class="tablebody">
                        <td class="emit">${item.type}</td>
                        <td class="emit">${item.location}</td>
                        <td class="emit">招生人数</td>
                        <td>${item.enrollmentNumber2022}</td>
                        <td>${item.enrollmentNumber2021}</td>
                        <td>${item.enrollmentNumber2020}</td>
                    </tr>
                </div>
            </c:forEach>

        </table>
    </div>
</div>



</body>
</html>
