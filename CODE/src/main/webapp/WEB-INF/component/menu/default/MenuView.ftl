<!-- header -->
<div>
<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
<div class="container">
  <!-- Brand and toggle get grouped for better mobile display -->
  <div class="navbar-header">
    <a class="navbar-brand" href="#"><span class="text-primary">Brand</span></a>
  </div>

  <!-- Collect the nav links, forms, and other content for toggling -->
  <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
    <ul class="nav navbar-nav">
      <li class="active"><a href="${user_domain}">首页</a></li>
    	<#list header_menu_channels as item>
      		<li><a href="page1-channelId-${item.id}.html">${item.name}</a></li>
		</#list>
			<li><a href="#">全部商品</a></li>
    </ul>

	<ul class="nav navbar-nav navbar-right">
		<li id="buycarNavItem" style="border-left:1px solid #E5E3E6;">
			<a id="buycarNavItem"><span class="glyphicon glyphicon-shopping-cart">
				</span>&nbsp;&nbsp;购物车&nbsp;&nbsp;<span data-bind="text:carCount">0</span></a>
			<div id="buyCarContent" class="panel panel-default" style="z-index:500;" align="left">
			  <div class="panel-body" data-bind="foreach:selectedArticles">
					<div class="media">
					  <a class="pull-left" style="width:30%;" data-bind="attr:{'href':'page4-articleId-'+article.id+'.html'}">
					    <img data-bind="attr:{'src':article.homepageImg}" class="media-object" style="width:100%;" alt="...">
					  </a>
					  <div class="media-body">
					    <a data-bind="attr:{'href':'page4-articleId-'+article.id+'.html'}" class="not-underline"><h4 data-bind="text:article.name" class="media-heading" align="left"></h4></a>
					    	<p>数量:<span data-bind="text:count">1</span>
					    		<a href="#" class="pull-right"><span class="glyphicon glyphicon-remove text-danger" data-bind="click:$root.menuViewBuycarDeleteItem"></span></a>
					    	</p>
					  </div>
					</div>
			  </div>
			</div>
		</li>
		<li><div class="all-menu-btn"><a href="#" class="not-underline text-info">所有商品分类</a></div></li>
	</ul>

  </div><!-- /.navbar-collapse -->
 </div>
</nav>
</div>
<!-- //header-menu -->

<!-- header log -->
<div class="container">

<div class="row" align="right">
	<div class="col-md-12" style="font-size:12px;height:25px;">
		<div class="small-nav">
			<div><a  href="#" class="not-underline text-info">联系客服</a></div>
			<div><a href="#" class="not-underline text-info">积分兑换</a></div>
		  	<div>
				<a data-bind="visible:isTourist,click:register" href="#" class="not-underline text-info">注册</a>
				<a data-bind="visible:isConsumer,click:logout" href="#" class="not-underline text-info">退出</a>
		 	 </div>
		  	<div><a href="page6.html" class="not-underline text-info">我的订单</a></div>
		  	<div>
		  		<a data-bind="visible:isTourist,click:openLoginModal" href="#" class="not-underline text-info">登陆</a>
				<span data-bind="visible:isConsumer,text:loginConsumerName" href="#" class="not-underline text-info">2</span>
		  	</div>
		</div>
   </div>
</div>

<!-- logo & buycar count -->
<div class="row">
	<div class="col-md-5" align="left"><img src="${basePath}h/images/vip.png" /></div>
	<div class="col-md-4">
		<div class="pull-left" style="height:30px;width:120px;margin-top:20px;background-repeat: no-repeat;background-image:url('http://localhost:8080/baseweb/h/images/header_corn_new_v1.png');background-position:0px 0px;"></div>
		<div class="pull-left" style="height:30px;width:120px;margin-top:20px;background-repeat: no-repeat;background-image:url('http://localhost:8080/baseweb/h/images/header_corn_new_v1.png');background-position:0px -30px;"></div>
		<div class="pull-left" style="height:30px;width:120px;margin-top:20px;background-repeat: no-repeat;background-image:url('http://localhost:8080/baseweb/h/images/header_corn_new_v1.png');background-position:0px -60px;"></div>
	</div>
</div>

</div>
<!-- //log -->

