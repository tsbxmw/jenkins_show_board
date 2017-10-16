package com.visual.servlet;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.visual.dao.impl.WorkInfoDaoImpl;
import com.visual.domain.WorkInfo;

@WebServlet("/updateContentServlet")
public class UpdateContentServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 10L;
	private static Logger logger = LogManager.getLogger(UpdateContentServlet.class.getName());

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html;charset=UTF-8");
		HttpSession session = req.getSession();
		System.out.println("UpdateContentServlet ...");
		WorkInfo info = new WorkInfo();
		String name = URLDecoder.decode(req.getParameter("name"),"UTF-8");
		info.setName(name);
		info.setId(URLDecoder.decode(req.getParameter("userid"),"UTF-8"));
		info.setWork( URLDecoder.decode(req.getParameter("work"),"UTF-8"));
		info.setFeel( URLDecoder.decode(req.getParameter("feel"),"UTF-8"));
		info.setDate( URLDecoder.decode(req.getParameter("date"),"UTF-8"));
		info.setTeam( URLDecoder.decode(req.getParameter("team"),"UTF-8"));
		System.out.println("workinfo:"+info.toString());
		WorkInfoDaoImpl infoImpl = new WorkInfoDaoImpl();
		infoImpl.updateInfo(info);
	//	resp.getWriter().print(jsonArray.toString());
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
}
