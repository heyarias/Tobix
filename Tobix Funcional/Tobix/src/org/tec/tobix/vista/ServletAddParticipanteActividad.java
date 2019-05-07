package org.tec.tobix.vista;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.tec.tobix.dao.InsertarInformacion;
import org.tec.tobix.dao.ObtenerInformacion;
import org.tec.tobix.logicaIntegracion.EnvioCorreos;
import org.tec.tobix.logicaNegocio.Comentario;
import org.tec.tobix.util.Calendario;

/**
 * Servlet implementation class ServletAddParticipanteActividad
 */
@WebServlet("/ServletAddParticipanteActividad")
public class ServletAddParticipanteActividad extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private InsertarInformacion insertar = new InsertarInformacion();
	private Calendario calendar = new Calendario();
	ObtenerInformacion data = new ObtenerInformacion();
	
	private EnvioCorreos correos = new EnvioCorreos();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAddParticipanteActividad() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String id = request.getParameter("idPersona").toString();
		String Act = request.getParameter("id").toString();
		int idAct = Integer.parseInt(Act);	
		boolean  puedo = false;
		
		String hora;
		try {
			hora = data.selectHoraInicio(Act);
			String dia = data.selectFecha(Act);
			if (calendar.diaVrsDia(dia)) {
				if(calendar.horaVrsHora(hora).equals("MENOR")) {
					
				
				String confirmar = request.getParameter("confirmar").toString();
				if (id == null) {	
					RequestDispatcher dispatcher = request.getRequestDispatcher("addParticipanteActividad.jsp");
					dispatcher.forward(request, response);
				}
				else {
					try {
						//RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
						//dispatcher.forward(request, response);
						insertar.insertarParticipantes(id, idAct);
						if(confirmar.equals("SI")) {
							insertar.insertarParticipantesConfirmados(id, idAct);		
							String email = data.getEmail(id);
							correos.EnviarCorreo(Act , email);
							
						}

					}
					catch(Exception e) {			
		  			System.out.println(e);
				}
			}
		}
		else {
				System.out.println("You are late");
			}
		  }
		} catch (SQLException | ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("addParticipanteActividad.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
	}

}
