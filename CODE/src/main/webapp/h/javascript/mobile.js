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