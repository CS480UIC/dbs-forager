package restaurant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

/**
 * DDL functions performed in database
 */
public class RestaurantDao {

	/**
	 * user name to connect to the database
	 */
	private String MySQL_user = "forager"; // TODO change user

	/**
	 * password of your username to connect to the database
	 */
	private String MySQL_password = "warrior"; // TODO change password

	/**
	 * get the Search result with restaurantId
	 */
	public Restaurant findByRestaurantId(int restaurantId)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Restaurant restaurant = null;
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/forager", MySQL_user,
					MySQL_password);
			String sql = "select * from restaurant where restaurant_id=?";
			PreparedStatement preparestatement = connect.prepareStatement(sql);
			preparestatement.setInt(1, restaurantId);
			ResultSet resultSet = preparestatement.executeQuery();
			while (resultSet.next()) {
				int restaurant_id = resultSet.getInt("restaurant_id");
				if (restaurant_id == restaurantId) {
					restaurant = new Restaurant(resultSet.getInt("restaurant_id"), resultSet.getString("food_type"), resultSet.getString("address"), resultSet.getInt("safety_rating"));
				}
			}
			connect.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return restaurant;
	}

	public void add(Restaurant restaurant) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/forager", MySQL_user,
					MySQL_password);
			
//			System.out.print
			
			String sql = "insert into restaurant(restaurant_id, food_type, address , safety_rating) values(?,?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql);
			preparestatement.setInt(1, restaurant.getRestaurantId());
			preparestatement.setString(2, restaurant.getFoodType());
			preparestatement.setString(3, restaurant.getAddress() );
			preparestatement.setInt(4, restaurant.getSafetyRating());
			preparestatement.executeUpdate();
			connect.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Object> findall() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/forager", MySQL_user,
					MySQL_password);
			String sql = "select * from restaurant";
			PreparedStatement preparestatement = connect.prepareStatement(sql);
			ResultSet resultSet = preparestatement.executeQuery();
			while (resultSet.next()) {
				Restaurant restaurant = new Restaurant(resultSet.getInt("restaurant_id"), resultSet.getString("food_type"), resultSet.getString("address"),resultSet.getInt("safety_rating"));
				list.add(restaurant);
			}
			connect.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
	}

	public List<Object> simpleQuery() throws Exception {
		List<Object> list = new ArrayList<>();
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/forager", MySQL_user,
				MySQL_password);
		String sql = "select * from restaurant order by safety_rating desc";
		PreparedStatement preparestatement = connect.prepareStatement(sql);
		ResultSet resultSet = preparestatement.executeQuery();
		while (resultSet.next()) {
			Restaurant restaurant = new Restaurant(resultSet.getInt("restaurant_id"), resultSet.getString("food_type"), resultSet.getString("address"),
					resultSet.getInt("safety_rating"));
			list.add(restaurant);
		}
		connect.close();
		return list;
	}

	public List<Object> aggQuery() throws Exception {
		List<Object> list = new ArrayList<>();
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/forager", MySQL_user,
				MySQL_password);
		String sql = "select food_type, count(*) " + " from restaurant group by food_type " + "	order by count(*) desc";
		PreparedStatement preparestatement = connect.prepareStatement(sql);
		ResultSet resultSet = preparestatement.executeQuery();
		while (resultSet.next()) {
			
			//System.out.println(resultSet.getString("food_type") +"  " + resultSet.getInt("count(*)"));
			
			RestaurantAggDTO restaurantAggDTO = new RestaurantAggDTO(resultSet.getString("food_type"), resultSet.getInt("count(*)"));
			list.add(restaurantAggDTO);
			
			System.out.println("real " + restaurantAggDTO.getFoodType()  + "  "  + restaurantAggDTO.getCount());
			
//			
//			Restaurant restaurant = new Restaurant(resultSet.getString("food_type"),resultSet.getInt("count(*)"));
//			list.add(restaurant);
			
//			Restaurant restaurantAggDTO = new Restaurant(resultSet.getString("food_type"), resultSet.getInt("count(*)"));
//			list.add(restaurantAggDTO);
			
		}
		connect.close();
		
		System.out.println(list);
		
		return list;
	}

	public List<Object> complexQuery() throws Exception {
		List<Object> list = new ArrayList<>();
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/forager", MySQL_user,
				MySQL_password);
		String sql = "\r\n"
				+ "select * from users inner join restaurant on users.org_id = restaurant.restaurant_id where exists (select * from receiver where users_id = users.ID );";
		PreparedStatement preparestatement = connect.prepareStatement(sql);
		ResultSet resultSet = preparestatement.executeQuery();
		while (resultSet.next()) {
			Restaurant restaurant = new Restaurant(resultSet.getInt("restaurant_id"), resultSet.getString("food_type"), resultSet.getString("address"),
					resultSet.getInt("safety_rating"));
			list.add(restaurant);
		}
		connect.close();
		return list;
	}

	public void updateRestaurant(Restaurant restaurant) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/forager", MySQL_user,
				MySQL_password);
		String sql = "update restaurant set food_type=?, address=?, safety_rating=? where restaurant_id=?";
		PreparedStatement preparestatement = connect.prepareStatement(sql);
		preparestatement.setString(2, restaurant.getAddress());
		preparestatement.setInt(3, restaurant.getSafetyRating());
		preparestatement.setString(1, restaurant.getFoodType());
		preparestatement.setInt(4, restaurant.getRestaurantId());
		preparestatement.executeUpdate();
		connect.close();
	}

	public void deleteRestaurant(int restaurantId) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/forager", MySQL_user,
				MySQL_password);
		String sql = "delete from restaurant where restaurant_id=?";
		PreparedStatement preparestatement = connect.prepareStatement(sql);
		preparestatement.setInt(1, restaurantId);
		preparestatement.executeUpdate();
		connect.close();
	}

}
