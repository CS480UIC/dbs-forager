package food.bean;

public class FoodComplexDTO {
	private String food_name;
	private float calorie_tracker;
	public FoodComplexDTO(String food_name, float calorie_tracker) {
		super();
		this.food_name = food_name;
		this.calorie_tracker = calorie_tracker;
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
	
}
