<!-- 最新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="${basePath}h/javascript/bootstrap/css/bootstrap.min.css">

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="${basePath}h/javascript/jquery-1.9.1.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="${basePath}h/javascript/bootstrap/js/bootstrap.min.js"></script>

<!--knockout-->
<script src="${basePath}h/javascript/knockout-3.0.0.js"></script>

<!--jquery.form-->
<script src="${basePath}h/javascript/jquery.form.js"></script>

<div >

<div class="container" style="width:100%;">
<div class="row">
	<div class="col-md-6">
		<div class="panel panel-primary">
			<div class="panel-heading">检索条件</div>
			<div class="panel-body">
			
				<form id="queryForm" class="form-inline" role="form" action="${basePath}order/query">
				  
				    <div class="radio">
					  <label>
					    <input type="radio" name="runStatus" value="0">刚下单
					  </label>
					</div>
					<div class="radio">
					  <label>
					    <input type="radio" name="runStatus" value="1">正在处理订单
					  </label>
					</div>
					<div class="radio">
					  <label>
					    <input type="radio" name="runStatus" value="2">正在配送
					  </label>
					</div>
					<div class="radio">
					  <label>
					    <input type="radio" name="runStatus" value="3">交易成功
					  </label>
					</div>
					<div class="radio">
					  <label>
					    <input type="radio" name="runStatus" value="4">收藏
					  </label>
					</div>
					<div><a class="btn btn-default" data-bind="click:query">检索</a></div>
				</form>

			</div>
		</div>
	</div>
</div>
</div>

</div>


<div class="container" style="width:100%;">
<div class="row">
	<div class="col-md-12">
		<div class="panel panel-primary">
			<div class="panel-body">
				<table class="table">
					<tr>
						<th>ID</th>
						<th>商品</th>
						<th>用户</th>
						<th>数量</th>
						<th>状态</th>
						<th>下单时间</th>
						<th colspan=4>状态转换</th>
					</tr>
					<tbody data-bind="foreach:items">
						<tr>
							<td data-bind="text:order.id"></td>
							<td data-bind="text:article.name"></td>
							<td data-bind="text:consumer.name"></td>
							<td data-bind="text:order.count"></td>
							<td data-bind="text:order.runStatus==0?'已下单':(order.runStatus==1?'正在处理订单':(order.runStatus==2?'正在配送':(order.runStatus==3?'交易结束':'用户收藏')))"></td>
							<td data-bind="text:order.uDt"></td>
							<td><a href="#" data-bind="visible:order.runStatus<1,click:$root.setRunStatus1">接受订单</a></td>
							<td><a href="#" data-bind="visible:order.runStatus<2,click:$root.setRunStatus2">正在配送</a></td>
							<td><a href="#" data-bind="visible:order.runStatus<3,click:$root.setRunStatus3">交易结束</a></td>
<!-- 							<td><a href="#">[删除]</a></td> -->
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>
</div>

<script>
var Model=function(){
	var self=this;
	self.items=ko.observableArray();
	self.query=function(){
		$("#queryForm").ajaxSubmit({
			dataType:'json',
			success:function(data){
				model.items(data);
			}
		});
	};
	self.setRunStatus1=function(item){
		
		$.ajax({
			url:'${basePath}order/setRunStatus',
			async:true,
			data:{"orderId":item.order.id,"runStatus":1},
			success:function(data){
				remoteItems()
			}
		});
	};
	self.setRunStatus2=function(item){
		
		$.ajax({
			url:'${basePath}order/setRunStatus',
			async:true,
			data:{"orderId":item.order.id,"runStatus":2},
			success:function(data){
				remoteItems()
			}
		});
	};
	self.setRunStatus3=function(item){
		
		$.ajax({
			url:'${basePath}order/setRunStatus',
			async:true,
			data:{"orderId":item.order.id,"runStatus":3},
			success:function(data){
				remoteItems()
			}
		});
		
	};
};
var model=new Model();

$(function(){
	
	ko.applyBindings(model);
	
	remoteItems();
});

function remoteItems(){
	$("#queryForm").ajaxSubmit({
		dataType:'json',
		success:function(data){
			model.items(data);
		}
	});
};

</script>