<%--
  Created by IntelliJ IDEA.
  User: Alx
  Date: 2017/7/28
  Time: 8:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>基金管理系统</title>
    <%@include file="config.jsp"%>
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <ul class="nav nav-tabs">
                <li class="active">
                    <a href="#">查看最近投资信息</a>
                </li>
                <li>
                    <a href="#">简介</a>
                </li>
                <li class="disabled">
                    <a href="#">信息</a>
                </li>
                <li class="dropdown pull-right">
                    <a href="#" data-toggle="dropdown" class="dropdown-toggle">下拉<strong class="caret"></strong></a>
                    <ul class="dropdown-menu">
                        <li>
                            <a href="#">操作</a>
                        </li>
                        <li>
                            <a href="#">设置栏目</a>
                        </li>
                        <li>
                            <a href="#">更多设置</a>
                        </li>
                        <li class="divider">
                        </li>
                        <li>
                            <a href="#">分割线</a>
                        </li>
                    </ul>
                </li>
            </ul>
            <div class="row clearfix">
                <div class="col-md-3 column">
                    <ul class="nav nav-pills nav-stacked">
                        <li class="active">
                            <a href="#">首页</a>
                        </li>
                        <li>
                            <a href="#">简介</a>
                        </li>
                        <li class="disabled">
                            <a href="#">信息</a>
                        </li>
                        <li class="dropdown pull-right">
                            <a href="#" data-toggle="dropdown" class="dropdown-toggle">下拉<strong class="caret"></strong></a>
                            <ul class="dropdown-menu">
                                <li>
                                    <a href="#">操作</a>
                                </li>
                                <li>
                                    <a href="#">设置栏目</a>
                                </li>
                                <li>
                                    <a href="#">更多设置</a>
                                </li>
                                <li class="divider">
                                </li>
                                <li>
                                    <a href="#">分割线</a>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </div>
                <div class="col-md-9 column">
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
