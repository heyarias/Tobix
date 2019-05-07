package org.tec.tobix.vista;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.tec.tobix.dao.InsertarInformacion;
import org.tec.tobix.logicaNegocio.Encargado;
import org.tec.tobix.logicaNegocio.Persona;
import org.tec.tobix.util.Calendario;

import javax.servlet.http.*;
/**
 * Servlet implementation class ServletRegistroEncargado//
 * 
 */
@WebServlet("/ServletRegistroEncargado")
public class ServletRegistroEncargado extends HttpServlet {
	
	private InsertarInformacion insertar= new InsertarInformacion();
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletRegistroEncargado() {
        super();
        // TODO Auto-generated constructor stub
    }

    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("Identificacion").toString();
		String nombre = request.getParameter("Nombre").toString();
		String apellido1 = request.getParameter("ap1").toString();
		String apellido2 = request.getParameter("ap2").toString();
		String email = request.getParameter("email").toString();
		String Genero= request.getParameter("Genero");
		String entidad = request.getParameter("entidad").toString();
		int anios = Integer.parseInt( request.getParameter("anios"));
		try {
			Persona encargado = new Encargado(anios,id,Genero,email,nombre,apellido1,apellido2, entidad);
			
			System.out.println(encargado.toString());
			RequestDispatcher dispatcher = request.getRequestDispatcher("registrarEncargado.jsp");
			dispatcher.forward(request, response);	
		}	
		catch(Exception e) {	
  			System.out.println(e);
		}
		
	}

}
