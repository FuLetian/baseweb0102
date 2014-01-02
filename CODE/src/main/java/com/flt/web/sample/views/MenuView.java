package com.flt.web.sample.views;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;

import com.flt.common.StatusEnum;
import com.flt.web.base.BaseView;
import com.flt.web.sample.views.model.Menu;
import com.thoughtworks.xstream.XStream;

public class MenuView extends BaseView {
	
	private static List<Menu> MENUS;
	
	public static Map<String, Menu> menuMap=new HashMap<>();
	
	static {
		StatusEnum status=StatusEnum.SUCCESS;
		
		File menusFile=null;
		try {
			menusFile=ResourceUtils.getFile("classpath:menus.xml");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			status=StatusEnum.FAIL;
		}
		
		XStream xStream=new XStream();
		
		if(StatusEnum.SUCCESS.equals(status)){
			try {
				xStream.alias("menu", Menu.class);
				xStream.alias("list", ArrayList.class);
				MenuView.MENUS=(List<Menu>) xStream.fromXML(new FileInputStream(menusFile));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				status=StatusEnum.FAIL;
			}
		}
	}
	
	public MenuView(Model model) {
		super(model, MenuView.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void rander() {
		// TODO Auto-generated method stub
		StatusEnum status=StatusEnum.SUCCESS;
		
		model.addAttribute("menuView_menus", MENUS);
	}

}
