package com.visual.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.visual.dao.impl.WorkInfoDaoImpl;
import com.visual.domain.WorkInfo;

@WebServlet("/visualServlet")
public class VisualServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Logger logger = LogManager.getLogger(VisualServlet.class.getName());

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html;charset=UTF-8");
		String team = req.getParameter("team");
		System.out.println("visual date:"+req.getParameter("date")+" == team is "+team);
		WorkInfoDaoImpl info = new WorkInfoDaoImpl();
		ArrayList<WorkInfo> workInfo = info.getWorkInfoByDate(req.getParameter("date"));
		if(!(team!=null && team!="")){
			
		}
		JSONArray jsonArray = new JSONArray();
		for(int i = 0; i<workInfo.size();i++){
			if(workInfo.get(i).getTeam().equals(team))
			{
				JSONObject js = new JSONObject();  
				js.put("name", workInfo.get(i).getName());  
				js.put("userid", workInfo.get(i).getId());
				js.put("work", workInfo.get(i).getWork().replace("\n", "<br>\n"));  
		        js.put("feel", workInfo.get(i).getFeel().replace("\n", "<br>\n"));   
		        js.put("action", "<a href=\"javascript:;\" class=\"btn btn-info edit btn-lg\"><span class=\"icon-edit\"></span>ÐÞ¸Ä </a>"); 
		        jsonArray.add(js);
	        }
		}
		resp.getWriter().print(jsonArray.toString());
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
}
