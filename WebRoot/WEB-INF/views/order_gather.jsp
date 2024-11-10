<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="renderer" content="webkit">

<title>预订走势</title>
<meta name="keywords" content="预订走势">
<meta name="description" content="预订走势">

<link href="${pageContext.request.contextPath}/static/admin/css/bootstrap.min.css?v=3.4.0" rel="stylesheet">
<link href="${pageContext.request.contextPath}/static/admin/font-awesome/css/font-awesome.css?v=4.3.0" rel="stylesheet">

<!-- Morris -->
<link href="${pageContext.request.contextPath}/static/admin/css/plugins/morris/morris-0.4.3.min.css?t=322" rel="stylesheet">

<!-- Gritter -->
<link href="${pageContext.request.contextPath}/static/admin/js/plugins/gritter/jquery.gritter.css?t=322" rel="stylesheet">

<link href="${pageContext.request.contextPath}/static/admin/css/animate.css?t=322" rel="stylesheet">
<link href="${pageContext.request.contextPath}/static/admin/css/style.css?v=2.2.0" rel="stylesheet">
<script type="text/javascript" src="${pageContext.request.contextPath}/static/datetime/4.8/skin/WdatePicker.css"></script>

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
		<h2>预订走势</h2>
	</div>
	<div class="col-lg-2">
	</div>
</div>
<div class="gray-bg dashbard-1" style="height:758px">
	<div class="row">
		<div class="col-lg-12">
			<div class="ibox float-e-margins">
				<div class="ibox-title">
					<h5>预订走势</h5>
				</div>
				<div class="ibox-content">
					<div class="col-lg-4"  style="margin-top:4px">
						<label>创建时间</label>
						<div style="height:40px;">
							<div style="width:49%;float:left">
								<input type="text" class="form-control  Wdate"  readonly="readonly"  value=""  onFocus="WdatePicker({startDate: '%y-%M-%d' ,dateFmt:'yyyy-MM-dd',alwaysUseStartDate: true })"  placeholder="请输入开始日期" id="meCreateTime1">
							</div>
							<div style="width:49%;float:left;margin-left:2%">
								<input type="text" class="form-control  Wdate"  readonly="readonly"  value=""  onFocus="WdatePicker({startDate: '%y-%M-%d' ,dateFmt:'yyyy-MM-dd',alwaysUseStartDate: true })"  placeholder="请输入结束日期" id="meCreateTime2">
							</div>
						</div>
					</div>
					<div class="col-lg-1">
						<label style="visibility: hidden;display:block">1</label>
						<button type="button" onclick="orderGather();" class="btn btn-primary">查询</button>
					</div>
					<div id="orderGather" style="width:  90%;height:500px;margin-top:60px;"></div>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- Mainly scripts -->
<script src="${pageContext.request.contextPath}/static/admin/js/jquery-2.1.1.min.js?t=322"></script>
<script src="${pageContext.request.contextPath}/static/admin/js/bootstrap.min.js?v=3.4.0"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/common/utils/listutils.js?v=3401"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/common/echarts/echarts.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/datetime/4.8/WdatePicker.js"></script>

<script type="text/javascript">
$(function(){
	orderGather();
});
function orderGather() {
	showLoading('${pageContext.request.contextPath}/static/common/loading.gif');
	$.ajax({
		type : 'get',
		url : "${pageContext.request.contextPath}/commonapi/orderGatherSubmit",
		data : {
			'mecreateTime1':$('#meCreateTime1').val(),
		'mecreateTime2':$('#meCreateTime2').val()	},
		success : function(result) {
			hideLoading();
			var myChart = echarts.init(document.getElementById('orderGather'));
			var option = {
				title : {
					text: '预订走势',
					subtext: '预订走势'
				},
				tooltip : {
					trigger: 'axis'
				},
				legend: {
					data:['预订走势']
				},
				toolbox: {
					show : false,
					feature : {
						mark : {show: true},
						magicType : {
							show: true,
							type: ['line', 'bar'],
							title:['转为折线图','转为柱状图']
						},
						saveAsImage : {
							show: true,
							title :'保存为图片'
						}
					}
				},
				calculable : true,
				xAxis : [
				{
					type : 'category',
					boundaryGap : false
				}
				],
				yAxis : [
				{
					type : 'value',
					axisLabel : {
						formatter: '{value} '
					}
				}
				],
				series : [
				{
					name:'预订走势',
					type:'line',
					markPoint : {
						data : [
						{type : 'max', name: '最大值'},
						{type : 'min', name: '最小值'}
						]
					},
					markLine : {
						data : [
						{type : 'average', name: '平均值'}
						]
					}
				}
				]
			};
			var rsList1X=[];
			var rsList1Y=[];
			for(var i=0;i<result.createTimeXList.length;i++){
				rsList1X.push(result.createTimeXList[i]);
			}
			rsList1X.sort((a, b) => a - b);
			for(var i=0;i<rsList1X.length;i++){
				var isFound=0;
				for(var j=0;j<result.rsList1.length;j++){
					if(result.rsList1[j].col2==rsList1X[i]){
						rsList1Y.push(result.rsList1[j].col1);
						isFound=1;
					}
				}
				if(isFound==0){
					rsList1Y.push(0);
				}
			}
			option.xAxis[0].data=rsList1X;
			option.series[0].data=rsList1Y;
			myChart.setOption(option);
		}
	});
}
function gotoPage(e){
	var url = $(e).attr("data-url");
	window.location.href=url;
}

</script>

</body>

</html>

