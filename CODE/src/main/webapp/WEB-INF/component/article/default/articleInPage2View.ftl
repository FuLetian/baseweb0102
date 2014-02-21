<!-- 
当前页面
a:html/page2-brandId- -channelId- -menuId- -priceRange- -discountRange- .html

商品详情界面
a:html/page4-articleId- .html
 -->

<!-- location -->
<div class="container">
	<div class="row">
		<div class="col-md-12">
			<div class="location container text-info">您现在的位置:商品检索</div>
		</div>
	</div>
</div>
<!-- //location -->

<!-- articles -->
<div class="container">
<div class="bar-sort">
	<div data-bind="attr:{'class':(model.page2OrderByType()==0?'btn-sort btn-sort-active-default':'btn-sort')}" onclick="model.page2OrderByType(0);remotePage2Articles();"><label>默认排序</label><span class="glyphicon glyphicon-align-center"></span></div>
	<div data-bind="attr:{'class':(model.page2OrderByType()==1?'btn-sort btn-sort-active-default':'btn-sort')}" onclick="model.page2OrderByType(1);remotePage2Articles();"><label>销量降序</label><span class="glyphicon glyphicon-arrow-down"></span></div>
	<div data-bind="attr:{'class':(model.page2OrderByType()==2?'btn-sort btn-sort-active-default':'btn-sort')}" onclick="model.page2OrderByType(2);remotePage2Articles();"><label>价格升序</label><span class="glyphicon glyphicon-arrow-up"></span></div>
	<div data-bind="attr:{'class':(model.page2OrderByType()==3?'btn-sort btn-sort-active-default':'btn-sort')}" onclick="model.page2OrderByType(3);remotePage2Articles();"><label>折扣升序</label><span class="glyphicon glyphicon-arrow-up"></span></div>
</div>
<div class="row">

<div data-bind="foreach:page2Artricles">
  <div class="col-xs-3">
    <div class="thumbnail">
    <a href="#" data-bind="attr:{'href':'page4-articleId-'+article.id+'.html'}">
      <img data-bind="attr:{'src':article.homepageImg}" alt="...">
     </a>
      <div class="caption">
        <h3 data-bind="text:article.name"></h3>
        <p><span data-bind="text:article.price"></span></p>
        <p><button class="btn btn-primary addToBuyCar" role="button" data-bind="click:addArticeToBuycar">加入购物车</button> 
        	<a href="page5.html" class="btn btn-default" role="button">购买</a></p>
      </div>
    </div>
  </div>
</div>

</div>
</div>
<!-- //articles -->

<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title" id="myModalLabel">您已将[<span class="articleName"></span>]加入购物车</h4>
      </div>
      <div class="modal-body">
        <dl class="dl-horizontal">
		  <dt>...</dt>
		  <dd>...</dd>
		</dl>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

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
        <a href="page5.html" class="btn btn-primary">结算</a>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
