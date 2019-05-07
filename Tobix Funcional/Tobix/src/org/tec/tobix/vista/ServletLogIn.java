package org.tec.tobix.vista;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.tec.tobix.dao.ObtenerInformacion;

/**
 * Servlet implementation class ServletLogIn
 */
@WebServlet("/ServletLogIn")
public class ServletLogIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletLogIn() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String username = request.getParameter("username").toString();
		String password = request.getParameter("password").toString();
		String tipo = request.getParameter("tipo").toString();
		ObtenerInformacion info = new ObtenerInformacion();
		String puedo = null;
		try {
			puedo = info.selectLogIn(username, password);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			if(puedo!= null) {
				if(puedo.equals("Administrador")) {
					RequestDispatcher dispatcher = request.getRequestDispatcher("principalAdmin.jsp");
					dispatcher.forward(request, response);
					
				}
				else if (puedo.equals("Usuario")){
					RequestDispatcher dispatcher = request.getRequestDispatcher("principalUser.jsp");
					dispatcher.forward(request, response);				
				}
			}
			else {
				System.out.println("no puedes entrar");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}



}
