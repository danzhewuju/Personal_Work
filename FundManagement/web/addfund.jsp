<%--
  Created by IntelliJ IDEA.
  User: Alx
  Date: 2017/7/30
  Time: 15:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加基金</title>
    <%@include file="title.jsp"%>
    <script type="text/javascript">
        function check() {
            var message="${sessionScope.message}";
            if(message!="")
            {
                alert(message);

            }

        }


        function Buyfund(fid) {
           window.location.href="BuyFund?fid="+fid;
            
        }
    </script>
</head>
<body>
<% session.removeAttribute("message");%>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-4 column">
            <h2 class="text-center">推荐的基金</h2>
            <div class="panel-group" id="panel-878465">

                <c:forEach var="i" begin="0" end="${sessionScope.funds.count}" step="1">
                    <c:if test="${i!=sessionScope.funds.count}">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <a class="panel-title" data-toggle="collapse" data-parent="#panel-878465" href="#panel-element-605933${i}">${sessionScope.funds.funds[i].name}</a>

                            </div>
                            <div id="panel-element-605933${i}" class="panel-collapse collapse">
                               <ul>
                                   <li>
                                       平台:${sessionScope.funds.funds[i].platform}
                                   </li>
                                   <li>
                                       经理:${sessionScope.funds.funds[i].manager}
                                   </li>
                                   <li>
                                       评分:${sessionScope.funds.funds[i].grade}分
                                   </li>

                               </ul>
                                <button class="btn btn-danger" onclick="Buyfund('${sessionScope.funds.funds[i].fid}')">购买该基金</button>
                            </div>
                        </div>


                    </c:if>

                </c:forEach>


        </div>
        </div>
        <div class="col-md-8 column">
            <h3 class="text-center">添加基本的基金信息</h3>
            <form class="form-horizontal" role="form" action="AddFund" method="post">
                <div class="form-group">
                    <label class="col-sm-2 control-label">基金名称</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="name" name="name" />
                    </div>
                </div>
                <div class="form-group">
                    <label  class="col-sm-2 control-label">基金平台</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="platform " name="platform" />
                    </div>
                </div>
                <div class="form-group">
                    <label  class="col-sm-2 control-label">经理</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="manager" name="manager" />
                    </div>
                </div>
                <div class="form-group">
                    <label  class="col-sm-2 control-label">基金规模</label>
                    <div class="col-sm-10">

                        <label class="col-sm-1"> 大<input type="radio" class="checkbox" name="ballpark" value="大"></label>
                        <label class="col-sm-1"> 中 <input type="radio" class="checkbox" name="ballpark" value="中"></label>
                        <label class="col-sm-1" > 小 <input type="radio" class="checkbox" name="ballpark" value="小"></label>

                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">评分</label>
                    <div class="col-sm-10">
                        <label class="col-sm-1"> 5 <input type="radio" class="radio" name="grade" value="5"> </label>
                        <label class="col-sm-1"> 4 <input type="radio" class="radio" name="grade" value="4"> </label>
                        <label class="col-sm-1"> 3 <input type="radio" class="radio" name="grade" value="3"> </label>
                        <label class="col-sm-1"> 2 <input type="radio" class="radio" name="grade" value="2"> </label>
                        <label class="col-sm-1"> 1 <input type="radio" class="radio" name="grade" value="1"> </label>
                    </div>
                </div>

                <div class="form-group">
                    <label  class="col-sm-2 control-label">B评分</label>
                    <div class="col-sm-10">
                        <label class="col-sm-1"> 5 <input type="radio" class="radio" name="bgrade" value="5"> </label>
                        <label class="col-sm-1"> 4 <input type="radio" class="radio" name="bgrade" value="4"> </label>
                        <label class="col-sm-1"> 3 <input type="radio" class="radio" name="bgrade" value="3"> </label>
                        <label class="col-sm-1"> 2 <input type="radio" class="radio" name="bgrade" value="2"> </label>
                        <label class="col-sm-1"> 1 <input type="radio" class="radio" name="bgrade" value="1"> </label>

                    </div>
                </div>

                <div class="form-group">
                    <label  class="col-sm-2 control-label">经理评分</label>
                    <div class="col-sm-10">
                        <label class="col-sm-1"> 5 <input type="radio" class="radio" name="mgrade" value="5"> </label>
                        <label class="col-sm-1"> 4 <input type="radio" class="radio" name="mgrade" value="4"> </label>
                        <label class="col-sm-1"> 3 <input type="radio" class="radio" name="mgrade" value="3"> </label>
                        <label class="col-sm-1"> 2 <input type="radio" class="radio" name="mgrade" value="2"> </label>
                        <label class="col-sm-1"> 1 <input type="radio" class="radio" name="mgrade" value="1"> </label>
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-sm-offset-4 col-sm-7">

                        <button type="reset" class="btn btn-success ">重置</button>
                        <button type="submit" class=" col-sm-offset-2 btn btn-danger ">提交</button>
                    </div>

                </div>
            </form>
            <a id="modal-199775" href="#modal-container-199775" role="button" class="btn" data-toggle="modal">触发遮罩窗体</a>

            <div class="modal fade" id="modal-container-199775" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                            <h4 class="modal-title" id="myModalLabel">
                                标题
                            </h4>
                        </div>
                        <div class="modal-body">
                            内容...
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button> <button type="button" class="btn btn-primary">保存</button>
                        </div>
                    </div>

                </div>

            </div>

        </div>

    </div>
</div>

</body>
</html>
