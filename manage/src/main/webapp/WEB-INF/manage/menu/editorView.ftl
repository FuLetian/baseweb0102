<form id="menuEditorFrom" action="${basePath}menu/onSaveOrUpdateMenu">
<table class="table">
	<tr>
		<th>p_id</th>
		<td>
			<select id="menuList" name="pId">
				<#list menus as item>
				<option value="${item.id}" >${item.name}</option>
				</#list>
			</select>
		</td>
	</tr>
	<tr>
		<th>name</th>
		<td>
			<input name="name" value="${menu.name}" />
		</td>
	</tr>
	<tr>
		<th>idx</th>
		<td>
			<input name="idx" value="${menu.idx}" />
		</td>
	</tr>
</table>
</form>

<script>

$(function(){
	
});

function onSubmit(){
	$("#menuEditorFrom").ajaxSubmit(function(){
		location.reload();
	});
	
}
function onClose(){
}
</script>