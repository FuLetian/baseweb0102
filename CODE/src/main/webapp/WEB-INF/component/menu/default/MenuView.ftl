<style>
.all-menu-btn{color:#FFFFFF;font-size:14px;text-align:center;float:right;width:150px;height:50px;line-height:50px;border-left:1px solid #E5E3E6;border-right:1px solid #E5E3E6;}
.all-menu-content{width:20px;height:100px;float:right;}
.AllMenuBtnActive{background-color:#FFFFFF;color:#E02284;}
.all-menu-ul li{height:30px;line-height:30px;}
.first-menu-title{color:#E5288A;font-size:12px;margin-top:10px;font-weight:bold;}
</style>
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
		<div id="buyCar" class="buy-car"><span class="glyphicon glyphicon-shopping-cart"></span>&nbsp;&nbsp;购物车<span data-bind="text:carCount" class="buy-car-count">0</span></div>
		<div id="buyCarContent" style="z-index:500;" align="left">
			<div class="panel panel-default">
			  <div class="panel-heading">Panel heading without title</div>
			  <div class="panel-body" data-bind="foreach:selectedArticles">
					<div class="media">
					  <a class="pull-left" href="#" style="width:30%;">
					    <img data-bind="attr:{'src':thumbnail}" class="media-object" style="width:100%;" alt="...">
					  </a>
					  <div class="media-body">
					    <h4 data-bind="text:articleName" class="media-heading" align="left">Media heading</h4>
					    	<p>数量:<span data-bind="text:count">1</span></p>
					  </div>
					</div>
			  </div>
			</div>
		</div>
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
    <div class="all-menu-btn"><label>所有商品分类</label></div>

</div>
</div>
</div>
</div>
<!-- //header-menu -->

<div id="allMenus" class="popover fade bottom in" style="display: none;">
	<div class="arrow"></div>
	<h3 class="popover-title">A Title</h3>
	<div class="popover-content" style="height:400px;width:270px;overflow-y:scroll;padding:0px 10px 10px 10px;">
	
		<#list menus as item>
		<div class="first-menu-title">${item.menu.name}</div>
		<ul class="all-menu-ul list-inline">
			<#list item.childMenus as item2>
			<li><a href="#">${item2.menu.name}</a></li>
			</#list>
		</ul>
		</#list>
		
	</div>
</div>
<script>
$(function(){

	<!--allMenus listener-->
		$("#allMenus").mouseleave(function(){
			$(this).hide();
		});
	<!--// allMenus listener-->

	$(".all-menu-btn").hover(function(){
		
		var allMenuBtn=$(".all-menu-btn");
		var left=allMenuBtn.offset().left;
		var top=allMenuBtn.offset().top;
		$("#allMenus").show().css("left",left-100).css("top",top+50);
		
		$(".all-menu-btn").addClass("AllMenuBtnActive");
	},function(){
		$(".all-menu-btn").removeClass("AllMenuBtnActive");
	});
	
});
</script>