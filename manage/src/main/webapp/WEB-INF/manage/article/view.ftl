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
<table class="table">
	<tr>
		<th>id</th>
		<th>name</th>
		<th>price</th>
		<th>discount</th>
		<th>idx</th>
		<th>operation</th>
	</tr>
	
	<tbody data-bind="foreach:articles">
		<td data-bind="text:id"></td>
		<td data-bind="text:name"></td>
		<td data-bind="text:price"></td>
		<td data-bind="text:discount"></td>
		<td data-bind="text:idx"></td>
		<td>
			<a href="#" data-bind="click:$parent.onEdit">edit</a>
			<a href="#" data-bind="click:$parent.onDelete">delete</a>
		</td>
	</tbody>
</table>
</div>
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
      <div id="modalBody" class="modal-body"></div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal" data-bind="click:onCloseModal">Close</button>
        <button type="button" class="btn btn-primary" data-dismiss="modal" data-bind="click:onSubmitModal">Save changes</button>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<script>
	$(function(){
		var ViewModel=function(){
			var self=this;
			self.articles=ko.observableArray(${articles});
			self.openModalToAdd=function(){
				$("#myModal").modal();
				$("#modalBody").load("${basePath}article/editor?id=0");
			}
			self.onCloseModal=function(){}
			self.onSubmitModal=function(){
				onSaveArticle();
			}
			self.onEdit=function(item){
				$("#myModal").modal();
				$("#modalBody").load("${basePath}article/editor?id="+item.id);
			}
			self.onDelete=function(item){
				$.ajax({
					url:"${basePath}article/delete",
					data:{"id":item.id},
					success:function(){
						location.reload();
					}
				});
			}
		}
		
		ko.applyBindings(new ViewModel());
	});
	
</script>