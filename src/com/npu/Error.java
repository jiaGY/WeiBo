package com.npu;

import java.io.*;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class Error
 */
@WebServlet("/error")
public class Error extends HttpServlet {
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		try{
			PrintWriter out=response.getWriter();
			out.println("<!DOCTYPE html PUBLIC " +
	                "'-//W3C//DTD HTML 4.01 Transitional//EN'>");
			out.println("<html>");
			out.println("<head>");
			out.println("<meta content='text/html;charset=UTF-8'+http-equiv='content-type'>");
			out.println("<title>新增会员失败</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>新增会员失败</h1>");
			out.println("<ul style='color:rgb(255,0,0)'>");
			
			//取得请求属性
			List<String> errors=(List<String>)request.getAttribute("error");
			for(String error:errors){
				out.println("<li>"+error+"</li>");
			}
				
			out.println("</ul>");
			out.println("<a href='register'>返回注册界面</a>");
			out.println("</body>");
			out.println("</html>");
			out.close();
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
