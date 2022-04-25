package food.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import food.bean.Food;
import food.bean.FoodAggregateDTO;
import food.bean.FoodComplexDTO;

public class FoodDao {
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
	
	//Insert Food
	public void insertFood(Food food) throws ClassNotFoundException, InstantiationException, IllegalAccessException  {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection(URL, MySQL_user, MySQL_password);
			
			String sql = "insert into food values(?,?,?,?,?);";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,food.getFood_id());
		    preparestatement.setString(2,food.getFood_type());
		    preparestatement.setString(3,food.getFood_name());
		    preparestatement.setFloat(4,food.getCalorie_tracker());
		    preparestatement.setInt(5,food.getDonor_id());
		    preparestatement.executeUpdate();
		    connect.close();
		}
		catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	//Update
	public void updateFood(Food food)throws ClassNotFoundException, InstantiationException, IllegalAccessException{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection(URL, MySQL_user, MySQL_password);
			
			String sql = "update food set food_type = ?, food_name = ?, calorie_tracker = ?, donor_id = ? where food_id = ?;";
			PreparedStatement preparestatement = connect.prepareStatement(sql);
			preparestatement.setInt(5,food.getFood_id());
		    preparestatement.setString(1,food.getFood_type());
		    preparestatement.setString(2,food.getFood_name());
		    preparestatement.setFloat(3,food.getCalorie_tracker());
		    preparestatement.setInt(4,food.getDonor_id());
		    preparestatement.executeUpdate();
		    connect.close();
		}
		catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	//Delete
	public void deleteFood(int food_id)throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection(URL, MySQL_user, MySQL_password);
			
			String sql = "delete from food where food_id = ?;";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,food_id);
		    preparestatement.executeUpdate();
		    connect.close();
		}
		catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	//Read
	public Food findByFoodId(int food_id)throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Food food = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection(URL, MySQL_user, MySQL_password);
			
			String sql = "select * from food where food_id=?;";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			
			preparestatement.setInt(1,food_id);
			ResultSet resultSet = preparestatement.executeQuery();
			while(resultSet.next()){
				int foodId = resultSet.getInt("food_id");
			    if(food_id == foodId){
			    	food = new Food();
			    	food.setFood_id(resultSet.getInt("food_id"));
			    	food.setFood_type(resultSet.getString("food_type"));
			    	food.setFood_name(resultSet.getString("food_name"));
			    	food.setCalorie_tracker(resultSet.getFloat("calorie_tracker"));
			    	food.setDonor_id(resultSet.getInt("donor_id"));
			    	}
			    }
			    connect.close();
		}
		catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return food;
	}
	
	//Read All
	public List<Food> findAll()throws ClassNotFoundException, InstantiationException, IllegalAccessException{
		List<Food> resList = new ArrayList<Food>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection(URL, MySQL_user, MySQL_password);
			
			String sql =  "Select * from food;";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();
			while(resultSet.next()) {
				Food food = new Food();
				food.setFood_id(resultSet.getInt("food_id"));
		    	food.setFood_type(resultSet.getString("food_type"));
		    	food.setFood_name(resultSet.getString("food_name"));
		    	food.setCalorie_tracker(resultSet.getFloat("calorie_tracker"));
		    	food.setDonor_id(resultSet.getInt("donor_id"));
		    	resList.add(food);
			}
			connect.close();
		}
		catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return resList; 
	}
	
	public List<Food> simpleQuery()throws ClassNotFoundException, InstantiationException, IllegalAccessException{
		List<Food> resList = new ArrayList<Food>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection(URL, MySQL_user, MySQL_password);
			
			String sql =  "SELECT * FROM food WHERE food_type LIKE \"Dairy\" OR food_type = \"Protein\" ORDER BY calorie_tracker;";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();
			while(resultSet.next()) {
				Food food = new Food();
				food.setFood_id(resultSet.getInt("food_id"));
		    	food.setFood_type(resultSet.getString("food_type"));
		    	food.setFood_name(resultSet.getString("food_name"));
		    	food.setCalorie_tracker(resultSet.getFloat("calorie_tracker"));
		    	food.setDonor_id(resultSet.getInt("donor_id"));
		    	resList.add(food);
			}
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return resList;
	}
	
	public List<FoodAggregateDTO> aggregateQuery()throws ClassNotFoundException, InstantiationException, IllegalAccessException{
		List<FoodAggregateDTO> resList = new ArrayList<FoodAggregateDTO>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection(URL, MySQL_user, MySQL_password);
			
			String sql =  "SELECT food_type, AVG(calorie_tracker) AS avgCalorieTracker FROM food GROUP BY food_type HAVING AVG(calorie_tracker)>50.0;";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();
			while(resultSet.next()) {
				FoodAggregateDTO foodAggregateDTO = new FoodAggregateDTO(resultSet.getString("food_type"), resultSet.getFloat("avgCalorieTracker"));
				resList.add(foodAggregateDTO);
			}
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return resList;
	}
	
	public List<FoodComplexDTO> complexQuery()throws ClassNotFoundException, InstantiationException, IllegalAccessException{
		List<FoodComplexDTO> resList = new ArrayList<FoodComplexDTO>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection(URL, MySQL_user, MySQL_password);
			
			String sql =  "SELECT food_name, main.calorie_tracker AS calories "
					+ "FROM food AS main WHERE main.calorie_tracker = (SELECT MAX(sub.calorie_tracker) "
					+ "FROM food AS sub WHERE sub.food_type LIKE \"veg\");";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();
			while(resultSet.next()) {
				FoodComplexDTO foodComplexDTO = new FoodComplexDTO(resultSet.getString("food_name"), resultSet.getFloat("calories"));
				resList.add(foodComplexDTO);
			}
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return resList;
	}
	
		
}
