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
    <title>智慧高校大数据</title>
    <link href="../css/left.css" type="text/css" rel="stylesheet" />
</head>
<body>
<!-- 导航栏主体 -->
<div class="left-menu">
    <!-- 顶部标题 -->
<!--    <div>导航栏</div>-->
    <!-- 链接 -->
    <a href="main.jsp" target="mainFrame">
        <div class="menu-no-child menu-item">
            <img class="image" src="https://i.postimg.cc/xTkFKdwn/choose.png" width="15px" height="15px">
            首页
        </div>
    </a>

    <!--用户登录显示的左侧导航栏-->
    <c:if test="${!isadmin}">
        <div class="menu-item-hasChild menu-item">
            <img class="image" src="https://i.postimg.cc/CK0PTszx/edu.png" width="15px" height="15px">
            选择大学
            <span class="icon">></span>
        </div>
        <div class="menu-first-items" id="parentDiv">
            <ul>
                <li>
                    <label>
                        关键字:
                        <input type="search" name="keyword" id="keyword">
                    </label>
                    <br>
                    <button onclick="searchByName()">搜索</button>
                    <div id="searchResultContainer"></div>

                </li>
                <li>
                    <div class="li-text li-underline" onclick="display985()">985大学</div>
                </li>


                <!--此处显示985大学列表-->
                <div style="display: none" id="list985">
                    <c:forEach items="${list985}" var="item985">
                        <div id="${item985}" >
                            <a href="/getschoolInfo?name=${item985}" target="mainFrame">${item985}</a>
                        </div>
                    </c:forEach>
                </div>

                <li>
                    <div class="li-text li-underline" onclick="display211()">211大学</div>
                </li>
                <!--此处显示211大学列表-->
                <div style="display: none" id="list211">
                    <c:forEach items="${list211}" var="item211">
                        <div id="${item211}" href="#">
                            <a href="/getschoolInfo?name=${item211}" target="mainFrame">${item211}</a>
                        </div>

                    </c:forEach>
                </div>

            </ul>
        </div>

        <a href="location.jsp" target="mainFrame">
            <div class="menu-no-child menu-item">
                <img class="image" src="https://i.postimg.cc/QtxfVNgL/location.png" width="15px" height="15px">
                地理位置
            </div>
        </a>

        <a href="education.jsp" target="mainFrame">
            <div class="menu-no-child menu-item">
                <img class="image" src="https://i.postimg.cc/SQ1v29tg/alarm.png" width="15px" height="15px">
                志愿填报
            </div>
        </a>

        <a href="my.jsp" target="mainFrame">
            <div class="menu-no-child menu-item">
                <img class="image" src="https://i.postimg.cc/VNF7Y0CB/photo.png" width="15px" height="15px">
                个人信息
            </div>
        </a>
    </c:if>

    <!--管理员登录显示的左侧导航栏-->
    <c:if test="${isadmin}">
        <a href="/userlist" target="mainFrame">
            <div class="menu-no-child menu-item">
                <img class="image" src="https://i.postimg.cc/VNF7Y0CB/photo.png" width="15px" height="15px">
                用户管理
            </div>
        </a>
        <div class="menu-item-hasChild menu-item" >
            <img class="image" src="../images/反馈.svg" width="15px" height="15px">
            用户反馈
            <span class="icon">></span>
        </div>
        <div class="menu-first-items" id="feedback">
            <ul>
                <li>
                    <a href="/unsolvedlist" target="mainFrame">

                        <div class="li-text li-underline">未处理</div>
                    </a>
                </li>

                <li>
                    <a href="/solvedlist" target="mainFrame">
                        <div class="li-text li-underline">已处理</div>
                    </a>
                </li>
            </ul>
        </div>

        <a href="/jsp/datamanage.jsp" target="mainFrame">
            <div class="menu-no-child menu-item">
                <img class="image" src="https://i.postimg.cc/bwffzDFt/image.png" width="15px" height="15px">
                数据管理
            </div>
        </a>

    </c:if>


</div>

