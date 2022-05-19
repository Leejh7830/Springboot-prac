package study;

public class StudyForm {
	private String email;
	private String password;
	private String confirmpassword;
	private String name;
	private String regdate;
	
	
	public StudyForm() {}
	public StudyForm(String email, String password, String confirmpassword, String name) {
		super();
		this.email = email;
		this.password = password;
		this.confirmpassword = confirmpassword;
		this.name = name;
	}
	@Override
	public String toString() {
		return "StudyForm [email=" + email + ", password=" + password + ", confirmpassword=" + confirmpassword
				+ ", name=" + name + "]";
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
	public String getConfirmpassword() {
		return confirmpassword;
	}
	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	
}
