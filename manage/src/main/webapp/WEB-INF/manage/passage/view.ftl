<!-- 最新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="http://cdn.bootcss.com/twitter-bootstrap/3.0.3/css/bootstrap.min.css">

<!-- 可选的Bootstrap主题文件（一般不用引入） -->
<link rel="stylesheet" href="http://cdn.bootcss.com/twitter-bootstrap/3.0.3/css/bootstrap-theme.min.css">

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="//code.jquery.com/jquery-1.10.2.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="http://cdn.bootcss.com/twitter-bootstrap/3.0.3/js/bootstrap.min.js"></script>

<!--knockout-->
<script src="${basePath}javascript/knockout-3.0.0.js"></script>

<!--jquery.form-->
<script src="${basePath}javascript/jquery.form.js"></script>

<!-- Single button -->
<div class="btn-group">
  <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
    Action <span class="caret"></span>
  </button>
  <ul class="dropdown-menu" role="menu">
    <li><a href="#" onclick="setId(1);">正品保障</a></li>
    <li><a href="#" onclick="setId(2);">7*24小时服务</a></li>
    <li><a href="#" onclick="setId(3);">退货退款流程</a></li>
    <li><a href="#" onclick="setId(4);">保障范围</a></li>
    <li class="divider"></li>
    <li><a href="#" onclick="setId(5);">导购演示</a></li>
    <li><a href="#" onclick="setId(6);">订单操作</a></li>
    <li><a href="#" onclick="setId(7);">会员注册</a></li>
    <li><a href="#" onclick="setId(8);">会员等级</a></li>
    <li class="divider"></li>
    <li><a href="#" onclick="setId(9);">支付方式</a></li>
    <li><a href="#" onclick="setId(10);">货到付款</a></li>
    <li><a href="#" onclick="setId(11);">配送范围及运费</a></li>
    <li><a href="#" onclick="setId(12);">验货与验收</a></li>
    <li class="divider"></li>
    <li><a href="#" onclick="setId(13);">退货政策</a></li>
    <li><a href="#" onclick="setId(14);">退货流程</a></li>
    <li><a href="#" onclick="setId(15);">退货方式及时效</a></li>
  </ul>
</div>

<form id="editorForm" action="${basePath}passage/onUpdate" method="post" enctype="multipart/form-data">
<input id="hidden_id" type="hidden" name="passageNum" value="1">
<textarea id="editor_id" name="text" style="width:100%;height:500px;"></textarea>
</form>
<button data-bind="click:onPreview">preview</button>

<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title" id="myModalLabel">Modal title</h4>
      </div>
      <div id="modalBody" class="modal-body"></div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal" data-bind="click:onCloseModal">Close</button>
        <button type="button" class="btn btn-primary" data-dismiss="modal" data-bind="click:onSubmitModal">Save changes</button>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<script charset="utf-8" src="${basePath}editor/kindeditor.js"></script>
<script charset="utf-8" src="${basePath}editor/lang/zh_CN.js"></script>
<script>
KindEditor.ready(function(K) {
        window.editor = K.create('#editor_id',{
        	    uploadJson : '${basePath}util/upload',
                fileManagerJson : '../asp.net/file_manager_json.ashx',
                allowFileManager : false
        });
});

function setId(num){
	$("#hidden_id").val(num);
	
	$.ajax({
		url:'${basePath}passage/getPassage',
		data:{'passageNum':num},
		success:function(data){
			window.editor.html(data);
		}
	});
}

$(function(){

var ViewModel=function(){
	var self=this;
	
	self.onPreview=function(){
		var html=window.editor.html();
		$("#editor_id").val(html);
		$("#modalBody").html(html);
		$('#myModal').modal();
	}
	
	self.onCloseModal=function(){}
	
	self.onSubmitModal=function(){
		$("#editorForm").ajaxSubmit();
	}
}

ko.applyBindings(new ViewModel());

});
</script>