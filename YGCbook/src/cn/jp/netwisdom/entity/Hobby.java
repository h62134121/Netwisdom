package cn.jp.netwisdom.entity;
/*
 *  @author kou 
 */
public class Hobby {
	//创建与数据库对应的属性  用户名
	private String username;
	//兴趣爱好
	private String hobby;
	
	//获取get set方法
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	
	
	//设置构造函数
	public Hobby(String username, String hobby) {
		super();
		this.username = username;
		this.hobby = hobby;
	}
	
	//设置初始构造函数
	public Hobby() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

  
}
 