package com.flt.common.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyDirectoryUtil {
	public boolean copy(String file1,String file2) {
		
		File in=new File(file1);
		File out=new File(file2);
		if(!in.exists()){
			System.out.println(in.getAbsolutePath()+"源文件路径错误！！！");
			return false;
		}
		else {
			System.out.println("源文件路径"+in.getAbsolutePath());
			System.out.println("目标路径"+out.getAbsolutePath());
			
		}
		if(!out.exists()) 
			out.mkdirs();
		File[] file=in.listFiles();
		FileInputStream fin=null;
		FileOutputStream fout=null;
		for(int i=0;i<file.length;i++){
		if(file[i].isFile()){
			try {
				fin=new FileInputStream(file[i]);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("in.name="+file[i].getName());
			try {
				fout=new FileOutputStream(new File(file2+"/"+file[i].getName()));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(file2);
			int c;
			byte[] b=new byte[1024*5];
			try {
				while((c=fin.read(b))!=-1){
					
					fout.write(b, 0, c);
					System.out.println("复制文件中！");
				}
				fin.close();
				fout.flush();
				fout.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return true;
		}
		else copy(file1+"/"+file[i].getName(),file2+"/"+file[i].getName());
		}
		
		return false;
	
	
	}

	public static void main(String[] args) {
		CopyDirectoryUtil copyFile = new CopyDirectoryUtil();
		copyFile.copy("E:\\ppsfile", "E:\\pps");
	}
} 
