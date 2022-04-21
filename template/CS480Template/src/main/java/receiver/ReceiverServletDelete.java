package receiver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReceiverServletDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ReceiverServletDelete() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ReceiverService receiverService = new ReceiverService();
		Map<String, String[]> paramMap = request.getParameterMap();
		List<String> info = new ArrayList<String>();
		for (String name : paramMap.keySet()) {
			String[] values = paramMap.get(name);
			info.add(values[0]);
		}
		try {
			if (info.size() == 1) {
				receiverService.deleteReceiver(Integer.parseInt(info.get(0)));
				request.setAttribute("success", "Donor was deleted!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
		}
		try {
			request.setAttribute("receivers", receiverService.findall());
		} catch (Exception e) {
			request.setAttribute("error", e.getMessage());
		}
		request.getRequestDispatcher("/jsps/receiver/delete.jsp").forward(request, response);

	}

}
