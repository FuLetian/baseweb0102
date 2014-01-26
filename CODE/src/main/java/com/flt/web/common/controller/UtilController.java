package com.flt.web.common.controller;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.flt.web.common.service.ICommonService;

@Controller
@RequestMapping("util")
public class UtilController {
	
	@Autowired
	private ICommonService service;

	@RequestMapping(value="upload",method=RequestMethod.POST)
	@ResponseBody
	public String upload(Integer userId,MultipartFile imgFile,Model model,HttpServletRequest req){
		
		String realDir=req.getSession().getServletContext().getRealPath("images"+File.separator+"upload");

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
		
		String imgContextPath=req.getContextPath()+"/images/upload/"+imgName;
		String domain=service.loadUserById(userId).getDomain();
		
		JSONObject jo=new JSONObject();
		jo.put("result",true);
		jo.put("path", domain+imgContextPath);
		
		return jo.toString();
	}
	
	private String buildImgName(String originName){
		
		Long date=Calendar.getInstance().getTimeInMillis();
		
		int index=originName.lastIndexOf(".");
		int length=originName.length();
		return date+originName.substring(index,length);
	}

}