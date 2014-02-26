function ViewModel(){};
var model=new ViewModel();

model.menus=ko.observableArray();
model.navToMenus=function(){
	romoteMenus(function(){
		$.mobile.changePage("#channelListPage");
	});
};

$(function(){
	ko.applyBindings(model);
});

function romoteMenus(callback){
	
	if(model.menus.length>0){
		callback();
		return;
	}
	
	$.getJSON(basePath+"phone-homepage/menus",{userId:1},function(data){
		model.menus(data);
		callback();
	});
}