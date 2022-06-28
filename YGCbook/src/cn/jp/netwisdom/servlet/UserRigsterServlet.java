package cn.jp.netwisdom.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.key.dao.SysAdminDAO;
import cn.key.entity.SysAdmin;

public class UserRigsterServlet extends HttpServlet {
 
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//姓名
		String username = request.getParameter("username"); 
		//密码
 		String password = request.getParameter("password");
		//性别
		String sex = request.getParameter("sex");
		//专业
		String major = request.getParameter("major");
		//爱好
		String hobby = request.getParameter("hobby");
		//简介 
		String intro = request.getParameter("intro"); 
		
		
		BookInfoDao dao = new BookInfoDao(); 
		dao.save(book);

		SysAdmin admin = new SysAdmin();
		
		admin = dao.findById(id);
		request.setAttribute("admin", admin);
		request.getRequestDispatcher("/background/sysAdmin/upSysAdminStates.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		this.doGet(request, response);
	}

} 