<script>
    let menuItems = document.getElementsByClassName("menu-item-hasChild");
    let items = document.getElementsByClassName("menu-first-items");
    let noChildItem = document.getElementsByClassName('menu-no-child');
    let icons = document.getElementsByClassName("icon");
    var showlist985 = false;
    var showlist211 = false;

    var searchresult=[];

    /** 记录当前打开的一级菜单是哪个 没有打开任何菜单的状态 默认为-1 */
    let currentDisplayIndex = -1;

    noChildItem[0].classList.toggle('bg-color');

    for (let i = 0; i < menuItems.length; i++) {
        menuItems[i].onclick = function () {
            /** 再次点击已打开的菜单，关闭此菜单 */
            if (currentDisplayIndex === i) {
                items[currentDisplayIndex].classList.toggle("ul-active");
                // items[currentDisplayIndex].setAttribute("style","height=0;");
                icons[currentDisplayIndex].classList.toggle("reverse-icon");
                menuItems[currentDisplayIndex].classList.toggle('bg-color');
                currentDisplayIndex = -1
                return;
            }

            /** 关闭前一个被打开的菜单 打开当前要打开的菜单 */
            if (currentDisplayIndex != -1) {
                items[currentDisplayIndex].classList.toggle("ul-active");
                // items[currentDisplayIndex].setAttribute("style","height=0;");
                icons[currentDisplayIndex].classList.toggle("reverse-icon");
                menuItems[currentDisplayIndex].classList.toggle('bg-color');

                items[i].classList.toggle("ul-active");
                // items[i].setAttribute("style","height=0;");
                icons[i].classList.toggle("reverse-icon");
                menuItems[i].classList.toggle('bg-color');
            }
            /** 没有任何菜单被打开时 打开新菜单 */
            else{
                items[i].classList.toggle("ul-active");
                // items[i].setAttribute("style","height=0;");
                icons[i].classList.toggle("reverse-icon");
                menuItems[i].classList.toggle('bg-color');
            }

            // 清除没有下一级列表的菜单的背景
            if(currentDisplayIndex === -1){
                for(let e of noChildItem){
                    if(e.classList.contains('bg-color')){
                        e.classList.toggle('bg-color');
                    }
                }
            }

            currentDisplayIndex = i;
        };
    }

    // 当没有子菜单的菜单被点击
    for(let e of noChildItem){
        e.addEventListener('click',()=>{
            // 处理非同类菜单
            for(let i = 0 ; i < items.length ; i ++){
                if(items[i].classList.contains('ul-active')){
                    items[i].classList.toggle('ul-active');
                    icons[i].classList.toggle('reverse-icon');
                    menuItems[i].classList.toggle('bg-color');
                }
            }
            // 去除其他同类子菜单的背景色
            for(let i = 0 ; i < noChildItem.length ; i ++){
                if(noChildItem[i].classList.contains('bg-color')){
                    noChildItem[i].classList.toggle('bg-color');
                }
            }
            // 为自己添加背景色
            e.classList.toggle('bg-color');
            currentDisplayIndex = -1;
        })
    }

    // 导航栏的显现与隐藏
    // let OC = document.getElementsByClassName("open-close")[0];
    // let menu = document.getElementsByClassName("left-menu")[0];
    // OC.onclick = function () {
    //     OC.classList.toggle("reverse-condition");
    //     menu.classList.toggle("hide-menu");
    // };

    function searchByName(){
        var keyworddom = document.getElementById("keyword");
        var keyword = keyworddom.value;
        if(keyword==null||keyword==""){
            var container = document.getElementById("searchResultContainer");
            // 清空searchResultContainer的子标签
            container.innerHTML = "";
            calcParentDivHeight("parentDiv");
            return;
        }
        //一定要这样加才可以
        var url = '/searchBySchoolName?keyword=' + encodeURIComponent(keyword);

        fetch(url).then(function response(response){
            return response.text();
        }).then(function (data){
            // console.log(data);
            searchresult=JSON.parse(data)
            //显示搜索结果
            var container = document.getElementById("searchResultContainer");
            // 清空searchResultContainer的子标签
            container.innerHTML = "";
            for (var i = 0; i < searchresult.length; i++) {
                var item = searchresult[i];
                var a = document.createElement("a");
                var div = document.createElement("div");
                a.textContent = item;
                //div的name属性为大学的名字
                a.setAttribute("href","/getschoolInfo?name="+item)
                a.setAttribute("target","mainFrame")
                div.appendChild(a);
                container.appendChild(div);
            }
            calcParentDivHeight("parentDiv");
        })
    }

    //获取总高度
    function calcParentDivHeight(id) {
        var parentDiv = document.getElementById(id);
        var totalHeight = 0;

        // 计算父级<div>的总高度
        for (var i = 0; i < parentDiv.children.length; i++) {
            totalHeight += parentDiv.children[i].offsetHeight;
        }

        // 设置父级<div>的高度
        // console.log(totalHeight);
        if (totalHeight>=450){
            totalHeight=450;
        }
        var stylesheet = document.styleSheets[0]
        var rule = stylesheet.cssRules[17]
        rule.style.height = totalHeight+"px"
        // parentDiv.style.height = totalHeight + "px";
    }

    function display985(){

        showlist985=!showlist985;
        showlist211=false;
        var dom985 = document.getElementById("list985");
        var dom211 = document.getElementById("list211");
        if(showlist985){
            dom985.style.display = "block";
            dom211.style.display = "none";
        }else {
            dom985.style.display = "none";
            dom211.style.display = "none";

        }
        calcParentDivHeight("parentDiv");

    }

    function display211(){

        showlist211=!showlist211;
        showlist985=false;
        var dom985 = document.getElementById("list985");
        var dom211 = document.getElementById("list211");
        if(showlist211){
            dom211.style.display = "block";
            dom985.style.display = "none";
        }else {
            dom985.style.display = "none";
            dom211.style.display = "none";
        }
        calcParentDivHeight("parentDiv");
    }


</script>

</body>
</html>
