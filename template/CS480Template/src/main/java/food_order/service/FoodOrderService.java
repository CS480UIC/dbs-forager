package food_order.service;

import java.util.List;

import donor.Donor;
import donor.DonorDao;
import food_order.bean.FoodOrder;
import food_order.dao.FoodOrderDAO;
import receiver.Receiver;
import receiver.ReceiverDao;

public class FoodOrderService {
	private FoodOrderDAO foodOrderDAO = new FoodOrderDAO();
	private DonorDao donorDao = new DonorDao();
	private ReceiverDao receiverDao = new ReceiverDao();
	
	public void addFoodOrder(FoodOrder foodOrder)throws FoodOrderException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		FoodOrder f = foodOrderDAO.findByOrderId(foodOrder.getOrder_id());
		if(f !=null && f.getOrder_id()==foodOrder.getOrder_id()) throw new FoodOrderException("This order has been registered!");
		Donor d = donorDao.findByDonorId(foodOrder.getDonor_id());
		if(d == null) throw new FoodOrderException("This donor doesn't exist"); 
		Receiver r;
		try {
			r = receiverDao.findByReceiverId(foodOrder.getReceiver_id());
			if(r == null) throw new FoodOrderException("This receiver doesn't exist"); 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		foodOrderDAO.insertFoodOrder(foodOrder);	
	}
	public void updateFoodOrder(FoodOrder foodOrder)throws FoodOrderException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		FoodOrder f = foodOrderDAO.findByOrderId(foodOrder.getOrder_id());
		if(f == null) throw new FoodOrderException("There's no order item with this id");
		Donor d = donorDao.findByDonorId(foodOrder.getDonor_id());
		if(d == null) throw new FoodOrderException("This donor doesn't exist"); 
		Receiver r;
		try {
			r = receiverDao.findByReceiverId(foodOrder.getReceiver_id());
			if(r == null) throw new FoodOrderException("This receiver doesn't exist"); 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		foodOrderDAO.updateFoodOrder(foodOrder);	
	}
	public void deleteFoodOrder(int order_id) throws FoodOrderException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		FoodOrder f = foodOrderDAO.findByOrderId(order_id);
		if(f == null) throw new FoodOrderException("There's no order item with this id");
		foodOrderDAO.deleteFoodOrder(order_id);
	}
	public FoodOrder getFoodOrder(String order_id) throws FoodOrderException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		FoodOrder f = foodOrderDAO.findByOrderId(Integer.parseInt(order_id));
		if(f == null) throw new FoodOrderException("There's no order item with this id");
		return f;
	}
	public List<FoodOrder> getAll() throws FoodOrderException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		return foodOrderDAO.findAll();
	}
}
