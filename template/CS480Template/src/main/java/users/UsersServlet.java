package users;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class UsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public UsersServlet() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getServletPath();

        try {
            switch (action) {
                case "/UsersServlet/Add":
                	addUsers(request,response);
                    break;
                case "/UsersServlet/Read":
                	getUsersById(request, response);
                    break;
                case "/UsersServlet/Update":
                   updateUsers(request, response);
                    break;
                case "/UsersServlet/Delete":
                	deleteUsers(request, response);
                    break;
                default:
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
	
	public void addUsers(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		UsersService usersService = new UsersService();
		Map<String,String[]> paramMap = request.getParameterMap();
		Users u = new Users();
		List<String> info = new ArrayList<String>();

		for(String name : paramMap.keySet()) {
			String[] values = paramMap.get(name);
			info.add(values[0]);
		}
		u.setID(Integer.parseInt(info.get(0)));
		u.setUsername(info.get(1));
		u.setPassword(info.get(2));
		u.setName_of_organization(info.get(3));
		u.setOrg_id(Integer.parseInt(info.get(4)));
		u.setFirst_name(info.get(5));
		u.setLast_name(info.get(6));
		u.setEmail_id(info.get(7));
		u.setContact_number(Long.parseLong(info.get(8)));
		u.setAddress(info.get(9));
		
		try {
			
			usersService.addUsers(u);
			request.setAttribute("success", "User has been created.");
		}catch (Exception e) {
			request.setAttribute("error", e.getMessage());
		}
		request.getRequestDispatcher("/jsps/users/create.jsp").forward(request, response);
	}
	
	
	
	public void updateUsers(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		UsersService usersService = new UsersService();
		Map<String, String[]> paramMap = request.getParameterMap();

		List<String> info = new ArrayList<String>();

		for (String name : paramMap.keySet()) {
			String[] values = paramMap.get(name);
			info.add(values[0]);
		}

		try {
			if (info.size() == 10) {
				Users users = new Users(Integer.parseInt(info.get(0)), info.get(1), info.get(2), info.get(3), Integer.parseInt(info.get(4)), info.get(5), info.get(6), info.get(7), Long.parseLong(info.get(8)), info.get(9) );
				usersService.updateUsers(users);
				request.setAttribute("success", "Updated!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
		}
		try {
			request.setAttribute("users", usersService.getAll());
		} catch (Exception e) {
			request.setAttribute("error", e.getMessage());
		}
		request.getRequestDispatcher("/jsps/users/update.jsp").forward(request, response);
	}
	
	public void deleteUsers(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		UsersService usersService = new UsersService();
		
		Map<String, String[]> paramMap = request.getParameterMap();
		List<String> info = new ArrayList<String>();
		for (String name : paramMap.keySet()) {
			String[] values = paramMap.get(name);
			info.add(values[0]);
		}
		try {
			if(info.size()==1) {
				usersService.deleteUsers(Integer.parseInt(info.get(0)));
			request.setAttribute("success", "User deleted");
			}	
		}catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
		}
		try {
			request.setAttribute("users", usersService.getAll());
		}catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
		}
		request.getRequestDispatcher("/jsps/users/delete.jsp").forward(request, response);
	}
	
	public void getUsersById(HttpServletRequest request, HttpServletResponse response)  throws SQLException, ServletException, IOException {
		UsersService usersService = new UsersService();
		
		Map<String, String[]> paramMap = request.getParameterMap();

		List<String> info = new ArrayList<String>();

		for (String name : paramMap.keySet()) {
			String[] values = paramMap.get(name);
			info.add(values[0]);
	}

		try {
			Users users = usersService.getUsers(info.get(0));
			request.setAttribute("users", users);
			request.setAttribute("success", "Found the entry");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
		}
		
	request.getRequestDispatcher("/jsps/users/read.jsp").forward(request, response);
	}

}
