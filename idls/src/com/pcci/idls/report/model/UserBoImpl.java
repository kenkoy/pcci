package com.pcci.idls.report.model;

public class UserBoImpl  implements UserBo{
 
	String name;
 
	public void setName(String name) {
		this.name = name;
	}
 
	public String getMessage() {
 
		return "JSF 2 + Spring Integration saying : " + name;
 
	}
 
}
