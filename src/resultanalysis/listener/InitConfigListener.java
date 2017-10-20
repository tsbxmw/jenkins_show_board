package resultanalysis.listener;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

@WebListener
public class InitConfigListener implements ServletContextListener {
	public static HashMap<String, String> dbHashMap = new HashMap<String, String>();
	public static Properties properties = new Properties();

	public InitConfigListener() {

	}

	public void contextInitialized(ServletContextEvent servletContextEvent) {
		initSql();
//		initUpload();
	}

	private void initUpload() {
		String webPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
		try {
			webPath=URLDecoder.decode(webPath,"utf-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			FileInputStream inStream = new FileInputStream(new File(webPath + "uploadConfig.properties"));
			properties.load(inStream);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	private void initSql() {
		String webPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
		try {
			webPath=URLDecoder.decode(webPath,"utf-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		File file = new File(webPath + "dbMySql.xml");
		SAXReader saxReader = new SAXReader();
		Document document = null;
		try {
			document = saxReader.read(file);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		Element root = document.getRootElement();
		List<Element> elementList = root.elements();
		for (int i = 0; i < elementList.size(); i++) {
			List<Element> subElementList = elementList.get(i).elements();
			for (int j = 0; j < subElementList.size(); j++) {
				dbHashMap.put(subElementList.get(j).attributeValue("id"), subElementList.get(j).getTextTrim());
			}
		}
	}

	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		destoryTempFiles();

	}

	private void destoryTempFiles() {
		
	}

}
