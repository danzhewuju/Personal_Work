<%--
  Created by IntelliJ IDEA.
  User: Alx
  Date: 2017/7/28
  Time: 10:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>基金管理</title>
    <%@include file="config.jsp"%>
</head>
<body>

<nav class="navbar navbar-default ">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">基金管理系统</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li ><a href="CheckInvest">本轮投资查询</a></li>
                <li><a href="InvestEveryDay">今日定投</a></li>
                <li><a href="#contact">出售基金</a></li>
                <li><a href="addfund.jsp">基金添加</a></li>

            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="../navbar/">操作细则</a></li>
                <li><a href="login.jsp">安全退出</a></li>

            </ul>
        </div><!--/.nav-collapse -->
    </div>
</nav>


</body>
</html>
