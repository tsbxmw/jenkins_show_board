package com.visual.dao;

import java.util.ArrayList;
import java.util.List;

import com.visual.domain.User;



public interface IUserDao {

	/*
	List<User> selectUserData();
	
	String getSex(int sex);
	
	boolean insertUserData(User user);
	
	boolean updateUserData(User user);
	
	boolean deleteUserData(int userId);
	*/
	
	String getUserId(String loginName);
	
	String getUserRole(String loginName);

	
	/**
	 * 条件查询用户数量
	 * @param str_sql 查询条件
	 * @return 符合条件的用户数量
	 * 2016-04-22
	 */
	int getUserCount(String str_sql);

	/**
	 * 判断用户名是否存在
	 * @param userName
	 * @return true-已存在/false-不存在
	 * 2016-04-22
	 */
	boolean isUserNameExist(String userName);

	/**
	 * 添加新用户
	 * @param user
	 * @return
	 * 2016-04-22
	 */
	boolean addUser(User user);

	/**
	 * 通过Id获得该用户信息
	 * @param id
	 * @return
	 * 2016-04-22
	 */
	User getUserById(String id);

	/**
	 * 修改用户信息
	 * @param user
	 * 2016-04-22
	 */
	boolean updateUser(User user);

	/**
	 * 通过id删除该用户
	 * @param id 用户id
	 * 2016-04-22
	 */
	boolean delUserById(String id);

	/**
	 * 根据用户名得到密码
	 * @param userName
	 * @return
	 */
	String getPasswordByUserName(String userName);

	/**
	 * 通过用户名设置validataCode
	 * @param randomKey
	 * @param loginName 
	 */
	boolean setValidataCodeByUserName(String validataCode, String loginName);

	/**
	 * 通过用户名获取validataCode
	 * @param loginName
	 * @return
	 */
	String getValidataCodeByUserName(String loginName);

	/**
	 * 通过用户名获取邮箱
	 * @param name
	 * @return
	 */
	String getEmailByUserName(String name);

	/**
	 * 通过用户名设置验证码有效期限
	 * @param string
	 * @param name
	 */
	boolean setOutTimeByUserName(String outDate, String name);
	
	/**
	 * 通过用户名获取outTime
	 * @param loginName
	 * @return
	 */
	String getOutTimeByUserName(String loginName);

	/**
	 * 通过用户名设置密码
	 * @param password
	 * @param name
	 * @return
	 */
	boolean setPasswordByUserName(String password, String name);
	
	
	/**
	 * 获取所有用户
	 */
	boolean getAdminUserName(String username);
	/*
	 * 获取管理员用户
	 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * */
	String getAdminPassword(String username);
	/* 获取管理员用户
	 * */
	boolean addNewUser(String username,String email,String sex,String team,String userid);
	boolean removeUser(String userid);
	boolean getUserIdByuserId(String userid);
	
	public ArrayList<User> getAllUsers();

	String getUserNameByuserId(String userid);
}
