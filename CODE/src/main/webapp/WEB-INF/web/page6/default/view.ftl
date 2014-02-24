<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Page6</title>

<#include "/common/resources.ftl"/>

<script>
var global_server_domain="${global_server_domain}";

window.global_flag_login_validation_enable=true;
</script>

</head>
<body>
	<#include MenuView/>
	
	<div class="container">
		<div class="row">
			<div class="col-md-12" style="font-size:12px;height:40px;">
				<ol class="breadcrumb">
				  <li>Bootstrap</li>
				  <li>我的订单</li>
				  <li class="active">全部订单</li>
				</ol>
			</div>
		</div>
	</div>
	
	<div class="container">
		<div class="row">
			<div class="col-md-2">
				<div class="panel panel-default">
				  <!-- group -->
				  <div class="panel-heading"><b>服务保障</b></div>

						<div class="list-group">
							<a href="#" class="list-group-item active" onclick="remoteHasBuyArticles();triggerActiveItem(this);">全部订单与收藏</a>
						  <a href="#" class="list-group-item" onclick="remoteHasBuyArticles(2);triggerActiveItem(this);">正在配送</a>
						  <a href="#" class="list-group-item" onclick="remoteHasBuyArticles(1);triggerActiveItem(this);">订单正在处理</a>
						  <a href="#" class="list-group-item" onclick="remoteHasBuyArticles(0);triggerActiveItem(this);">已下单</a>
						  <a href="#" class="list-group-item" onclick="remoteHasBuyArticles(3);triggerActiveItem(this);">购买成功</a>
						  <a href="#" class="list-group-item" onclick="remoteHasBuyArticles(4);triggerActiveItem(this);">收藏夹</a>
						</div>
				  <!--// group -->
				</div>
			</div>
			<div class="col-md-10">
				<div class="panel panel-default">
				  <!-- group -->
				  <div class="panel-heading"><b>服务保障</b></div>
					<div class="panel-body">
					
					<div style="height:500px;overflow-y:scroll;">
						<table class="table">
							<tr>
								<th>商品名字</th>
								<th>单价</th>
								<th>数量</th>
								<th>价格</th>
								<th>下单时间</th>
								<th>操作</th>
							</tr>
							<tbody data-bind="foreach:hasBuyArticles">
								<tr>
									<td data-bind="text:article.name"></td>
									<td data-bind="text:article.price"></td>
									<td data-bind="text:order.count"></td>
									<td data-bind="text:(article.price*order.count)"></td>
									<td data-bind="text:order.cDt"></td>
									<td>
										<a href="#" data-bind="click:$root.page6_btn_showDetail_action">查看</a>
										<a href="#" data-bind="click:$root.page6_btn_action_delete,visible:$root.page6_btn_delete_visible">删除</a>
										<a href="#" data-bind="click:$root.page6_btn_action_buy,visible:$root.page6_btn_buy_visible">购买</a>
									</td>
								</tr>
							</tbody>
						</table>
					</div>
						
					</div>				  
				</div>
			</div>
		</div>
	</div>
	
	
	
	<#include FooterView/>
	
	

<!-- Modal -->
<div class="modal fade" id="detailModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title" id="myModalLabel">Modal title</h4>
      </div>
      <div class="modal-body">
      <form id="articleCommentForm" action="${basePath}page6/setComment" method="POST">
        <table class="table">
        	<tr>
        		<th>商品名称</th>
        		<td data-bind="text:page6_detail_data().article.name"></td>
        	</tr>
        	<tr>
        		<th>单价</th>
        		<td data-bind="text:page6_detail_data().article.price"></td>
        	</tr>
        	<tr>
        		<th>数量</th>
        		<td data-bind="text:page6_detail_data().order.count"></td>
        	</tr>
        	<tr>
        		<th>价格</th>
        		<td data-bind="text:page6_detail_data().article.price*page6_detail_data().order.count"></td>
        	</tr>
        	<tr>
        		<th>下单时间</th>
        		<td data-bind="text:page6_detail_data().order.uDt"></td>
        	</tr>
        	<tr data-bind="visible:page6_detail_data().order.runStatus==3">
        		<th>评分</th>
        		<td>
        			<a href="#"><span id="star1" index="1" class="glyphicon glyphicon-star-empty"></span></a>
        			<a href="#"><span id="star2" index="2" class="glyphicon glyphicon-star-empty"></span></a>
        			<a href="#"><span id="star3" index="3" class="glyphicon glyphicon-star-empty"></span></a>
        			<a href="#"><span id="star4" index="4" class="glyphicon glyphicon-star-empty"></span></a>
        			<a href="#"><span id="star5" index="5" class="glyphicon glyphicon-star-empty"></span></a>
        		</td>
        	</tr>
        	<tr data-bind="visible:page6_detail_data().order.runStatus==3">
        		<th>评论内容</th>
        		<td>
        			<input type="hidden" name="grade" id="grade" value="0">
        			<input type="hidden" name="articleId" data-bind="value:page6_detail_data().article.id">
        			<input type="hidden" name="consumerId" data-bind="value:page6_data_loginConsumerId()">
        			<textarea name="content" data-bind="text:page6_detail_data().comment.content" rows="" cols="60"></textarea>
        		</td>
        	</tr>
        	<tr data-bind="visible:page6_detail_data().order.runStatus==3">
        		<th>回复内容</th>
        		<td>
        			<div class="panel">
        				<div class="panel-body" data-bind="text:page6_detail_data().comment.replyContent"></div>
        			</div>
        		</td>
        	</tr>
        	
        </table>
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary" data-bind="click:page6_btn_action_setComment">提交评论</button>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<script>
function triggerActiveItem(self){
	$(".list-group-item").removeClass("active");
	$(self).addClass("active");
}
$(function(){
	$(".glyphicon").hover(function(){
		var self=$(this);
		var index=self.attr("index");
		
		$(".glyphicon").removeClass("glyphicon-star").addClass("glyphicon-star-empty");
		$("#grade").val(index);
		while(index>0){
			$("#star"+index).removeClass("glyphicon-star-empty").addClass("glyphicon-star");
			index=index-1;
		}
	},function(){});
});
</script>
</body>
</html>