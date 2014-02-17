package com.flt.common.freemarker;

import javax.servlet.http.HttpServletRequest;

public interface HTMLAbled {

	 String createHtml(HttpServletRequest req,Integer userId);
}
