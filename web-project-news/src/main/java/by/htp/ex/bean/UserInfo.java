package by.htp.ex.bean;

import java.io.Serializable;

public class UserInfo implements Serializable {	
	
	private static final long serialVersionUID = 1L;
	private String loginUser="";
	private String passwordUser="";	
	
	public UserInfo() {}
	
	public UserInfo(String loginUser, String passwordUser) {
		super();
		
		this.loginUser=loginUser;
		this.passwordUser=passwordUser;
	}
		
	
	public String getLogin() {
		return loginUser;
	}
	public void setLogin(String loginUser) {
		this.loginUser = loginUser;
	}
	public String getPassword() {
		return passwordUser;
	}
	public void setPassword(String passwordUser) {
		this.passwordUser = passwordUser;
	}
	@Override
    public String toString() {
        return loginUser + passwordUser;
    }

}
