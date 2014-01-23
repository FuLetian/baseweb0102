$(function(){
	
	//排序按钮hover监听
	$(".btn-sort").hover(function(e){
		$(this).addClass("btn-sort-active");
	},function(){
		$(this).removeClass("btn-sort-active");
	});
	
	//【加入购物车】按钮
	$(".addToBuyCar").click(function(){
		$("#myModal").modal();
	});
	
	//homepage
	
	$("#buyCarContent").css('position','absolute').css("left",270).hide();
	
	$("#buyCar").hover(function(){
		$("#buyCarContent").show("normal");
	},function(){
		$("#buyCarContent").hide();
	});
});