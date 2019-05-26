package org.tec.tobix.vista;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.sql.ResultSet;
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
import org.tec.tobix.logicaIntegracion.FlujoWatson;
import org.tec.tobix.logicaIntegracion.Watson;
import org.tec.tobix.logicaNegocio.Comentario;
import org.tec.tobix.util.Calendario;

import com.ibm.watson.developer_cloud.assistant.v1.model.MessageResponse;

/**
 * Servlet implementation class ServletChatBot
 */
@WebServlet("/ServletChatBot")
public class ServletChatBot extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//private FlujoWatson flujo = new FlujoWatson();
	private Calendario calendar = new Calendario();
	ObtenerInformacion data = new ObtenerInformacion();
	InsertarInformacion info = new InsertarInformacion();
	private EnvioCorreos correos = new EnvioCorreos();
       
	private String mensaje; 
	private String cedula;
	private String idActividad ;
	private String tipofiltro ;
	private String comentario ;
	private String filtro ;
	private String accion;
	private String booleano;
	

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletChatBot() {
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
		// TODO Auto-generated method stub
		String variable = null;
		String value = null;
		String mensaje = "Hubo un error";	
		MessageResponse response1;
		String ask = request.getParameter("mensajeEnviar").toString();
		Watson w = Watson.getSingletonInstance();
		MessageResponse msg = (MessageResponse) w.startWatson();

		response1 = w.askWatsonMe(ask);
		mensaje = w.getWatsonMessage();
		variable = w.getVariable(response1);
		value = w.getResultado(response1);
		System.out.println("Variable:  " + variable);
		System.out.println("Value: "+ value);
		//booleano = "si";
		//servletE = w.askWatson(ask);
		/*do{
			
		     System.out.println(w.askWatson(ask));
		}while (ask != salir) ;*/
		
		/*if(ask.equals("registrar")) {
			//do something
			RequestDispatcher dispatcher = request.getRequestDispatcher("addParticipanteActividad.jsp");
			dispatcher.forward(request, response);
		}
		else if (ask.equals("comentar")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("addComentario.jsp");
			dispatcher.forward(request, response);		
		}
		else if (ask.equals("consultar")) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("consultas.jsp");
				dispatcher.forward(request, response);	
			}
		else {
			
		}*/
		if(variable.equals("accion")) {
			accion = value;
		}
		
		if(accion.equals("registrar")) {
			if( value.equals("registrar")) {
				System.out.println(" ");
			}
			else if(cedula == null ) {
				cedula = value;
			}
			else if(filtro == null) {
					filtro = value;
					System.out.println("filtro ");
			}else if(idActividad == null) {
				idActividad= value;
			}
			else if(booleano == null) {
				booleano = value;
			}
			 else {
				 try {
					 String hora;
					 hora = data.selectHoraInicio(idActividad);
					String dia = data.selectFecha(idActividad);
						if (calendar.diaVrsDia(dia) != true ) {				
							try {
								int Actividad = Integer.parseInt(idActividad);
								info.insertarParticipantes(cedula, Actividad);
								System.out.println("Insertar Participantes'");

								if(booleano.equals("si")) {
									info.insertarParticipantesConfirmados(cedula, Actividad);		
									String email = data.getEmail(cedula);
									correos.EnviarCorreo(idActividad , email);						
									System.out.println(" Se envio");
									}
								}
								catch(Exception e) {			
					  			System.out.println(e);
							}
						}else {
						}
					}
				 catch(Exception e) {
					 System.out.println(e);
					 System.out.println("La actividad que desea registrar ya paso de dia , por ende no puede comentar'");
				  	}
				 }			
			}
			//reset values
		else if(accion.equals("comentar")) {
			if(cedula == null) {
				cedula = value;
				//System.out.println("cedula ");
			}
			else if(idActividad == null){
				idActividad = value;
			}
			else {
				//flujo.setComentario(value);
				String hora;
				try {
					hora = data.selectHoraInicio(idActividad);
					String dia = data.selectFecha(idActividad);
					if (calendar.diaVrsDia(dia) != true) {
						/*if(calendar.horaVrsHora(hora).equals("MAYOR")) {
							Comentario comentario = new Comentario(mensaje);
							System.out.println(comentario.toString());
						}*/
						
						
					}
					System.out.print("Se supone que va a insertar");
					info.insertarComentario(idActividad,ask);
				} catch (SQLException | ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
			
		}
		else if(accion.equals("consultar")) {
			String encargado = w.getEncargado(response1);
			String franja = w.getFranja(response1);
			String fecha = w.getFecha(response1);
			String tipo = w.getTipoEvento(response1);
			String empresa = null;
			String tematica = null;
			ResultSet resultado = null ;
			if(fecha != null) {
				try {
					resultado = data.selectWatsonActividadesFecha(filtro);
					mensaje = crearMensaje(resultado,10);
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}else if(tipo != null ){
				try {
					resultado = data.selectActividadTipo(filtro);
					mensaje = crearMensaje(resultado,10);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}else if (franja != null)  {
				try {
					resultado = data.selectWatsonActividadesFranja(filtro);
					mensaje = crearMensaje(resultado,10);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			else if (empresa != null ) {
				
				try {
					resultado = data.selectWatsonActividadesEmpresa(filtro);
					mensaje = crearMensaje(resultado,10);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if (tematica != null) {
				try {
					resultado = data.selectWatsonActividadesTematica(filtro);
					System.out.print("Da resultado");
					mensaje = crearMensaje(resultado,10);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			else if (encargado != null) {
				try {
					resultado = data.selectActividadXEncargados(filtro);
					System.out.print("Da resultado");
					mensaje = crearMensaje(resultado,10);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		}
		
		PrintWriter out = response.getWriter();
		out.println( 
				"<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n" + 
				"<html>\r\n" + 
				"<head>\r\n" + 
				"<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n" + 
				"<title>Chat Tobix</title>\r\n" + 
				"<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\" integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\" crossorigin=\"anonymous\">\r\n" + 
				"		<link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.5.0/css/all.css\" integrity=\"sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU\" crossorigin=\"anonymous\">\r\n" + 
				"				<link  rel=\"stylesheet\" type=\"text/css\" href=\"styles.css\">\r\n" + 
				"		<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>\r\n" + 
				"		<link rel=\"stylesheet\" type=\"text/css\" href=\"https://cdnjs.cloudflare.com/ajax/libs/malihu-custom-scrollbar-plugin/3.1.5/jquery.mCustomScrollbar.min.css\">\r\n" + 
				"		<script type=\"text/javascript\" src=\"https://cdnjs.cloudflare.com/ajax/libs/malihu-custom-scrollbar-plugin/3.1.5/jquery.mCustomScrollbar.min.js\"></script>\r\n" + 
				"	</head>\r\n" + 
				"	<!--Coded With Love By Mutiullah Samim-->\r\n" + 
				"	<body>\r\n" + 
				"		<div class=\"container-fluid h-100\">\r\n" + 
				"			<div class=\"row justify-content-center h-100\">\r\n" + 
				"			<form action=\"ServletChatBot\" method=\"post\">	\r\n" + 
				"				<div class=\"col-md-8 col-xl-6 chat\">\r\n" + 
				"					<div class=\"card\">\r\n" + 
				"						<div class=\"card-header msg_head\">\r\n" + 
				"							<div class=\"d-flex bd-highlight\">\r\n" + 
				"								<div class=\"img_cont\">\r\n" + 
				"									<img src=\"https://us.123rf.com/450wm/vectomart/vectomart1206/vectomart120600109/14126113-ilustraci%C3%B3n-de-la-mujer-de-negocios-en-el-vector-3d-hablando-por-auriculares-en-el-centro-de-llamadas.jpg?ver=6\" class=\"rounded-circle user_img\">\r\n" + 
				"									<span class=\"online_icon\"></span>\r\n" + 
				"								</div>\r\n" + 
				"								<div class=\"user_info\">\r\n" + 
				"									<span>Watson Chat</span>\r\n" + 
				"									<p>bluemix</p>\r\n" + 
													
				"									<div class=\"msg_cotainer\">\r\n" + 
													mensaje + 
				"								</div>\r\n" + 
				"\r\n" + 
				"							</div>\r\n" + 
				"						</div>\r\n" + 
				"							<div class=\"d-flex justify-content-end mb-4\">\r\n" + 
				"								<div class=\"msg_cotainer_send\">\r\n" + 
													ask + 
				"								</div>\r\n" + 
				"								</div>\r\n" + 
				"							</div>\r\n" + 
				"						</div>\r\n" + 
				"						\r\n" + 
				"						<div class=\"card-body msg_card_body\">\r\n" + 
				"							<div class=\"d-flex justify-content-start mb-4\">\r\n" + 
				"								<div class=\"img_cont_msg\">\r\n" + 
				"									<img src=\"https://us.123rf.com/450wm/vectomart/vectomart1206/vectomart120600109/14126113-ilustraci%C3%B3n-de-la-mujer-de-negocios-en-el-vector-3d-hablando-por-auriculares-en-el-centro-de-llamadas.jpg?ver=6\" class=\"rounded-circle user_img_msg\">\r\n" + 
				"								</div>\r\n" + 
				"								\r\n" + 
				"							\r\n" + 
				"						<div class=\"card-footer\">\r\n" + 
				"							<div class=\"input-group\">\r\n" + 
				"						\r\n" + 
				"								<textarea name=\"mensajeEnviar\" class=\"form-control type_msg\" placeholder=\"Type your message...\"></textarea>\r\n" + 
				"								<div class=\"input-group-append\">\r\n" + 
				"									<span type=\"submit\" style=\"backgroundcolor:blue;color:blue class=\"input-group-text send_btn\"><i class=\"fas fa-location-arrow\"></i>\r\n" + 
				"										\r\n" + 
				"								</div>\r\n" + 
				"								<br><div><br><div align= \"right\"><br><input type=\"submit\" class=\"button\" value=\"Enviar\" style=\"width: 154px; \"><br></div>\r\n" + 
			 ""+
				"							</div>\r\n" + 
				"						</div>\r\n" + 
				"					</div>\r\n" + 
				"				</div>\r\n" + 
				"			</div>\r\n" + 
				"		</div>\r\n" + 
				"	</form>\r\n" + 
				"	</body>\r\n" + 
				"</html>\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"");
	}
	public String crearMensaje(ResultSet rs,int atributos) throws SQLException {
		String mensaje = "idk";
		System.out.println(rs);
		while(rs.next()) {
			int i = 1;
			while(i-1<atributos) {
				mensaje += rs.getString(i) + " ,";
				i++;
			}
			mensaje += "\n";
		}
		System.out.println(mensaje);
		return mensaje;
	}
	

}
