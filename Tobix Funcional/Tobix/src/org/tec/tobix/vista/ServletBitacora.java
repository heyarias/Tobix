package org.tec.tobix.vista;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.tec.tobix.logicaIntegracion.AlmacenarBitacora;
import org.tec.tobix.logicaIntegracion.CSV;
import org.tec.tobix.logicaIntegracion.Posicional;
import org.tec.tobix.logicaIntegracion.XML;

/**
 * Servlet implementation class ServletBitacora
 */
@WebServlet("/ServletBitacora")
public class ServletBitacora extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletBitacora() {
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
		//doGet(request, response);
		//String path=request.getRealPath("service.json");
		String path = "C:\\Users\\Hazel\\Desktop";
		String bitacora  = request.getParameter("bitacora").toString();
		AlmacenarBitacora bit = new AlmacenarBitacora(new XML(path));

		PrintWriter out = response.getWriter();
		if(bitacora.equals("xml")) {
			System.out.println("xml");
			 bit = new AlmacenarBitacora(new XML(path));
			 
			 ArrayList<String> data = bit.leer();
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
															"Bitacora" + 
						"								</div>\r\n" + 
						"\r\n" + 
						"							</div>\r\n" + 
						"						</div>\r\n" + 
						"							<div class=\"d-flex justify-content-end mb-4\">\r\n" + 
						"								<textarea rows=\"10\" cols=\"70\">"+ 
															data + 
						"								</textarea>" + 
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
			
		}else if(bitacora.equals("csv")) {
			System.out.println("csv");
			 bit = new AlmacenarBitacora(new Posicional(path));
			 ArrayList<String> data = bit.leer();
			 String datos = data.get(1);
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
															"Bitacora CSV" + 
						"								</div>\r\n" + 
						"\r\n" + 
						"							</div>\r\n" + 
						"						</div>\r\n" + 
						"							<div class=\"d-flex justify-content-end mb-4\">\r\n" + 
						"								<textarea rows=\"10\" cols=\"70\">"+ 
															data + 
						"								</textarea>" + 
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
		}else if(bitacora.equals("trama")) {
			bit = new AlmacenarBitacora(new Posicional(path));
			ArrayList<String> datos = bit.leer();
			int i = 0;
			String msj = "";
			while (i < datos.size()) {
				msj = msj + " "+datos.get(i) + "\n ";
				i++;
				
			}
			System.out.println("trama");
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
														"Bitacora Trama Plana" + 
					"								</div>\r\n" + 
					"\r\n" + 
					"							</div>\r\n" + 
					"						</div>\r\n" + 
					"							<div class=\"d-flex justify-content-end mb-4\">\r\n" + 
					"								<textarea rows=\"10\" cols=\"70\">"+ 
														msj + 
					"								</textarea>" + 
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
		
		}else if (bitacora.equals("act")) {
			try {
				bit.update(path);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		//response.getWriter().append((CharSequence) msj);
		
	}
		

}
