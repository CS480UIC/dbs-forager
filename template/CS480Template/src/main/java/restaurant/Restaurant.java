package restaurant;

public class Restaurant {

	
		
			
	private int restaurantId;
	private String foodType;
	private String address;
	private int safetyRating;
	private int count;


	public Restaurant() {
	}

	public Restaurant(String foodType, String restaurantId) {
		super();
		this.restaurantId = Integer.parseInt(restaurantId);
		this.foodType = foodType;
	
	}
	
	public Restaurant(int restaurantId, int safetyRating , String address ,String foodType ) {
		super();
		this.restaurantId = restaurantId;
		this.foodType = foodType;
		this.address = address;
		this.safetyRating  = safetyRating;
	}

	public Restaurant(int restaurantId, String foodType, String address, int safetyRating) {
		super();
		this.restaurantId = restaurantId;
		this.foodType = foodType;
		this.address = address;
		this.safetyRating  = safetyRating;
	
	}
	
	public Restaurant(int restaurantId, String foodType, String address, int safetyRating , int junk) {
		super();
		this.restaurantId = restaurantId;
		this.foodType = foodType;
		this.address = address;
		this.safetyRating  = safetyRating;
	
	}
	



	public Restaurant(  String restaurantId, String safetyRating,  String address, String foodType ) {
		super();
		this.restaurantId = Integer.parseInt(restaurantId);
		this.foodType = foodType;
		this.address = address;
		this.safetyRating  = Integer.parseInt(safetyRating);

	}



	public Restaurant(String string, int int1) {
		// TODO Auto-generated constructor stub
		this.foodType = string;
		this.count = int1;
	}

	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getFoodType() {
		return foodType;
	}

	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getSafetyRating() {
		return safetyRating ;
	}

	public void setSafetyRating(int safetyRating) {
		this.safetyRating  = safetyRating;
	}

	@Override
	public String toString() {
		return "Restaurant [restaurantId=" + restaurantId + ", foodType=" + foodType + ", address=" + address
				+ ", safetyRating =" + safetyRating  + "]";
	}

}
