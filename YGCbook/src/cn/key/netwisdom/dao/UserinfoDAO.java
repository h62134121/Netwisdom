package cn.key.netwisdom.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import cn.jp.netwisdom.entity.Userinfo;
import cn.key.Tools.DataTool;
import cn.key.dbManager.JdbcTemplate;
import cn.key.entity.BookInfo;
import cn.key.entity.BookType;
import cn.key.mapping.UserinfoMapping;
//DAO层
public class UserinfoDAO {
	private JdbcTemplate template = new JdbcTemplate();
	
   //将前端数据导入数据库方法
	public boolean save(Userinfo userinfo) {
		int row = 0;
		//创建与数据库对应的数据类型 问好代表还未传入的未知数据
		String sql = "insert into userinfo(username,password,sex,major,intro)" + 
		                "values(?,?,?,?,?)";
		

		//创建一个对象 获取entity里面属性和get方法
		Object[] values = new Object[]{
		                userinfo.getUsername(),
		                userinfo.getPassword(),
						userinfo.getSex(),
						userinfo.getMajor(),
						userinfo.getIntro()};
		
		//最终执行SQl文是通过try/template来执行
		try {
			row = template.updata(sql, values);
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return (row == 1);
	}
	
	
	
	
	
	//数据库信息抽出 
	public List<Userinfo> findUserInfo(String username, String sex, String major) {
		
		String sql = "select * from userinfo where ";
		//当姓名不为空时
		if(!"".equals(username)){
			sql = sql + " username = '" + username + "' and"; 
		}
		//性别
		sql = sql + " sex = '" + sex + "'";
		//专业
		if(!"".equals(major)){
			sql = sql + " and major = '" + major + "'";
		}
		
		
		List<Userinfo> list = new Vector<Userinfo>();
		try { 
			list = template.selete(sql, new UserinfoMapping());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	} 
}

