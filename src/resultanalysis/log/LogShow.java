package resultanalysis.log;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LogShow {
	
	public void println(String funcName, String logLevel, String msg) {
		 SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 String date = df.format(new Date());
		 System.out.println(date + " [" + funcName + "]" + "(" + logLevel + ") " + msg + "\n");
	}
	
	public void print(String funcName, String logLevel, String msg) {
		 SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 String date = df.format(new Date());
		 System.out.println(date + " [" + funcName + "]" + "(" + logLevel + ") " + msg);
	}
}
