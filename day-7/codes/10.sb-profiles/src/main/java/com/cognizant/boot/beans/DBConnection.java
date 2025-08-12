package com.cognizant.boot.beans;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "jdbc")
public class DBConnection {
	private String driverClassName;
	private String url;
	private String usrName;
	private String password;

	public String getDriverClassName() {
		return driverClassName;
	}

	public void setDriverClassName(String driverClassName) {
		this.driverClassName = driverClassName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsrName() {
		return usrName;
	}

	public void setUsrName(String userName) {
		this.usrName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "DBConfiguration [driverClassName=" + driverClassName + ", url=" + url + ", userName=" + usrName
				+ ", password=" + password + "]";
	}

}
