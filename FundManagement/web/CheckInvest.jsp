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
        </div>
    </div>
</div>



</div>
</body>
</html>
