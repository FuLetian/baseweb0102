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
			<img id="bigPic" alt="" src="${img.path}" class="image-equal-width"/>
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
			<div class="detail-article-line top-border">
				<dl class="dl-horizontal">
					<dt>数量</dt>
					<dd><input id="articleCount" type="number" value="1"/></dd>
				<dl>
				<div style="width:40%;">
					<a data-bind="click:openBuycarModal" href="#" class="btn btn-primary btn-block">&nbsp;&nbsp;&nbsp;加入购物车&nbsp;&nbsp;&nbsp;</a>
				</div>
			</div>
		</div>
	</div>	
</div>
<!--// article meta -->

<!-- Modal -->
<div class="modal fade" id="detailModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title" id="myModalLabel">Modal title</h4>
      </div>
      <div class="modal-body">
        <div>
			<dl class="dl-horizontal">
			  <dt>已成功加入购物车:</dt>
			  <dd>特仑苏</dd>
			  <dt>数量:</dt>
			  <dd>1</dd>
			  <dt>价钱:</dt>
			  <dd>1</dd>
			</dl>
        </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">继续购物</button>
        <button type="button" class="btn btn-primary">结算</button>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->