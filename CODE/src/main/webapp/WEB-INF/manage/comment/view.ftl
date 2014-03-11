<!-- 最新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="${basePath}h/javascript/bootstrap-google/css/bootstrap.min.css">

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="${basePath}h/javascript/jquery-1.9.1.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="${basePath}h/javascript/bootstrap-google/js/bootstrap.min.js"></script>

<!--knockout-->
<script src="${basePath}h/javascript/knockout-3.0.0.js"></script>

<!--jquery.form-->
<script src="${basePath}h/javascript/jquery.form.js"></script>

<script>

var Model=function(){
	var self=this;
	
	self.items=ko.observableArray();
	
	self.details=function(item){
		//alert(item.comment.id);
		$("#detailModal").modal();
		self.details_item(item);
	}
	
	self.details_item=ko.observable();
	
	self.saveReplyContent=function(){
		var content=$("#replyContent").val();
		$.getJSON("${basePath}comment/setContent",{"commentId":self.details_item().comment.id,"replyContent":content},function(data){
			alert("回复成功");
		});
	}
};
var model=new Model();

$(function(){
	ko.applyBindings(model);
	romoteItems();
});

function romoteItems(){
	$.getJSON("${basePath}comment/getItems",function(data){
		model.items(data);		
	});
}
</script>

<table class="table">
	<tr>
		<th>ID</th>
		<th>grade</th>
		<th>content</th>
		<th>consumer</th>
		<th>article name</th>
		<th>date</th>
		<th>操作</th>
	</tr>
	<tbody data-bind="foreach:items">
		<td data-bind="text:comment.id"></td>
		<td data-bind="text:comment.grade"></td>
		<td data-bind="text:comment.content"></td>
		<td data-bind="text:consumer.name"></td>
		<td data-bind="text:article.name"></td>
		<td data-bind="text:comment.uDt"></td>
		<td>
			<a href="#" data-bind="click:$root.details">details</a>
		</td>
	</tbody>
</table>

<!-- Modal -->
<div class="modal fade" id="detailModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title" id="myModalLabel">Modal title</h4>
      </div>
      <div id="modalBody" class="modal-body">
      
			<div class="tabbable tabs-left"> <!-- Only required for left/right tabs -->
			  <ul class="nav nav-tabs">
			    <li class="active"><a href="#tab1" data-toggle="tab">商品</a></li>
			    <li><a href="#tab2" data-toggle="tab">评论</a></li>
			    <li><a href="#tab3" data-toggle="tab">会员</a></li>
			  </ul>
			  <div class="tab-content">
			    <div class="tab-pane active" id="tab1">
			      <table class="table">
			      	<tr>
			      		<td>id</td>
			      		<td data-bind="text:details_item()==null?'':details_item().article.id"></td>
			      	</tr>
			      	<tr>
			      		<td>名字</td>
			      		<td data-bind="text:details_item()==null?'':details_item().article.name"></td>
			      	</tr>
			      	<tr>
			      		<td colspan=2>
			      			<img data-bind="attr:{'src':details_item()==null?'':details_item().article.homepageImg}" style="width:100%;"/>
			      		</td>
			      	</tr>
			      </table>
			    </div>
			    <div class="tab-pane" id="tab2">
			      <table class="table">
			      	<tr>
			      		<td>id:</td>
			      		<td data-bind="text:details_item()==null?'':details_item().comment.id"></td>
			      	</tr>
			      	<tr>
			      		<td>评分:</td>
			      		<td data-bind="text:details_item()==null?'':details_item().comment.grade"></td>
			      	</tr>
			      	<tr>
			      		<td>内容:</td>
			      		<td data-bind="text:details_item()==null?'':details_item().comment.content"></td>
			      	</tr>
			      	<tr>
			      		<td>回复:</td>
			      		<td>
			      			<textarea id="replyContent" rows="" cols="" data-bind="value:details_item()==null?'':details_item().comment.replyContent"></textarea>
			      		</td>
			      	</tr>
			      </table>
			    </div>
			    <div class="tab-pane" id="tab3">
			      <table class="table">
			      	<tr>
			      		<td>id:</td>
			      		<td data-bind="text:details_item()==null?'':details_item().consumer.id"></td>
			      	</tr>
			      	<tr>
			      		<td>name:</td>
			      		<td data-bind="text:details_item()==null?'':details_item().consumer.name"></td>
			      	</tr>
			      </table>
			    </div>
			  </div>
			</div>

      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary" data-dismiss="modal" data-bind="click:saveReplyContent">Save changes</button>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->