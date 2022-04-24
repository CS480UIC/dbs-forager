package interaction;

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
public class InteractionDao {

	/**
	 * user name to connect to the database
	 */
	private String MySQL_user = "newuser"; // TODO change user

	/**
	 * password of your username to connect to the database
	 */
	private String MySQL_password = "passw"; // TODO change password

	/**
	 * get the Search result with interactionId
	 */
	public Interaction findByInteractionId(int interactionId)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Interaction interaction = null;
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/forager", MySQL_user,
					MySQL_password);
			
			
		
			
			
			String sql = "select * from interaction where interaction_id=?";
			PreparedStatement preparestatement = connect.prepareStatement(sql);
			preparestatement.setInt(1, interactionId);
			ResultSet resultSet = preparestatement.executeQuery();
			while (resultSet.next()) {
				int interaction_id = resultSet.getInt("interaction_id");
				if (interaction_id == interactionId) {

					if(resultSet.getString("reply_of") == null) {
						
						interaction = new Interaction(resultSet.getString("interaction_id"), resultSet.getString("message_id"), resultSet.getString("to_id") , resultSet.getString("from_id") , resultSet.getString("date_created"));
					}else {
						interaction = new Interaction(resultSet.getString("interaction_id"), resultSet.getString("message_id"), resultSet.getString("reply_of") , resultSet.getString("to_id") , resultSet.getString("from_id") , resultSet.getString("date_created"));
					}
					
					
										
					//interaction = new Interaction(resultSet.getInt("interaction_id"), resultSet.getString("messageId"), resultSet.getString("replyOf"), resultSet.getInt("toId") , resultSet.getInt("fromId") , resultSet.getString("dateCreated") , resultSet.getString("messageContent"));
				}
			}
			
			System.out.println("hereeee123");
			System.out.println(interaction);
			System.out.println("hereeee");
			sql = "select * from message where message_id=?";
			preparestatement = connect.prepareStatement(sql);
			
			if(interaction != null)
			{
				
			preparestatement.setInt(1, interaction.getMessageId());
			resultSet = preparestatement.executeQuery();
			while (resultSet.next()) {
				//int interaction_id = resultSet.getInt("message_id");


					interaction.setMessageContent(resultSet.getString("message_content"));
					//interaction = new Interaction(resultSet.getString("interaction_id"), resultSet.getString("message_id"), resultSet.getString("reply_of"), resultSet.getString("to_id") , resultSet.getString("from_id") , resultSet.getString("date_created") , resultSet.getString("messageContent"));
										
					//interaction = new Interaction(resultSet.getInt("interaction_id"), resultSet.getString("messageId"), resultSet.getString("replyOf"), resultSet.getInt("toId") , resultSet.getInt("fromId") , resultSet.getString("dateCreated") , resultSet.getString("messageContent"));
				}
			
			}
			
			
			connect.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return interaction;
	}

	public void add(Interaction interaction) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/forager", MySQL_user,
					MySQL_password);
			
