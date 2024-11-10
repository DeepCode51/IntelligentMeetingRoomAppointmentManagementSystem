<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="renderer" content="webkit">

<title>智能化会议室预订系统</title>
<meta name="keywords" content="智能化会议室预订系统">
<meta name="description" content="智能化会议室预订系统">

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
</style>
</head>

<body class="bodyClass">

<div id="wrapper">
	<nav class="navbar-default navbar-static-side" role="navigation">
		<div class="sidebar-collapse">
			<ul class="nav" id="side-menu">
				<li style="padding:8px;">
					<a  href="#"><h3 style="color:white;text-align:center">智能化会议室预订系统</h3></a>
				</li>
				<li>
					<a href="javascript:void(0)"><i class="fa fa-edit"></i> <span class="nav-label">个人信息</span><span class="fa arrow"></span></a>
					<ul class="nav nav-second-level">
						<li>
							<a  href="javascript:void(0)" onclick="gotoPage(this)" data-url="${pageContext.request.contextPath}/user/user_msg/detail" >个人信息 </a>
						</li>
					</ul>
					</li><li>
					<a href="javascript:void(0)"><i class="fa fa-edit"></i> <span class="nav-label">会议室查询</span><span class="fa arrow"></span></a>
					<ul class="nav nav-second-level">
						<li>
							<a  href="javascript:void(0)" onclick="gotoPage(this)" data-url="${pageContext.request.contextPath}/user/room_msg" >会议室 </a>
						</li>
					</ul>
					</li><li>
					<a href="javascript:void(0)"><i class="fa fa-edit"></i> <span class="nav-label">会议室预订</span><span class="fa arrow"></span></a>
					<ul class="nav nav-second-level">
						<li>
							<a  href="javascript:void(0)" onclick="gotoPage(this)" data-url="${pageContext.request.contextPath}/user/meeting_order" >会议室预订管理 </a>
						</li>
					</ul>
					</li><li>
					<a href="javascript:void(0)"><i class="fa fa-edit"></i> <span class="nav-label">公告查询</span><span class="fa arrow"></span></a>
					<ul class="nav nav-second-level">
						<li>
							<a  href="javascript:void(0)" onclick="gotoPage(this)" data-url="${pageContext.request.contextPath}/user/notice_msg" >公告 </a>
						</li>
					</ul>
					</li><li>
					<a href="javascript:void(0)"><i class="fa fa-edit"></i> <span class="nav-label">我参与的会议</span><span class="fa arrow"></span></a>
					<ul class="nav nav-second-level">
						<li>
							<a  href="javascript:void(0)" onclick="gotoPage(this)" data-url="${pageContext.request.contextPath}/user/member" >会议列表 </a>
						</li>
					</ul>
					</li><li>
					<a href="javascript:void(0)"><i class="fa fa-edit"></i> <span class="nav-label">签到</span><span class="fa arrow"></span></a>
					<ul class="nav nav-second-level">
						<li>
							<a  href="javascript:void(0)" onclick="gotoPage(this)" data-url="${pageContext.request.contextPath}/user/sign_log" >我的签到 </a>
						</li>
					</ul>
					</li><li>
					<a href="javascript:void(0)"><i class="fa fa-edit"></i> <span class="nav-label">共享文件查询</span><span class="fa arrow"></span></a>
					<ul class="nav nav-second-level">
						<li>
							<a  href="javascript:void(0)" onclick="gotoPage(this)" data-url="${pageContext.request.contextPath}/user/file_share" >共享文件 </a>
						</li>
					</ul>
				</li>
			</ul>
		</div>
	</nav>
	<div id="page-wrapper" class="gray-bg dashbard-1" style="min-height: 935px;">
		<div class="row border-bottom">
			<nav class="navbar navbar-static-top" role="navigation" style="margin-bottom: 0">
				<div class="navbar-header">
					<a class="navbar-minimalize minimalize-styl-2 btn btn-primary " href="#"><i class="fa fa-bars"></i> </a>
				</div>
				<ul class="nav navbar-top-links navbar-right">
					<li>
						<span class="m-r-sm text-muted welcome-message">欢迎您，${login.name}！</span>
					</li>
					<li>
						<a href="javascript:void(0)" onclick="alterPassword()">
							<i class="fa fa-edit"></i> 修改密码
						</a>
					</li>
					<li>
						<a  href="${pageContext.request.contextPath}/login/sys_logout">
							<i class="fa fa-sign-out"></i> 退出
						</a>
					</li>
				</ul>
			</nav>
		</div>
		<div class="row" >
			<div class="content" style="width:100%;">
				<iframe  id="iframeDom" style="position:absolute; width: 100%; height:835px; top: 0;border:0px ;margin-top:60px"   src="${pageContext.request.contextPath}/user/user_msg/detail"></iframe>
			</div>
			<div class="footer">
				<div>
					<strong>Copyright</strong> &nbsp;&nbsp;&nbsp;&nbsp;智能化会议室预订系统
				</div>
			</div>
		</div>
	</div>
</div>
<!-- Mainly scripts -->
<script src="${pageContext.request.contextPath}/static/admin/js/jquery-2.1.1.min.js?t=322"></script>
<script src="${pageContext.request.contextPath}/static/admin/js/bootstrap.min.js?v=3.4.0"></script>
<script src="${pageContext.request.contextPath}/static/admin/js/plugins/metisMenu/jquery.metisMenu.js?t=322"></script>
<script src="${pageContext.request.contextPath}/static/admin/js/plugins/slimscroll/jquery.slimscroll.min.js?t=322"></script>
<!-- Custom and plugin javascript -->
<script src="${pageContext.request.contextPath}/static/admin/js/hplus.js?v=2.2.0"></script>
<script src="${pageContext.request.contextPath}/static/admin/js/plugins/pace/pace.min.js?t=322"></script>

<script type="text/javascript">
$(function(){
});
function gotoPage(e){
	var url = $(e).attr("data-url");
	$('#iframeDom').attr('src', url);
	$("#page-container").removeClass("sidebar-o-xs");
}
function alterPassword(){
	$('#iframeDom').attr('src', '${pageContext.request.contextPath}/alterPwd/alterPassword');
	$("#page-container").removeClass("sidebar-o-xs");
}

</script>

</body>

</html>

