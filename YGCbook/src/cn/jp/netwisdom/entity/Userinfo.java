package cn.jp.netwisdom.entity;
 
public class Userinfo {
	//创建与数据库对应的属性
	private String username;
	private String password;
	private String sex;
	private String major;
	private String intro;
	
	//设置get set 方法
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	
	//调用构造函数
	public Userinfo(String username, String password, String sex, String major, String intro) {
		super();
		this.username = username;
		this.password = password;
		this.sex = sex;
		this.major = major;
		this.intro = intro;
	}
	//添加无参构造函数
	public Userinfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
