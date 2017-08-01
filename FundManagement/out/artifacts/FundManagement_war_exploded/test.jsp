
<%--
  Created by IntelliJ IDEA.
  User: Alx
  Date: 2017/7/28
  Time: 15:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>test</title>
    <script src="js/echarts.js"></script>
    <script type="text/javascript">

        function draw() {
            // 基于准备好的dom，初始化echarts实例
            /*1*/     var myChart = echarts.init(document.getElementById('main'));

            // 指定图表的配置项和数据
            /*2*/      var option = {
                title: {
                    text: '信息表'
                },
                tooltip: {},
                legend: {
                    data:['收益']
                },
                xAxis: {
                    data: ["衬衫","羊毛衫","雪纺衫","裤子","高跟鞋","袜子"]
                },
                yAxis: {},
                series: [{
                    name: '收益',
                    type: 'bar',
                    data: [5, 20, 36, 10, 10, 20]
                }]
            };

            // 使用刚指定的配置项和数据显示图表。
            /*3*/     myChart.setOption(option);
        }
    </script>
</head>
<div id="main" style="height: 400px;width: 400px" ></div>
<script type="text/javascript">
    draw();


</script>
<body>
<%! String json1; %>
<%
    String json= (String) session.getAttribute("json");
    System.out.println("************************************");
    System.out.println(json);
    json1=json;

%>
<p> <%= json1%></p>

<script type="text/javascript">
    var json2='<%=json1%>';
    var obj=eval("("+json2+")");
    alert(obj.count);

</script>





</body>
</html>
