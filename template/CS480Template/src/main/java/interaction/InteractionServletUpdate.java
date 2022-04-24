package interaction;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InteractionServletUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public InteractionServletUpdate() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		InteractionService interactionService = new InteractionService();
		@SuppressWarnings("unchecked")
		Map<String, String[]> paramMap = request.getParameterMap();

		List<String> info = new ArrayList<String>();

		for (String name : paramMap.keySet()) {
			String[] values = paramMap.get(name);
			info.add(values[0]);
		}

		try {
			if (info.size() == 7) {
				//Interaction interaction = new Interaction(info.get(0), info.get(1), info.get(2), info.get(3));
				
				Interaction interaction = new Interaction(info.get(0), info.get(1), info.get(2), info.get(3) , info.get(4) , info.get(5) , info.get(6));
				interactionService.updateInteraction(interaction);
				request.setAttribute("success", "Interaction was updated!");
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
		request.getRequestDispatcher("/jsps/messages/update.jsp").forward(request, response);

	}

}
