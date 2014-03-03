<div class="ui-body-d ui-content">
<#list comments as item>
	<div style="margin-top:10px;">
		<div style="float:left;width:20%;padding:0px 5px 5px 5px;">
			<a href="#purchase" data-rel="popup" data-position-to="window" data-transition="pop"><img src="${item.consumer.thumbnailPath}" class="util-img-equals-width"/></a></div>
		<div style="margin-left:25%;padding:10px 10px 10px 10px;font-size:12px;border:1px solid #D0E4C2;">
			<div style="border-bottom:1px dashed #D0E4C2;">${item.consumer.name}<div style="float:right;">${item.comment.cDt?string("yyyy/MM/dd HH:mm")}</div></div>
			<div>☆☆☆☆☆</div>
			<p class="util-text-popular util-text-indent">${item.comment.content}</p>
		</div>
	</div>
</#list>
</div>

