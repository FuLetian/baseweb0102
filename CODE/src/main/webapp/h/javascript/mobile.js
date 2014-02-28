function listComments(userId,articleId){
	createLoadingMSG();
	$.ajax({
		url:basePath+"mobile-article/comments-list",
		data:{"userId":userId,"articleId":articleId},
		success:function(data){
			$("#tabsContent-info").hide();
			$("#tabsContent-comments").html(data).show();			
		},
		complete:function(){
			$.mobile.loading( "hide" );
		}
	});
}
function listDetailsInfo(){
	$("#tabsContent-comments").hide();
	$("#tabsContent-info").show();
}

function createLoadingMSG(){
    $.mobile.loading( "show", {
        text: "",
        textVisible:false,
        theme: $.mobile.loader.prototype.options.theme,
        textonly: false,
        html: ""
    });
}

function addToBuycar(articleId){
	var count=$("#countInput").val();
	
	 if(!/^[0-9]*$/.test(count)){
	        alert("请输入数字!");
	        return false;
	 }
	 
	 $.getJSON(basePath+"buycar/addItem",{"articleId":articleId,"count":count},function(data){
		 alert("成功加入购物车,请进入购物车查看!");
	 });
}

function plusCount(){
	var count=$("#countInput").val();
	$("#countInput").val(parseInt(count)+1);
}

function minusCount(){
	var count=$("#countInput").val();
	
	if(count>1){
		$("#countInput").val(parseInt(count)-1);
	}
}

function removeBuycarItem(id){
	
	if(!confirm("确定删除吗?")){
		return false;
	}
	
	$.getJSON(basePath+"buycar/removeItem",{"articleId":id},function(data){
		$("#buycar-item-"+id).remove();
		totalMoneyItem();
	});
}

function totalMoneyItem(){
	var $items=$(".moneyItem");
	var total=0;
	$.each($items,function(index,value){
		total=total+parseInt($(value).text());
	});
	
	if(total==0){
		$("#nothingContent").show();
		$("#articleList").hide();
	}else{
		$("#nothingContent").hide();
		$("#articleList").show();
	}
	
	$("#meneyTotal").text(total);
}

function login(){
	$("#loginForm").ajaxSubmit({
		dataType:"json",
		success:function(data){
			if(data.result){
				$("#loginPage").dialog("close");
				$.cookie('key_session_consumer_id',data.consumerId, { expires: 7, path: '/' });
				
			}else{
				alert("账户或密码错误!");
			}
		}
	});
	
	return false;
}

function getLoginConsumerId(){
	var id=$.cookie("key_session_consumer_id");
	if(!id){
		id=0;
	}
	
	return id;
}

function changePage(url){
	$.mobile.changePage(url);
}