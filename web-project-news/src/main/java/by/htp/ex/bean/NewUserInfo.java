package by.htp.ex.bean;

import java.io.Serializable;

public class NewUserInfo implements Serializable {
			
	private static final long serialVersionUID = 1L;
	
	private String login="";
	private String password="";
	private String email="";
	private String tel="";
	
	public NewUserInfo() {}
	
	public NewUserInfo(String email, String tel, String login, String password) {
		super();
		
		this.login=login;
		this.password=password;
		this.email=email;
		this.tel=tel;				
	}	
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	
	
}
