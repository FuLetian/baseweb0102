package com.flt.web.manage.charts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flt.service.order.IOrderCommonService;

@Controller
@RequestMapping("charts")
public class ChartsController {
	
	@Autowired
	private IOrderCommonService orderCommonService;

	@RequestMapping("view")
	public String view(Model model,HttpServletRequest req){
		
		model.addAttribute("basePath", req.getContextPath()+"/");
		return "manage/charts/view.ftl";
	}
	
	@RequestMapping("chart1-data")
	@ResponseBody
	public String chart1Data(){
		
		List<String> days=new ArrayList<>();//最近一月号数集合
		
		Calendar today=Calendar.getInstance();
		Calendar lastMonthDay=Calendar.getInstance();
		
		int lastMonth=today.get(Calendar.MONTH)-1;
		lastMonthDay.set(Calendar.MONTH,lastMonth);
		
		Calendar tmp=(Calendar) lastMonthDay.clone();
		while(!(tmp.get(Calendar.MONTH)==today.get(Calendar.MONTH)&&tmp.get(Calendar.DAY_OF_MONTH)==today.get(Calendar.DAY_OF_MONTH))){
			days.add(tmp.get(Calendar.MONTH)+"."+tmp.get(Calendar.DAY_OF_MONTH));
			tmp.add(Calendar.DAY_OF_MONTH, 1);
		}
		
		List<Integer> saleCountTotal=this.orderCommonService.listCountBetweenDateByRunstatus((Calendar)lastMonthDay.clone(),today, Arrays.asList(0,1,2,3), 1);
		List<Integer> colletion=this.orderCommonService.listCountBetweenDateByRunstatus((Calendar)lastMonthDay.clone(), today, Arrays.asList(4), 1);
		List<Integer> successOrder=this.orderCommonService.listCountBetweenDateByRunstatus((Calendar)lastMonthDay.clone(), today, Arrays.asList(3), 1);
		
		
		JSONObject o=new JSONObject();
		
		o.put("days", days);
		o.put("totalOrderCount", JSONArray.fromObject(saleCountTotal));
		o.put("successOrderCount", JSONArray.fromObject(successOrder));
		o.put("collectionOrderCount", JSONArray.fromObject(colletion));
		
		return o.toString();
	}
}
