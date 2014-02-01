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
		<li>
			<a data-bind="visible:isTourist,click:openLoginModal" class="btn btn-primary btn-xs">登陆</a>
			<span data-bind="visible:isConsumer,text:loginConsumerName">2</span>
			</li>
		<li>
			<a data-bind="visible:isTourist,click:register" class="btn btn-default btn-xs">注册</a>
			<a data-bind="visible:isConsumer,click:logout" class="btn btn-default btn-xs">退出</a>
			</li>
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
					    <h4 data-bind="text:article.name" class="media-heading" align="left">Media heading</h4>
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
    	<#list header_menu_channels as item>
      		<li><a href="#">${item.name}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a></li>
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

<!-- Modal 注册-->
<div class="modal fade" id="registerModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title" id="myModalLabel">Modal title</h4>
      </div>
      <div class="modal-body">
      
<form id="thumbnailForm" class="form-horizontal" role="form" action="${basePath}util/upload" method="POST" enctype="multipart/form-data">

  <div class="form-group">
    <label for="i7" class="col-sm-2 control-label">头像</label>
    <div class="col-sm-10">
		<div class="media">
		  <a class="pull-left" href="#">
		    <img id="thumbnailImg" class="media-object" src="http://localhost:8080/baseweb/images/icon-user.jpg" alt="...">
		  </a>
		  <div class="media-body">
		  	<input type="file" name="imgFile"/>
		  	<input type="hidden" name="userId" value="${global_user_id}">
		  </div>
		</div>
    </div>
  </div>
  
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button data-bind="click:onThumbnailUpload" type="submit" class="btn btn-default">register</button>
    </div>
  </div>
  
</form>

<form id="registerForm" class="form-horizontal" role="form" action="${basePath}consumerITF/register" method="POST">

  <div class="form-group">
    <label for="i2" class="col-sm-2 control-label">真实姓名</label>
    <div class="col-sm-10">
      <input id="i2" name="realName" type="text" class="form-control">
      <input name="userId" type="hidden" value="${global_user_id}">
      <input name="thumbnailPath" type="hidden" value="">
    </div>
  </div>
  
  <div class="form-group">
    <label for="i3" class="col-sm-2 control-label">密码</label>
    <div class="col-sm-10">
      <input id="i3" name="pwd1" type="text" class="form-control">
    </div>
  </div>
  
  <div class="form-group">
    <label for="i4" class="col-sm-2 control-label">确认密码</label>
    <div class="col-sm-10">
      <input id="i4" name="pwd2" type="text" class="form-control">
    </div>
  </div>
  
  <div class="form-group">
    <label for="i5" class="col-sm-2 control-label">电话号码</label>
    <div class="col-sm-10">
      <input id="i5" name="phoneNum" type="text" class="form-control">
    </div>
  </div>
  
  <div class="form-group">
    <label for="i6" class="col-sm-2 control-label">收货地址</label>
    <div class="col-sm-10">
      <input id="i6" name="address" type="text" class="form-control">
    </div>
  </div>
  
  <div class="form-group">
    <label for="i7" class="col-sm-2 control-label">Email</label>
    <div class="col-sm-10">
      <input id="i7" name="email" type="text" class="form-control" id="inputEmail3" placeholder="Email">
    </div>
  </div>

  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button data-bind="click:onRegister" type="submit" class="btn btn-default">register</button>
    </div>
  </div>

</form>

      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<!-- Modal -->
<div class="modal fade" id="loginModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title" id="myModalLabel">Modal title</h4>
      </div>
      <div class="modal-body">

<form class="form-horizontal" role="form">
  <div class="form-group">
	<div id="loginResultFeedback" class="text-danger"></div>
  </div>
  <div class="form-group">
    <label for="loginText" class="col-sm-2 control-label">Email</label>
    <div class="col-sm-10">
      <input id="loginText" type="text" class="form-control" placeholder="Email">
    </div>
  </div>
  
  <div class="form-group">
    <label for="loginPwd" class="col-sm-2 control-label">Password</label>
    <div class="col-sm-10">
      <input id="loginPwd" type="password" class="form-control" placeholder="Password">
    </div>
  </div>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button data-bind="click:login" type="submit" class="btn btn-default">Sign in</button>
    </div>
  </div>
</form>

      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

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