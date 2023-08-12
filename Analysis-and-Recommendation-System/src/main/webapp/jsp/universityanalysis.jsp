
<%--
  Created by IntelliJ IDEA.
  User: 22751
  Date: 2023-07-18
  Time: 18:33
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>对比分析</title>
    <link href="../css/universityright.css" type="text/css" rel="stylesheet" />
    <link href="../css/universityanalysis.css" type="text/css" rel="stylesheet" />
</head>
<style>
  .container{
    padding: 15px;
  }
</style>
<body>

<div style="display: flex;" class="all">
  <script type="text/javascript" src="../js/echarts.js"></script>
  <script type="text/javascript" src="../js/echarts-wordcloud.js"></script>

<%--  词云图--%>
<div class="main">
  <div id="screen" class="center"></div>
  <script>
    let myEcharts = echarts.init(document.getElementById('screen'));
    var option  = {
      title: {
        text: "热门关注",
        left: 'center',
        textStyle: {
          color: '#FFFFFF',
          fontFamily: 'taiekaishu',
        },
      },
      backgroundColor: 'transparent',
      tooltip: {
        show: true
      },
      series: [{
        type: 'wordCloud',
        shape: 'circle',
        keepAspect: false,
        //maskImage: maskImage,
        left: 'center',
        top: 'center',
        width: '70%',
        height: '80%',
        right: null,
        bottom: null,
        size: ['100%', '100%'],
        width: '100%',
        height: '100%',
        sizeRange: [20, 50],
        autoSize: {
          enable: true,
          minSize: 20
        },
        rotationRange: [-90, 90],
        rotationStep: 45,
        gridSize: 50,
        drawOutOfBound: false,
        layoutAnimation: true,
        textStyle: {
          fontFamily: 'jixiangsongti',
          fontWeight: 'normal',
          color: function () {
            return 'rgb(' + [
              Math.round(Math.random() * 160),
              Math.round(Math.random() * 160),
              Math.round(Math.random() * 160)
            ].join(',') + ')';
          }
        },
        emphasis: {
          focus: 'self',
          textStyle: {
            textShadowBlur: 3,
            textShadowColor: '#FFFFFF'
          }
        },
        //data属性中的value值却大，权重就却大，展示字体就却大
        data: [
          <c:forEach items="${hotspotList}" var="item">
          {name: "${item.word}", value: ${item.heatRatio}},
          </c:forEach>
        ]
      }]

    };
    myEcharts.setOption(option);

    //屏幕自适应
    window.addEventListener('resize', function (){
      myEcharts.resize();
    });
  </script>

<%--  就业率图表--%>
  <div class="left1" id="left1"></div>
  <script>
    var chartDom = document.getElementById('left1');
    var myChart = echarts.init(chartDom);
    var option;

    option = {
      title: {
        text: '${school.name}就业数据',
        left: 'center',
        textStyle: {
          color: '#FFFFFF',
          fontFamily: 'taiekaishu'
        }
      },
      tooltip: {
        trigger: 'item'
      },
      legend: {
        top: 'bottom',
        left: 'center',
        color:'#fff'
      },
      series: [
        {
          // name: '四川大学就业指标',
          type: 'pie',
          radius: ['60%', '70%'],
          avoidLabelOverlap: false,
          itemStyle: {
            borderRadius: 10,
            borderColor: '#fff',
            borderWidth: 0
          },
          label: {
            show: false,
            position: 'center',
            color:'#fff'
          },
          emphasis: {
            label: {
              show: true,
              fontSize: 20,
              fontWeight: 'bold',
              color:'#fff'
            },
            itemStyle: {
              shadowBlur: 10,
              shadowOffsetX: 0,
              shadowColor: 'rgba(255, 255, 255, 0.5)'
            }
          },
          labelLine: {
            show: false
          },
          data: [
            { value: ${school.employmentRatio}, name: '就业率' ,itemStyle:{color:'#fff'}},
            { value: ${100-school.employmentRatio}, name: '未就业率' ,itemStyle:{color:'#7dc94d'}},
            // { value: 70, name: '就业率' },
            // { value: 30, name: '未就业率' }
          ]
        }
      ]
    };

    myChart.setOption(option);

    //屏幕自适应
    window.addEventListener('resize', function (){
      myEcharts.resize();
    });
  </script>

