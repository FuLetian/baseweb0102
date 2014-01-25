	function ViewModel(){
		var self=this;
		
		//articleComment
		self.comments=ko.observableArray();
		
		//articleDetail
		self.openBuycarModal=function(){
			$("#detailModal").modal();
			
			var item=[];
			item.articleId=1;
			item.thumbnail="http://localhost:8080/baseweb/images/icon-user.jpg";
			item.articleName="name";
			item.count=3;
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
			$.cookie("localBuyCarKey",strBuf);
		}
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
	
$(function(){
	ko.applyBindings(model);	
	
	$.getJSON("http://localhost:8080/baseweb/commentITF/getComments",{"articleId":1,"userId":1},function(data){
		model.comments(data);
	});
	
});