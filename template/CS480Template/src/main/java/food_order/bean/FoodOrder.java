package food_order.bean;

public class FoodOrder {
	private int order_id;
	private String pick_up_location;
	private String drop_location;
	private int transporter_id;
	private int food_id;
	private String pick_up_time;
	private String drop_time;
	private int receiver_id;
	private int donor_id;
	
	public FoodOrder() {
		super();
	}
	
	public FoodOrder(int order_id, String pick_up_location, String drop_location, int transporter_id, int food_id,
			String pick_up_time, String drop_time, int receiver_id, int donor_id) {
		super();
		this.order_id = order_id;
		this.pick_up_location = pick_up_location;
		this.drop_location = drop_location;
		this.transporter_id = transporter_id;
		this.food_id = food_id;
		this.pick_up_time = pick_up_time;
		this.drop_time = drop_time;
		this.receiver_id = receiver_id;
		this.donor_id = donor_id;
	}
	public FoodOrder(String pick_up_location, String drop_location, int transporter_id, int food_id,
			String pick_up_time, String drop_time, int receiver_id, int donor_id) {
		super();
		this.pick_up_location = pick_up_location;
		this.drop_location = drop_location;
		this.transporter_id = transporter_id;
		this.food_id = food_id;
		this.pick_up_time = pick_up_time;
		this.drop_time = drop_time;
		this.receiver_id = receiver_id;
		this.donor_id = donor_id;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public String getPick_up_location() {
		return pick_up_location;
	}
	public void setPick_up_location(String pick_up_location) {
		this.pick_up_location = pick_up_location;
	}
	public String getDrop_location() {
		return drop_location;
	}
	public void setDrop_location(String drop_location) {
		this.drop_location = drop_location;
	}
	public int getTransporter_id() {
		return transporter_id;
	}
	public void setTransporter_id(int transporter_id) {
		this.transporter_id = transporter_id;
	}
	public int getFood_id() {
		return food_id;
	}
	public void setFood_id(int food_id) {
		this.food_id = food_id;
	}
	public String getPick_up_time() {
		return pick_up_time;
	}
	public void setPick_up_time(String pick_up_time) {
		this.pick_up_time = pick_up_time;
	}
	public String getDrop_time() {
		return drop_time;
	}
	public void setDrop_time(String drop_time) {
		this.drop_time = drop_time;
	}
	public int getReceiver_id() {
		return receiver_id;
	}
	public void setReceiver_id(int receiver_id) {
		this.receiver_id = receiver_id;
	}
	public int getDonor_id() {
		return donor_id;
	}
	public void setDonor_id(int donor_id) {
		this.donor_id = donor_id;
	}
	
}
