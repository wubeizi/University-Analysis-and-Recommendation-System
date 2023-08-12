<%@ page import="java.util.Random" %><%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2023/7/18
  Time: 19:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>招生信息</title>
    <link href="../css/universityenroll.css" type="text/css" rel="stylesheet" />
    <link href="../css/universityright.css" type="text/css" rel="stylesheet" />
</head>
<style>
    .container{
        padding: 15px;
    }
</style>
<body>
<div style="overflow: hidden;display: flex">
    <div style="width: calc(100% - 30px)" id="infocontainer">
        <div class="container">
            <div id="screen" class="main"></div>

            <div class="left" id="left" style="display: none">
                <%--近三年招生人数--%>
                <%--    <div class="text">四川大学</div>--%>
                <div class="left1" id="left1"></div>
                <%--近三年分数线--%>
                <div class="left2" id="left2"></div>
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


<script type="text/javascript" src="../js/echarts.js"></script>
<script type="text/javascript" src="../js/echarts.min.js"></script>
<script type="text/javascript" src="https://api.map.baidu.com/api?v=3.0&ak=htxr8lFN7V7U0MajYdkHeeoYMVLngh6N"></script>
<script src="../js/bmap.js"></script>
<script src="../js/china.js"></script>
<script src="../js/jquery-3.2.1.min.js"></script>

