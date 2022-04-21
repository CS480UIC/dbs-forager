package donor;

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
public class DonorDao {

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
	public Donor findByDonorId(Integer donorId)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Donor donor = null;
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/forager", MySQL_user,
					MySQL_password);
			String sql = "select * from donor where donor_id=?";
			PreparedStatement preparestatement = connect.prepareStatement(sql);
			preparestatement.setInt(1, donorId);
			ResultSet resultSet = preparestatement.executeQuery();
			while (resultSet.next()) {
				int donor_id = resultSet.getInt("donor_id");
				if (donor_id == donorId) {
				//	donor.setDonorId(resultSet.getInt("donor_id"));
					donor = new Donor(resultSet.getInt("users_id"), resultSet.getString("donor_type"),
							resultSet.getInt("no_of_times_donated"), resultSet.getInt("avg_rating_recieved"),
							resultSet.getInt("donor_id"));

				}
			}

			connect.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return donor;
	}

	/**
	 * insert User
	 */
	public void add(Donor donor) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/forager", MySQL_user,
					MySQL_password);

			String sql = "insert into donor(donor_id, donor_type, users_id) values(?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql);
			preparestatement.setInt(1, donor.getDonorId());
			preparestatement.setString(2, donor.getDonorType());
			preparestatement.setInt(3, donor.getUsersId());
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
			String sql = "select * from donor";
			PreparedStatement preparestatement = connect.prepareStatement(sql);
			ResultSet resultSet = preparestatement.executeQuery();
			while (resultSet.next()) {
				Donor donor = new Donor(resultSet.getInt("users_id"), resultSet.getString("donor_type"),
						resultSet.getInt("no_of_times_donated"), resultSet.getInt("avg_rating_recieved"),
						resultSet.getInt("donor_id"));
				list.add(donor);
			}
			connect.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return list;

	}

}
