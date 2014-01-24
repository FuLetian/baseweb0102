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
      	<form id="editForm" action="${basePath}brand/onSaveOrUpdate">
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
				success:function(data){
					location.reload();
				}
			});
		}
		self.openModalToAdd=function(){
			$("input[name='id']").val("0");
			$("#myModal").modal();
		}
		self.edit=function(item){
			$("input[name='id']").val(item.id);
			$("input[name='name']").val(item.name);
			$("input[name='idx']").val(item.idx);
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