package com.visual.dao.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;


public class DBConnection {
	private static DataSource dataSource;
	static {
		Properties properties = new Properties();
		String webPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
		try {
			webPath=URLDecoder.decode(webPath,"utf-8");
			FileInputStream inStream = new FileInputStream(new File(
					webPath+"dbcp.properties"));
			properties.load(inStream);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			dataSource = BasicDataSourceFactory.createDataSource(properties);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}

	public static void close(Connection connection,
			PreparedStatement preparedStatement, ResultSet resultSet) {
			   try {
		  if (resultSet!=null)  {
				resultSet.close();
		  }
		  if (preparedStatement!=null) {
			  preparedStatement.close();
		  }
		  if (connection!=null) {
			 connection.close();
		}
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

}
