<!--
商品详情界面
a:html/page2-articleId-${articleId}
-->

<div class="col-xs-8">
	<div class="subject-text1"></div>
	<#list articles as item>
	<div>
		<a href="${global_local_domain}html/page2-articleId-${item.id}.html" class="thumbnail">
		<div class="row">
			<div class="col-xs-3">d</div>
			<div class="col-xs-9">
				<img src="../images/article1.png" alt="${item.name}" class="image-equal-width" />
			</div>
		</div>
		</a>
	</div>
	</#list>
</div>