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
	 * ������ѯ�û�����
	 * @param str_sql ��ѯ����
	 * @return �����������û�����
	 * 2016-04-22
	 */
	int getUserCount(String str_sql);

	/**
	 * �ж��û����Ƿ����
	 * @param userName
	 * @return true-�Ѵ���/false-������
	 * 2016-04-22
	 */
	boolean isUserNameExist(String userName);

	/**
	 * ������û�
	 * @param user
	 * @return
	 * 2016-04-22
	 */
	boolean addUser(User user);

	/**
	 * ͨ��Id��ø��û���Ϣ
	 * @param id
	 * @return
	 * 2016-04-22
	 */
	User getUserById(String id);

	/**
	 * �޸��û���Ϣ
	 * @param user
	 * 2016-04-22
	 */
	boolean updateUser(User user);

	/**
	 * ͨ��idɾ�����û�
	 * @param id �û�id
	 * 2016-04-22
	 */
	boolean delUserById(String id);

	/**
	 * �����û����õ�����
	 * @param userName
	 * @return
	 */
	String getPasswordByUserName(String userName);

	/**
	 * ͨ���û�������validataCode
	 * @param randomKey
	 * @param loginName 
	 */
	boolean setValidataCodeByUserName(String validataCode, String loginName);

	/**
	 * ͨ���û�����ȡvalidataCode
	 * @param loginName
	 * @return
	 */
	String getValidataCodeByUserName(String loginName);

	/**
	 * ͨ���û�����ȡ����
	 * @param name
	 * @return
	 */
	String getEmailByUserName(String name);

	/**
	 * ͨ���û���������֤����Ч����
	 * @param string
	 * @param name
	 */
	boolean setOutTimeByUserName(String outDate, String name);
	
	/**
	 * ͨ���û�����ȡoutTime
	 * @param loginName
	 * @return
	 */
	String getOutTimeByUserName(String loginName);

	/**
	 * ͨ���û�����������
	 * @param password
	 * @param name
	 * @return
	 */
	boolean setPasswordByUserName(String password, String name);
	
	
	/**
	 * ��ȡ�����û�
	 */
	boolean getAdminUserName(String username);
	/*
	 * ��ȡ����Ա�û�
	 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * */
	String getAdminPassword(String username);
	/* ��ȡ����Ա�û�
	 * */
	boolean addNewUser(String username,String email,String sex,String team,String userid);
	boolean removeUser(String userid);
	boolean getUserIdByuserId(String userid);
	
	public ArrayList<User> getAllUsers();

	String getUserNameByuserId(String userid);
}
