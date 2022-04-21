package donor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DonorServletSimpleQuery extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DonorServletSimpleQuery() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DonorService donorService = new DonorService();

		try {
			request.setAttribute("simpleRes", donorService.getSimpleQuery());
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", e.getMessage());

		}
		request.getRequestDispatcher("/jsps/donor/queries.jsp").forward(request, response);

	}

}
