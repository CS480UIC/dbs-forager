package food.service;

import java.util.List;

import donor.Donor;
import donor.DonorDao;
import entity1.service.Entity1Exception;
import food.bean.Food;
import food.bean.FoodAggregateDTO;
import food.bean.FoodComplexDTO;
import food.dao.FoodDao;

public class FoodService {
	private FoodDao foodDao = new FoodDao();
	private DonorDao donorDao = new DonorDao();
	
	public void addFood(Food food)throws FoodException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		Food f = foodDao.findByFoodId(food.getFood_id());
		if(f !=null && f.getFood_id()==food.getFood_id()) throw new FoodException("This food_id has been registered!");
		Donor d = donorDao.findByDonorId(food.getDonor_id());
		if(d == null) throw new FoodException("This donor doesn't exist"); 
		foodDao.insertFood(food);		
	}
	
	public void updateFood(Food food)throws FoodException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		Food f = foodDao.findByFoodId(food.getFood_id());
		if(f == null) throw new FoodException("There's no food item with this id");
		Donor d = donorDao.findByDonorId(food.getDonor_id());
		if(d == null) throw new FoodException("This donor doesn't exist"); 
		foodDao.updateFood(food);	
	}
	
	public void deleteFood(int food_id) throws FoodException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		Food f = foodDao.findByFoodId(food_id);
		if(f == null) throw new FoodException("There's no food item with this id");
		foodDao.deleteFood(food_id);
	}
	
	public Food getFood(String food_id) throws FoodException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		Food f = foodDao.findByFoodId(Integer.parseInt(food_id));
		if(f == null) throw new FoodException("There's no food item with this id");
		System.out.println(f.getDonor_id());
		return f;
	}
	
	public List<Food> getAll() throws FoodException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		return foodDao.findAll();
	}
	public List<Food> simple() throws FoodException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		return foodDao.simpleQuery();
	}
	public List<FoodAggregateDTO> aggregate() throws FoodException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		return foodDao.aggregateQuery();
	}
	public List<FoodComplexDTO> complex() throws FoodException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		return foodDao.complexQuery();
	}
}
