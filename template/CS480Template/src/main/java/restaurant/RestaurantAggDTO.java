package restaurant;

public class RestaurantAggDTO {

	private String foodType;
	private int count;
	
	
	public RestaurantAggDTO(String foodType, int count) {
		super();
		this.foodType = foodType;
		this.count = count;
	}
	public String getFoodType() {
		return foodType;
	}
	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	
}
