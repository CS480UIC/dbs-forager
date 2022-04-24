package interaction;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InteractionServletCreate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public InteractionServletCreate() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		InteractionService interactionService = new InteractionService();
		Map<String, String[]> paramMap = request.getParameterMap();

		List<String> info = new ArrayList<String>();

		for (String name : paramMap.keySet()) {
			String[] values = paramMap.get(name);
			info.add(values[0]);
			System.out.println("create " + values[0]);
		}

		Interaction form = new Interaction(info.get(0), info.get(1), info.get(2), info.get(3) , info.get(4) , info.get(5) , info.get(6));

		try {
			interactionService.register(form);
			request.setAttribute("success", "Interaction has been created.");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", e.getMessage());
			
		}
		request.getRequestDispatcher("/jsps/messages/create.jsp").forward(request, response);

	}

}
