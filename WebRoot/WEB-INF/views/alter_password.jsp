<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit">

    <title>修改密码</title>
    <meta name="keywords" content="修改密码">
    <meta name="description" content="修改密码">

    <link href="${pageContext.request.contextPath}/static/admin/css/bootstrap.min.css?v=3.4.0" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/admin/font-awesome/css/font-awesome.css?v=4.3.0" rel="stylesheet">

    <!-- Morris -->
    <link href="${pageContext.request.contextPath}/static/admin/css/plugins/morris/morris-0.4.3.min.css?t=322" rel="stylesheet">

    <!-- Gritter -->
    <link href="${pageContext.request.contextPath}/static/admin/js/plugins/gritter/jquery.gritter.css?t=322" rel="stylesheet">

    <link href="${pageContext.request.contextPath}/static/admin/css/animate.css?t=322" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/admin/css/style.css?v=2.2.0" rel="stylesheet">

<c:set var="uri" value="${pageContext.request.contextPath}" />

<script type="text/javascript">
var uri='${uri}';
</script>
<style>
.bodyClass::-webkit-scrollbar {
																	display: none; /* Chrome Safari */
																	}
																	.bodyClass {
																	scrollbar-width: none; /* firefox */
																	-ms-overflow-style: none; /* IE 10+ */
																	overflow-x: hidden;
																	overflow-y: auto;
																	}
																	
																		.dz-image>img{
																						width:120px;
																						height:120px;
																					}
</style>
</head>

<body class="bodyClass"  style="background-color:#f3f3f4">
   
     <div class="modal inmodal"  id="bodyModal" tabindex="-1" role="dialog" aria-hidden="true" style="top:80px;left:-200px;">
                                    <div class="modal-dialog">
                                        <div class="modal-content animated bounceInRight">
                                            <div class="modal-header">
                                                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">关闭</span>
                                                </button>
                                              
                                                <h4 class="modal-title"  id="bodyModalTile"></h4>
                                            
                                        </div>
                                        <div class="modal-body"  id="bodyModalContent">
												
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-white" data-dismiss="modal">关闭</button>
                                     
                                        </div>
                                    </div>
                                </div>
                            </div>
   
   <div class="row wrapper border-bottom white-bg page-heading">
                <div class="col-lg-10">
                    <h2>修改密码 </h2>
                   
                </div>
                <div class="col-lg-2">

                </div>
            </div>
			<div class="gray-bg dashbard-1" style="height:758px">
			<div class="row">
                    <div class="col-lg-12">
                        <div class="ibox float-e-margins">
                            <div class="ibox-title">
                               
                                <div class="ibox-tools">
                                 
                                </div>
                            </div>
                            <div class="ibox-content">
                                <div class="row"   style="width:80%;margin-left:10%">
								<div class="col-lg-6">
                                   <div class="form-group">
<label>账号名</label>
<input type="text" class="form-control" value="${login.name}" disabled>
</div>
<div class="form-group">
<label>旧密码</label>
<input  class="form-control" type="password" placeholder="旧密码"  id="password1">
</div>


<div class="form-group">
<label>新密码</label>
<input  class="form-control" type="password" placeholder="新密码"  id="password2">
</div>


<div class="form-group">
<label>新密码</label>
<input  class="form-control" type="password" placeholder="再次输入新密码"  id="password3">
</div>



<div class="form-group">
<button type="button" class="btn btn-primary" onclick="alterPassword();">提交</button>
</div>
                                </div>
                                </div>
								
								
                          

                            </div>
                        </div>
                    </div>

                </div>

			</div>

    <!-- Mainly scripts -->
    <script src="${pageContext.request.contextPath}/static/admin/js/jquery-2.1.1.min.js?t=322"></script>
    <script src="${pageContext.request.contextPath}/static/admin/js/bootstrap.min.js?v=3.4.0"></script>


<script type="text/javascript" src="${pageContext.request.contextPath}/static/common/utils/listutils.js?v=#随机码#"></script>

<script>

function alterPassword(){
var password1 = $("#password1").val();
var password2 = $("#password2").val();
var password3 = $("#password3").val();
	$.ajax({
	    type: 'post',
	    dataType : "json",
	    url: '${pageContext.request.contextPath}/alterPwd/alterPassword/submit',
	    data:{
	    	"password1":password1,
	    	"password2":password2,
	    	"password3":password3
	    },
	    success: function(result) {
	    	if(result.code == 0){
	    		alert(result.msg);
			}else{
				alert(result.msg);
			}
	    }
	}); 
}


</script>

</body>

</html>