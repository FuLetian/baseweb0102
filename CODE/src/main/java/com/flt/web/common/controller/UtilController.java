package com.flt.web.common.controller;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.flt.common.config.Configuration;
import com.flt.common.utils.EmailUtil;
import com.flt.common.utils.ImgUtil;
import com.flt.dao.model.Consumer;
import com.flt.web.common.service.ICommonService;
import com.flt.web.common.service.ICommonStaticWebService;
import com.flt.web.common.session.SessionUserLoader;

@Controller
@RequestMapping("util")
public class UtilController {
	
	@Autowired
	private ICommonService service;
	
	@Autowired
	private ICommonStaticWebService staticWebService;

	/**
	 * @param imgFile
	 * @param extra
	 * @param model
	 * @param req
	 * @return
	 */
	@RequestMapping(value="upload",method=RequestMethod.POST)
	@ResponseBody
	public String upload(MultipartFile imgFile,String extra,Model model,HttpServletRequest req){
		
		Integer sessionUserId=SessionUserLoader.findSessionUserId(req);
		
		String realDir=req.getSession().getServletContext().getRealPath("h"+File.separator+"images"+File.separator+"upload"+File.separator+sessionUserId);
		File temp=new File(realDir);
		if(!temp.exists()){
			temp.mkdir();
		}
		
		byte[] bytes=null;
		if(!imgFile.isEmpty()){
			try {
				bytes=imgFile.getBytes();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		String imgName=null;
		if(bytes!=null){
			imgName=buildImgName(imgFile.getOriginalFilename());
			String imgPath=realDir+File.separator+imgName;
			File file=new File(imgPath);
			try {
				FileCopyUtils.copy(bytes, file);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		String absolutePath=req.getSession().getServletContext().getRealPath("h"+File.separator+"images"+File.separator+"upload"+File.separator+sessionUserId+File.separator+imgName);
		ImgUtil.compressImg(absolutePath,Integer.valueOf(Configuration.getProp("image.max.size")));
		
		String imgContextPath=req.getContextPath()+"/h/images/upload/"+sessionUserId+"/"+imgName;
		//String domain=service.loadUserById(userId).getDomain();
		
		JSONObject jo=new JSONObject();
		jo.put("result",true);
		jo.put("path",imgContextPath);
		jo.put("extra", extra);
		
		return jo.toString();
	}
	
	private String buildImgName(String originName){
		
		Long date=Calendar.getInstance().getTimeInMillis();
		
		int index=originName.lastIndexOf(".");
		int length=originName.length();
		return date+originName.substring(index,length);
	}
	
	/**
	 * 
	 */
	@RequestMapping("onStaticWeb")
	@ResponseBody
	public String onStaticweb(Integer userId,HttpServletRequest req){
		Assert.notNull(userId);
		
		staticWebService.staticweb(userId,req);
		
		//CopyDirectoryUtil.copyResources("css", "h"+File.separator+userId, req);
		//CopyDirectoryUtil.copyResources("javascript", "h"+File.separator+userId, req);
		
		JSONObject o=new JSONObject();
		o.put("result", true);
		
		return o.toString();
	}
	
	/**
	 * session 记录广告开关
	 * @param status show/hide
	 * @param req
	 * @return
	 */
	@RequestMapping("setAdFlag")
	@ResponseBody
	public String setAdFlag(String status,HttpServletRequest req){
		
		JSONObject o=new JSONObject();
		
		req.getSession().setAttribute("AD_FLAG", status);
		
		o.put("status", status);
		return o.toString();
	}
	
	/**
	 * session 获取广告开关
	 * @param req
	 * @return
	 */
	@RequestMapping("getAdFlag")
	@ResponseBody
	public String getAdFlag(HttpServletRequest req){
		JSONObject o=new JSONObject();
		String status=(String) req.getSession().getAttribute("AD_FLAG");
		if(status==null){
			o.put("status", "show");
		}else{
			o.put("status", status);
		}
		
		return o.toString();
	}
	
	/**
	 * 找回密码
	 * @param email
	 * @return
	 */
	@RequestMapping("findPwd")
	@ResponseBody
	public String findoutPwd(String email){
		JSONObject o=new JSONObject();
		
		Consumer c=service.findConsumerByEmail(email);
		
		if(c!=null){
			
			EmailUtil.send("找回密码", "您的账户是:"+c.getAccount()+"\r\n您的密码是:"+c.getPassword(), c.getEmail());
			
			o.put("exist", true);
			o.put("href", "https://mail.qq.com/cgi-bin/loginpage");
		}else{
			o.put("exist", false);
		}
		
		return o.toString();
		
	}

	

}
