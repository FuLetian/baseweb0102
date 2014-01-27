	function ViewModel(){
		var self=this;
		
		//articleComment
		self.comments=ko.observableArray();
		
		//articleDetail
		self.openBuycarModal=function(){
			$("#detailModal").modal();
			
			var item=[];
			item.articleId=1;
			item.thumbnail=$("#bigPic").attr("src");;
			item.articleName=$(".detail-title").text();
			item.count=$("#articleCount").val();
			
			//至session
			$.getJSON(global_server_domain+"buycar/addItem",{"articleId":item.articleId,"count":item.count},function(data){
				self.selectedArticles(data);
			});
		};
	}
	var model=new ViewModel();

	model.selectedArticles=ko.observableArray();
	model.carCount=ko.computed(function(){
		var count= model.selectedArticles().length;
		return count;
	});
	
	/**
	 * menuView 与登录相关
	 */
	var loginConsumerId=$.cookie("loginConsumerId");
	var loginConsumerName=$.cookie("loginConsumerName");
	if(loginConsumerId){
		model.isTourist=ko.observable(false);
	}else{
		model.isTourist=ko.observable(true);
	}
	model.loginConsumerName=ko.observable(loginConsumerName);
	model.isConsumer=ko.computed(function(){
		return !model.isTourist();
	},this);
	model.openLoginModal=function(){
		
		$("#loginModal").modal();
	};
	model.login=function(){
		var account=$("#loginText").val();
		var pwd=$("#loginPwd").val();
		
		$.post(global_server_domain+"/consumerITF/login",{"account":account,"pwd":pwd},function(data){
			if(data.result){
				model.isTourist(false);
				model.loginConsumerName(data.account);
				$("#loginModal").modal("toggle");
				
				$.cookie("loginConsumerId",data.consumerId);
				$.cookie("loginConsumerName",data.account);
				$.cookie("loginConsumerUserId",data.userId);
			}else{
				$("#loginResultFeedback").text("账户或密码错误");
			}
		},"json");
	};
	model.logout=function(){
		var result=confirm("确认退出吗?");
		if(result){
			$.cookie("loginConsumerId",null);
			$.cookie("loginConsumerName",null);
			model.isTourist(true);
		}
	};
	
	/**
	 * menuView 注册
	 */
	model.onThumbnailUpload=function(){
		//上传头像
		$("#thumbnailForm").ajaxSubmit({
			dataType:'json',
			success:function(data){
				if(data.result){
					$("#thumbnailImg").attr("src",data.path);
					$("input[name='thumbnailPath']").val(data.path);
				}
			}
		});
	};
	model.register=function(){
		$("#registerModal").modal();
	};
	model.onRegister=function(){
		
		$("#registerForm").ajaxSubmit({
			dataType:"json",
			success:function(data){
				if(data.result){
					model.isTourist(false);
					model.loginConsumerName(data.account);
					$("#registerModal").modal("toggle");
					
					$.cookie("loginConsumerId",data.consumerId);
					$.cookie("loginConsumerName",data.account);
					$.cookie("loginConsumerUserId",data.userId);
				}
			}
		});
	};
	
	/**
	 * 购物车
	 */
	model.consumerOrderInfo=ko.observable({"address":"","consumerId":1,"email":"","name":"","phoneNum":""});
	model.deleteItem=function(articleDTO){
		$.getJSON(global_server_domain+"buycar/removeItem",{"articleId":articleDTO.article.id},function(data){
			model.selectedArticles(data);
		});
	};
	model.isAutoSetConsumerInfo=ko.observableArray(["1"]);
	model.setConsumerInfo=ko.computed(function(){
		var d=model.isAutoSetConsumerInfo();
		
		if(d.length==1){
			var loginConsumerId=$.cookie("loginConsumerId");
			$.getJSON(global_server_domain+"consumerITF/getLoginConsumerInfo",{"consumerId":loginConsumerId},function(data){
				model.consumerOrderInfo(data);
			});
		}
	});
	model.onSaveOrder=function(){
		var d=model.selectedArticles();
		var d2=model.consumerOrderInfo();
		var loginConsumerId=$.cookie("loginConsumerId");
		if(!loginConsumerId){
			loginConsumerId=1;
		}
		var _remark=$("#remark").val();
		
		if(d.length==0){
			alert("您的购物车还是空的呢!");
			return false;
		}
		
		$.each(d,function(index,value){
			var json={"articleId":value.article.id,"count":value.count,"name":d2.name,"address":d2.address,"phoneNum":d2.phoneNum,"email":d2.email,"consumerId":loginConsumerId};
			$.post(global_server_domain+"buycar/addOrder",json,function(data){
			});
		});
		
		$("#saveOrderSuccessModal").modal();
	};
	
	/**
	 * page3
	 */
	
	
$(function(){
	ko.applyBindings(model);
	
	remoteBuycar();
	
	$.getJSON("http://localhost:8080/baseweb/commentITF/getComments",{"articleId":1,"userId":1},function(data){
		model.comments(data);
	});
	
});

function remoteBuycar(){
	/**
	 * 与服务器session同步购物车数据
	 */
	$.getJSON(global_server_domain+"buycar/getBuycar",function(data){
		model.selectedArticles(data);
	});
}