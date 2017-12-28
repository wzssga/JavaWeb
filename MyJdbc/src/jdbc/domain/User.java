package jdbc.domain;

public class User {
	private int uid;
	private String uname;
	private String upassword;
	/*Eclipse快速添加get、set方法：
	首先，创建需要实现get、set的参数
	统一创建完成后，在合适的地方采用快捷键 Shift+Alt+S 
	选择红框中的【Generate Getter and Setter……】，再选择需要实现get、set的参数*/
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpassword() {
		return upassword;
	}
	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}
	
	
}
