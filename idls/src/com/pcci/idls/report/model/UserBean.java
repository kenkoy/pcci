package com.pcci.idls.report.model;

import java.io.Serializable;

public class UserBean  implements Serializable{
 
	private static final long serialVersionUID = 5385894615377752670L;
	//DI via Spring
	UserBo userBo;
 
	public void setUserBo(UserBo userBo) {
		this.userBo = userBo;
	}
 
	public String printMsgFromSpring() {
 		return userBo.getMessage();
 	}
 
}