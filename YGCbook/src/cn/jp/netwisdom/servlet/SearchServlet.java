package cn.jp.netwisdom.servlet;



import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.jp.netwisdom.entity.Hobby;
import cn.jp.netwisdom.entity.Userinfo;
import cn.key.dao.SysAdminDAO;
import cn.key.entity.SysAdmin;
import cn.key.netwisdom.dao.HobbyDAO;
import cn.key.netwisdom.dao.UserinfoDAO;


public class UserSearchServlet extends HttpServlet {
	//创建servlet层 继承父类HttpSerclet
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//获取搜索表单FROM里的姓名信息
		String username = request.getParameter("username");
		//获取搜索表单FROM里的性别信息
		String sex = request.getParameter("sex");
		//获取搜索表单FROM里的爱好信息
		String major = request.getParameter("major");

		
		
		
		UserinfoDAO dao = new UserinfoDAO();
		List<Userinfo> list = dao.findUserInfo(username, sex, major);
		
		System.out.println("用户信息如下:");
		 for(Userinfo userinfo : list){
				System.out.println("姓名:" + userinfo.getUsername());
				System.out.println("密码:" + userinfo.getPassword());
				System.out.println("性别:" + userinfo.getSex());
				System.out.println("专业:" + userinfo.getMajor());
				System.out.println("简介:" + userinfo.getIntro());
				System.out.println("------------------------------");
		  }

		
		
		
		System.out.println("取得成功");
		System.out.println("向画面进行表示");
		
		
		
		
		

		
		//HobbyDAO saveDao  = new HobbyDAO();
 

	
    } 
}	