package com.visual.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sun.corba.se.spi.orbutil.threadpool.Work;
import com.visual.dao.IWorkInfoDao;
import com.visual.domain.User;
import com.visual.domain.WorkInfo;
import com.visual.listener.InitConfigListener;

public class WorkInfoDaoImpl implements IWorkInfoDao {
	
	
	public boolean initWorkInfoByDate(String date){
		
		ArrayList<User> userList = new UserDaoImpl().getAllUsers();
		boolean result = true;
		int count = 0;
		try {
			Connection connection = DBConnection.getConnection();
			PreparedStatement preparedStatement = connection
					.prepareStatement(InitConfigListener.dbHashMap.get("insertWorkInfo"));
			for(int i=0;i<userList.size();i++){
				if(!getUserByiddate(userList.get(i).getUserId(),date)){
					//System.out.println("true");
					preparedStatement.clearParameters();
					count = 0;
					preparedStatement.setString(++count, userList.get(i).getUserName());
					preparedStatement.setString(++count, "");
					preparedStatement.setString(++count, "");
					preparedStatement.setString(++count, date);
					preparedStatement.setString(++count, userList.get(i).getTeam());
					preparedStatement.setString(++count, userList.get(i).getUserId());
					//System.out.println(preparedStatement);
					int index = preparedStatement.executeUpdate();
					if(index<0){
						result = false;
					}
				}
			
			}
			DBConnection.close(connection, preparedStatement, null);
			return result;
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	public ArrayList<WorkInfo> getWorkInfoByDate(String date){
		
		ArrayList<WorkInfo> infoList = new ArrayList<WorkInfo>();
		try{
			Connection connection = DBConnection.getConnection();
			PreparedStatement preparedStatement = connection
					.prepareStatement(InitConfigListener.dbHashMap.get("getWorkInfoByDate"));
			preparedStatement.setString(1, date);
			ResultSet resultSet = preparedStatement.executeQuery();
			initWorkInfoByDate(date);
			
			while(resultSet.next()){
				WorkInfo workInfo = new WorkInfo();
				workInfo.setIndex(resultSet.getInt("info_id"));
				
				workInfo.setName(resultSet.getString("name"));
				workInfo.setWork(resultSet.getString("work"));
				workInfo.setFeel(resultSet.getString("feel"));
				workInfo.setDate(resultSet.getString("date"));
				workInfo.setTeam(resultSet.getString("team"));
				workInfo.setId(resultSet.getString("userid"));
				//System.out.println(workInfo);
				infoList.add(workInfo);
			}
			
			if(infoList.size()==0){
				initWorkInfoByDate(date);
				ResultSet resultSet1 = preparedStatement.executeQuery();
				while(resultSet1.next()){
					WorkInfo workInfo = new WorkInfo();
					workInfo.setIndex(resultSet1.getInt("info_id"));
					workInfo.setName(resultSet1.getString("name"));
					workInfo.setWork(resultSet1.getString("work"));
					workInfo.setFeel(resultSet1.getString("feel"));
					workInfo.setDate(resultSet1.getString("date"));
					workInfo.setTeam(resultSet1.getString("team"));
					workInfo.setId(resultSet1.getString("userid"));
					infoList.add(workInfo);
				}
			}
			
			DBConnection.close(connection,preparedStatement,resultSet);
		}catch(SQLException e){
			e.printStackTrace();
		}
	
		return infoList;
	}
//add by mengwei to find the user date in workinfo to insert	
	
	public boolean getUserByiddate(String id,String date){

		boolean result = true;
		int count = 0;
		String userid=null;
		try {
			Connection connection = DBConnection.getConnection();
			PreparedStatement preparedStatement = connection
					.prepareStatement(InitConfigListener.dbHashMap.get("infoIsExist"));
			preparedStatement.setString(++count, id);
			preparedStatement.setString(++count, date);
			//System.err.println(preparedStatement);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				userid=resultSet.getString("userid");
			}
			DBConnection.close(connection, preparedStatement, null);
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(id.equals(userid))
			return true;
		return false;
	}
	public boolean updateInfo(WorkInfo info){
		
		boolean result = true;
		int count = 0;
		try {
			Connection connection = DBConnection.getConnection();
			PreparedStatement preparedStatement = connection
					.prepareStatement(InitConfigListener.dbHashMap.get("updateWorkInfo"));
			
			preparedStatement.setString(++count, info.getWork());
			preparedStatement.setString(++count, info.getFeel());
			preparedStatement.setString(++count, info.getTeam());
			preparedStatement.setString(++count, info.getId());
			preparedStatement.setString(++count, info.getName());
			preparedStatement.setString(++count, info.getDate());
			//System.err.println(preparedStatement);
			int index = preparedStatement.executeUpdate();
			if(index<0){
				result = false;
			}
			DBConnection.close(connection, preparedStatement, null);
			return result;
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
		
	}
	
	public boolean  deleteWorkInfo(String userid){
		boolean result = true;
		try {
			Connection connection = DBConnection.getConnection();
			PreparedStatement preparedStatement = connection
					.prepareStatement(InitConfigListener.dbHashMap.get("deleteWorkInfo"));
			preparedStatement.setString(1, userid);
			int index = preparedStatement.executeUpdate();
			if(index<0){
				result = false;
			}
			DBConnection.close(connection, preparedStatement, null);
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	

}
