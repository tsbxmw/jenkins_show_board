package resultanalysis.servlet;
import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import resultanalysis.dao.impl.ResultAnalysisDaoImpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@WebServlet("/ResultAnalysisServlet")
public class ResultAnalysisServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	private static Logger logger = LogManager.getLogger(ResultAnalysisServlet.class.getName());

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		HttpSession session = req.getSession();
		String sessionId = session.getId();
		if (session.isNew()) {
		    System.out.println("[session] - new " + sessionId);
		}else {
			System.out.println("[session] - old " + sessionId);
		}
		
		ResultAnalysisDaoImpl radi = new ResultAnalysisDaoImpl();
		
		String get_all_test = req.getParameter("get_all_test");
		
		if(get_all_test != null && get_all_test.equals("true")) {
			ArrayList<File> alltest = radi.getFilePath();
			JSONArray ja = new JSONArray();
			JSONObject jcount = new JSONObject();
			jcount.put("count", alltest.size());
			ja.add(jcount);
			JSONObject jo = new JSONObject();
			for(int i=0; i<alltest.size(); i++) {
				jo.put(Integer.toString(i), alltest.get(i).toString());
			}
			ja.add(jo);
			resp.getWriter().println(ja.toString());
		}
		
		resp.setContentType("text/html;charset=UTF-8");
		System.out.println("[debug] - post");
			
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}


}
