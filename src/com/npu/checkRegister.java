package com.npu;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class checkRegister
 */
@WebServlet("/checkRegister")
public class checkRegister extends HttpServlet {
	private  final String SUCCESS = "success";
	private  final String ERROR = "error";
	private  final String USERS = "E:/Eclipse/Web/WeiBo/users";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub		
		
		//ȡ���������
		String email=request.getParameter("email");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String confirmedPassword=request.getParameter("confirmedpassword");
		
		System.out.println(email);
		System.out.println(username);
		System.out.println(password);
		System.out.println(confirmedPassword);
		//��֤�������
		List<String> errors=new ArrayList<String>();
//		if(isInvalidEmail(email)){
//			errors.add("δ��д����������ʽ����ȷ");
//		}
        if(isInvalidUsername(username)){
	    	errors.add("�û���Ϊ�ջ��Ѵ���");
	    }
        if(isInvalidPassword(password,confirmedPassword)){
        	errors.add("��ȷ��������ϸ�ʽ���ٴ�ȷ������");
        }
       String resultPage=ERROR;
       if(!errors.isEmpty()){
    	 //������֤�����������ռ������listΪ��������
    	   request.setAttribute("error", errors);
       }else{
    	 //�����û�����
    	   resultPage=SUCCESS;
    	   creatuserData(email,username,password);  
       }
       request.getRequestDispatcher(resultPage).forward(request, response);
	}

	//�����û����ϣ���profile�д洢���������
	private void creatuserData(String email, String username, String password)throws IOException {
		// TODO Auto-generated method stub
		File userhome=new File(USERS+"/"+username);
		userhome.mkdir();
		BufferedWriter writer=new BufferedWriter(new FileWriter(userhome+"/profile"));
		writer.write(email+"\t"+password);
		writer.close();
	}

	private boolean isInvalidPassword(String password, String confirmedPassword) {
		// TODO Auto-generated method stub
		return password==null || password.length()<6 ||
				password.length()>16 || !password.equals(confirmedPassword);
	}

	private boolean isInvalidUsername(String username) {
		// TODO Auto-generated method stub
		for(String file : new File(USERS).list()){
			if(file.equals(username)){
				return true;
			}
		}
		return false;
	}

	private boolean isInvalidEmail(String email) {
		// TODO Auto-generated method stub
		return email==null || !email.matches("^[a-z0-90]+([.][_a-z0-9-]+)*@[a-z0-9-9]+[a-z0-9-]+)*$");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
