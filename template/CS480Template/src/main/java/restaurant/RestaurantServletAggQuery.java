package restaurant;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RestaurantServletAggQuery extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RestaurantServletAggQuery() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RestaurantService restaurantService = new RestaurantService();

		try {
			request.setAttribute("aggRes", restaurantService.getAggQuery());
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", e.getMessage());

		}
		request.getRequestDispatcher("/jsps/restaurant/queries.jsp").forward(request, response);

	}

}
