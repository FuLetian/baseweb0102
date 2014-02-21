<!-- location -->
<div class="container">
	<div class="row">
		<div class="col-xs-12">
			<div class="location text-info">商品参数:</div>
		</div>
	</div>
	
</div>
<!-- //location -->

<!-- article parameters -->
<div class="container">
	<div class="row">
		<div class="col-xs-12 article-param">
			<dl class="dl-horizontal">
			<#list props as item>
			  <dt>${item.name}</dt>
			  <dd>${item.value}</dd>
			</#list>
			</dl>
		</div>
	</div>
</div>
<!--// article parameters -->