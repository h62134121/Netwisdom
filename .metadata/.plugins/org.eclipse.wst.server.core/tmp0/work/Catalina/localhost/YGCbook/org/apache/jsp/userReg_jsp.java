/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.42
 * Generated at: 2022-07-02 07:02:57 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class userReg_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<title>课后练习题</title>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\t<form action=\"UserRigster\"  method=\"get\">\r\n");
      out.write("\t\t姓名:<input id=\"username\" name=\"username\"><br>\r\n");
      out.write("\t\t密码:<input type=\"password\" id=\"password\" name=\"password\"><br>\r\n");
      out.write("\t\t性别:<input type=\"radio\" name=\"sex\" checked  id=\" sex1\" value=\"0\">男\r\n");
      out.write("\t\t     <input type=\"radio\"  name=\"sex\" id=\"sex2\"  value=\"1\">女\r\n");
      out.write("\t\t\t <br>\r\n");
      out.write("\t\t爱好:<input type=\"checkbox\" name=\"hobby\" value=\"0\">足球\r\n");
      out.write("\t\t     <input type=\"checkbox\" name=\"hobby\" value=\"1\">篮球\r\n");
      out.write("\t\t\t <input type=\"checkbox\" name=\"hobby\" value=\"2\">网球\r\n");
      out.write("\t\t\t <br>\r\n");
      out.write("\t\t专业:<select id=\"major\" name=\"major\">\r\n");
      out.write("\t\t\t<option value=\"0\">软件工程</option>\r\n");
      out.write("\t\t\t<option value=\"1\" >英语</option>\r\n");
      out.write("\t\t\t<option value=\"2\">数学</option>\r\n");
      out.write("\t\t    </select><br>\r\n");
      out.write("\t\t简介:<br><textarea id=\"intro\" name=\"intro\">abcd</textarea><br>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<input type=\"submit\" value=\"注册用户\">\r\n");
      out.write("\t\t<input type=\"reset\" value=\"重置\">\r\n");
      out.write("\t</form>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
