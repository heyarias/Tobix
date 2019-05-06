package org.tec.tobix.vista;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.tec.tobix.logicaNegocio.Comentario;
import java.sql.Date;

/**
 * Servlet implementation class ServletComentario
 */
@WebServlet("/ServletComentario")
public class ServletComentario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletComentario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String id = request.getParameter("idActividad").toString();
		String mensaje = request.getParameter("comentario").toString();
		if (id == null) {	
			RequestDispatcher dispatcher = request.getRequestDispatcher("addComentario.jsp");
			dispatcher.forward(request, response);
		}
		else {
			try {
				//RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
				//dispatcher.forward(request, response);
				
				Comentario comentario = new Comentario(mensaje);
				System.out.println(comentario.toString());
			}
			catch(Exception e) {			
  			System.out.println(e);
		}
	}
		RequestDispatcher dispatcher = request.getRequestDispatcher("addComentario.jsp");
		dispatcher.forward(request, response);

	}
}
