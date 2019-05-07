package org.tec.tobix.vista;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.tec.tobix.logicaNegocio.Asistente;
import org.tec.tobix.logicaNegocio.Encargado;
import org.tec.tobix.logicaNegocio.Persona;

/**
 * Servlet implementation class ServletRegistroAsistente
 */
@WebServlet("/ServletRegistroAsistente")
public class ServletRegistroAsistente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletRegistroAsistente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String id = request.getParameter("Identificacion").toString();
		String nombre = request.getParameter("Nombre").toString();
		String apellido1 = request.getParameter("ap1").toString();
		String apellido2 = request.getParameter("ap2").toString();
		String email = request.getParameter("email").toString();
		String Genero= request.getParameter("Genero");
		String password= request.getParameter("password").toString();
		String entidad = request.getParameter("entidad").toString();
		try {
			Persona asistente = new Asistente(password,id,Genero,email,nombre,apellido1,apellido2, entidad);
			System.out.println(asistente.toString());
			RequestDispatcher dispatcher = request.getRequestDispatcher("registrarAsistente.jsp");
			dispatcher.forward(request, response);
		}	
		catch(Exception e) {	
  			System.out.println(e);
		}
	}



}
