<%--
  Created by IntelliJ IDEA.
  User: Alx
  Date: 2017/8/1
  Time: 23:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>基金管理系统-基金出售</title>
    <%@include file="title.jsp"%>
    <script type="text/javascript">

        function sale(fid) {
            window.location.href="SaleFund?fid="+fid;

        }
    </script>
</head>
<body>
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

                       <c:set var="tep" value="${j}" scope="session"></c:set><!-- 获利的记录-->
                </c:if>



            </c:forEach>

<tr>
<td>
    汇总:
</td>
    <td>
        出售总资产:${sessionScope.userinvest.investings[i].investings[tep].amount}
    </td>
    <td>
        本轮获利:${sessionScope.userinvest.investings[i].investings[tep].thisincome}
    </td>
     <td>
         平台手续费:${sessionScope.userinvest.investings[i].investings[tep].thisincome*0.05/0.95}
     </td>
    <td><button class="btn btn-danger" onclick="sale('${sessionScope.userinvest.investings[i].fund.fid}')">出售</button> </td>
</tr>
            </tbody>


        </table>


    </c:forEach>
</c:if>
</body>
</html>
