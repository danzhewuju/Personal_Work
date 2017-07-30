<%--
  Created by IntelliJ IDEA.
  User: Amos
  Date: 2017/6/28
  Time: 00:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>


    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>基金管理系统</title>
    <link rel='stylesheet prefetch' href="css/sign_log/reset.css">
    <link rel="stylesheet" type="text/css" href="css/sign_log/default.css">
    <link rel="stylesheet" type="text/css" href="css/sign_log/styles.css">

</head>
<body>
<div class="htmleaf-content">
    <!-- multistep form -->
    <form id="msform" action="Login" method="post">
        <!-- fieldsets -->
        <fieldset>
            <h2 class="fs-title">Log to  my account</h2>
            <input name="myusername" id="myusername" type="text"  placeholder="Account" autofocus>
            <input name="mypassword" id="mypassword" type="password" placeholder="Password" onchange="validate()">
            <font color="red" size="3px">${rresult}</font><br><br>
            <input type="submit" name="submit" class="next action-button" value="Submit" />
            <input type="reset" name="reste" class="next action-button1" value="Reset" />
        </fieldset>
    </form>
</div>
</body>
</html>