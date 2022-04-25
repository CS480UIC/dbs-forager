package volunteer;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class VolunteerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public VolunteerServlet() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getServletPath();

        try {
            switch (action) {
                case "/VolunteerServlet/Add":
                  addVolunteer(request,response);
                    break;
                case "/VolunteerServlet/Read":
                	getVolunteerById(request, response);
                    break;
                case "/VolunteerServlet/Update":
                   updateVolunteer(request, response);
                    break;
                case "/VolunteerServlet/Delete":
                	deleteVolunteer(request, response);
                    break;
                case "/VolunteerServlet/Queries/Simple":
                	simpleQuery(request, response);
                    break;
                case "/VolunteerServlet/Queries/Aggregate":
                	aggregateQuery(request, response);
                    break;
                case "/VolunteerServlet/Queries/Complex":
                	complexQuery(request, response);
                    break;
                default:
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
	
	public void addVolunteer(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		VolunteerService volunteerService = new VolunteerService();
		Map<String,String[]> paramMap = request.getParameterMap();
		Volunteer v = new Volunteer();
		List<String> info = new ArrayList<String>();

		for(String name : paramMap.keySet()) {
			String[] values = paramMap.get(name);
			info.add(values[0]);
		}
		v.setUsers_id(Integer.parseInt(info.get(0)));
		v.setVolunteer_name(info.get(1));
		v.setPreferred_location(info.get(2));
		v.setLocation_radius(Float.parseFloat(info.get(3)));
		v.setAvailability_date(info.get(4));
		
		try {
			volunteerService.addVolunteer(v);
			request.setAttribute("success", "Volunteer has been created.");
		}catch (Exception e) {
			request.setAttribute("error", e.getMessage());
		}
		request.getRequestDispatcher("/jsps/volunteer/create.jsp").forward(request, response);
	}
	
	public void simpleQuery(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		VolunteerService volunteerService = new VolunteerService();
		try {
			request.setAttribute("simpleQuery", volunteerService.simple());
		} catch (Exception e) {
			request.setAttribute("error", e.getMessage());
		}
		request.getRequestDispatcher("/jsps/volunteer/queries.jsp").forward(request, response);
	}
	
	public void aggregateQuery(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		VolunteerService volunteerService = new VolunteerService();
		try {
			request.setAttribute("aggregateQuery", volunteerService.aggregate());
		} catch (Exception e) {
			request.setAttribute("error", e.getMessage());
		}
		request.getRequestDispatcher("/jsps/volunteer/queries.jsp").forward(request, response);
	}
	
	public void complexQuery(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		VolunteerService volunteerService = new VolunteerService();
		try {
			request.setAttribute("complexQuery", volunteerService.complex());
		} catch (Exception e) {
			request.setAttribute("error", e.getMessage());
		}
		request.getRequestDispatcher("/jsps/volunteer/queries.jsp").forward(request, response);
	}
	
	public void updateVolunteer(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		VolunteerService volunteerService = new VolunteerService();
		Map<String, String[]> paramMap = request.getParameterMap();

		List<String> info = new ArrayList<String>();

		for (String name : paramMap.keySet()) {
			String[] values = paramMap.get(name);
			info.add(values[0]);
		}

		try {
			if (info.size() == 5) {
				Volunteer volunteer = new Volunteer(Integer.parseInt(info.get(0)), info.get(1), info.get(2), Float.parseFloat(info.get(3)), info.get(4));
				volunteerService.updateVolunteer(volunteer);
				request.setAttribute("success", "Updated!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
		}
		try {
			request.setAttribute("volunteer", volunteerService.getAll());
		} catch (Exception e) {
			request.setAttribute("error", e.getMessage());
		}
		request.getRequestDispatcher("/jsps/volunteer/update.jsp").forward(request, response);
	}
	
	public void deleteVolunteer(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		VolunteerService volunteerService = new VolunteerService();
		
		Map<String, String[]> paramMap = request.getParameterMap();
		List<String> info = new ArrayList<String>();
		for (String name : paramMap.keySet()) {
			String[] values = paramMap.get(name);
			info.add(values[0]);
		}
		try {
			if(info.size()==1) {
				volunteerService.deleteVolunteer(Integer.parseInt(info.get(0)));
			request.setAttribute("success", "Volunteer deleted");
			}	
		}catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
		}
		try {
			request.setAttribute("volunteer", volunteerService.getAll());
		}catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
		}
		request.getRequestDispatcher("/jsps/volunteer/delete.jsp").forward(request, response);
	}
	
	public void getVolunteerById(HttpServletRequest request, HttpServletResponse response)  throws SQLException, ServletException, IOException {
		VolunteerService volunteerService = new VolunteerService();
		
		Map<String, String[]> paramMap = request.getParameterMap();

		List<String> info = new ArrayList<String>();

		for (String name : paramMap.keySet()) {
			String[] values = paramMap.get(name);
			info.add(values[0]);
	}

		try {
			Volunteer volunteer = volunteerService.getVolunteer(info.get(0));
			request.setAttribute("volunteer", volunteer);
			request.setAttribute("success", "Found the entry");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
		}
		
	request.getRequestDispatcher("/jsps/volunteer/read.jsp").forward(request, response);
	}

}
