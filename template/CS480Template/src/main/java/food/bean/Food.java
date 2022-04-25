package food.bean;

public class Food {
	private int food_id;
	private String food_type;
	private String food_name;
	private float calorie_tracker;
	private int donor_id;
	
	public Food() {
		
	}

	public Food(String food_type, String food_name, float calorie_tracker, int donor_id) {
		super();
		this.food_type = food_type;
		this.food_name = food_name;
		this.calorie_tracker = calorie_tracker;
		this.donor_id = donor_id;
	}

	public Food(int food_id, String food_type, String food_name, float calorie_tracker, int donor_id) {
		super();
		this.food_id = food_id;
		this.food_type = food_type;
		this.food_name = food_name;
		this.calorie_tracker = calorie_tracker;
		this.donor_id = donor_id;
	}

	public int getFood_id() {
		return food_id;
	}

	public void setFood_id(int food_id) {
		this.food_id = food_id;
	}

	public String getFood_type() {
		return food_type;
	}

	public void setFood_type(String food_type) {
		this.food_type = food_type;
	}

	public String getFood_name() {
		return food_name;
	}

	public void setFood_name(String food_name) {
		this.food_name = food_name;
	}

	public float getCalorie_tracker() {
		return calorie_tracker;
	}

	public void setCalorie_tracker(float calorie_tracker) {
		this.calorie_tracker = calorie_tracker;
	}

	public int getDonor_id() {
		return donor_id;
	}

	public void setDonor_id(int donor_id) {
		this.donor_id = donor_id;
	}
	
}
