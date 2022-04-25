package food.bean;

public class FoodAggregateDTO {
	private String food_type;
	private float average;
	public FoodAggregateDTO(String food_type, float average) {
		super();
		this.food_type = food_type;
		this.average = average;
	}
	public String getFood_type() {
		return food_type;
	}
	public void setFood_type(String food_type) {
		this.food_type = food_type;
	}
	public float getAverage() {
		return average;
	}
	public void setAverage(float average) {
		this.average = average;
	}
	
}
