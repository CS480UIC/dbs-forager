package restaurant;

import java.util.List;

public class RestaurantService {
	private RestaurantDao restaurantDao = new RestaurantDao();

	public void register(Restaurant form)
			throws RestaurantException, ClassNotFoundException, InstantiationException, IllegalAccessException {

		Restaurant restaurant = restaurantDao.findByRestaurantId(form.getRestaurantId());
		if (restaurant != null && restaurant.getRestaurantId() == form.getRestaurantId())
			throw new RestaurantException("This restaurant id has been registered!");
		restaurantDao.add(form);
	}

	public Restaurant getRestaurant(String restaurantId) throws Exception {
		
		System.out.println(restaurantId);
		
		Restaurant restaurant = restaurantDao.findByRestaurantId(Integer.parseInt(restaurantId));
		if (restaurant == null)
			throw new RestaurantException("This restaurant does not exist!");
		return restaurant;
	}
	
	public Restaurant updateRestaurant(Restaurant restaurant) throws Exception {
		Restaurant oldRestaurant = restaurantDao.findByRestaurantId(restaurant.getRestaurantId());
		if (oldRestaurant == null)
			throw new RestaurantException("This restaurant does not exist!");
		restaurantDao.updateRestaurant(restaurant);
		return restaurant;
	}
	
	public void deleteRestaurant(int restaurantId) throws Exception {
		Restaurant restaurant = restaurantDao.findByRestaurantId(restaurantId);
		if (restaurant == null)
			throw new RestaurantException("This restaurant does not exist!");
		restaurantDao.deleteRestaurant(restaurantId);
	}
	
	public List<Object> getSimpleQuery() throws Exception{
		return restaurantDao.simpleQuery();
	}
	
	public List<Object> getComplexQuery() throws Exception{
		return restaurantDao.complexQuery();
	}
	
	public List<Object> getAggQuery() throws Exception{
		return restaurantDao.aggQuery();
	}

	public List<Object> findall() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		return restaurantDao.findall();

	}
}
