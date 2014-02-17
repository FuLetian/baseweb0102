package com.flt.common.utils;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.util.FileCopyUtils;

public class CopyDirectoryUtil {
	
	public static void copyResources(String inDir,String outDir,HttpServletRequest req){
		String in=req.getSession().getServletContext().getRealPath(inDir);
		String out=req.getSession().getServletContext().getRealPath(outDir);
		
		chainIfDirectory(new File(in),out,inDir);
		
	}

	public static void chainIfDirectory(File file,String outRootPath,String resourceDirName) {
		// TODO Auto-generated method stub
		File[] files=file.listFiles();
		for(File f:files){
			if(f.isDirectory()){
				chainIfDirectory(f,outRootPath,resourceDirName);
			}else{
				String absolutePath=f.getAbsolutePath();
				int index=absolutePath.indexOf(File.separator+resourceDirName+File.separator);
				String targetFilePath=outRootPath+absolutePath.substring(index);
				
				try {
					FileCopyUtils.copy(f, new File(targetFilePath));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
