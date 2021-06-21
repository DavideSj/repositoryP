package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.UserDao;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		UserDao userDao=new UserDao();

		String email = request.getParameter("email");
		String password =  request.getParameter("password");




		if((password.equals("")||email.equals(""))||(password==null||email==null)) 
			response.getWriter().append("La password o l'email è vuota ");

		else if(userDao.loginUser(email, password)) 
			response.getWriter().append("Bentornato "+email);


		else 
			response.getWriter().append("Password o email non corrette ");


		//		if(password.equals("")) 
		//			response.getWriter().append("La password è vuota ");
		//
		//		else if(email.equals("davidesaiano1@gmail.com")&& password.equals("password")) 
		//			response.getWriter().append("Bentornato ");
		//
		//
		//		else 
		//			response.getWriter().append("Password o email non corrette ");





	}

}
