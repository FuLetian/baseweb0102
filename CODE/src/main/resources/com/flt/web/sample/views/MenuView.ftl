<div class="list-group">
	<#list menuView_menus as menu>
		 <a href="#" class="list-group-item" onclick="loadWorkspace('${menu.id}')">${menu.title}</a>
	</#list>
</div>
<script>

function loadWorkspace(id){
	$("#workspace").load("/baseweb/sample/loadWorkspace/"+id);
}
</script>