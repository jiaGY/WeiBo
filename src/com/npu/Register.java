package com.npu;

import java.io.*;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
@WebServlet("/register")
public class Register extends HttpServlet {
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
			out.println("<h1>会员注册</h1>");
			out.println("<form action=checkRegister   method=post>");
			out.println("邮箱：<input type=text name=email size=25 maxlength=100><br>");
			out.println("用户名(最大16字符)：<input type=text name=username size=25 maxlength=16><br>");
			out.println("密码(6-16字符)：<input type=password name=password size=25 maxlength=16><br>");
			out.println("确认密码：<input type=password name=confirmedpassword size=25 maxlength=16><br>");
			out.println("<input type=submit value=注册><br>");
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
