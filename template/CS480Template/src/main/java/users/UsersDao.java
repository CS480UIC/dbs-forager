package users;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsersDao {
	/**
	 * user name to connect to the database 
	 */
	private String MySQL_user = "forager"; //TODO change user
	
	/**
	 * password of your username to connect to the database
	 */
	private String MySQL_password = "warrior"; //TODO change password
	
	/**
	 * URL
	 */
	private String URL = "jdbc:mysql://127.0.0.1:3306/forager";
	
	//Insert Users
	public void insertUsers(Users users) throws ClassNotFoundException, InstantiationException, IllegalAccessException  {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection(URL, MySQL_user, MySQL_password);
			
			String sql = "insert into users values(?,?,?,?,?,?,?,?,?,?);";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,users.getID());
		    preparestatement.setString(2,users.getUsername());
		    preparestatement.setString(3,users.getPassword());
		    preparestatement.setString(4,users.getName_of_organization());
		    preparestatement.setInt(5,users.getOrg_id());
		    preparestatement.setString(6,users.getFirst_name());
		    preparestatement.setString(7,users.getLast_name());
		    preparestatement.setString(8,users.getEmail_id());
		    preparestatement.setLong(9,users.getContact_number());
		    preparestatement.setString(10,users.getAddress());
		    
		    preparestatement.executeUpdate();
		    connect.close();
		}
		catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	//Update
	public void updateUsers(Users users)throws ClassNotFoundException, InstantiationException, IllegalAccessException{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection(URL, MySQL_user, MySQL_password);
			
			String sql = "update users set username = ?, password = ?, name_of_organization = ?, org_id = ?, first_name = ?, last_name = ?, email_id = ?, contact_number = ?, address = ? where ID = ?;";
			PreparedStatement preparestatement = connect.prepareStatement(sql);
			preparestatement.setInt(10,users.getID());
		    preparestatement.setString(1,users.getUsername());
		    preparestatement.setString(2,users.getPassword());
		    preparestatement.setString(3,users.getName_of_organization());
		    preparestatement.setInt(4,users.getOrg_id());
		    preparestatement.setString(5,users.getFirst_name());
		    preparestatement.setString(6,users.getLast_name());
		    preparestatement.setString(7,users.getEmail_id());
		    preparestatement.setLong(8,users.getContact_number());
		    preparestatement.setString(9,users.getAddress());
		    preparestatement.executeUpdate();
		    connect.close();
		}
		catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	//Delete
	public void deleteUsers(int ID)throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection(URL, MySQL_user, MySQL_password);
			
			String sql = "delete from users where ID = ?;";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,ID);
		    preparestatement.executeUpdate();
		    connect.close();
		}
		catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	//Read
	public Users findByUsersId(int ID)throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Users users = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection(URL, MySQL_user, MySQL_password);
			
			String sql = "select * from users where ID=?;";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			
			preparestatement.setInt(1,ID);
			ResultSet resultSet = preparestatement.executeQuery();
			while(resultSet.next()){
				int usersId = resultSet.getInt("ID");
			    if(ID == usersId){
			    	users = new Users();
			    	users.setID(resultSet.getInt("ID"));
			    	users.setUsername(resultSet.getString("username"));
			    	users.setPassword(resultSet.getString("password"));
			    	users.setName_of_organization(resultSet.getString("name_of_organization"));
			    	users.setOrg_id(resultSet.getInt("org_id"));
			    	users.setFirst_name(resultSet.getString("first_name"));
			    	users.setLast_name(resultSet.getString("last_name"));
			    	users.setEmail_id(resultSet.getString("email_id"));
			    	users.setContact_number(resultSet.getLong("contact_number"));
			    	users.setAddress(resultSet.getString("address"));
			    	}
			    }
			    connect.close();
		}
		catch(SQLException e) {
			throw new RuntimeException(e);
		}
		
		return users;
	}
	
	//Read All
	public List<Users> findAll()throws ClassNotFoundException, InstantiationException, IllegalAccessException{
		List<Users> resList = new ArrayList<Users>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection(URL, MySQL_user, MySQL_password);
			
			String sql =  "select * from users;";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();
			while(resultSet.next()) {
				Users users = new Users();
				users.setID(resultSet.getInt("ID"));
		    	users.setUsername(resultSet.getString("username"));
		    	users.setPassword(resultSet.getString("password"));
		    	users.setName_of_organization(resultSet.getString("name_of_organization"));
		    	users.setOrg_id(resultSet.getInt("org_id"));
		    	users.setFirst_name(resultSet.getString("first_name"));
		    	users.setLast_name(resultSet.getString("last_name"));
		    	users.setEmail_id(resultSet.getString("email_id"));
		    	users.setContact_number(resultSet.getLong("contact_number"));
		    	users.setAddress(resultSet.getString("address"));
		    	resList.add(users);
			}
			connect.close();
		}
		catch(SQLException e) {
			throw new RuntimeException(e);
		}
		
		return resList; 
	}
	
	
		
}
