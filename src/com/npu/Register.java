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
			out.println("<h1>��Աע��</h1>");
			out.println("<form action=checkRegister   method=post>");
			out.println("���䣺<input type=text name=email size=25 maxlength=100><br>");
			out.println("�û���(���16�ַ�)��<input type=text name=username size=25 maxlength=16><br>");
			out.println("����(6-16�ַ�)��<input type=password name=password size=25 maxlength=16><br>");
			out.println("ȷ�����룺<input type=password name=confirmedpassword size=25 maxlength=16><br>");
			out.println("<input type=submit value=ע��><br>");
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
