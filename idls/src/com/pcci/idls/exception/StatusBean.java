package com.pcci.idls.exception;

public class StatusBean {

	//private String status = "";
	private String type = "";
	private String code = "";
	private String description = "";
	
	public StatusBean() {
		// TODO Auto-generated constructor stub
	}

	public StatusBean(String type, String description, String code) {
		super();
		this.type = type;
		this.description = description;
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}
	
	
	
	
}
