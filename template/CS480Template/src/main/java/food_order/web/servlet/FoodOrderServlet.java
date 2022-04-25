package food_order.web.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import food.bean.Food;
import food.service.FoodException;
import food.service.FoodService;
import food_order.bean.FoodOrder;
import food_order.service.FoodOrderException;
import food_order.service.FoodOrderService;

public class FoodOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public FoodOrderServlet() {
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getServletPath();

        try {
            switch (action) {
                case "/FoodOrderServlet/Add":
                  addFoodOrder(request,response);
                    break;
                case "/FoodOrderServlet/Read":
                	getFoodOrderById(request, response);
                    break;
                case "/FoodOrderServlet/Update":
                   updateFoodOrder(request, response);
                    break;
                case "/FoodOrderServlet/Delete":
                	deleteFoodOrder(request, response);
                    break;
                default:
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
	
	public void addFoodOrder(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		FoodOrderService foodOrderService = new FoodOrderService();
		Map<String,String[]> paramMap = request.getParameterMap();
		FoodOrder f = new FoodOrder();
		List<String> info = new ArrayList<String>();

		for(String name : paramMap.keySet()) {
			String[] values = paramMap.get(name);
			info.add(values[0]);
		}
		f.setOrder_id(Integer.parseInt(info.get(0)));
		f.setPick_up_location(info.get(1));
		f.setDrop_location(info.get(2));
		f.setTransporter_id(Integer.parseInt(info.get(3)));
		f.setFood_id(Integer.parseInt(info.get(4)));
		f.setPick_up_time(info.get(5));
		f.setDrop_time(info.get(6));
		f.setReceiver_id(Integer.parseInt(info.get(7)));
		f.setDonor_id(Integer.parseInt(info.get(8)));
		
		
		try {
			foodOrderService.addFoodOrder(f);
			request.setAttribute("success", "New Order Created!");
			
		}catch (Exception e) {
			request.setAttribute("error", e.getMessage());
		}
		request.getRequestDispatcher("/jsps/order/CreateOrder.jsp").forward(request, response);
	}
	
	public void updateFoodOrder(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		FoodOrderService foodOrderService = new FoodOrderService();
		Map<String, String[]> paramMap = request.getParameterMap();

		List<String> info = new ArrayList<String>();

		for (String name : paramMap.keySet()) {
			String[] values = paramMap.get(name);
			info.add(values[0]);
		}

		try {
			if (info.size() == 9) {
				FoodOrder foodOrder = new FoodOrder(Integer.parseInt(info.get(0)), info.get(1), info.get(2), Integer.parseInt(info.get(3)), Integer.parseInt(info.get(4)), info.get(5), info.get(6), Integer.parseInt(info.get(7)),Integer.parseInt(info.get(8)));
				foodOrderService.updateFoodOrder(foodOrder);
				request.setAttribute("success", "Updated!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
		}
		try {
			request.setAttribute("foodOrder", foodOrderService.getAll());
		} catch (Exception e) {
			request.setAttribute("error", e.getMessage());
		}
		request.getRequestDispatcher("/jsps/order/UpdateOrder.jsp").forward(request, response);
	}
	
	public void deleteFoodOrder(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		FoodOrderService foodOrderService = new FoodOrderService();
		
		Map<String, String[]> paramMap = request.getParameterMap();
		List<String> info = new ArrayList<String>();
		for (String name : paramMap.keySet()) {
			String[] values = paramMap.get(name);
			info.add(values[0]);
		}
		try {
			if(info.size()==1) {
				foodOrderService.deleteFoodOrder(Integer.parseInt(info.get(0)));
			request.setAttribute("success", "Order deleted");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
		}
		try {
			request.setAttribute("foodOrder", foodOrderService.getAll());

		}catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
		}
		request.getRequestDispatcher("/jsps/order/DeleteOrder.jsp").forward(request, response);
	}
	
	public void getFoodOrderById(HttpServletRequest request, HttpServletResponse response)  throws SQLException, ServletException, IOException {
		FoodOrderService foodOrderService = new FoodOrderService();
		
		Map<String, String[]> paramMap = request.getParameterMap();

		List<String> info = new ArrayList<String>();

		for (String name : paramMap.keySet()) {
			String[] values = paramMap.get(name);
			info.add(values[0]);
	}

		try {
			FoodOrder foodOrder = foodOrderService.getFoodOrder(info.get(0));
			request.setAttribute("foodOrder", foodOrder);
			request.setAttribute("success", "The entry is found");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
		}
		
	request.getRequestDispatcher("/jsps/order/ReadOrder.jsp").forward(request, response);
	}

}