<%--  升学率图表--%>
  <div class="left2" id="left2"></div>
  <script>
    var chartDom = document.getElementById('left2');
    var myChart = echarts.init(chartDom);
    var option;

    option = {
      title: {
        text: '${school.name}升学数据',
        left: 'center',
        textStyle: {
          color: '#fff',
          fontFamily: 'taiekaishu'
        }
      },
      tooltip: {
        trigger: 'item'
      },
      legend: {
        top: 'bottom',
        left: 'center'
      },
      series: [
        {
          // name: '四川大学升学指标',
          type: 'pie',
          radius: ['60%', '70%'],
          avoidLabelOverlap: false,
          itemStyle: {
            borderRadius: 10,
            borderColor: '#fff',
            borderWidth: 0,
            // color:['#fff','#367ef1']
          },
          label: {
            show: false,
            position: 'center',
            color:'#fff'
          },
          emphasis: {
            label: {
              show: true,
              fontSize: 20,
              fontWeight: 'bold',
              color:'#fff'
            },
            itemStyle: {
              shadowBlur: 10,
              shadowOffsetX: 0,
              shadowColor: 'rgba(255, 255, 255, 0.5)'
            }
          },
          labelLine: {
            show: false
          },
          data: [
            { value: ${school.enrollmentRatio}, name: '升学率' ,itemStyle:{color:'#fff'}},
            { value: 50, name: '未升学率' ,itemStyle:{color:'#367ef1'}},
            <%--{ value: ${school.enrollmentRatio}, name: '升学率' },--%>
            <%--{ value: ${100-school.enrollmentRatio}, name: '未升学率' }--%>
          ]
        }
      ]
    };

    myChart.setOption(option);

    //屏幕自适应
    window.addEventListener('resize', function (){
      myEcharts.resize();
    });
  </script>

<%--  出国率图表--%>
  <div class="right1" id="right1"></div>
  <script>
    var chartDom = document.getElementById('right1');
    var myChart = echarts.init(chartDom);
    var option;

    option = {
      title: {
        text: '${school.name}出国数据',
        left: 'center',
        textStyle: {
          color: '#fff',
          fontFamily: 'taiekaishu'
        }
      },
      tooltip: {
        trigger: 'item'
      },
      legend: {
        top: 'bottom',
        left: 'center',
        color:'#fff'
      },
      series: [
        {
          // name: '四川大学出国指标',
          type: 'pie',
          radius: ['60%', '70%'],
          avoidLabelOverlap: false,
          itemStyle: {
            borderRadius: 10,
            borderColor: '#fff',
            borderWidth: 0
          },
          label: {
            show: false,
            position: 'center',

          },
          emphasis: {
            label: {
              show: true,
              fontSize: 20,
              fontWeight: 'bold',
              color:'#fff'
            },
            itemStyle: {
              shadowBlur: 10,
              shadowOffsetX: 0,
              shadowColor: 'rgba(255, 255, 255, 0.5)'
            }
          },
          labelLine: {
            show: false
          },
          data: [
            { value: ${school.goAbroadRatio}, name: '出国率' ,itemStyle:{color:'#fff'}},
            { value: ${100-school.goAbroadRatio}, name: '未出国率' ,itemStyle:{color:'#e7a84a'}}
            // { value: 30, name: '出国率' },
            // { value: 70, name: '未出国率' }
          ]
        }
      ]
    };

    myChart.setOption(option);

    //屏幕自适应
    window.addEventListener('resize', function (){
      myEcharts.resize();
    });
  </script>

<%--  男女比例图标--%>
  <div class="right2" id="right2"></div>
  <script>
    var chartDom = document.getElementById('right2');
    var myChart = echarts.init(chartDom);
    var option;

    option = {
      title: {
        text: '${school.name}男女比例',
        left: 'center',
        textStyle: {
          color: '#fff',
          fontFamily: 'taiekaishu'
        }
      },
      tooltip: {
        trigger: 'item'
      },
      legend: {
        top: 'bottom',
        left: 'center',
        color:'#fff'
      },
      series: [
        {
          type: 'pie',
          radius: '60%',
          itemStyle: {
            borderColor: '#fff',
            borderWidth: 0
          },
          data: [
            { value: ${school.sexRatio}, name: '男' ,itemStyle:{color:'#dc6352'}},
            { value: ${100-school.sexRatio}, name: '女' ,itemStyle:{color:'#fff'}}
            // { value: 1, name: '男' },
            // { value: 0.7, name: '女' }
          ],
          emphasis: {
            itemStyle: {
              shadowBlur: 10,
              shadowOffsetX: 0,
              shadowColor: 'rgba(255, 255, 255, 0.5)'
            }
          }
        }
      ]
    };

    myChart.setOption(option);

    //屏幕自适应
    window.addEventListener('resize', function (){
      myEcharts.resize();
    });
  </script>

</div>

  <div style="overflow:hidden;display: flex">
    <div style="width: calc(100% - 30px)" id="infocontainer">
      <div class="container">


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
</div>
<h1 style="position: fixed;top: 40px;color: white;width: 100%;text-align: center">大学对比分析</h1>
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
