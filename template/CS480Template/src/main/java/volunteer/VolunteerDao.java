package volunteer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VolunteerDao {
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
	
	//Insert Volunteer
	public void insertVolunteer(Volunteer volunteer) throws ClassNotFoundException, InstantiationException, IllegalAccessException  {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection(URL, MySQL_user, MySQL_password);
			
			String sql = "insert into volunteer values(?,?,?,?,?);";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,volunteer.getUsers_id());
		    preparestatement.setString(2,volunteer.getVolunteer_name());
		    preparestatement.setString(3,volunteer.getPreferred_location());
		    preparestatement.setFloat(4,volunteer.getLocation_radius());
		    preparestatement.setString(5,volunteer.getAvailability_date());
		    preparestatement.executeUpdate();
		    connect.close();
		}
		catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	//Update
	public void updateVolunteer(Volunteer volunteer)throws ClassNotFoundException, InstantiationException, IllegalAccessException{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection(URL, MySQL_user, MySQL_password);
			
			String sql = "update volunteer set volunteer_name = ?, preferred_location = ?, location_radius = ?, availability_date = ? where users_id = ?;";
			PreparedStatement preparestatement = connect.prepareStatement(sql);
			preparestatement.setInt(5,volunteer.getUsers_id());
		    preparestatement.setString(1,volunteer.getVolunteer_name());
		    preparestatement.setString(2,volunteer.getPreferred_location());
		    preparestatement.setFloat(3,volunteer.getLocation_radius());
		    preparestatement.setString(4,volunteer.getAvailability_date());
		    preparestatement.executeUpdate();
		    connect.close();
		}
		catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	//Delete
	public void deleteVolunteer(int users_id)throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection(URL, MySQL_user, MySQL_password);
			
			String sql = "delete from volunteer where users_id = ?;";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,users_id);
		    preparestatement.executeUpdate();
		    connect.close();
		}
		catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	//Read
	public Volunteer findByVolunteerId(int users_id)throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Volunteer volunteer = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection(URL, MySQL_user, MySQL_password);
			
			String sql = "select * from volunteer where users_id=?;";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			
			preparestatement.setInt(1,users_id);
			ResultSet resultSet = preparestatement.executeQuery();
			while(resultSet.next()){
				int volunteerId = resultSet.getInt("users_id");
			    if(users_id == volunteerId){
			    	volunteer = new Volunteer();
			    	volunteer.setUsers_id(resultSet.getInt("users_id"));
			    	volunteer.setVolunteer_name(resultSet.getString("volunteer_name"));
			    	volunteer.setPreferred_location(resultSet.getString("preferred_location"));
			    	volunteer.setLocation_radius(resultSet.getFloat("location_radius"));
			    	volunteer.setAvailability_date(resultSet.getString("availability_date"));
			    	}
			    }
			    connect.close();
		}
		catch(SQLException e) {
			throw new RuntimeException(e);
		}
		
		return volunteer;
	}
	
	//Read All
	public List<Volunteer> findAll()throws ClassNotFoundException, InstantiationException, IllegalAccessException{
		List<Volunteer> resList = new ArrayList<Volunteer>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection(URL, MySQL_user, MySQL_password);
			
			String sql =  "select * from volunteer;";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();
			while(resultSet.next()) {
				Volunteer volunteer = new Volunteer();
				volunteer.setUsers_id(resultSet.getInt("users_id"));
		    	volunteer.setVolunteer_name(resultSet.getString("volunteer_name"));
		    	volunteer.setPreferred_location(resultSet.getString("preferred_location"));
		    	volunteer.setLocation_radius(resultSet.getFloat("location_radius"));
		    	volunteer.setAvailability_date(resultSet.getString("availability_date"));
		    	resList.add(volunteer);
			}
			connect.close();
		}
		catch(SQLException e) {
			throw new RuntimeException(e);
		}
		
		return resList; 
	}
	
	public List<VolunteerSimpleDTO> simpleQuery()throws ClassNotFoundException, InstantiationException, IllegalAccessException{
		List<VolunteerSimpleDTO> resList = new ArrayList<VolunteerSimpleDTO>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection(URL, MySQL_user, MySQL_password);
			
			String sql =  "select users_id, location_radius from volunteer where location_radius = 20.0;";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();
			while(resultSet.next()) {
				VolunteerSimpleDTO volunteerSimpleDTO = new VolunteerSimpleDTO(resultSet.getInt("users_id"), resultSet.getFloat("location_radius"));
				resList.add(volunteerSimpleDTO);
			}
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
		
		return resList;
	}
	
	public List<VolunteerAggregateDTO> aggregateQuery()throws ClassNotFoundException, InstantiationException, IllegalAccessException{
		List<VolunteerAggregateDTO> resList = new ArrayList<VolunteerAggregateDTO>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection(URL, MySQL_user, MySQL_password);
			
			String sql =  "select preferred_location, max(location_radius) from volunteer group by preferred_location having max(location_radius) > 20;";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();
			while(resultSet.next()) {
				VolunteerAggregateDTO volunteerAggregateDTO = new VolunteerAggregateDTO(resultSet.getString("preferred_location"), resultSet.getFloat("max(location_radius)"));
				resList.add(volunteerAggregateDTO);
			}
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
		
		return resList;
	}
	
	public List<VolunteerComplexDTO> complexQuery()throws ClassNotFoundException, InstantiationException, IllegalAccessException{
		List<VolunteerComplexDTO> resList = new ArrayList<VolunteerComplexDTO>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection(URL, MySQL_user, MySQL_password);
			
			String sql =  "select volunteer_name from volunteer v where exists( select * from users where ID = v.users_id and first_name = 'Andrea');";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();
			while(resultSet.next()) {
				VolunteerComplexDTO volunteerComplexDTO = new VolunteerComplexDTO(resultSet.getString("volunteer_name"));
				resList.add(volunteerComplexDTO);
			}
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
		
		return resList;
	}
	
		
}
