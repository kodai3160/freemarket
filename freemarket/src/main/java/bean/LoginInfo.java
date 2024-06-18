package bean;

public class LoginInfo {
	
	private int userId;
	
	private String email;
	
	private String password;
	
	private int loginFlag;
	
	public LoginInfo() {
		
		this.userId = 0;
		
		this.email = null;
		
		this.password = null;
		
		this.loginFlag = 0;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getLoginFlag() {
		return loginFlag;
	}

	public void setLoginFlag(int loginFlag) {
		this.loginFlag = loginFlag;
	}
	
}