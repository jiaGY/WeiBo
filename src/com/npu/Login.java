package com.npu;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out=response.getWriter();
			
			out.println("<html>");
			out.println("<body>");
			out.println("<h1>会员登录</h1>");
			out.println("<a href='register'>还不是会员？</a>");
			out.println("<form action=loginCheck   method=post>");
			out.println("用户名：<input type=text name=username><br>");
			out.println("密码：<input type=password name=password><br>");
			out.println("记住密码:<input type=checkbox name=autologin/><br>");
			out.println("<input type=submit value=登录><br>");
			out.println("</form>");
			out.println("</body>");
			out.println("</html>");
			
		}catch(Exception e){
		e.printStackTrace();
		}

	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
