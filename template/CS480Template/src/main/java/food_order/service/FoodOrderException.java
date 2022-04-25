package food_order.service;

public class FoodOrderException extends Exception{
	private static final long serialVersionUID = 1L;
	
	public FoodOrderException() {
		super();
	}

	public FoodOrderException(String message) {
		super(message);
	}
}
