package initialize.dao;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;

import org.apache.ibatis.jdbc.ScriptRunner;




//import java.util.ArrayList;
//import java.util.List;



/**
 * DDL functions performed in database
 */
public class InitializeDao {
	
	/**
	 * user name to connect to the database 
	 */
	private String MySQL_user = "newuser"; //TODO change user
	
	/**
	 * password of your username to connect to the database
	 */
	private String MySQL_password = "passw"; //TODO change password

	
	public void initialize(InputStream input) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/forager", MySQL_user, MySQL_password);
			//Initialize the script runner
	   		 ScriptRunner sr = new ScriptRunner(connect);
	   		 //Creating a reader object
	   		 Reader reader = new InputStreamReader(input);
	   		 //Running the script
	   		 sr.runScript(reader);
		
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
