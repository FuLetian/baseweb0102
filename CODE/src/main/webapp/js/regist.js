function initRegist(qnToken,basePath){
	
	var bgImgLink,logoImgLink;
	
	var option1 = {
			"uptoken":qnToken,
			"browse_button":"bg_img_upload_btn",
			"init":{
				"FileUploaded":function(up, file, info){
					var domain = up.getOption('domain');
		            var res = $.parseJSON(info);
		            var sourceLink = domain + "/" + res.key;
		            bgImgLink = sourceLink;
		            $("#imgBg").val(sourceLink);
				}
			}
	};
	
	var option2 = {
			"uptoken":qnToken,
			"container":"container2",
			"browse_button":"bg_logo_upload_btn",
			"init":{
				"FileUploaded":function(up, file, info){
					var domain = up.getOption('domain');
		            var res = $.parseJSON(info);
		            var sourceLink = domain + "/" + res.key;
		            logoImgLink = sourceLink;
		            $("#imgLogo").val(sourceLink);
				}
			}
	};
	
	var uploader1 = loadQiniu(option1);
	var uploader2 = loadQiniu(option2);
		  
	var options = {      
	   beforeSubmit: function showRequest(formData, jqForm, options){  
		   //formData: 数组对象，提交表单时，Form插件会以Ajax方式自动提交这些数据，格式如：[{name:user,value:val },{name:pwd,value:pwd}]  
		   //jqForm:   jQuery对象，封装了表单的元素     
		   //options:  options对象  
		   if($("#name").val().length == 0){
			   alert("请输入名字");
			   return false;
		   }
		   if($("#phone").val().length == 0){
			   alert("请输入电话号码");
			   return false;
		   }
		   if($("#password").val().length == 0){
			   alert("请输入密码");
			   return false;
		   }
		   if($("#password2").val() != $("#password").val()){
			   alert("两次密码输入不一致");
			   return false;
		   }
		   
		   if($("#imgLogo").val().length == 0){
			   alert("请上传logo");
			   return false;
		   }
		   
		   if($("#imgBg").val().length == 0){
			   alert("请上传背景图");
			   return false;
		   }
		   
		   if($("#info").val().length == 0){
			   alert("请输入商品商家介绍");
			   return false;
		   }
		   return true;  //只要不返回false，表单都会提交,在这里可以对表单元素进行验证  
		},  //提交前的回调函数  
	   success: function (responseText, statusText){  
		   //dataType=xml  
			if(responseText.success == "1"){
				alert("注册成功");
				window.location.href = basePath + "wechat-business/page-login";
			}else{
				alert(responseText.errMsg);
			}
		},      //提交后的回调函数
	   //url: url,                 //默认是form的action， 如果申明，则会覆盖  
	   //type: type,               //默认是form的method（get or post），如果申明，则会覆盖  
	   dataType: "json",           //html(默认), xml, script, json...接受服务端返回的类型  
	   //clearForm: true,          //成功提交后，清除所有表单元素的值  
	   //resetForm: true,          //成功提交后，重置所有表单元素的值  
	   timeout: 3000               //限制请求的时间，当请求大于3秒后，跳出请求  
	}  
	  
	$("#registForm").ajaxForm(options);
}