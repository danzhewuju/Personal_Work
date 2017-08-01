<%--
  Created by IntelliJ IDEA.
  User: Alx
  Date: 2017/7/30
  Time: 18:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>基金管理-今日投资</title>
    <%@include file="title.jsp"%>
    <script type="text/javascript">

        var xmlhttp;
        function getdate() {
            var today=new Date();
            var month=today.getMonth()+1;
            if(month<=9)
            {
                month="0"+month;
            }
            var day=today.getDate();
            if(day<=9)
            {
                day="0"+day;
            }



            var  date = (today.getFullYear()) +"-" + month  + "-" + day ;

            document.getElementById("today").value=date;
        }

        window.onload=getdate;

function validate() {
    xmlhttp=new XMLHttpRequest();
    var fid;
    var obj=document.getElementById("fid");
    var index=obj.selectedIndex;
    fid=obj.options[index].value;
    xmlhttp.onreadystatechange=function () {
        if(xmlhttp.readyState==4&&xmlhttp.status==200)
            var message=xmlhttp.responseText;
            var obj=eval("("+message+")");
            document.getElementById("firstdate").value=obj.firstdate;
            document.getElementById("invest").value=obj.invest;

      //  document.getElementById("invest").value=message;

    }
    xmlhttp.open("GET","AjaxTest?fid="+fid,true);
    xmlhttp.send();
}
    </script>


</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-6 column">

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
            <h3 class="text-center color-picker-label">基金信息更新管理</h3>
            <form class="form-horizontal" action="InvestEveryDay" method="post">
                <div class="form-group">
                    <label id="handle" class="col-sm-2 control-label">操作人</label>
                    <div class="col-sm-10">
                        <label class="col-sm-2 control-label">${sessionScope.userinvest.user.uid} </label>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">基金</label>
                    <div class="col-sm-5">
                        <select class="form-control"  id="fid" onchange="validate()">
                            <option value="" >请选择</option>
                            <c:forEach var="i" begin="0" end="${sessionScope.userinvest.count}" step="1">
                                <c:if test="${i!=sessionScope.userinvest.count}">
                                    <option value="${sessionScope.userinvest.investings[i].fund.fid}" >${sessionScope.userinvest.investings[i].fund.name} </option>
                                </c:if>
                            </c:forEach>

                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">首日投资日期</label>
                    <div class="col-sm-10">
                        <input type="date" class="form-control" id="firstdate" name="firstdate"   readonly />
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label">今日投资日期</label>
                    <div class="col-sm-10">
                        <input type="date" class="form-control" id="today" name="today"   />
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label">持仓盈亏</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="proalo" name="proalo"   />
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">已实现盈利</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="getincome" name="getincome"   />
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">基金总资产</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="amount" name="amount"   />
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label">昨日涨跌幅</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="rifa" name="rifa"   />
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label">今日投资</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="invest" name="invest" value="5000" />
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-sm-offset-4 col-sm-7">

                        <button type="reset" class="btn btn-success ">重置</button>
                        <button type="submit" class=" col-sm-offset-2 btn btn-danger ">提交</button>
                    </div>

                </div>
            </form>

        </div>
    </div>
</div>


</body>
</html>
