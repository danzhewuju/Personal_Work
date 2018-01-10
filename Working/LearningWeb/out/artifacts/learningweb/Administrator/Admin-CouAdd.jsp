<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/6/26
  Time: 19:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="utf-8">
    <!--[if IE]>
    <meta http-equiv="x-ua-compatible" content="IE=9"/><![endif]-->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>MAPS|淘课-基于知识地图的多元化学习网站</title>

    <!-- CSS -->
    <link rel="stylesheet" href="../css/bootstrap.css">
    <link rel="stylesheet" href="../css/font-awesome.css">
    <link rel="stylesheet" href="../css/animate.css">
    <link rel="stylesheet" href="../css/chartist-custom.css">
    <link rel="stylesheet" href="../css/ad_main.css">
    <script src="https://use.fontawesome.com/61a9ff3a07.js"></script>
    <%@include file="../config.jsp" %>
    <%@include file="../navbar_blue.jsp" %>

</head>
<body>
<%@page import="java.util.*" %>
<%@page import="java.io.*" %>
<%@page import="DAO.*" %>
<%@page import="Entity.*" %>
<%@page import="Page.*" %>
<%@ page import="Database.AddCourseDao" %>

<!-- WRAPPER -->
<div id="wrapper">
    <!-- LEFT SIDEBAR -->
    <div id="sidebar-nav" class="sidebar">
        <div class="sidebar-scroll">
            <nav>
                <ul class="nav">
                    <li><a href="AdminHeadPage.jsp" class=""><span>Home</span></a></li>
                    <li><a href="Admin-StuSel.jsp" class=""> <span>Student</span></a></li>
                    <li>
                        <a href="#menu1" data-toggle="collapse" class="collapsed"><span>Course</span><i
                                class="icon-submenu fa fa-angle-double-right"></i></a>
                        <div id="menu1" class="collapse">
                            <ul class="nav">
                                <li><a href="Admin-CouSel.jsp" class="">课程信息管理</a></li>
                                <li><a href="Admin-RelSel.jsp" class="">课程关系管理</a></li>
                                <li><a href="Admin-CouAdd.jsp" class="">添加新课程</a></li>
                                <li><a href="Admin-Verify.jsp" class="">审核新课程</a></li>
                            </ul>
                        </div>
                    </li>
                    <li>
                        <a href="#menu2" data-toggle="collapse" class="collapsed"><span>Teacher</span><i
                                class="icon-submenu fa fa-angle-double-right"></i></a>
                        <div id="menu2" class="collapse ">
                            <ul class="nav">
                                <li><a href="Admin-TeaSel.jsp" class="">教师信息管理</a></li>
                                <li><a href="Admin-TeaAdd.jsp" class="">添加新教师</a></li>
                            </ul>
                        </div>
                    </li>
                    <li><a href="Admin-VerTab.jsp" class=""><span>Record</span></a></li>
                </ul>
            </nav>
        </div>
    </div>

    <!-- END LEFT SIDEBAR -->
    <div class="main">
        <!-- MAIN CONTENT -->
        <div class="main-content">
            <div class="container-fluid">
                <h3 class="page-title">添加新课程</h3>
                <div class="row">
                    <!-- TABLE -->
                    <div class="panel panel-info">
                        <ul class="breadcrumb">
                            <li>
                                <a href="AdminHeadPage.jsp">主页</a>
                            </li>
                            <li>
                                <a href="#">课程管理</a>
                            </li>
                            <li class="active">
                                添加新课程
                            </li>
                        </ul>
                        <div class="panel-body">
                            <form action="../AdminCouAdd" method="post">
                                <fieldset>
                                    <legend>填写课程信息</legend>
                                    <table class="table">
                                        <tr class="danger">
                                            <td>课程号</td>
                                            <td><input type="text" name="Cno"/></td>
                                        </tr>
                                        <tr class="info">
                                            <td>课程名</td>
                                            <td><input type="text" name="Cname"/></td>
                                        </tr>

                                        <tr class="success">
                                            <td>教师</td>
                                            <%
                                                TeacherDAO dao = new TeacherDAO();
                                                List<TeacherPage> list = dao.GetAll();
                                            %>
                                            <td><select name="Tno">
                                                <%
                                                    Course c = (Course) request.getSession().getAttribute("Teacou");
                                                    CoursePage cp = new CoursePage();

                                                    if (c != null) {
                                                %>
                                                <option value="<%=c.getTeacherid() %>" selected><%=c.getTname() %>
                                                </option>
                                                <%}%>
                                                <%for (TeacherPage t : list) { %>
                                                <option value="<%=t.getId()%>"><%=t.getName() %>
                                                </option>
                                                <%} %></select></td>
                                        </tr>
                                        <tr class="warning">
                                            <td>种类</td>
                                            <td><select name="Ckind">
                                                <option value="计算机" selected>计算机</option>
                                                <option value="文学">文学</option>
                                                <option value="历史学">历史</option>
                                                <option value="经济学">经济学</option>
                                                <option value="工程技术">工程技术</option>
                                                <option value="医学">医学</option>
                                                <option value="医学">法学</option>
                                            </select></td>
                                        </tr>

                                    </table>
                                    <br/>
                                    <button type="submit" class="btn btn-info">提交</button>
                                </fieldset>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
