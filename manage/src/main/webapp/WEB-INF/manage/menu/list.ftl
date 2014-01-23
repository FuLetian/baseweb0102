<div class="container">
<div class="row">
	<div class="col-md-12">
		<button data-bind="click:openModalToCreateRecord">b</button>
	</div>
</div>
<div class="row">
	<div class="col-md-12">
		<table class="table table-bordered table-hover">
			<tr>
				<th>ID</th>
				<th>NAME</th>
				<th>P_ID</th>
				<th>IDX</th>
				<th>operation</th>
			</tr>
			<tbody data-bind="foreach:menus">
			<tr>
				<td data-bind="text:$data.id"></td>
				<td data-bind="text:$data.name"></td>
				<td data-bind="text:$data.pId"></td>
				<td data-bind="text:$data.idx"></td>
				<td>
					<a href="#" data-bind="click:$parent.detailRecord"><span>编辑</span></a>
					<a href="#" data-bind="click:$parent.removeRecord"><span>删除</span></a>
				</td>
			</tr>
			</tbody>
		</table>
	</div>
</div>
</div>

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

<script>
$(function(){
	function MenuViewModel(){
		var self=this;
		self.menus=ko.observableArray(${menus});
		self.removeRecord=function(menu){
		
			var result=confirm("确认删除吗?");
			if(!result){
				return false;
			}
			$.ajax({
				url:'${basePath}menu/removeItem',
				data:{"id":menu.id},
				success:function(data){
					if(data=="SUCCESS"){
						self.menus.remove(menu);
					}else{
						alert("删除失败");
					}
				}
			});
		}
		
		self.openModalToCreateRecord=function(){
		
			$('#myModal').modal();
			$("#modalBody").load('${basePath}menu/getMenuEditorView');
		}
		
		self.onCloseModal=function(){
			if(onClose){
				onClose();
			}
		}
		self.onSubmitModal=function(){
			if(onSubmit){
				onSubmit();
			}
		}
		self.detailRecord=function(menu){
			$('#myModal').modal();
			$("#modalBody").load('${basePath}menu/getMenuEditorView?menuId='+menu.id);
		}
	}
	
	ko.applyBindings(new MenuViewModel());
});
</script>