package org.tec.tobix.vista;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.tec.tobix.logicaNegocio.Bloque;
import org.tec.tobix.logicaNegocio.Tematica;
/**
 * Servlet implementation class ServletRBloque
 */
@WebServlet("/ServletRBloque")
public class ServletRBloque extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletRBloque() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String edicion = request.getParameter("edicion").toString();
		String fecha = request.getParameter("date").toString();
		String franja = request.getParameter("franja").toString();
		String tematicaN = request.getParameter("tematica").toString();
		String descripcion = request.getParameter("descripcion").toString();
		SimpleDateFormat fechareal = new SimpleDateFormat("dd-MM-yyyy");
		if (edicion == null) {	
			RequestDispatcher dispatcher = request.getRequestDispatcher("addComentario.jsp");
			dispatcher.forward(request, response);
		}else {
			try {
				//RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
				//dispatcher.forward(request, response);
				java.util.Date dateE = fechareal.parse(fecha);
				java.sql.Date sqlStartDate = new java.sql.Date(dateE.getTime());
				Bloque bloque = new Bloque(edicion,sqlStartDate,franja);
				Tematica tematica = new Tematica(tematicaN,descripcion);
				System.out.println(tematica.toString());
			}
			catch(Exception e) {			
  			System.out.println(e);
		}
	}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("addBloque.jsp");
		dispatcher.forward(request, response);

	}

}
