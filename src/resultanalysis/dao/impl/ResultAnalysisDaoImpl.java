package resultanalysis.dao.impl;

import java.util.ArrayList;
import java.io.File;

import resultanalysis.dao.ResultAnalysisDao;
import resultanalysis.domain.DataofFiles;
import resultanalysis.log.LogShow;

public class ResultAnalysisDaoImpl implements ResultAnalysisDao{
	
	@Override
	public ArrayList<File> getFilePath() {
		// TODO Auto-generated method stub
		LogShow logshow = new LogShow();
		try {
			DataofFiles dof = new DataofFiles();
			String remote_file_path = dof.getFilepath();
			File file = new File(remote_file_path);
			ArrayList<File> file_a = new ArrayList<File>();
			if(file.exists() && file.isDirectory())	{
				File files_test_times[] = file.listFiles();
				for(int i=0; i<files_test_times.length; i++)
				{
					file_a.add(files_test_times[i]);
				}
				return file_a;
			}else {
				logshow.println("getFilePath", "Error", remote_file_path + " is not exists !");				
			}
		}catch(Exception e) {
			logshow.println("getFilePath", "Error", e.toString());
		}
		
		return null;
	}

	@Override
	public ArrayList<File> getJsonPath() {
		// TODO Auto-generated method stub
		LogShow logshow = new LogShow();
		try {
			DataofFiles dof = new DataofFiles();
			String remote_file_path = dof.getJsonpath();
			File file = new File(remote_file_path);
			ArrayList<File> file_a = new ArrayList<File>();
			if(file.exists() && file.isDirectory())	{
				File files_test_times[] = file.listFiles();
				for(int i=0; i<files_test_times.length; i++)
				{
					file_a.add(files_test_times[i]);
				}
				return file_a;
			}else {
				logshow.println("getJsonPath", "Error", remote_file_path + " is not exists !");				
			}
		}catch(Exception e) {
			logshow.println("getJsonPath", "Error", e.toString());
		}
		return null;
	}

	@Override
	public ArrayList<File> getLogPath() {
		// TODO Auto-generated method stub
		LogShow logshow = new LogShow();
		try {
			DataofFiles dof = new DataofFiles();
			String remote_file_path = dof.getLogpath();
			File file = new File(remote_file_path);
			ArrayList<File> file_a = new ArrayList<File>();
			if(file.exists() && file.isDirectory())	{
				File files_test_times[] = file.listFiles();
				for(int i=0; i<files_test_times.length; i++)
				{
					file_a.add(files_test_times[i]);
				}
				return file_a;
			}else {
				logshow.println("getLogPath", "Error", remote_file_path + " is not exists !");				
			}
		}catch(Exception e) {
			logshow.println("getLogPath", "Error", e.toString());
		}
		return null;
	}
	
}
