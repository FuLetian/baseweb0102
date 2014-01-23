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

<div class="container">
<div class="row">
	<div class="col-md-12">
		<button data-bind="click:openModalToEdit">b</button>
	</div>
</div>
<div class="row">
	<div class="col-md-12">
		<table class="table table-bordered table-hover">
			<tr>
				<th>id</th>
				<th>name</th>
				<th>idx</th>
				<th>operation</th>
			</tr>
			
			<tbody data-bind="foreach:items">
			<tr>
				<td data-bind="text:$data.id"></td>
				<td data-bind="text:$data.name"></td>
				<td data-bind="text:$data.idx"></td>
				<td>
					<a href="#" data-bind="click:$parent.onDeleteRecord">delete</a>
					<a href="#" data-bind="click:$parent.onOpenModalToEditView">edit</a>
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
      <div id="modalBody" class="modal-body">
      	<form id="editForm" action="${basePath}channel/onSaveOrUpdateChannel">
      		<table class="table">
      			<tr>
      				<td>name</td>
      				<td><input name="name"></td>
      			</tr>
      			<tr>
      				<td>idx</td>
      				<td>
      					<input name="idx">
      				</td>
      			</tr>
      		</table>
      	</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal" data-bind="click:onCloseModal">Close</button>
        <button type="button" class="btn btn-primary" data-dismiss="modal" data-bind="click:onSubmitModal">Save changes</button>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<script>

$(function(){
	var ChannelModel=function(){
		var self=this;
		self.items=ko.observableArray(${channels});
		
		self.openModalToEdit=function(item){
		
			$("#editForm").clearForm();
			
			$("#editForm > input[type=hidden]").remove();
			$('#myModal').modal();
		}
		self.onCloseModal=function(){
			if(onClose){
				onClose();
			}
		}
		self.onSubmitModal=function(){
			$("#editForm").ajaxSubmit(function(){
				location.reload();
			});
		}
		self.onDeleteRecord=function(item){
		
			var result=confirm("are you sure?");
			if(!result){return false;}
			
			$.ajax({
				url:${basePath}+"channel/delete",
				data:{"channelId":item.id},
				success:function(){
					location.reload();
				}
			});
		}
		self.onOpenModalToEditView=function(item){
			$("#editForm > input[type=hidden]").remove();
			$("#editForm").append("<input type='hidden' name='id' value="+item.id+" >")
			
			$("#editForm input[name='name']").val(item.name);
			$("#editForm input[name='idx']").val(item.idx);
			
			$('#myModal').modal();
		}
	}
	
	ko.applyBindings(new ChannelModel());
});

</script>