<!-- <div class="container"> -->
<!-- 	<div class="row"> -->
<!-- 		<div class="col-md-12 bg"> -->
<!-- 			<div style="height:30px;line-height:30px;padding-left:10px;width:100%;border:1px solid #E3007F;margin:5px 0px 5px 0px;"> -->
<!-- 				<p class="text-info" style="font-size:12px;"><span class="glyphicon glyphicon-cloud"></span>&nbsp;&nbsp;&nbsp;&nbsp;哥哥了给和人力和任何好皇天后土好搜噶和他如何让它</p> -->
<!-- 			</div> -->
<!-- 		</div> -->
<!-- 	</div> -->
<!-- </div> -->

<div id="infoContainer" style="border-bottom:1px solid #CCCCCC;border-top:1px solid #CCCCCC;" class="margin-top-line">
	<div class="container">
		<div class="row">
			<div class="col-md-12 text-center" style="height:30px;line-height:30px;">
				<p class="text-info">范围跟顾客非<a href="#"><span id="closeImg" style="margin-top:5px;" class="pull-right glyphicon glyphicon-remove text-info"></span></a></p>
			</div>
		</div>
	</div>
</div>

<div id="allMenus" class="popover fade bottom in" style="display: none;">
	<div class="arrow"></div>
	<h3 class="popover-title">所有商品</h3>
	<div class="popover-content" style="height:400px;width:270px;overflow-y:scroll;padding:0px 10px 10px 10px;">
	
		<#list menus as item>
		<div class="first-menu-title">※${item.menu.name}</div>
		<ul class="all-menu-ul list-inline">
			<#list item.childMenus as item2>
			<li><a href="page2-menuId-${item2.menu.id}.html" class="not-underline text-info">${item2.menu.name}</a></li>
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
      <a id="showFindPwdContainer" href="#" class="text-danger not-underline pull-right" style="margin-top:10px;margin-right:10px;font-size:12px;">忘记密码</a>
    </div>
  </div>
  <div id="findPwd" class="form-group" style="display:none">
    <label for="loginPwd" class="col-sm-4 control-label text-warning">请输入注册邮箱地址:</label>
    <div class="col-sm-5">
      <input id="findPwdByEmail" type="text" class="form-control" placeholder="email">
    </div>
    <div class="col-sm-3">
    	<button id="sendEmail" class="btn btn-danger">发送验证邮件</button>
    </div>
  </div>
  <div id="emailLoginContainer" class="form-group" style="display:none" align="center">
  	<a id="emailLogin" target="_blank" href="#" class="text-success">登陆邮箱>></a>
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
			$(this).hide(500);
			$(".all-menu-btn").removeClass("AllMenuBtnActive");
		});
	<!--// allMenus listener-->

	$(".all-menu-btn").hover(function(){
		
		var allMenuBtn=$(".all-menu-btn");
		var left=allMenuBtn.offset().left;
		var top=allMenuBtn.offset().top;
		$("#allMenus").show().css("left",left-100).css("top",top+50);
		
		$(".all-menu-btn").addClass("AllMenuBtnActive");
	},function(){
	});
	
	$("#closeImg").click(function(){
		$("#infoContainer").hide(500);
		$.getJSON(global_server_domain+"util/setAdFlag",{status:'hide'},function(data){
			
		});
	});
	
	<!--ad-->
	$.getJSON(global_server_domain+"util/getAdFlag",function(data){
		if(data.status=='hide'){
			$("#infoContainer").hide();
		}else if(data.status=='show'){
			$("#infoContainer").show();
		}
	});
	
	$("#buycarNavItem").hover(function(){
		$("#buyCarContent").show();
		$(this).addClass("AllMenuBtnActive");
	},function(){
		$("#buyCarContent").hide(300);
		$(this).removeClass("AllMenuBtnActive");
	});
	
	$("#showFindPwdContainer").click(function(){
		$("#findPwd").show();
		$("#emailLoginContainer").hide();
	});
	
	$("#sendEmail").click(function(){
		var email=$("#findPwdByEmail").val();
		
		if(!email){
			alert("请输入邮箱地址");
			return false;
		}else{
			$.getJSON(global_server_domain+"util/findPwd",{"email":email},function(data){
				if(data.exist){
					$("#emailLogin").attr("href",data.href);
					$("#emailLoginContainer").show();
				}else{
					alert("邮件地址不存在");
				}
			});
		}
	});
	
});

</script>