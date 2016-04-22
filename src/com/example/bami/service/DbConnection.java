package com.example.bami.service;

import com.google.cloud.sql.jdbc.Connection;

import java.sql.DriverManager;



public class DbConnection {

	private  String url;
	private  Connection conn = null;
	private  String user = "root";
	private  String password = "12345";
	
	public DbConnection() throws Exception {
		/*Class.forName("com.mysql.jdbc.Driver");
		//this.url = "jdbc:mysql://127.0.0.1:3306/bamidata";
		this.url = "jdbc:google:rdbms://localhost/bamidata";
		if(conn == null || conn.isClosed())
			this.conn = (Connection)DriverManager.getConnection(url,user,password);*/
	}

	public Connection getConn() throws Exception {
		Boolean dev = false;
		if(!dev) {
			Class.forName("com.mysql.jdbc.GoogleDriver");
	        url = "jdbc:google:rdbms://bami-2414:bami-sql/bamidata?user=root";
			//Class.forName("com.mysql.jdbc.Driver");
			//url = "jdbc:google:rdbms://173.194.237.232:3306/bamidata";
		} else {
			Class.forName("com.mysql.jdbc.Driver");
			//this.url = "jdbc:mysql://127.0.0.1:3306/bamidata";
			url = "jdbc:google:rdbms://localhost/bamidata?user="+user+"&password="+password;
		}
		//if(conn == null || !conn.isValid(1))
			conn = (Connection)DriverManager.getConnection(url);
		return conn;
	}
	
	public void closeConnection() throws Exception {
		conn.close();
	}
}
