package food_order.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import food_order.bean.FoodOrder;


public class FoodOrderDAO {
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
		public void insertFoodOrder(FoodOrder foodOrder) throws ClassNotFoundException, InstantiationException, IllegalAccessException  {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection connect = DriverManager.getConnection(URL, MySQL_user, MySQL_password);
				
				String sql = "insert into food_order values(?,?,?,?,?,STR_TO_DATE(?,'%Y-%m-%dT%H:%i:%s.%f'),STR_TO_DATE(?,'%Y-%m-%dT%H:%i:%s.%f'),?,?);";
				PreparedStatement preparestatement = connect.prepareStatement(sql); 
			  preparestatement.setInt(1, foodOrder.getOrder_id());
			  preparestatement.setString(2, foodOrder.getPick_up_location());
			  preparestatement.setString(3, foodOrder.getDrop_location());
			  preparestatement.setInt(4,foodOrder.getTransporter_id());
			  preparestatement.setInt(5,foodOrder.getFood_id());
			  preparestatement.setString(6, foodOrder.getPick_up_time());
			  preparestatement.setString(7, foodOrder.getDrop_time());
			  preparestatement.setInt(8, foodOrder.getDonor_id());
			  preparestatement.setInt(9, foodOrder.getReceiver_id());
			    preparestatement.executeUpdate();
			    connect.close();
			}
			catch(SQLException e) {
				throw new RuntimeException(e);
			}
		}
		
		//Update
		public void updateFoodOrder(FoodOrder foodOrder)throws ClassNotFoundException, InstantiationException, IllegalAccessException{
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection connect = DriverManager.getConnection(URL, MySQL_user, MySQL_password);
				
				String sql = "update food_order set pick_up_location = ?, drop_location = ?, transporter_id = ?, food_id = ?, pick_up_time = ?, drop_time = ?,donor_id = ?, receiver_id = ? where order_id = ?;";
				PreparedStatement preparestatement = connect.prepareStatement(sql);
				  preparestatement.setInt(9, foodOrder.getOrder_id());
				  preparestatement.setString(1, foodOrder.getPick_up_location());
				  preparestatement.setString(2, foodOrder.getDrop_location());
				  preparestatement.setInt(3,foodOrder.getTransporter_id());
				  preparestatement.setInt(4,foodOrder.getFood_id());
				  preparestatement.setString(5, foodOrder.getPick_up_time());
				  preparestatement.setString(6, foodOrder.getDrop_time());
				  preparestatement.setInt(7, foodOrder.getDonor_id());
				  preparestatement.setInt(8, foodOrder.getReceiver_id());
			    preparestatement.executeUpdate();
			    connect.close();
			}
			catch(SQLException e) {
				throw new RuntimeException(e);
			}
		}
		
		//Delete
		public void deleteFoodOrder(int order_id)throws ClassNotFoundException, InstantiationException, IllegalAccessException {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection connect = DriverManager.getConnection(URL, MySQL_user, MySQL_password);
				
				String sql = "delete from food_order where order_id = ?;";
				PreparedStatement preparestatement = connect.prepareStatement(sql); 
			    preparestatement.setInt(1,order_id);
			    preparestatement.executeUpdate();
			    connect.close();
			}
			catch(SQLException e) {
				throw new RuntimeException(e);
			}
		}
		
		//Read
		public FoodOrder findByOrderId(int order_id)throws ClassNotFoundException, InstantiationException, IllegalAccessException {
			FoodOrder foodOrder = null;
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection connect = DriverManager.getConnection(URL, MySQL_user, MySQL_password);
				
				String sql = "select * from food_order where order_id=?;";
				PreparedStatement preparestatement = connect.prepareStatement(sql); 
				
				preparestatement.setInt(1,order_id);
				ResultSet resultSet = preparestatement.executeQuery();
				while(resultSet.next()){
					int orderId = resultSet.getInt("order_id");
				    if(order_id == orderId){
				    	foodOrder = new FoodOrder();
				    	foodOrder.setOrder_id(resultSet.getInt("order_id"));
				    	foodOrder.setPick_up_location(resultSet.getString("pick_up_location"));
				    	foodOrder.setDrop_location(resultSet.getString("drop_location"));
				    	foodOrder.setTransporter_id(resultSet.getInt("transporter_id"));
				    	foodOrder.setFood_id(resultSet.getInt("food_id"));
				    	foodOrder.setPick_up_time(resultSet.getString("pick_up_time"));
				    	foodOrder.setDrop_time(resultSet.getString("drop_time"));
				    	foodOrder.setReceiver_id(resultSet.getInt("receiver_id"));
				    	foodOrder.setDonor_id(resultSet.getInt("donor_id"));
				    	}
				    }
				    connect.close();
			}
			catch(SQLException e) {
				throw new RuntimeException(e);
			}
			return foodOrder;
		}
		//Read All
		public List<FoodOrder> findAll()throws ClassNotFoundException, InstantiationException, IllegalAccessException{
			List<FoodOrder> resList = new ArrayList<FoodOrder>();
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection connect = DriverManager.getConnection(URL, MySQL_user, MySQL_password);
				
				String sql =  "Select * from food_order;";
				PreparedStatement preparestatement = connect.prepareStatement(sql); 
				ResultSet resultSet = preparestatement.executeQuery();
				while(resultSet.next()) {
					FoodOrder foodOrder = new FoodOrder();
					foodOrder.setOrder_id(resultSet.getInt("order_id"));
			    	foodOrder.setPick_up_location(resultSet.getString("pick_up_location"));
			    	foodOrder.setDrop_location(resultSet.getString("drop_location"));
			    	foodOrder.setTransporter_id(resultSet.getInt("transporter_id"));
			    	foodOrder.setFood_id(resultSet.getInt("food_id"));
			    	foodOrder.setPick_up_time(resultSet.getString("pick_up_time"));
			    	foodOrder.setDrop_time(resultSet.getString("drop_time"));
			    	foodOrder.setReceiver_id(resultSet.getInt("receiver_id"));
			    	foodOrder.setDonor_id(resultSet.getInt("donor_id"));
			    	resList.add(foodOrder);
				}
				connect.close();
			}
			catch(SQLException e) {
				throw new RuntimeException(e);
			}
			return resList; 
		}
}
