package interaction;

public class InteractionAggDTO {

	private String foodType;
	private int count;
	
	
	public InteractionAggDTO(String foodType, int count) {
		super();
		this.foodType = foodType;
		this.count = count;
	}
	public String getInteractionType() {
		return foodType;
	}
	public void setInteractionType(String foodType) {
		this.foodType = foodType;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	
}
