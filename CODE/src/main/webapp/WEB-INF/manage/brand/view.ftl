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

<div class="container">
<div class="row">
	
	<table class="table">
		<tr>
			<td>id</td>
			<td>name</td>
			<td>type</td>
			<td>idx</td>
			<td>operation</td>
		</tr>
		<tbody data-bind="foreach:brands">
			<tr>
				<td data-bind="text:id"></td>
				<td data-bind="text:name"></td>
				<td data-bind="text:type"></td>
				<td data-bind="text:idx"></td>
				<td>
					<a href="#" data-bind="click:$parent.edit">edit</a>
					<a href="#" data-bind="click:$parent.delete">delete</a>
				</td>
			</tr>
		</tbody>
	</table>
</div>
</div>
<button data-bind="click:openModalToAdd">add</button>
<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title" id="myModalLabel">Modal title</h4>
      </div>
      <div id="modalBody" class="modal-body">
      	<form id="editForm" action="${basePath}util/upload" method="POST" enctype="multipart/form-data">
      		<input type="hidden" name="id" value="0">
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
      			<tr>
      				<td>thumbnails</td>
      				<td>
      					<input name="imgFile" type="file">
      					<img id="thumbnailImg" style="width:450px;">
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
	var BrandModel=function(){
		var self=this;
		
		self.brands=ko.observableArray(${brands});
		
		self.onCloseModal=function(){}
		
		self.onSubmitModal=function(){
			
			$("#editForm").ajaxSubmit({
				dataType:'json',
				success:function(data){
					
					var path=data.path;
					$("#editForm").append("<input type='hidden' name='thumbnail' value='"+path+"'>").ajaxSubmit({
						url:'${basePath}brand/onSaveOrUpdate',
						type:'GET',
						//data:{'name':name,'idx':idx,'thumbnail':path},
						success:function(data){
							$(this).clearForm();
							location.reload();
						}
					});
				}
			});
			return false;
		}
		self.openModalToAdd=function(){
			$("input[name='id']").val("0");
			$("#myModal").modal();
		}
		self.edit=function(item){
			$("input[name='id']").val(item.id);
			$("input[name='name']").val(item.name);
			$("input[name='idx']").val(item.idx);
			$("#thumbnailImg").attr("src",item.thumbnail);
			$("#myModal").modal();
		}
		self.delete=function(item){
			
			$.ajax({
				url:"${basePath}brand/delete",
				data:{"id":item.id},
				success:function(data){
					self.brands.remove(item);				
				}
			});
		}
	}
	
	ko.applyBindings(new BrandModel());
</script>