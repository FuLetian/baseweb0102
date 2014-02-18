<form id="dataForm" action="${basePath}article/onSaveOrUpdate" method="POST">
<table class="table">
<tr>
	<th>name</th>
	<td>
		<input type="hidden" name="id" value="${id}">
		<input type="hidden" name="homepageImg" value="0">
		<input name="name" value="${article.name}"></td>
</tr>
<tr>
	<th>price</th>
	<td><input name="price" value="${article.price}"></td>
</tr>
<tr>
	<th>discount</th>
	<td><input name="discount" value="${article.discount}"></td>
</tr>
<tr>
	<th>idx</th>
	<td><input name="idx" value="${article.idx}"></td>
</tr>
<tr>
	<th>brand</th>
	<td>
		<select name="brandId">
			<#list brands as item>
				<option value="${item.id}">${item.name}</option>
			</#list>
		</select>
	</td>
</tr>
<tr>
	<th>menu</th>
	<td>
		<select name="menuId">
			<#list menus as item>
				<option value="${item.id}">${item.name}</option>
			</#list>
		</select>
	</td>
</tr>
<tr>
	<th>channel</th>
	<td>
		<select name="channelId">
			<#list channels as item>
				<option value="${item.id}">${item.name}</option>
			</#list>
		</select>
	</td>
</tr>
<tr>
	<th>property</th>
	<td>
		<input id="propName">
		<input id="propValue"><a href="#" onclick="addProp(0);">add0</a>
		<a href="#" onclick="addProp(1);">add1</a>
		<ul id="propUl">
			<#list properties as p>
			<li>${p.name}:${p.value}</li>
			</#list>
		</ul>
	</td>
</tr>
</table>
</form>

<form id="uploadForm" action="${basePath}util/upload" method="post" enctype="multipart/form-data">
<table class="table">
<tr>
	<th>images</th>
	<td>
		<input type="hidden" name="dir" value="1">
		<input type="checkbox" name="extra" value="1">
		<input type="file" name="imgFile"><input type="button" onclick="uploadImg();"  value="add">
	</td>
</tr>
<tr>
	<th>首页图片</th>
	<td>
		<div id="homepageImgContainer"><img src="${article.homepageImg}"/></div>
	</td>
</tr>
<tr>
<td colspan=2>
<div id="imgPreview" class="row">
	<#list imgs as item>
		<div class="col-sm-6"><img src="${item.path}" style="width:100%;" /></div>
	</#list>
</div>
</td>
</tr>
</table>
</form>
<script>

function onSaveArticle(){
	$("#dataForm").ajaxSubmit({
		url:"${basePath}article/onSaveOrUpdate",
		success:function(data){
			location.reload();
		}
	});
}

function addProp(type){
	var $name=$("#propName");
	var $value=$("#propValue");
	
	$("#propUl").append("<li>"+$name.val()+":"+$value.val()+"</li>");
	appendHiddenInput("properties",$name.val()+"-"+$value.val()+"-"+type);
	
	$name.val("");
	$value.val("");
}

function uploadImg(){
	$("#uploadForm").ajaxSubmit({
		url:"${basePath}util/upload",
		dataType:'json',
		success:function(data){
			
			var path=data.path;
			var tmp=path.replace(/\//g,"-");
			
			if(data.extra&&data.extra==1){
				//设置为homepage img
				$("#homepageImgContainer").html("<img style=\"width:100%;\" src=\""+path+"\" />");
				$("input[name='homepageImg']").val(path);
				alert($("input[name='homepageImg']").length);
			}else{
				appendHiddenInput("imgs",tmp);
				$("#imgPreview").append("<div class=\"col-sm-6\"><img style=\"width:100%;\" src=\""+path+"\" /></div>");
			}
			
		}
	});
}

function appendHiddenInput(name,value){
	var $input=$("input[name='"+name+"']");
	var length=$input.length;
	
	if(length==0){
		$("#dataForm").append("<input type='hidden' name='"+name+"' value='"+value+"' >");
	}else{
		var origin=$input.val();
		$input.val(origin+","+value);
	}
}

$(function(){
	$("input[name='menuId']").val("${article.menuId}");
	$("input[name='brandId']").val("${article.brandId}");
	$("input[name='channelId']").val("${article.channelId}");
	
});

</script>