package com.flt.web.manage.user;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flt.dao.model.User;
import com.flt.service.user.IUserCommonService;

@Controller
@RequestMapping("user-manage")
public class UserManageController {
	
	@Autowired
	private IUserCommonService userCommonService;

	@RequestMapping("view")
	public String view(Model model,HttpServletRequest req){
		
		model.addAttribute("user", userCommonService.loadUserById(1));
		model.addAttribute("basePath", req.getContextPath()+"/");
		return "manage/user/view.ftl";
	}
	
	@RequestMapping(value="update",method=RequestMethod.POST)
	@ResponseBody
	public String update(User user){
		JSONObject o=new JSONObject();
		
		Assert.notNull(user.getId(),"user.id");
		
		this.userCommonService.updateUser(user);
		
		o.put("result", true);
		return o.toString();
	}
}
