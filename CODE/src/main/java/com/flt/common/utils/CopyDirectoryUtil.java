package com.flt.common.utils;

import java.io.File;
import java.io.IOException;

import org.springframework.util.FileCopyUtils;
import org.springframework.util.StringUtils;

public class CopyDirectoryUtil {
	
	private static String resource;
	private static String target;
	
	public static void entry(String resource,String target){
		if(StringUtils.isEmpty(resource)||StringUtils.isEmpty(target)){
			System.err.println("resource||target is/are empty");
			return;
		}
		
		CopyDirectoryUtil.resource=resource;
		CopyDirectoryUtil.target=target;
		
		checkFileOrDir(new File(resource));
	}

	private static void checkFileOrDir(File f) {
		// TODO Auto-generated method stub
		if(f.isDirectory()){
			
			String absolutePath=f.getAbsolutePath();
			int index=absolutePath.indexOf(CopyDirectoryUtil.resource);
			if(index==-1){
				System.err.println(CopyDirectoryUtil.resource);
				System.err.println(absolutePath);
			}else{
				int length=CopyDirectoryUtil.resource.length();
				String subStr=absolutePath.substring(length);
				
				File targetFile=new File(CopyDirectoryUtil.target+subStr);
				targetFile.mkdir();
			}
			
			listFilesFromDir(f);
		}else{
			copyFileToTarget(f);
		}
	}

	private static void copyFileToTarget(File file) {
		// TODO Auto-generated method stub
		String absolutePath=file.getAbsolutePath();
		int index=absolutePath.indexOf(CopyDirectoryUtil.resource);
		if(index==-1){
			System.err.println(CopyDirectoryUtil.resource);
			System.err.println(absolutePath);
		}else{
			int length=CopyDirectoryUtil.resource.length();
			String subStr=absolutePath.substring(length);
			
			File targetFile=new File(CopyDirectoryUtil.target+subStr);
			try {
				FileCopyUtils.copy(file, targetFile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private static void listFilesFromDir(File file) {
		// TODO Auto-generated method stub
		File[] fs=file.listFiles();
		for(File f:fs){
			checkFileOrDir(f);
		}
	}

	public static void main(String[] args) {
		entry("E:"+File.separator+"htmlApp","E:\\htmlApp2");
	}
} 
