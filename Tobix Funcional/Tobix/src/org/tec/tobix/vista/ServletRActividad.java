package org.tec.tobix.vista;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.tec.tobix.dao.InsertarInformacion;
import org.tec.tobix.dao.ObtenerInformacion;
import org.tec.tobix.logicaNegocio.Actividad;

/**
 * Servlet implementation class ServletRActividad
 */
@WebServlet("/ServletRActividad")
public class ServletRActividad extends HttpServlet {
	private static final long serialVersionUID = 1L;
	InsertarInformacion data = new InsertarInformacion();
	ObtenerInformacion info = new ObtenerInformacion();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletRActividad() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		int idBloque = Integer.parseInt( request.getParameter("idBloque"));
		String id = request.getParameter("idBloque");
		String tipo = request.getParameter("tipo").toString();
		String nombre = request.getParameter("nombre").toString();
		String fecha = null;
		String horaInicio = request.getParameter("horaInicio").toString();
		String horaFinal = request.getParameter("horaFinal").toString();
		String descripcion = request.getParameter("description").toString();
		PrintWriter out = response.getWriter();
		SimpleDateFormat fechareal = new SimpleDateFormat("dd-MM-yyyy");
		try {
			fecha = info.selectFechaBloque(id); 
			java.util.Date dateE = fechareal.parse(fecha);
			java.sql.Date sqlDate = new java.sql.Date(dateE.getTime());
			System.out.println(sqlDate);
			Actividad actividad = new Actividad(tipo,nombre,sqlDate,horaInicio, horaFinal, descripcion);
			System.out.println(actividad.toString());
			int idActividad = info.selectIdActividad(nombre, tipo);
			data.insertarActividadXBloque(idActividad, idBloque);
			RequestDispatcher dispatcher = request.getRequestDispatcher("addActivity.jsp");
			dispatcher.forward(request, response);	
		}
		catch(Exception e) {
  			System.out.println(e);
  			out.println("<script type=\"text/javascript\">");
  		    out.println("alert('Bloque no encontrado');");
  		    out.println("location='addActivity.jsp';");
  		    out.println("</script>");
		}
	}

	

	}
