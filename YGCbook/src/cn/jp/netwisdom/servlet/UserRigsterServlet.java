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


public class UserRigsterServlet extends HttpServlet {
	//创建servlet层 继承父类HttpSerclet
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//获取FROM表单里的注册姓名信息
		String username = request.getParameter("username"); 
		//获取FROM表单里的信息密码信息
 		String password = request.getParameter("password");
		//获取FROM表单里的性别信息
		String sex = request.getParameter("sex");
		//获取FROM表单里的专业信息
		String major = request.getParameter("major");
		//获取FROM表单里的简介信息 
		String intro = request.getParameter("intro");

		
		//获取前端存到实体里的数据
		Userinfo userinfo = new Userinfo(username,password,sex,major,intro);
		//创建一个对象
		UserinfoDAO dao = new UserinfoDAO();
		//调用DAO层的save方法 来判断插入是否成功
		boolean rs1 = dao.save(userinfo);
       
	
	
        //获取FROM表单里的爱好信息 TODO 0 1 2
        String[]  hobbyArray = request.getParameterValues("hobby");
        //将数组用list实装
        List<Hobby> hobbyList = new ArrayList<Hobby>();
        
        //数据转换和插入
        for(String hobbyRs : hobbyArray){
        	Hobby hobbyOne = new Hobby(username,hobbyRs);
        	hobbyList.add(hobbyOne);
        }
        
        //创建一个对象
		HobbyDAO saveDao  = new HobbyDAO();
		//调用save方法
		boolean rs2 = saveDao.save(hobbyList);
		
		//判断rs1和rs2为真还是假后 分别进行执行分歧语句
		if(rs1 && rs2){
			System.out.println("用户注册成功");
			request.getRequestDispatcher("userSuccess.jsp").forward(request, response);
		}else{
			System.out.println("用户注册失败");
			request.getRequestDispatcher("userFail.jsp").forward(request, response);
			
		}
	}
	
		//用户爱好表更新 TODO
//		SysAdmin admin = new SysAdmin();
////		request.setAttribute("admin", admin);
//		request.getRequestDispatcher("/background/sysAdmin/upSysAdminStates.jsp").forward(request, response);
//	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		this.doGet(request, response);
	}

} 