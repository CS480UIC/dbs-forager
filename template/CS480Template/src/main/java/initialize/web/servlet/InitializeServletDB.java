package initialize.web.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import initialize.service.InitializeException;
import initialize.service.InitializeService;
import user.domain.User;
import user.service.UserException;
import user.service.UserService;

public class InitializeServletDB extends HttpServlet{
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InitializeServletDB() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		InitializeService initializeService = new InitializeService();
		//Read the file from webapp/sql
		InputStream input = getServletContext().getResourceAsStream("/sql/InitializeDB.sql");

		try {
			initializeService.init(input);
			request.setAttribute("success", "Database Initialized");
			//response.sendRedirect( request.getContextPath() + "/jsps/user/login.jsp");
		} catch (ClassNotFoundException | InitializeException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} 
		
	}

}

