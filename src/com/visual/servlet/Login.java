package com.visual.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.visual.dao.impl.UserDaoImpl;
@WebServlet("/LoginServlet")
public class Login extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String verifyc  = request.getParameter("verifycode");
		
		//<span style="font-family: Arial, Helvetica, sans-serif;">//锟矫碉拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟�</span>
		String svc =(String) request.getSession().getAttribute("sessionverify");
		
		
		boolean psw =new UserDaoImpl().getAdminUserName(username);
		
		
		String pass_psw = new UserDaoImpl().getAdminPassword(username);


		if(username==null||username==""){
			request.setAttribute("msg", "User Name can not be NULL ");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}
		if(!psw){
			request.setAttribute("msg", "User not exist !");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}
		if(psw&&!pass_psw.equals(password)){
			request.setAttribute("msg", "Password is wrong ! ");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}

		if(pass_psw.equals(password)){
			request.setAttribute("msg", "welcome "+username+", now login");
			request.getRequestDispatcher("/edit.jsp").forward(request, response);
			response.setHeader("Refresh","1;url=edit.jsp");
			return;
		}
		
	}

}