<script>
    let myEcharts = echarts.init(document.getElementById('screen'));
    var outData = [
        // {name: '四川', value: '2', name985: '四川大学、电子科技大学', value211: '4', name211: '四川大学、电子科技大学、西南财经大学、四川农业大学'},
        // {name: '安徽', value: '1', name985: '中国科学技术大学', value211: '3', name211: '中国科学技术大学、合肥工业大学、安徽大学'},
        // {name: '福建', value: '1', name985: '厦门大学', value211: '2', name211: '厦门大学、福州大学'},
        // {name: '甘肃', value: '1', name985: '兰州大学', value211: '1', name211: '兰州大学'},
        // {name: '广东', value: '2', name985: '中山大学、华南理工大学', value211: '4', name211: '中山大学、华南理工大学、暨南大学、华南师范大学'},
        // {name: '广西', value: '0', name985: '无', value211: '1', name211: '广西大学'},
        // {name: '贵州', value: '0', name985: '无', value211: '1', name211: '贵州大学'},
        // {name: '海南', value: '0', name985: '无', value211: '1', name211: '海南大学'},
        // {name: '河北', value: '0', name985: '无', value211: '1', name211: '河北工业大学'},
        // {name: '河南', value: '0', name985: '无', value211: '1', name211: '郑州大学'},
        // {name: '黑龙江', value: '1', name985: '哈尔滨工业大学', value211: '4', name211: '哈尔滨工业大学、哈尔滨工程大学、东北林业大学、东北农业大学'},
        // {name: '湖北', value: '2', name985: '华中科技大学、武汉大学', value211: '7', name211: '华中科技大学、武汉大学、武汉理工大学、华中师范大学、华中农业大学、中南财经政法大学、中国地质大学（武汉）'},
        // {name: '湖南', value: '3', name985: '国防科技大学、中南大学、湖南大学', value211: '4', name211: '国防科技大学、中南大学、湖南大学、湖南师范大学'},
        // {name: '吉林', value: '1', name985: '吉林大学', value211: '3', name211: '吉林大学、东北师范大学、延边大学'},
        // {name: '江苏', value: '2', name985: '南京大学、东南大学', value211: '11', name211: '南京大学、东南大学、河海大学、南京理工大学、南京农业大学、南京师范大学、苏州大学、南京航空航天大学、中国矿业大学、江南大学、中国药科大学'},
        // {name: '江西', value: '0', name985: '无', value211: '1', name211: '南昌大学'},
        // {name: '辽宁', value: '2', name985: '大连理工大学、东北大学', value211: '4', name211: '大连理工大学、东北大学、辽宁大学、大连海事大学'},
        // {name: '内蒙古', value: '0', name985: '无', value211: '1', name211: '内蒙古大学'},
        // {name: '宁夏', value: '0', name985: '无', value211: '1', name211: '宁夏大学'},
        // {name: '青海', value: '1', name985: '无', value211: '1', name211: '青海大学'},
        // {name: '山东', value: '2', name985: '山东大学、中国海洋大学', value211: '3', name211: '山东大学、中国海洋大学、中国石油大学（华东）'},
        // {name: '山西', value: '0', name985: '无', value211: '1', name211: '太原理工大学'},
        // {name: '陕西', value: '3', name985: '西安交通大、西北工业大学、西北农林科技大学', value211: '9', name211: '西安交通大学、西北工业大学、西北大学、西南交通大学、西安电子科技大学、西北农林科技大学、陕西师范大学、空军军医大学、长安大学'},
        // {name: '上海', value: '4', name985: '上海交通大学、复旦大学、同济大学、华东师范大学', value211: '10', name211: '上海交通大学、复旦大学、同济大学、华东师范大学、华东理工大学、上海财经大学、上海大学、东华大学、海军军医大学、上海外国语大学'},
        // {name: '天津', value: '2', name985: '天津大学、南开大学', value211: '3', name211: '天津大学、南开大学、天津医科大学'},
        // {name: '西藏', value: '0', name985: '无', value211: '1', name211: '西藏大学'},
        // {name: '云南', value: '0', name985: '无', value211: '1', name211: '云南大学'},
        // {name: '新疆', value: '0', name985: '无', value211: '2', name211: '新疆大学、石河子大学'},
        // {name: '浙江', value: '1', name985: '浙江大学', value211: '1', name211: '浙江大学'},
        // {name: '重庆', value: '1', name985: '重庆大学', value211: '2', name211: '重庆大学、西南大学'},
        // {name: '北京', value: '8', name985: '北京大学、清华大学、北京师范大学、中国人民大学、北京航空航天大学、北京理工大学、中国农业大学、中央民族大学', value211: '27', name211: '北京大学、清华大学、北京师范大学、中国人民大学、北京航空航天大学、北京理工大学、中国农业大学、\n北京协和医学院\n、北京科技大学、北京交通大学、北京邮电大学、北京外国语大学、中国政法大学、北京化工大学、北京工业大学、中国石油大学（北京）、中国传媒大学、中央民族大学、北京林业大学、对外经济贸易大学、北京中医药大学、中央财经大学、北京体育大学、中国矿业大学（北京）、中国地质大学（北京）、华北电力大学、中央音乐学院'},
        // {name: '香港', value: '0', name985: '无', value211: '0', name211: '无'},
        // {name: '澳门', value: '0', name985: '无', value211: '0', name211: '无'},
        // {name: '台湾', value: '0', name985: '无', value211: '0', name211: '无'},
        // {name: '南海诸岛', value: '0', name985: '无', value211: '0', name211: '无'}
    ];


    option = {
        legend: {
            orient: 'vertical',
            left: 'left',
        },
        geo: {
            select: {
                itemStyle: {
                    areaColor: "#4467CC",
                    borderColor: "#448aff",
                    borderWidth: 3,
                }
            },
            type: 'map',
            map: 'china',
            show: true,
            roam: true,
            label: {
                normal: {
                    show: true,
                    textStyle: {
                        color: '#000000',
                        fontFamily: 'taiekaishu',
                        fontSize: '15px'
                    }
                },
                //选中高亮情况下配置项
                emphasis: {
                    textStyle: {
                        color: '#FFF'
                    }
                }
            },
            //各省样式
            itemStyle: {
                normal: {
                    areaColor: '#3034A0',
                    borderColor: '#3057D3',
                    borderWidth: 1,
                    shadowColor: 'rgba(0,63,140,0.2)',
                    shadowOffsetY: 20,
                    shadowBlur: 10
                },
                emphasis: {
                    areaColor: '#4467CC',
                    borderColor: '#448aff',
                    borderWidth: 2
                }
            },
        },

        backgroundColor: 'transparent',
        title: {
            text: '招生信息',
            left: 'center',
            textStyle: {
                color: '#FFFFFF',
                fontFamily: 'taiekaishu',
                fontSize: '30px',
                fontWeight: 'normal'
            }
        },

        tooltip: {
            trigger: 'item',
            confine: true,
            textStyle: {
                fontcolor: '#000000'
            },
            backgroundColor: 'rgba(255,255,255,0.9)',
            formatter: function(params) {
                var content = params.name;
                // content += "985大学数" + ': ' + params.data.value + '<br>'
                //     + params.data.name985 + '<br>'
                //     + "211大学数" + ': ' + params.data.value211 + '<br>'
                //     + params.data.name211;
                return content;
            }
        },

        scaleLimit: {
            min: 0.7,
            max: 5
        },

        //系列配置
        series: [
            {
                type: 'map',
                map: 'china',
                label: {
                    show: true,
                    color: '#FFFFFF'
                },
                roam: true,
                //【此参数必须配置，否则visualMap不起作用】
                geoIndex: 0,
                //此处可接收后端参数，当前数据仅为测试
                data: outData
            }],
        animationType: 'scale',
        animationEasing: 'elasticOut',
        animationDelay: 2000
    };

    myEcharts.setOption(option);


    //近三年招生人数
    myEcharts.on('click', function(param) {
        const p = document.getElementById('left');
        var chartDom = document.getElementById('left1');
        var myChart1 = echarts.init(chartDom);
        var option;

        p.style.display = 'block';

        var data1 = parseInt(Math.random()*(300-50+1)+50,10);
        var data2 = parseInt(Math.random()*(300-50+1)+50,10);
        var data3 = parseInt(Math.random()*(300-50+1)+50,10);
        var outdata = [data1, data2, data3];

        option = {
            title: {
                text: "近三年招生人数",
                left: 'center',
                textStyle: {
                    color: '#000000',
                    fontFamily: 'taiekaishu',
                    fontSize: '25px',
                    fontWeight: 'normal'
                }
            },
            tooltip: {
                //鼠标悬停提示内容
                trigger: 'axis', // 触发类型，默认数据触发，可选为：'axis' item
            },
            xAxis: {
                type: 'category',
                boundaryGap: true,
                data: ['2020', '2021', '2022'],
            },
            yAxis: {
                type: 'value',
            },
            series: [
                {
                    data: outdata,
                    type: 'line',
                    areaStyle: {
                        color: 'rgba(136,154,215,0.6)'
                    }
                }
            ]
        };

        myChart1.setOption(option);

        //屏幕自适应
        window.addEventListener('resize', function (){
            myChart1.resize();
        });
    });

    //近三年分数线
    myEcharts.on('click', function(param) {
        var chartDom = document.getElementById('left2');
        var myChart2 = echarts.init(chartDom);
        var option;

        var data1 = parseInt(Math.random()*(700-560+1)+560,10);
        var data2 = parseInt(Math.random()*(700-560+1)+560,10);
        var data3 = parseInt(Math.random()*(700-560+1)+560,10);
        var outdata = [data1, data2, data3];

        option = {
            title: {
                text: '近三年分数线',
                left: 'center',
                textStyle: {
                    color: '#000000',
                    fontFamily: 'taiekaishu',
                    fontSize: '25px',
                    fontWeight: 'normal'
                }
            },
            tooltip: {
                //鼠标悬停提示内容
                trigger: 'axis', // 触发类型，默认数据触发，可选为：'axis' item
            },
            xAxis: {
                type: 'category',
                data: ['2020', '2021', '2022']
            },
            yAxis: {
                type: 'value'
            },
            series: [
                {
                    data: outdata,
                    type: 'line'
                }
            ]
        };

        myChart2.setOption(option);

        //屏幕自适应
        window.addEventListener('resize', function (){
            myChart2.resize();
        });
    });

    //屏幕自适应
    window.addEventListener('resize', function (){
        myEcharts.resize();
    });
</script>

<script>
    window.onload=function(){
        var a = document.getElementById("screen");//获取div块对象
        var Height=document.documentElement.clientHeight;//取得浏览器页面可视区域的宽度
        var Width=document.documentElement.clientWidth;//取得浏览器页面可视区域的宽度
        var gao1 = a.offsetHeight;//获取div块的高度值
        var gao2 = a.offsetWidth;//获取div块的宽度值
        var Sgao1= (Height - gao1)/2+"px";
        var Sgao2= (Width - gao2)/2+"px";
        a.style.top=Sgao1;
        a.style.left=Sgao2;
    }
</script>

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
</body>
</html>
