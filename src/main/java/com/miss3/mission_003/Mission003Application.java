package com.miss3.mission_003;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.DriverManager;
import java.sql.SQLException;

@SpringBootApplication
public class Mission003Application
{

	public static void main(String[] args)
	{
		/*String url = "jdbc";
		String user = "";
		String pwd = "";

		try
		{
			Connection myConn = DriverManager.getConnection(url, user, pwd);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}*/

		SpringApplication.run(Mission003Application.class, args);
	}

}
