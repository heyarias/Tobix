package org.tec.tobix.logicaIntegracion;

import org.tec.tobix.dao.ObtenerInformacion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ibm.watson.developer_cloud.assistant.v1.model.MessageResponse;

public class FlujoWatson {

	private MessageResponse msg = null;
	private String mensaje; 
	Watson chat = Watson.getSingletonInstance();
	ObtenerInformacion info = new ObtenerInformacion();

	

	public String obtenerMensajeWatson() throws IOException {
		MessageResponse msg = (MessageResponse) chat.startWatson();
		return chat.getOutput(msg);
	}
	
	public void flujoNormal(String ask) throws Exception {
		do{
			//darRespuestaWatson(ask);
		}while (ask != "salir") ;
	}
	
	/*public String flujoConsultar(MessageResponse ms) throws SQLException {
		ResultSet resultado = null ;
		String mensaje = null;
		String fecha = chat.getFecha(ms);
		String tipoEvento = chat.getTipoEvento(ms);
		String franja = chat.getFranja(ms);
		if(fecha != null) {
			resultado = info.selectWatsonActividadesFecha(fecha);
			mensaje = crearMensajeConsulta(resultado,10);
		}else if(tipoEvento != null) {
			resultado = info.selectActividadTipo(tipoEvento);
			mensaje = crearMensajeConsulta(resultado,7);
		}else if (franja != null) {
			resultado = info.selectWatsonActividadesFranja(franja);
			mensaje = crearMensajeConsulta(resultado,10);
		}	
		return mensaje;	
	}*/
	
	public String crearMensajeConsulta(ResultSet rs,int atributos) throws SQLException {
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
