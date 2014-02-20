package com.flt.dao.datasource;

import com.flt.common.config.Configuration;

public class DataSource extends org.apache.commons.dbcp.BasicDataSource{

	public DataSource() {
		// TODO Auto-generated constructor stub
		this.setDriverClassName("com.mysql.jdbc.Driver");
		this.setUrl(Configuration.getProp("jdbc.url"));
		this.setUsername(Configuration.getProp("jdbc.username"));
		this.setPassword(Configuration.getProp("jdbc.password"));
		this.setMaxActive(100);
		this.setMaxIdle(30);
		this.setMaxWait(500l);
		this.setDefaultAutoCommit(true);
	}
}
