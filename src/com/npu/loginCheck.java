package com.npu;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class loginCheck
 */
@WebServlet("/loginCheck")
public class loginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String SUCCESS = "member";
	private final String ERROR = "login";
	private final String USERS = "E:/Eclipse/Web/WeiBo/users";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public loginCheck() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 取得请求参数
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie ck : cookies) {
				String name = ck.getName();
				String value = ck.getValue();
				if (username.equals(name) && password.equals(value)) {
					request.getRequestDispatcher(SUCCESS).forward(request,
							response);
				}
			}
		} else {

			// 检查用户名称与密码是否符合
			if (checkLogin(username, password)) {
				// 符合，跳转到会员界面
				String login = request.getParameter("autologin");
				if ("autologin".equals(login)) {
					Cookie cookie = new Cookie("user",username);
					cookie.setMaxAge(7 * 24 * 60 * 60);
					response.addCookie(cookie);
				}
				 try {
					Thread.sleep(8000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				request.getRequestDispatcher(SUCCESS)
						.forward(request, response);
			} else {
				// 不符合，重定向回首页
				response.sendRedirect(ERROR);
			}
		}

	}

	private boolean checkLogin(String username, String password)
			throws IOException {
		// TODO Auto-generated method stub
		if (username != null && password != null) {
			for (String file : new File(USERS).list()) {
				BufferedReader reader = new BufferedReader(new FileReader(USERS
						+ "/" + file + "/profile"));
				String passwd = reader.readLine().split("\t")[1];
				if (passwd.equals(password))
					return true;
			}
		}
		return false;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
