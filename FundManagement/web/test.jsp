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
    <%@include file="title.jsp"%>
    <script type="text/javascript">


        function getdate() {
            var today=new Date();
            var month=today.getMonth()+1;
            if(month<=9)
            {
                month="0"+month;
            }


          var  date = (today.getFullYear()) +"-" + month  + "-" + today.getDate() ;

            document.getElementById("today").value=date;
        }
        window.onload=getdate;
        var xmlhttp;
        function ajax() {
           xmlhttp=new XMLHttpRequest();
           xmlhttp.onreadystatechange=function () {
               if(xmlhttp.readyState==4&&xmlhttp.status==200)
               {

                var message=xmlhttp.responseText;
                var user=eval("("+message+")");
                alert("id="+user.id+"password"+user.password);

               }

           }
           xmlhttp.open("GET","AjaxTest",true);
           xmlhttp.send();

        }
        window.onload=ajax;
    </script>
</head>
<body>
<h3 class="text-center color-picker-label">基金信息更新管理</h3>
<form class="form-horizontal" role="form" action="InvestEveryDay" method="post">

    <div class="form-group">
        <label class="col-sm-2 control-label">首日投资</label>
        <div class="col-sm-10">
            <input type="date" class="form-control" id="today" name="today"   />
        </div>
    </div>

</form>
</body>
</html>
