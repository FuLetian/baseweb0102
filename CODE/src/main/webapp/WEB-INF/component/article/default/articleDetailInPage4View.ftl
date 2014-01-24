<!-- location -->
<div class="container">
	<div class="row">
		<div class="col-xs-12">
			<div class="location">您现在的位置:</div>
		</div>
	</div>
	
</div>
<!-- //location -->

<!-- article meta -->
<div class="container">
	<div class="row">
		<div class="col-xs-5">
			<img alt="" src="${img.path}" class="image-equal-width"/>
		</div>
		<div class="col-xs-7">
			<div class="detail-title">${a.name}</div>
			<div class="detail-price"><span>￥</span><span class="detail-price-number"><i>${a.price}</i></span>&nbsp;&nbsp;&nbsp;<span class="label label-primary">${a.discount}折</span></div>
			<div class="detail-article-line">
				<dl class="dl-horizontal">
				<#list props0 as item>
				  <dt>${item.name}</dt>
				  <dd>${item.value}</dd>
				</#list>
				  <dt>大众评分</dt>
				  <dd>
				  	<div style="color:red">
				  	<#list grade as item>
				  		<span class="glyphicon glyphicon-star"></span>
				  	</#list>
				  	</div>
				  </dd>
				</dl>
			</div>
			<div class="detail-article-line">
				<a href="#" class="btn btn-primary btn-lg">&nbsp;&nbsp;&nbsp;加入购物车&nbsp;&nbsp;&nbsp;</a>
			</div>
		</div>
	</div>	
</div>
<!--// article meta -->