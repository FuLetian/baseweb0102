package com.flt.common.view;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;

import com.flt.common.annotation.View;
import com.flt.common.config.Configuration;
import com.flt.dao.model.User;


public class PageWrapper {
	
	private BasePage page;
	
	private Map<String, Object> root;
	
	public PageWrapper(BasePage page,Map<String, Object> root,User user) {
		// TODO Auto-generated constructor stub
		this.page=page;
		this.root=root;
		this.root.put("global_user_id", user.getId());
		this.root.put("global_local_domain", user.getDomain());
		this.root.put("global_server_domain", Configuration.getProp("db.server.domain"));
	}
	
	public void addView(BaseView view){
		
		view.setUserId(page.getUserId());
		
		String viewName=this.subObjectName(view);
		String template=this.getPageTemplate(view);
		
		root.put(viewName, template);
		
		view.setRoot(root);
		view.render();
	}
	
	public void addView(BaseView view,String attributeName){
		
		String template=this.getPageTemplate(view);
		
		root.put(attributeName, template);
		
		view.setRoot(root);
		view.render();
	}
	
	public String getTargetHtmlName(){
		String p="Page1View_ChannelView_component/channel/default//channelView.ftl_activeChannelId_0_channels_[com.flt.dao.model.Channel@689d8408].html";
		String pageName=this.subObjectName(page);
		
		if(root.isEmpty()){
			return pageName+".html";
		}
		
		StringBuffer buf=new StringBuffer(pageName);

		Set<String> keySet=root.keySet();
		Object[] os=keySet.toArray();
		Arrays.sort(os);
		for(Object o:os){
			String key=o.toString();
			Object value=root.get(key);
			
			boolean flag=false;
			if(value instanceof String){
				flag=true;
				continue;
			}else if(value instanceof Integer){
				flag=true;
				continue;
			}
			
			if(flag){
				buf.append("_"+key+"_"+value);
			}
		}
		buf.append(".html");
		
		return buf.toString();
	}
	public Map<String,Object> getRoot(){
		return root;
	}
	public String getPageTemplate(){
		
		View view=page.getClass().getAnnotation(View.class);
		
		return view.template().replace("{theme}", Configuration.getProp("theme.home"));
	}
	
	public String getPageTemplate(BaseView baseView){
		
		View view=baseView.getClass().getAnnotation(View.class);
		
		return view.template().replace("{theme}", Configuration.getProp("theme.home"));
	}
	
	private String subObjectName(Object obj){
		String nameStr=obj.getClass().getName();
		nameStr=nameStr.replace(".", "-");
		String[] names=nameStr.split("-");
		
		int size=names.length;
		return names[size-1];
		
	}
}
