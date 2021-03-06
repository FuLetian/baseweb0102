<!-- 最新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="${basePath}javascript/bootstrap/dist/css/bootstrap.min.css">

<!-- 可选的Bootstrap主题文件（一般不用引入） -->
<link rel="stylesheet" href="${basePath}javascript/bootstrap/dist/css/bootstrap-theme.min.css">

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="${basePath}javascript/jquery-1.9.1.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="${basePath}javascript/bootstrap/dist/js/bootstrap.min.js"></script>

<!--knockout-->
<script src="${basePath}javascript/knockout-3.0.0.js"></script>

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
    <li><a onclick="load(${res1});" href="#">Action</a></li>
    <li><a onclick="load(${res2});" href="#">Another action</a></li>
    <li><a onclick="load(${res3});" href="#">Something else here</a></li>
  </ul>
</div>

<form action="${basePath}serviceAndPromise/update" method="POST">
	<input type="hidden" name="num" value="1">
	res1:<input name="text" value="${res1}"><input type="submit" value="submit">
</form>

<script>
function load(id){
	$("input[name='num']").val(id);
	
	$.ajax({
		url:"${basePath}serviceAndPromise/getText",
		data:{"num":id},
		success:function(data){
			$("input[name='text']").val(data);
		}
	});
}
</script>