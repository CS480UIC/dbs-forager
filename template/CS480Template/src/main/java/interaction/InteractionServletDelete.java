package interaction;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InteractionServletDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public InteractionServletDelete() {
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
		}
		try {
			if (info.size() == 1) {
				interactionService.deleteInteraction(Integer.parseInt(info.get(0)));
				request.setAttribute("success", "Interaction was deleted!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
		}
		try {
			request.setAttribute("interactions", interactionService.findall());
		} catch (Exception e) {
			request.setAttribute("error", e.getMessage());
		}
		request.getRequestDispatcher("/jsps/messages/delete.jsp").forward(request, response);

	}

}
