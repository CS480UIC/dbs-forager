package receiver;

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
public class ReceiverDao {

	/**
	 * user name to connect to the database
	 */
	private String MySQL_user = "root"; // TODO change user

	/**
	 * password of your username to connect to the database
	 */
	private String MySQL_password = "root"; // TODO change password

	/**
	 * get the Search result with donorId
	 */
	public Receiver findByReceiverId(int receiverId) throws Exception {
		Receiver receiver = null;
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/forager", MySQL_user,
				MySQL_password);
		String sql = "select * from receiver where receiver_id=?";
		PreparedStatement preparestatement = connect.prepareStatement(sql);
		preparestatement.setInt(1, receiverId);
		ResultSet resultSet = preparestatement.executeQuery();
		while (resultSet.next()) {
			int receiver_id = resultSet.getInt("receiver_id");
			if (receiver_id == receiverId) {
				receiver = new Receiver(resultSet.getInt("users_id"), resultSet.getString("receiver_type"),
						resultSet.getInt("avg_rating_given"), resultSet.getInt("receiver_id"));

			}
		}
		connect.close();
		return receiver;
	}

	public void add(Receiver receiver) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/forager", MySQL_user,
				MySQL_password);

		String sql = "insert into receiver(receiver_id, receiver_type, users_id) values(?,?,?)";
		PreparedStatement preparestatement = connect.prepareStatement(sql);
		preparestatement.setInt(1, receiver.getReceiverId());
		preparestatement.setString(2, receiver.getReceiverType());
		preparestatement.setInt(3, receiver.getUsersId());
		preparestatement.executeUpdate();
		connect.close();
	}

	public List<Object> findall() throws Exception {
		List<Object> list = new ArrayList<>();
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/forager", MySQL_user,
				MySQL_password);
		String sql = "select * from receiver";
		PreparedStatement preparestatement = connect.prepareStatement(sql);
		ResultSet resultSet = preparestatement.executeQuery();
		while (resultSet.next()) {
			Receiver receiver = new Receiver(resultSet.getInt("users_id"), resultSet.getString("receiver_type"),
					resultSet.getInt("avg_rating_given"), resultSet.getInt("receiver_id"));
			list.add(receiver);
		}
		connect.close();
		return list;
	}

	public void updateReceiver(Receiver receiver) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/forager", MySQL_user,
				MySQL_password);
		String sql = "update receiver set receiver_type=?, users_id=?, avg_rating_given=? where receiver_id=?";
		PreparedStatement preparestatement = connect.prepareStatement(sql);
		preparestatement.setInt(3, receiver.getAvgRatingGiven());
		preparestatement.setInt(4, receiver.getReceiverId());
		preparestatement.setString(1, receiver.getReceiverType());
		preparestatement.setInt(2, receiver.getUsersId());
		preparestatement.executeUpdate();
		connect.close();
	}

	public void deleteReceiver(int receiverId) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/forager", MySQL_user,
				MySQL_password);
		String sql = "delete from receiver where receiver_id=?";
		PreparedStatement preparestatement = connect.prepareStatement(sql);
		preparestatement.setInt(1, receiverId);
		preparestatement.executeUpdate();
		connect.close();
	}

}
