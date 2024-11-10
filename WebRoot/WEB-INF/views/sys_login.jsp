<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
<title>智能化会议室预订系统-登录</title>
<link href="${pageContext.request.contextPath}/static/login/css/bootstrap.min.css?t=300" rel="stylesheet">
<link href="${pageContext.request.contextPath}/static/login/css/a3common.css?t=300" rel="stylesheet">
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/login/css/login.css?t=300">
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/login/css/font_43459_lbtux0zjkr6yldi.css?t=300">

</head>


<body  style=" background-image:url(${pageContext.request.contextPath}/static/login_bg.jpg);background-size:100% 100%">

<div id="main" class="main-warp"  style="background:transparent">
	<div class="main-content">
		<div class="formDiv">
			<h2 class="text-center">智能化会议室预订系统-登录</h2>
			<div>
				<div class="dataform" >
					<p style="margin-top:20px">登录名</p>
					<div>
						<input id="name" name="name" type="text" placeholder="请输入登录名" style="width:100%;height:40px;display:block" class="" class="inputs">
					</div>
					<p style="margin-top:20px">密码</p>
					<div>
						<input id="password" name="password" type="password" placeholder="请输入密码" style="width:100%;height:40px;display:block" class="" class="inputs">
					</div>
					<p style="margin-top:20px">图片验证码</p>
					<div  class="input-warp">
						<input class="inputs" id="imgCode" name="imgCode" type="text" placeholder="验证码"  style="width:60%">
						<img id="codeImg1"  name="codeImg" alt="点击更换" title="点击更换" style="height:30px;width:120px;float:right">
						</div>
						<div class="gap">
							<div class="pretty-box">
								登录角色
								<input name="loginType" type="radio" value="1" id="loginType1" style="margin-left:10px;"/>
								<label for="loginType1">管理员</label>
								<input name="loginType" type="radio" value="2" id="loginType2" style="margin-left:10px;"/>
								<label for="loginType2">用户</label>
							</div>
						</div>
						<div class="gap">
							<div class="pull-right" style="margin-top: 6px">
							</div>
						</div>
						<div class="btn-warp gap">
							<div class="text-center">
								<input type="hidden" value="jsform" id="_app"/>
								<button type="button" onclick="submitForm()" id="submitBtn" class="btn btn-block lgbtn blue">登录</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/common/jquery-1.11.1.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/common/utils/listutils.js?v=26573"></script>
	
<script>
$(document).ready(function(e) {
	changeCode();
	$("#codeImg1").bind("click",changeCode);
});
function genTimestamp(){
	var time = new Date();
	return time.getTime();
}
function changeCode(){
	$("img[name='codeImg']").attr("src","${pageContext.request.contextPath}/validCode/code?t="+genTimestamp());
}
function submitForm(){
	$.ajax({
		type: 'post',
		url: '${pageContext.request.contextPath}/login/sysSubmit',
		data: {
			'imgCode':$('#imgCode').val(),
			'name':$("#name").val(),
			'password':$("#password").val(),
			'loginType':getCheckBoxVal('loginType')
		},
		success: function(result) {
			if(result.code==1){
				var lt = getCheckBoxVal('loginType');
				if(lt=='1'){
					window.location.href="${pageContext.request.contextPath}/admin/index";
				}
				if(lt=='2'){
					window.location.href="${pageContext.request.contextPath}/user/index";
				}
				}else{
				alert(result.msg);
			}
		}
	});
}
$(function(){
})

</script>

</body>
</html>

