	function ViewModel(){
		var self=this;
		
		//articleComment
		self.comments=ko.observableArray();
		
		//articleDetail
		self.openBuycarModal=function(){
			$("#detailModal").modal();
			
			var item=[];
			item.articleId=1;
			item.thumbnail=$("#bigPic").attr("src");
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
	model.menuViewBuycarDeleteItem=function(o){
		$.getJSON(global_server_domain+"buycar/removeItem",{"articleId":o.article.id},function(data){
			model.selectedArticles(data);
		});
	};
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
	model.loginConsumerName=ko.observable("欢迎您,"+loginConsumerName);
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
				
				$.cookie("loginConsumerId",data.consumerId,{"path":"/"});
				$.cookie("loginConsumerName",data.account,{"path":"/"});
				$.cookie("loginConsumerUserId",data.userId,{"path":"/"});
			}else{
				$("#loginResultFeedback").text("账户或密码错误");
			}
		},"json");
	};
	model.logout=function(){
		var result=confirm("确认退出吗?");
		if(result){
			$.cookie("loginConsumerId",null,{"path":"/"});
			$.cookie("loginConsumerName",null,{"path":"/"});
			$.cookie("loginConsumerUserId",null,{"path":"/"});
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
	model.isAutoSetConsumerInfo=ko.observableArray();
	model.setConsumerInfo=function(){
		var d=model.isAutoSetConsumerInfo();
		if(d.length==1){
			var loginConsumerId=$.cookie("loginConsumerId");
			$.getJSON(global_server_domain+"consumerITF/getLoginConsumerInfo",{"consumerId":loginConsumerId},function(data){
				model.consumerOrderInfo(data);
			});
		}
	};
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
	 * page2
	 * 商品筛选
	 */
	model.page2Artricles=ko.observableArray();
	model.page2MenuId=ko.observable();
	model.page2BrandId=ko.observable();
	model.page2PriceRange=ko.observable();
	model.page2ChannelId=ko.observable();
	model.page2DiscountRange=ko.observable();
	model.page2OrderByType=ko.observable(0);
	
	self.addArticeToBuycar=function(articleThumbnailDTO){
		$("#detailModal").modal();
		var item={};
		try{
			item.articleId=articleThumbnailDTO.article.id;
			item.thumbnail=articleThumbnailDTO.img.path;;
			item.articleName=articleThumbnailDTO.article.name;
			item.count=1;
		}catch(e){
			
		}
		//至session
		$.getJSON(global_server_domain+"buycar/addItem",item,function(data){
			model.selectedArticles(data);
		});
	};
	
	self.onMakeOrderForm=function(){
		$("#makeOrderForm").modal();
	};
	
	/**
	 * page6
	 */
	model.hasBuyArticles=ko.observableArray();//已买到的商品 ,run_status = 3
	model.page6_runStatus=ko.observable(2);
	model.page6_btn_buy_visible=ko.computed(function(){
		var v=model.page6_runStatus();
		if(v==4){
			return true;
		}
		
		return false;
	});
	model.page6_btn_delete_visible=ko.computed(function(){
		var v=model.page6_runStatus();
		if(v==0||v==3||v==4){
			return true;
		}
		
		return false;
	});
	model.page6_detail_data=ko.observable({
        "article": {
            "brandId": 1, 
            "cDt": "2014/01/24 14:45:03", 
            "channelId": 1, 
            "discount": 100, 
            "id": 1, 
            "idx": 1, 
            "menuId": 1, 
            "name": "12", 
            "price": 13333, 
            "saleCount": 0, 
            "uDt": "2014/01/24 14:45:03", 
            "userId": 1
        }, 
        "comment": {
            "articleId": 1, 
            "cDt": "2014/02/05 14:33:59", 
            "consumerId": 1, 
            "content": "content", 
            "grade": 5, 
            "id": 1, 
            "replyContent": "reply", 
            "uDt": "2014/01/24 14:33:32", 
            "userId": 1
        }, 
        "order": {
            "articleId": 1, 
            "cDt": "2014/01/27 16:54:26", 
            "consumerId": 1, 
            "count": 3, 
            "id": 1, 
            "remark": "", 
            "runStatus": 0, 
            "uDt": "2014/01/27 16:54:26"
        }
    });
	model.page6_data_loginConsumerId=ko.observable();
	model.page6_btn_showDetail_action=function(item){
		model.page6_detail_data(item);
		$("#detailModal").modal();
		
		var grade=model.page6_detail_data().comment.grade;
		if(grade){
			while(grade>0){
				$("#star"+grade).removeClass("glyphicon-star-empty").addClass("glyphicon-star");
				grade=grade-1;
			}
		}
	};
	model.page6_btn_action_setComment=function(){
		var loginConsumerId=$.cookie("loginConsumerId");
		model.page6_data_loginConsumerId(loginConsumerId);
		
		$("#articleCommentForm").ajaxSubmit(function(data){
			alert("感谢您的支持!");
		});
	};
	model.page6_btn_action_delete=function(item){
		var result=confirm("确定要删除吗?");
		
		if(result){
			model.hasBuyArticles.remove(item);
			$.getJSON(global_server_domain+"page6/delete",{"orderId":item.order.id},function(data){
			});
		}
	};
	model.page6_btn_action_buy=function(item){
		model.hasBuyArticles.remove(item);
		$.getJSON(global_server_domain+"page6/setRunStatus",{"orderId":item.order.id,"runStatus":0},function(data){
		});
	};
	
$(function(){
	ko.applyBindings(model);
	
	remoteBuycar();
	
	remotePage2Articles();
	
	if(window.global_flag_login_validation_enable){
		//初始化时检验是否已登录，若未登录启用login窗口
		remoteHasBuyArticles();
	}
	
	$.getJSON(global_server_domain+"commentITF/getComments",{"articleId":1,"userId":1},function(data){
		model.comments(data);
	});
	
});

function remoteHasBuyArticles(runStatus){

	model.page6_runStatus(runStatus);
	var loginConsumerId=$.cookie("loginConsumerId");
	if(!loginConsumerId){
		model.openLoginModal();
		return false;
	}
	$.getJSON(global_server_domain+"page6/getOrderByRunStatus",{"runStatus":runStatus,"consumerId":loginConsumerId},function(data){
		model.hasBuyArticles(data);
	});
};

function remoteBuycar(){
	/**
	 * 与服务器session同步购物车数据
	 */
	$.getJSON(global_server_domain+"buycar/getBuycar",function(data){
		model.selectedArticles(data);
	});
}

function remotePage2Articles(){
	var param={};
	
	try{
		if(page2_menu_id){
			model.page2MenuId(page2_menu_id);
		}
	}catch(e){}
	param.menuId=model.page2MenuId();
	param.brandId=model.page2BrandId();
	param.channelId=model.page2ChannelId();
	param.discountRange=model.page2DiscountRange();
	param.priceRange=model.page2PriceRange();
	param.orderByType=model.page2OrderByType();
	
	
	$.getJSON(global_server_domain+"page2/query",param,function(data){
		model.page2Artricles(data);
	});
}