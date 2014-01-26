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
			self.selectedArticles.push(item);
			
			var count=self.carCount();
			self.carCount(count+1);
			
			var allSelectedArticles=self.selectedArticles();
			var strBuf="[";
			$.each(allSelectedArticles,function(index,value){
				if(index==0){
					strBuf='[{"articleId":'+value.articleId+',"thumbnail":"'+value.thumbnail+'","articleName":"'+value.articleName+'","count":'+value.count+'}';
				}else{
					strBuf+=',{"articleId":'+value.articleId+',"thumbnail":"'+value.thumbnail+'","articleName":"'+value.articleName+'","count":'+value.count+'}';
				}
				
			});
			strBuf+="]";
			$.cookie("localBuyCarKey",strBuf,{expires:7,path:"/",domain:"localhost"});
		};
	}
	var model=new ViewModel();
	
	var localBuycarStr=$.cookie("localBuyCarKey");
	if(!localBuycarStr){
		localBuycarStr="[]";
	}
	console.log("get="+localBuycarStr);
	var localBuycarJSON=$.parseJSON(localBuycarStr);
	model.carCount=ko.observable(localBuycarJSON.length);
	model.selectedArticles=ko.observableArray(localBuycarJSON);
	
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
		
		$.post("http://localhost:8080/baseweb/consumerITF/login",{"account":account,"pwd":pwd},function(data){
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
	
$(function(){
	ko.applyBindings(model);	
	
	$.getJSON("http://localhost:8080/baseweb/commentITF/getComments",{"articleId":1,"userId":1},function(data){
		model.comments(data);
	});
	
});