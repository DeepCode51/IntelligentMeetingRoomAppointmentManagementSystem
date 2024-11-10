<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="renderer" content="webkit">

<title>用户</title>
<meta name="keywords" content="用户">
<meta name="description" content="用户">

<link href="${pageContext.request.contextPath}/static/admin/css/bootstrap.min.css?v=3.4.0" rel="stylesheet">
<link href="${pageContext.request.contextPath}/static/admin/font-awesome/css/font-awesome.css?v=4.3.0" rel="stylesheet">

<!-- Morris -->
<link href="${pageContext.request.contextPath}/static/admin/css/plugins/morris/morris-0.4.3.min.css?t=322" rel="stylesheet">

<!-- Gritter -->
<link href="${pageContext.request.contextPath}/static/admin/js/plugins/gritter/jquery.gritter.css?t=322" rel="stylesheet">

<link href="${pageContext.request.contextPath}/static/admin/css/animate.css?t=322" rel="stylesheet">
<link href="${pageContext.request.contextPath}/static/admin/css/style.css?v=2.2.0" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/page/myPagination.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/selectsearch/jquery.searchableSelect.css" />

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

td{
text-align:center
}
td >div{
display:inline
}
th{
text-align:center
}
#batchUpdate{
width:40%
}
video{
width:200px !important;
}
audio{
width:200px !important;
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
		<h2>用户</h2>
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
					<div class="row">
						<div class="col-lg-2">
							<label>登录名</label>
							<input type="text" class="form-control" value="" placeholder="请输入登录名" id="loginName" >
						</div>
						<div class="col-lg-2">
							<label>姓名</label>
							<input type="text" class="form-control" value="" placeholder="请输入姓名" id="realName" >
						</div>
						<div class="col-lg-2">
							<label>用户类型</label>
							<select  id="userType"  class="form-control">
								<option value="">全部</option>
								<c:forEach items="${userTypeList}" var="item">
									<option value="${item.id}">${item.name}</option>
								</c:forEach>
							</select>
						</div>
						<div class="col-lg-2">
							<label>所属部门</label>
							<select  id="departId" style="height:30px;width:200px"  >
								<option value="">全部</option>
								<c:forEach items="${departMsgList}" var="item">
									<option value="${item.id}">${item.name}</option>
								</c:forEach>
							</select>
						</div>
						<div class="col-lg-1">
							<label style="visibility: hidden;display:block">1</label>
							<button type="button" onclick="ajaxList(1);" class="btn btn-primary">查询</button>
						</div>
					</div>
					<div class="row"  style="margin-top:5px;padding-left: 15px;">
						<a href="${pageContext.request.contextPath}/admin/user_msg/add" class="btn btn-primary">新增</a>
					</div>
					<div class="row" style="margin-top:5px;margin-bottom:5px;padding-left: 15px;">
					</div>
					<div class="row" style="margin-top:5px;margin-bottom:5px;padding-left: 15px;"></div>
					<div class="table-responsive">
						<table class="table  table-striped table-bordered  table-hover">
							<thead>
								<tr>
									<th>登录名</th>
									<th>密码</th>
									<th>姓名</th>
									<th>联系电话</th>
									<th>邮箱</th>
									<th>性别</th>
									<th>用户类型</th>
									<th>所属部门</th>
									<th>职位名</th>
									<th>创建时间</th>
									<th style="width:200px;">操作</th>
								</tr>
							</thead>
							<tbody  id="user_msg_body">
							</tbody>
						</table>
						<div id="user_msg_bar" class="pagination" style="margin-top:20px;"></div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- Mainly scripts -->
<script src="${pageContext.request.contextPath}/static/admin/js/jquery-2.1.1.min.js?t=322"></script>
<script src="${pageContext.request.contextPath}/static/admin/js/bootstrap.min.js?v=3.4.0"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/page/myPagination.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/common/utils/listutils.js?v=2246"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/selectsearch/jquery.searchableSelect.js"></script>

<script>
$(function(){
	$('#departId').next().remove();
	$('#departId').searchableSelect();
	$(".searchable-select").css("width","100%");
	$(".searchable-select").css("height","35px");
	$(".searchable-select-holder").css("min-height","20px");
	$(".searchable-select-holder").css("height","35px");
	$(".searchable-select").css("min-width","40px");
	ajaxList(1);
});
var currentPage=1;
function ajaxList(page) {
	currentPage=page;
	var loginName = $("#loginName").val();
	var realName = $("#realName").val();
	var userType = $("#userType").val();
	var departId =$('#departId').val();
	var countRs = ajaxCount();
	if(countRs.totalPage<page){
		page = countRs.totalPage;
	}
	showLoading('${pageContext.request.contextPath}/static/common/loading.gif');
	$.ajax({
		type : 'get',
		url : "${pageContext.request.contextPath}/admin/user_msg/queryList",
		data : {
			"page":page,
			"loginName":loginName,
			"realName":realName,
			"userType":userType,
			"departId":departId
		},
		success : function(result) {
			hideLoading();
			var rows = result.list;//得到数据列
			var total = countRs.count;//得到数据总数
			var totalPage=countRs.totalPage;
			var html = '';
			for (var i = 0; i < rows.length; i++) {
				html += '<tr>' ;
				var loginNameVal=setNullToEmpty(rows[i].userMsg.loginName);
				html+='<td>'+ loginNameVal+'</td>';
				var passwordVal=setNullToEmpty(rows[i].userMsg.password);
				html+='<td>'+ passwordVal+'</td>';
				var realNameVal=setNullToEmpty(rows[i].userMsg.realName);
				html+='<td>'+ realNameVal+'</td>';
				var celPhoneVal=setNullToEmpty(rows[i].userMsg.celPhone);
				html+='<td>'+ celPhoneVal+'</td>';
				var emailVal=setNullToEmpty(rows[i].userMsg.email);
				html+='<td>'+ emailVal+'</td>';
				var sexVal=setNullToEmpty(rows[i].sexStr);
				html+='<td>'+sexVal+'</td>';
				var userTypeVal=setNullToEmpty(rows[i].userTypeStr);
				html+='<td>'+userTypeVal+'</td>';
				var departIdVal=setNullToEmpty(rows[i].departIdStr);
				html+='<td>'+ departIdVal+'</td>';
				var jobNameVal=setNullToEmpty(rows[i].userMsg.jobName);
				html+='<td>'+ jobNameVal+'</td>';
				var createTimeVal=setNullToEmpty(rows[i].userMsg.createTime);
				html+='<td>'+ createTimeVal+'</td>';
				html+='<td>';
				html+='<a href="${pageContext.request.contextPath}/admin/user_msg/update?id='+rows[i].userMsg.id+'" class="btn btn-success btnStyle">修改</a>';
				html+='<a href="javascript:void(0)" onclick="del(this)" data-id="'+rows[i].userMsg.id+'" class="btn btn-danger btnStyle">删除</a>';
				html+='</td>';
				html+='</tr>';
			}
			if (rows.length == 0) {
				html += '<tr><td></td><td></td><td></td><td></td><td></td><td>无数据</td><td></td><td></td><td></td><td></td><td></td></tr>';
			}
			$("#user_msg_body").html(html);
			new myPagination({
				id: 'user_msg_bar',
				curPage:page, //初始页码
				pageTotal:totalPage, //总页数
				pageAmount: 10,  //每页多少条
				dataTotal: total, //总共多少条数据
				pageSize: 10, //可选,分页个数
				showPageTotalFlag:true, //是否显示数据统计
				showSkipInputFlag:false, //是否支持跳转
				getPage: function (page) {
					ajaxList(page);
				}
			})
		}
	});
}
function ajaxCount() {
	var rs = null;
	var loginName = $("#loginName").val();
	var realName = $("#realName").val();
	var userType = $("#userType").val();
	var departId =$('#departId').val();
	$.ajax({
		type : 'get',
		url : "${pageContext.request.contextPath}/admin/user_msg/queryCount",
		async: false,
		data : {
			"loginName":loginName,
			"realName":realName,
			"userType":userType,
			"departId":departId
		},
		success : function(result) {
			rs = result;
		}
	});
	return rs;
}
function del(e){
	if(window.confirm('你确定要删除该用户吗')){
		var id = $(e).attr("data-id");
		$.ajax({
			type : 'get',
			url : "${pageContext.request.contextPath}/admin/user_msg/del",
			data : {
				"id":id
			},
			success : function(result) {
				alert(result.msg);
				if(result.code==1){
					ajaxList(currentPage);
				}
			}
		});
		return true;
		}else{
		return false;
	}
}
function downLoadFile(e){
	var url = $(e).attr("file-url");
	window.open(url);
}
function gotoPage(e){
	var url = $(e).attr("data-url");
	window.location.href=url;
}

</script>

</body>

</html>

