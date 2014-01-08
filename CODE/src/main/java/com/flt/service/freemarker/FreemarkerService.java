package com.flt.service.freemarker;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfig;

import freemarker.template.Template;
import freemarker.template.TemplateException;

@Service
public class FreemarkerService {

	@Autowired FreeMarkerConfig config;
	
	public void flush(HttpServletRequest request,String targetHtmlName,String templatePath,Map<String, Object> root){
		
		//html生成之后存放的路径  
        String dirPath = request.getSession().getServletContext().getRealPath("h");
        
        try {
			Writer out = new OutputStreamWriter(new FileOutputStream(dirPath+File.separator+targetHtmlName),"UTF-8");
			
			Template tempalte=config.getConfiguration().getTemplate(templatePath,"UTF-8");
			
			tempalte.process(root, out);
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TemplateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
