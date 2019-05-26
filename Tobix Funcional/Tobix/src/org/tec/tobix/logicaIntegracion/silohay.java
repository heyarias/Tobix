package org.tec.tobix.logicaIntegracion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Scanner;

import org.json.JSONObject;
import org.tec.tobix.dao.InsertarInformacion;
import org.tec.tobix.dao.ObtenerInformacion;
import org.tec.tobix.util.Calendario;
import org.tec.tobix.util.translate;
import org.tec.tobix.logicaIntegracion.ToneAnalyzerService;
import org.tec.tobix.logicaNegocio.Actividad;

import com.ibm.db2.jcc.am.ResultSet;
import com.ibm.watson.developer_cloud.assistant.v1.model.MessageResponse;

public class silohay {
	
	static InsertarInformacion data = new InsertarInformacion();
	public static void main(String[] args) throws IOException, SQLException{
		String mensaje = "Hubo un error";	
		MessageResponse response1;
		String ask = "consul";
		Watson w = Watson.getSingletonInstance();
		MessageResponse msg = (MessageResponse) w.startWatson();
		
			response1 = w.askWatsonMe("consultar");
			mensaje = w.getWatsonMessage();
			String variable = w.getVariable(response1);
			String value = w.getResultado(response1);
			System.out.println("Variable:  " + variable);
			System.out.println("Value: "+ value);
			
			response1 = w.askWatsonMe("tec");
			mensaje = w.getWatsonMessage();
		    variable = w.getVariable(response1);
			value = w.getFecha(response1);
			System.out.println("Variable:  " + variable);
			System.out.println("Value: "+ value);
		
		
	}
	
	}