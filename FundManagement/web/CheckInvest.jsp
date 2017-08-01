<%--
  Created by IntelliJ IDEA.
  User: Alx
  Date: 2017/7/28
  Time: 14:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>基金管理系统</title>
    <%@include file="title.jsp"%>
    <script src="js/echarts.js"></script>
    <script type="text/javascript">
        var json='${sessionScope.json}';
        var obj=eval("("+json+")");
        function  setdate(i) {

            var date=new Array();
            for (var j=0;j<obj.jsonIncomes[i].count;j++)
            {
                date[j]=obj.jsonIncomes[i].dates[j];
            }
            return date;

        }
        function setprofit(i) {
            var profit=new Array();
            for (var j=0;j<obj.jsonIncomes[i].count;j++)
            {
                profit[j]=obj.jsonIncomes[i].investingincome[j];

            }
            return profit;

        }
        function draw(i) {
            // 基于准备好的dom，初始化echarts实例
            /*1*/     var myChart = echarts.init(document.getElementById(i));

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
                    data: setdate(i)
                },
                yAxis: {},
                series: [{
                    name: '收益',
                    type: 'bar',
                    data: setprofit(i)
                }]
            };

            // 使用刚指定的配置项和数据显示图表。
            /*3*/     myChart.setOption(option);
        }
    </script>
</head>
<body>
<div class="container">
    <div class="row clearfix">

            <div class="col-md-6 column">
                <c:if test="${sessionScope.userinvest.allcount==0}">
                    <h3 class="text-center">你当前还没有投资任何的基金</h3>

                </c:if>
                   <c:if test="${sessionScope.userinvest.allcount>0}" >
                <h2 class="text-center">基金信息总览</h2>
                <c:forEach var="i" begin="0" end="${sessionScope.userinvest.allcount-1}" step="1">

                        <h3 class="text-center">
                                ${sessionScope.userinvest.allinvests[i].fund.name}基金详细
                        </h3>
                        <table class="table table-hover table-striped">
                        <thead>
                        <tr>
                            <th>
                                基金代码
                            </th>
                            <th>
                                定投方式
                            </th>
                            <th>
                                首投日期
                            </th>

                            <th>
                                投资日期
                            </th>
                            <th>
                                本轮收益
                            </th>
                            <th>
                                投资份额
                            </th>
                            <th>
                                账目资产
                            </th>
                            <th>
                                首日年化
                            </th>
                        </tr>
                        </thead>
                        <tbody>



                        <c:forEach var="j" begin="0" end="${sessionScope.userinvest.allinvests[i].allcount}" step="1">
                            <c:if test="${j<sessionScope.userinvest.allinvests[i].allcount}">
                                <tr>
                                    <td>
                                            ${sessionScope.userinvest.allinvests[i].fund.name}
                                    </td>
                                    <td>
                                            ${sessionScope.userinvest.allinvests[i].allinvests[j].mode}
                                    </td>
                                    <td>
                                            ${sessionScope.userinvest.allinvests[i].allinvests[j].firstdate}
                                    </td>
                                    <td>
                                            ${sessionScope.userinvest.allinvests[i].allinvests[j].today}
                                    </td>
                                    <td>
                                            ${sessionScope.userinvest.allinvests[i].allinvests[j].thisincome}
                                    </td>
                                    <td>
                                            ${sessionScope.userinvest.allinvests[i].allinvests[j].invest}
                                    </td>
                                    <td>
                                            ${sessionScope.userinvest.allinvests[i].allinvests[j].amount}
                                    </td>
                                    <td>
                                            ${sessionScope.userinvest.allinvests[i].allinvests[j].firstyearprofit}
                                    </td>
                                </tr>

                            </c:if>


                        </c:forEach>



                        </tbody>
                    </table>

                </c:forEach>
                </c:if>

              <c:if test="${sessionScope.userinvest.count==0}">

                  <h3 class="text-center">你当前没有购买任何基金</h3>
              </c:if>

                <c:if test="${sessionScope.userinvest.count>0}">

                    <h2 class="text-center">正在投资基金信息总览</h2>
                    <c:forEach var="i" begin="0" end="${sessionScope.userinvest.count-1}" step="1">


                        <h3 class="text-center">
                                ${sessionScope.userinvest.investings[i].fund.name}基金详细
                        </h3>
                        <table class="table table-hover table-striped">
                            <thead>
                            <tr>
                                <th>
                                    基金代码
                                </th>
                                <th>
                                    定投方式
                                </th>
                                <th>
                                    首投日期
                                </th>

                                <th>
                                    投资日期
                                </th>
                                <th>
                                    本轮收益
                                </th>
                                <th>
                                    投资份额
                                </th>
                                <th>
                                    账目资产
                                </th>
                                <th>
                                    首日年化
                                </th>
                            </tr>
                            </thead>

                            <tbody>
                            <c:forEach var="j" begin="0" end="${sessionScope.userinvest.investings[i].count}" step="1" >

                                <c:if test="${j!=sessionScope.userinvest.investings[i].count}">
                                    <tr>
                                        <td>
                                                ${sessionScope.userinvest.investings[i].fund.name}

                                        </td>

                                        <td>
                                                ${sessionScope.userinvest.investings[i].investings[j].mode}

                                        </td>
                                        <td>
                                                ${sessionScope.userinvest.investings[i].investings[j].firstdate}

                                        </td>
                                        <td>
                                                ${sessionScope.userinvest.investings[i].investings[j].today}

                                        </td>
                                        <td>
                                                ${sessionScope.userinvest.investings[i].investings[j].thisincome}

                                        </td>
                                        <td>
                                                ${sessionScope.userinvest.investings[i].investings[j].invest}

                                        </td>
                                        <td>
                                                ${sessionScope.userinvest.investings[i].investings[j].amount}

                                        </td>
                                        <td>
                                                ${sessionScope.userinvest.investings[i].investings[j].firstyearprofit}

                                        </td>

                                    </tr>


                                </c:if>



                            </c:forEach>


                            </tbody>


                        </table>


                    </c:forEach>
                </c:if>


                  </div>
        <div class="col-md-6 column">

            <c:forEach var="i" begin="0" end="${sessionScope.userinvest.count}" step="1">
                <c:if test="${i!=sessionScope.userinvest.count}">


                    <div class="panel-group" id="panel-442786${i}" >
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <a class="panel-title" data-toggle="collapse" data-parent="#panel-442786" href="#panel-element-874778${i}" >${sessionScope.userinvest.investings[i].fund.name}盈利表</a>
                            </div>
                            <div id="panel-element-874778${i}" class="panel-collapse collapse in">
                                <div id="${i}" class="panel-body" style="height: 400px;width:400px">
                                    <script type="text/javascript">
                                        draw('${i}');

                                    </script>

                                </div>
                            </div>
                        </div>

                    </div>

                </c:if>

            </c:forEach>



        </div>
    </div>
</div>





</div>
</body>
</html>
