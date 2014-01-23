<!-- header log -->
<div class="header-logo border container">
<div class="row" align="right">
	<ul class="list-inline header-logo-ul">
		<li>welcome to my world</li>
		<li><a class="btn btn-primary btn-xs">登陆</a></li>
		<li><a class="btn btn-default btn-xs">注册</a></a></li>
		<li>
			<div class="btn-group" align="left">
			  <button class="btn btn-default btn-xs dropdown-toggle" type="button" data-toggle="dropdown">
			    我的订单<span class="caret"></span>
			  </button>
			  <ul class="dropdown-menu">
			    <li><a href="#">已买到商品</a></li>
			    <li><a href="#">已下单商品</a></li>
			    <li><a href="#">已收藏商品</a></li>
			    <li class="divider"></li>
			    <li><a href="#">送货追踪</a></li>
			  </ul>
			</div>
		</li>
		<li><button class="btn btn-default btn-xs">积分兑换</button></li>
		<li><button class="btn btn-default btn-xs">联系客服</button></li>
	</ul>
</div>
<div class="row">
	<div class="col-xs-6"><img src="../images/vip.png" /></div>
	<div class="col-xs-6" align="right">
		<div id="buyCar" class="buy-car"><span class="glyphicon glyphicon-shopping-cart"></span>&nbsp;&nbsp;购物车<span class="buy-car-count">0</span></div>
		<div id="buyCarContent" style="z-index:500;">gggb</div>
	</div>
</div>
</div>
<!-- //header log -->

<!-- header -->
<div class="header-main-bg">
<div class="container border">
<div class="row">
<div class="col-xs-12">
    <ul class="header-menu nav navbar-nav navbar-left">
    	<#list menus as item>
      		<li><a href="#">${item.menu.name}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a></li>
		</#list>
    </ul>
</div>
</div>
</div>
</div>
<!-- //header-menu -->