package com.visual.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.visual.dao.IUserDao;
import com.visual.domain.User;
import com.visual.listener.InitConfigListener;

public class UserDaoImpl implements IUserDao {

	@Override
	public int getUserCount(String str_sql) {
		int count = 0;
		try {
			Connection connection = DBConnection.getConnection();
			PreparedStatement preparedStatement = connection
					.prepareStatement(InitConfigListener.dbHashMap.get("getUserCount")
							+" where "+str_sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				count = resultSet.getInt(1);
			}
			DBConnection.close(connection, preparedStatement, resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}


	
	@Override
	public String getUserId(String loginName) {
		Connection connection = null;
		String userId = null;
		try {
			connection = DBConnection.getConnection();
			PreparedStatement preparedStatement = connection
					.prepareStatement(InitConfigListener.dbHashMap.get("myGetUserIdByUserName"));
			preparedStatement.setString(1, loginName);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				userId = resultSet.getString("user_id");
			}
			DBConnection.close(connection, preparedStatement, resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userId;
	}

	@Override
	public String getUserRole(String loginName) {
		Connection connection = null;
		String userRole = null;
		try {
			connection = DBConnection.getConnection();
			PreparedStatement preparedStatement = connection
					.prepareStatement(InitConfigListener.dbHashMap.get("myGetUserRoleByUserName"));
			preparedStatement.setString(1, loginName);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				userRole = resultSet.getString("role");
			}
			DBConnection.close(connection, preparedStatement, resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userRole;
	}
	
	public String getSex(int sex) {
		return sex == 1 ? "ÄÐ" : "Å®";
	}

	@Override
	public boolean isUserNameExist(String userName) {
		boolean flag = false;
		try{
			Connection connection = DBConnection.getConnection();
			PreparedStatement preparedStatement = connection
					.prepareStatement(InitConfigListener.dbHashMap.get("getUserByName"));
			preparedStatement.setString(1,userName);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				flag = true;
			}
			DBConnection.close(connection,preparedStatement,resultSet);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean addUser(User user) {
		int count = 0;
		try {
			Connection connection = DBConnection.getConnection();
			PreparedStatement preparedStatement = connection
					.prepareStatement(InitConfigListener.dbHashMap.get("insertUserInfo"));
			preparedStatement.setString(++count, user.getUserName());
			preparedStatement.setString(++count, user.getPassword());
			preparedStatement.setInt(++count, user.getSex().equals("ÄÐ")?1:0);
			preparedStatement.setString(++count, user.getEmail());
			preparedStatement.setString(++count, user.getTeam());
			int index = preparedStatement.executeUpdate();
			DBConnection.close(connection, preparedStatement, null);
			if (index > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}




	@Override
	public boolean delUserById(String id) {
		try {
			Connection connection = DBConnection.getConnection();
			PreparedStatement preparedStatement = connection
					.prepareStatement(InitConfigListener.dbHashMap.get("myDeleteUser"));
			preparedStatement.setInt(1, Integer.parseInt(id));
			int index = preparedStatement.executeUpdate();
			DBConnection.close(connection, preparedStatement, null);
			if (index > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public String getPasswordByUserName(String userName) {
		Connection connection = null;
		String userRole = null;
		try {
			connection = DBConnection.getConnection();
			PreparedStatement preparedStatement = connection
					.prepareStatement(InitConfigListener.dbHashMap.get("getPasswordByUserName"));
			preparedStatement.setString(1, userName);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				userRole = resultSet.getString("password");
			}
			DBConnection.close(connection, preparedStatement, resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userRole;
	}

	@Override
	public boolean setValidataCodeByUserName(String validataCode, String loginName) {
		int count = 0;
		try {
			Connection connection = DBConnection.getConnection();
			PreparedStatement preparedStatement = connection
					.prepareStatement(InitConfigListener.dbHashMap.get("setValidataCodeByUserName"));
			preparedStatement.setString(++count, validataCode);
			preparedStatement.setString(++count, loginName);
			int index = preparedStatement.executeUpdate();
			DBConnection.close(connection, preparedStatement, null);
			if (index > 0) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public String getValidataCodeByUserName(String loginName) {
		Connection connection = null;
		String validataCode = null;
		try {
			connection = DBConnection.getConnection();
			PreparedStatement preparedStatement = connection
					.prepareStatement(InitConfigListener.dbHashMap.get("getValidataCodeByUserName"));
			preparedStatement.setString(1, loginName);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				validataCode = resultSet.getString("validataCode");
			}
			DBConnection.close(connection, preparedStatement, resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return validataCode;
	}

	@Override
	public String getEmailByUserName(String name) {
		Connection connection = null;
		String email = null;
		try {
			connection = DBConnection.getConnection();
			PreparedStatement preparedStatement = connection
					.prepareStatement(InitConfigListener.dbHashMap.get("getEmailByUserName"));
			preparedStatement.setString(1, name);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				email = resultSet.getString("email");
			}
			DBConnection.close(connection, preparedStatement, resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return email;
	}

	@Override
	public boolean setOutTimeByUserName(String outDate, String name) {
		int count = 0;
		try {
			Connection connection = DBConnection.getConnection();
			PreparedStatement preparedStatement = connection
					.prepareStatement(InitConfigListener.dbHashMap.get("setOutTimeByUserName"));
			preparedStatement.setString(++count, outDate);
			preparedStatement.setString(++count, name);
			int index = preparedStatement.executeUpdate();
			DBConnection.close(connection, preparedStatement, null);
			if (index > 0) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public String getOutTimeByUserName(String loginName) {
		Connection connection = null;
		String outTime = null;
		try {
			connection = DBConnection.getConnection();
			PreparedStatement preparedStatement = connection
					.prepareStatement(InitConfigListener.dbHashMap.get("getOutTimeByUserName"));
			preparedStatement.setString(1, loginName);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				outTime = resultSet.getString("outTime");
			}
			DBConnection.close(connection, preparedStatement, resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return outTime;
	}

	@Override
	public boolean setPasswordByUserName(String password, String name) {
		int count = 0;
		try {
			Connection connection = DBConnection.getConnection();
			PreparedStatement preparedStatement = connection
					.prepareStatement(InitConfigListener.dbHashMap.get("setPasswordByUserName"));
			preparedStatement.setString(++count, password);
			preparedStatement.setString(++count, name);
			int index = preparedStatement.executeUpdate();
			DBConnection.close(connection, preparedStatement, null);
			if (index > 0) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;	
	}



	@Override
	public User getUserById(String id) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public ArrayList<User> getAllUsers() {
		// TODO Auto-generated method stub
		ArrayList<User> userList = new ArrayList<User>();
		try{
			Connection connection = DBConnection.getConnection();
			PreparedStatement preparedStatement = connection
					.prepareStatement(InitConfigListener.dbHashMap.get("getAllUsers"));
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				User user = new User();
				user.setEmail(resultSet.getString("email"));
				user.setPassword(resultSet.getString("password"));
				user.setSex(getSex(resultSet.getInt("sex")));
				user.setTeam(resultSet.getString("team"));
				user.setUserId(resultSet.getString("user_id"));
				user.setUserName(resultSet.getString("user_name"));
				userList.add(user);
			}
			DBConnection.close(connection,preparedStatement,resultSet);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return userList;
	}
	
	
	//modify by mengwei 
	//find administrator user and login
	@Override
	public boolean getAdminUserName(String user){
		Connection connection = null;
		String username = null;
		try {
			connection = DBConnection.getConnection();
			PreparedStatement preparedStatement = connection
					.prepareStatement(InitConfigListener.dbHashMap.get("getAdminUserName"));
			preparedStatement.setString(1, user);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				username = resultSet.getString("username");
			}
			DBConnection.close(connection, preparedStatement, resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(!connection.isClosed())
					connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(user.equals(username))
			return true;
		else 
			return false;
	}



	@Override
	public String getAdminPassword(String username) {
		// TODO Auto-generated method stub
		Connection connection = null;
		String pass = null;
		try {
			connection = DBConnection.getConnection();
			PreparedStatement preparedStatement = connection
					.prepareStatement(InitConfigListener.dbHashMap.get("getAdminPassword"));
			preparedStatement.setString(1, username);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				pass = resultSet.getString("password");
			}
			DBConnection.close(connection, preparedStatement, resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
		}try {
			if(!connection.isClosed())
				connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pass;
	}



	@Override
	public boolean addNewUser(String username, String email, String sex, String team,String userid) {
		// TODO Auto-generated method stub
		
		Connection connection = null;
		String pass = null;
		boolean result = true;
		int count;
		try {
			connection = DBConnection.getConnection();
			PreparedStatement preparedStatement = connection
					.prepareStatement(InitConfigListener.dbHashMap.get("addNewUser"));

				preparedStatement.clearParameters();
				count = 0;
				preparedStatement.setString(++count, username);
				preparedStatement.setString(++count, email);
				preparedStatement.setString(++count, sex);
				preparedStatement.setString(++count, team);
				preparedStatement.setString(++count, "zte");
				preparedStatement.setString(++count, userid);
				System.out.println(preparedStatement);
				int index = preparedStatement.executeUpdate();
				if(index<0){
					result = false;
			}
			DBConnection.close(connection, preparedStatement, null);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(!connection.isClosed())
					connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}



	@Override
	public boolean removeUser(String userid) {
		// TODO Auto-generated method stub
		Connection connection = null;
		String pass = null;
		boolean result = true;
		int count;
		try {
			connection = DBConnection.getConnection();
			PreparedStatement preparedStatement = connection
					.prepareStatement(InitConfigListener.dbHashMap.get("removeUser"));
				preparedStatement.setString(1, userid);
				System.out.println(preparedStatement);
				int index = preparedStatement.executeUpdate();
				if(index<0){
					result = false;
			}
			DBConnection.close(connection, preparedStatement, null);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(!connection.isClosed())
					connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}



	@Override
	public boolean getUserIdByuserId(String userid) {
		// TODO Auto-generated method stub
		Connection connection = null;
		boolean result = false;
		try {
			connection = DBConnection.getConnection();
			PreparedStatement preparedStatement = connection
					.prepareStatement(InitConfigListener.dbHashMap.get("getUserIdByuserId"));
			preparedStatement.setString(1, userid);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				result=true;
			}
			DBConnection.close(connection, preparedStatement, resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				if(!connection.isClosed())
					connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	
	@Override
	public String getUserNameByuserId(String userid) {
		// TODO Auto-generated method stub
		Connection connection = null;
		String username = null;
		try {
			connection = DBConnection.getConnection();
			PreparedStatement preparedStatement = connection
					.prepareStatement(InitConfigListener.dbHashMap.get("getUserNameByuserId"));
			preparedStatement.setString(1, userid);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				username=resultSet.getString("user_name");
			}
			DBConnection.close(connection, preparedStatement, resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				if(!connection.isClosed())
					connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return username;
	}
	
	
}
