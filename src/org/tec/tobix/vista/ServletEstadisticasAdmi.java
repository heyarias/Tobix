package org.tec.tobix.vista;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.tec.tobix.dao.ObtenerInformacion;
import org.tec.tobix.logicaIntegracion.FlujoWatson;

/**
 * Servlet implementation class ServletEstadisticasAdmi
 */
@WebServlet("/ServletEstadisticasAdmi")
public class ServletEstadisticasAdmi extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ResultSet rs = null;
	ObtenerInformacion data = new ObtenerInformacion();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletEstadisticasAdmi() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String mensaje = "Hubo un error";	
		String query = request.getParameter("consultaAdmi").toString();
		
		if(query.equals("UsuariosConfirmados")) {
			try {
				rs = data.listarActividadesPorParticipantesConfirmados();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if (query.equals("UsuariosParticipantes")) {
			try {
				rs = data.listarActividadesPorParticipantes();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(query.equals("Cantidad de Comentarios por Actividad")) {
			try {
				rs = data.listarActividadesPorComentarios();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}/*else if(query.equals("Act x Felicidad")) {
			rs = data.
		}else if(query.equals("Act x Enojo")) {
			rs = data
		}*/
		try {
			mensaje = crearMensaje(rs,3);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>\r\n" + 
				"<html>\r\n" + 
				"	<head>\r\n" + 
				"		<title>Chat</title>\r\n" + 
				"		<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\" integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\" crossorigin=\"anonymous\">\r\n" + 
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
				"				\r\n" + 
				"				<div class=\"col-md-8 col-xl-6 chat\">\r\n" + 
				"					<div class=\"card\">\r\n" + 
				"						<div class=\"card-header msg_head\">\r\n" + 
				"							<div class=\"d-flex bd-highlight\">\r\n" + 
				"								<div class=\"img_cont\">\r\n" + 
				"									<img src=\"https://us.123rf.com/450wm/vectomart/vectomart1206/vectomart120600109/14126113-ilustraci%C3%B3n-de-la-mujer-de-negocios-en-el-vector-3d-hablando-por-auriculares-en-el-centro-de-llamadas.jpg?ver=6\" class=\"rounded-circle user_img\">\r\n" + 
				"									<span class=\"online_icon\"></span>\r\n" + 
				"								</div>\r\n" + 
				"								<div class=\"user_info\">\r\n" + 
				"									<span>Modulo Administrativo</span>\r\n" + 
				"									<p>Tobix</p>\r\n" + 
				"								</div>\r\n" + 
				"							</div>\r\n" + 
				"							<span id=\"action_menu_btn\"><i class=\"fas fa-ellipsis-v\"></i></span>\r\n" + 
				"						</div>\r\n" + 
				"						<div class=\"card-body msg_card_body\">\r\n" + 
				"							<div class=\"d-flex justify-content-start mb-4\">\r\n" + 
				"								<div class=\"img_cont_msg\">\r\n" + 
				"									<img src=\"https://us.123rf.com/450wm/vectomart/vectomart1206/vectomart120600109/14126113-ilustraci%C3%B3n-de-la-mujer-de-negocios-en-el-vector-3d-hablando-por-auriculares-en-el-centro-de-llamadas.jpg?ver=6\" class=\"rounded-circle user_img_msg\">\r\n" + 
				"								</div>\r\n" + 
				"								<div class=\"msg_cotainer\">\r\n" + 
				query+ 
				"									<span class=\"msg_time\"> Today</span>\r\n" + 
				"								</div>\r\n" + 
				"\r\n" + 
				"							</div>\r\n" + 
				"							<div class=\"d-flex justify-content-end mb-4\">\r\n" + 
				"								<div class=\"msg_cotainer_send\">\r\n" + 
				mensaje + 
				"									<span class=\"msg_time_send\">Today</span>\r\n" + 
				"								</div>\r\n" + 
				"								<div class=\"img_cont_msg\">\r\n" + 
				"								<img src=\"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTkUCC4XXwxT3EKnLNlj2hI5DKBZ3Nfeqo1dZgy_xDMPC-jlYFW\" class=\"rounded-circle user_img_msg\">\r\n" + 
				"								</div>\r\n" + 
				"							</div>						\r\n" + 
				"						</div>\r\n" + 
				"						<div class=\"card-footer\">\r\n" + 
				"							<div class=\"input-group\">\r\n" + 
				"								<div class=\"input-group-append\">\r\n" + 
				"									<span class=\"input-group-text attach_btn\"><i class=\"fas fa-paperclip\"></i></span>\r\n" + 
				"								</div>\r\n" + 
				"								<textarea name=\"\" class=\"form-control type_msg\" placeholder=\"Type your message...\"></textarea>\r\n" + 
				"								<div class=\"input-group-append\">\r\n" + 
				"									<span class=\"input-group-text send_btn\"><i class=\"fas fa-location-arrow\"></i></span>\r\n" + 
				"								</div>\r\n" + 
				"							</div>\r\n" + 
				"						</div>\r\n" + 
				"					</div>\r\n" + 
				"				</div>\r\n" + 
				"			</div>\r\n" + 
				"		</div>\r\n" + 
				"	</body>\r\n" + 
				"</html>\r\n" + 
				"");
	}
	public String crearMensaje(ResultSet rs,int atributos) throws SQLException {
		String mensaje = "";
		while(rs.next()) {
			int i = 1;
			while(i>atributos) {
				mensaje += rs.getString(i) + " ,";
			}
			mensaje += "\n";
		}
		return mensaje;
		
	}
}


