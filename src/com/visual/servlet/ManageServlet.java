package com.visual.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CORBA.PUBLIC_MEMBER;

import com.sun.xml.internal.ws.client.SenderException;
import com.visual.dao.IUserDao;
import com.visual.dao.impl.UserDaoImpl;
import com.visual.dao.impl.WorkInfoDaoImpl;
import com.visual.domain.User;
@WebServlet("/ManageServlet")
public class ManageServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public  void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String sex = request.getParameter("sex");
		String team = request.getParameter("team");
		String flag = request.getParameter("flag");
		String username_rm = request.getParameter("username_rm");
		String userid = request.getParameter("user_id");
		
		//<span style="font-family: Arial, Helvetica, sans-serif;">//得到表单输入的内容</span>
		String svc =(String) request.getSession().getAttribute("sessionverify");
		
		
		
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		


		
		if(flag==null||flag==""){
			//request.setAttribute("result", "flag不能为空！");
			request.getRequestDispatcher("/edit.jsp").forward(request, response);
			return;
		}
		System.out.println(flag);
		
		if(flag.equals("addNewUser")){
			boolean psw =new UserDaoImpl().getUserIdByuserId(userid);
			if(username==null||username==""){
				request.setAttribute("result", "用户名不能为空！");
				request.getRequestDispatcher("/edit.jsp").forward(request, response);
				return;
			}
			if(email==null||email==""){
				request.setAttribute("result", "邮箱名不能为空！");
				request.getRequestDispatcher("/edit.jsp").forward(request, response);
				return;
			}
			if(sex==null||sex==""){
				request.setAttribute("result", "性别不能为空！");
				request.getRequestDispatcher("/edit.jsp").forward(request, response);
				return;
			}
			if(team==null||team==""){
				request.setAttribute("result", "组别不能为空！");
				request.getRequestDispatcher("/edit.jsp").forward(request, response);
				return;
			}
			if(userid==null||userid=="")
			{
				request.setAttribute("result", "工号不能为空！");
				request.getRequestDispatcher("/edit.jsp").forward(request, response);
				return;
			}
			
			if(!userid.matches("[0-9]+")){
				request.setAttribute("result", "工号只能是数字！");
				request.getRequestDispatcher("/edit.jsp").forward(request, response);
				return;
			}
			if(userid.length()!=8&&userid.length()!=10){
				request.setAttribute("result", "工号不是8位或者10位！！");
				request.getRequestDispatcher("/edit.jsp").forward(request, response);
				return;
			}
			if(!email.endsWith(".com")){
				request.setAttribute("result", "邮箱地址不正确！");
				request.getRequestDispatcher("/edit.jsp").forward(request, response);
				return;
			}
			if(psw){
				request.setAttribute("result", "用户已存在！");
				request.getRequestDispatcher("edit.jsp").forward(request, response);
			}
			else{
				boolean result = userDaoImpl.addNewUser(username, email, sex, team,userid);
				
				if(result){
					request.setAttribute("result", "用户 "+username+" 添加成功！");
					request.getRequestDispatcher("edit.jsp").forward(request, response);
				}
				else{
					request.setAttribute("result", "用户添加失败，请重试！");
					request.getRequestDispatcher("edit.jsp").forward(request, response);
					
				}
			}
			return ;
		}
		
		//username_rm : user id (remove)
		if(flag.equals("removeUser")){
			if(username_rm==null||username_rm==""){
				request.setAttribute("result1", "工号不能为空！");
				request.getRequestDispatcher("/edit.jsp").forward(request, response);
				return;
			}
			if(!username_rm.matches("[0-9]+")){
				request.setAttribute("result1", "工号只能是数字！");
				request.getRequestDispatcher("/edit.jsp").forward(request, response);
				return;
			}
			if(username_rm.length()!=8 && username_rm.length()!=10){
				request.setAttribute("result1", "工号不是8位或者10位！！");
				request.getRequestDispatcher("/edit.jsp").forward(request, response);
				return;
			}
			boolean psw =new UserDaoImpl().getUserIdByuserId(username_rm);
			if(username_rm==null||username_rm==""){
				request.setAttribute("result1", "用户不存在或者已经移除！");
				request.getRequestDispatcher("/edit.jsp").forward(request, response);
				return;
			}
			if(psw){
				boolean result = userDaoImpl.removeUser(username_rm);
			
				if(result)
				{
					request.setAttribute("result1", "删除用户"+username_rm+"成功！");
					request.getRequestDispatcher("edit.jsp").forward(request, response);
					boolean deleteinfo = new WorkInfoDaoImpl().deleteWorkInfo(username_rm);
					if(deleteinfo)
					{
						request.setAttribute("result1", "删除用户"+username_rm+"信息成功！");
						request.getRequestDispatcher("edit.jsp").forward(request, response);
					}
					else {
						request.setAttribute("result1", "删除用户"+username_rm+"信息失败，请重试！");
						request.getRequestDispatcher("edit.jsp").forward(request, response);
						
					}
				}
				else {
					request.setAttribute("result1", "删除用户"+username_rm+"失败，请重试！");
					request.getRequestDispatcher("edit.jsp").forward(request, response);
					boolean deleteinfo = new WorkInfoDaoImpl().deleteWorkInfo(username_rm);
					if(deleteinfo)
					{
						request.setAttribute("result1", "删除用户"+username_rm+"信息成功！");
						request.getRequestDispatcher("edit.jsp").forward(request, response);
					}
					else {
						request.setAttribute("result1", "删除用户"+username_rm+"信息失败，请重试！");
						request.getRequestDispatcher("edit.jsp").forward(request, response);
						
					}
				}
				//delete the info of workinfo
			
			}
			else{
				request.setAttribute("result1", "用户不存在！");
				request.getRequestDispatcher("edit.jsp").forward(request, response);
			
			}
			
			return ;
		}
		
//		if(flag.equals("quit")){
//			//request.getRequestDispatcher("main.jsp").forward(request, response);
//			return ;
//		}
		
		
	}
	protected void addNewUser(String user,String email,String sex,String team ){
		
	}

}
