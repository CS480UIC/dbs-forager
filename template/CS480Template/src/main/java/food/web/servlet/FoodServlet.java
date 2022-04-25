package food.web.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import donor.Donor;
import entity1.domain.Entity1;
import entity1.service.Entity1Exception;
import entity1.service.Entity1Service;
import food.bean.Food;
import food.dao.FoodDao;
import food.service.FoodException;
import food.service.FoodService;

public class FoodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public FoodServlet() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getServletPath();

        try {
            switch (action) {
                case "/FoodServlet/Add":
                  addFood(request,response);
                    break;
                case "/FoodServlet/Read":
                	getFoodById(request, response);
                    break;
                case "/FoodServlet/Update":
                   updateFood(request, response);
                    break;
                case "/FoodServlet/Delete":
                	deleteFood(request, response);
                    break;
                case "/FoodServlet/Queries/Simple":
                	simpleQuery(request, response);
                    break;
                case "/FoodServlet/Queries/Aggregate":
                	aggregateQuery(request, response);
                    break;
                case "/FoodServlet/Queries/Complex":
                	complexQuery(request, response);
                    break;
                default:
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
	
	public void addFood(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		FoodService foodService = new FoodService();
		Map<String,String[]> paramMap = request.getParameterMap();
		Food f = new Food();
		List<String> info = new ArrayList<String>();

		for(String name : paramMap.keySet()) {
			String[] values = paramMap.get(name);
			info.add(values[0]);
		}
		f.setFood_id(Integer.parseInt(info.get(0)));
		f.setFood_type(info.get(1));
		f.setFood_name(info.get(2));
		f.setCalorie_tracker(Float.parseFloat(info.get(3)));
		f.setDonor_id(Integer.parseInt(info.get(4)));
		
		try {
			foodService.addFood(f);
			request.setAttribute("success", "Food has been created.");
		}catch (Exception e) {
			request.setAttribute("error", e.getMessage());
		}
		request.getRequestDispatcher("/jsps/food/CreateFood.jsp").forward(request, response);
	}
	
	public void simpleQuery(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		FoodService foodService = new FoodService();
		try {
			request.setAttribute("simpleQuery", foodService.simple());
		} catch (Exception e) {
			request.setAttribute("error", e.getMessage());
		}
		request.getRequestDispatcher("/jsps/food/FoodQueries.jsp").forward(request, response);
	}
	
	public void aggregateQuery(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		FoodService foodService = new FoodService();
		try {
			request.setAttribute("aggregateQuery", foodService.aggregate());
		} catch (Exception e) {
			request.setAttribute("error", e.getMessage());
		}
		request.getRequestDispatcher("/jsps/food/FoodQueries.jsp").forward(request, response);
	}
	
	public void complexQuery(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		FoodService foodService = new FoodService();
		try {
			request.setAttribute("complexQuery", foodService.complex());
		} catch (Exception e) {
			request.setAttribute("error", e.getMessage());
		}
		request.getRequestDispatcher("/jsps/food/FoodQueries.jsp").forward(request, response);
	}
	
	public void updateFood(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		FoodService foodService = new FoodService();
		Map<String, String[]> paramMap = request.getParameterMap();

		List<String> info = new ArrayList<String>();

		for (String name : paramMap.keySet()) {
			String[] values = paramMap.get(name);
			info.add(values[0]);
		}

		try {
			if (info.size() == 5) {
				Food food = new Food(Integer.parseInt(info.get(0)), info.get(1), info.get(2), Float.parseFloat(info.get(3)), Integer.parseInt(info.get(4)));
				foodService.updateFood(food);
				request.setAttribute("success", "Updated!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
		}
		try {
			request.setAttribute("food", foodService.getAll());
		} catch (Exception e) {
			request.setAttribute("error", e.getMessage());
		}
		request.getRequestDispatcher("/jsps/food/UpdateFood.jsp").forward(request, response);
	}
	
	public void deleteFood(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		FoodService foodService = new FoodService();
		
		Map<String, String[]> paramMap = request.getParameterMap();
		List<String> info = new ArrayList<String>();
		for (String name : paramMap.keySet()) {
			String[] values = paramMap.get(name);
			info.add(values[0]);
		}
		try {
			if(info.size()==1) {
			foodService.deleteFood(Integer.parseInt(info.get(0)));
			request.setAttribute("success", "Food deleted");
			}	
		}catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
		}
		try {
			request.setAttribute("food", foodService.getAll());
		}catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
		}
		request.getRequestDispatcher("/jsps/food/DeleteFood.jsp").forward(request, response);
	}
	
	public void getFoodById(HttpServletRequest request, HttpServletResponse response)  throws SQLException, ServletException, IOException {
		FoodService foodService = new FoodService();
		
		Map<String, String[]> paramMap = request.getParameterMap();

		List<String> info = new ArrayList<String>();

		for (String name : paramMap.keySet()) {
			String[] values = paramMap.get(name);
			info.add(values[0]);
	}

		try {
			Food food = foodService.getFood(info.get(0));
			request.setAttribute("food", food);
			request.setAttribute("success", "Found the entry");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
		}
		
	request.getRequestDispatcher("/jsps/food/ReadFood.jsp").forward(request, response);
	}

}