//			System.out.print
			
			//Interaction interaction = new Interaction(resultSet.getString("interaction_id"), resultSet.getString("messageId"), resultSet.getString("replyOf"), resultSet.getString("toId") , resultSet.getString("fromId") , resultSet.getString("dateCreated") , resultSet.getString("messageContent"));
			

			
			String sql = "insert into message( message_id , message_content ) values(?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql);
			preparestatement.setInt(1, interaction.getMessageId());
			preparestatement.setString(2, interaction.getMessageContent());
			preparestatement.executeUpdate();
			
			sql = "insert into interaction(interaction_id, message_id, reply_of , to_id  ,  from_id, date_created  ) values(?,?,?,?,?,?)";
			preparestatement = connect.prepareStatement(sql);
			preparestatement.setInt(1, interaction.getInteractionId());
			preparestatement.setInt(2, interaction.getMessageId());
			preparestatement.setInt(3, interaction.getReplyOf() );
			preparestatement.setInt(4, interaction.getToId());
			preparestatement.setInt(5, interaction.getFromId());
			preparestatement.setString(6, interaction.getDateCreated());
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
			String sql = "select * from interaction";
			PreparedStatement preparestatement = connect.prepareStatement(sql);
			ResultSet resultSet = preparestatement.executeQuery();
			while (resultSet.next()) {
				
				Interaction interaction = new Interaction(resultSet.getString("interaction_id"), resultSet.getString("messageId"), resultSet.getString("replyOf"), resultSet.getString("toId") , resultSet.getString("fromId") , resultSet.getString("dateCreated") , resultSet.getString("messageContent"));
				//Interaction interaction = new Interaction(resultSet.getInt("interaction_id"), resultSet.getString("food_type"), resultSet.getString("address"),resultSet.getInt("safety_rating"));
				list.add(interaction);
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
		String sql = "select * from interaction order by address desc";
		PreparedStatement preparestatement = connect.prepareStatement(sql);
		ResultSet resultSet = preparestatement.executeQuery();
		while (resultSet.next()) {
			
			Interaction interaction = new Interaction(resultSet.getString("interaction_id"), resultSet.getString("messageId"), resultSet.getString("replyOf"), resultSet.getString("toId") , resultSet.getString("fromId") , resultSet.getString("dateCreated") , resultSet.getString("messageContent"));
			
//			Interaction interaction = new Interaction(resultSet.getInt("interaction_id"), resultSet.getString("food_type"), resultSet.getString("address"),
//					resultSet.getInt("safety_rating"));
			list.add(interaction);
		}
		connect.close();
		return list;
	}

	public List<Object> aggQuery() throws Exception {
		List<Object> list = new ArrayList<>();
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/forager", MySQL_user,
				MySQL_password);
		String sql = "select food_type, count(*) " + " from interaction group by food_type " + "	order by count(*) desc";
		PreparedStatement preparestatement = connect.prepareStatement(sql);
		ResultSet resultSet = preparestatement.executeQuery();
		while (resultSet.next()) {
			InteractionAggDTO interactionAggDTO = new InteractionAggDTO(resultSet.getString("food_type"), resultSet.getInt("count(*)"));
			list.add(interactionAggDTO);
			
			
		}
		connect.close();
		return list;
	}

	public List<Object> complexQuery() throws Exception {
		List<Object> list = new ArrayList<>();
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/forager", MySQL_user,
				MySQL_password);
		String sql = "select * from interaction as d" + "	where exists ("
				+ "		select * from receiver where receiver.interaction_id = d.interaction_id" + "	);";
		PreparedStatement preparestatement = connect.prepareStatement(sql);
		ResultSet resultSet = preparestatement.executeQuery();
		while (resultSet.next()) {
			
			Interaction interaction = new Interaction(resultSet.getString("interaction_id"), resultSet.getString("messageId"), resultSet.getString("replyOf"), resultSet.getString("toId") , resultSet.getString("fromId") , resultSet.getString("dateCreated") , resultSet.getString("messageContent"));
			
//			Interaction interaction = new Interaction(resultSet.getInt("interaction_id"), resultSet.getString("food_type"), resultSet.getString("address"),
//					resultSet.getInt("safety_rating"));
			list.add(interaction);
		}
		connect.close();
		return list;
	}

	public void updateInteraction(Interaction interaction) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/forager", MySQL_user,
				MySQL_password);

		System.out.println(interaction);
		String sql = "update interaction set message_id=?, reply_of=?, to_id=? , from_id=? , date_created=? where interaction_id=?";
		PreparedStatement preparestatement = connect.prepareStatement(sql);
		preparestatement.setInt(6, interaction.getInteractionId());
		preparestatement.setInt(1, interaction.getMessageId());
		preparestatement.setInt(2, interaction.getReplyOf() );
		preparestatement.setInt(3, interaction.getToId());
		preparestatement.setInt(4, interaction.getFromId());
		preparestatement.setString(5, interaction.getDateCreated());
		preparestatement.executeUpdate();
		
				
		sql = "update message set message_content=? where message_id=?";
		preparestatement = connect.prepareStatement(sql);
		preparestatement.setInt(2, interaction.getMessageId());
		preparestatement.setString(1, interaction.getMessageContent());
		preparestatement.executeUpdate();
		
//		sql = "insert into interaction(interaction_id, messageId, replyOf , toId  ,  fromId, dateCreated  ) values(?,?,?,?,?,?)";
//		preparestatement = connect.prepareStatement(sql);
//		preparestatement.setInt(6, interaction.getInteractionId());
//		preparestatement.setInt(1, interaction.getMessageId());
//		preparestatement.setInt(2, interaction.getReplyOf() );
//		preparestatement.setInt(3, interaction.getToId());
//		preparestatement.setInt(4, interaction.getFromId());
//		preparestatement.setString(5, interaction.getDateCreated());
//		preparestatement.executeUpdate();
		
		connect.close();
	}

	public void deleteInteraction(int interactionId) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		
		System.out.println("helloooo deleting intra");
		
		Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/forager", MySQL_user,
				MySQL_password);
		String sql = "delete from interaction where interaction_id=?";
		PreparedStatement preparestatement = connect.prepareStatement(sql);
		preparestatement.setInt(1, interactionId);
		preparestatement.executeUpdate();
		connect.close();
	}

}
