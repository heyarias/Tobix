package org.tec.tobix.logicaIntegracion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;
import java.sql.SQLException;

import org.json.JSONObject;
import org.tec.tobix.dao.ObtenerInformacion;
import org.tec.tobix.util.Calendario;

import com.ibm.db2.jcc.am.ResultSet;
import com.ibm.watson.developer_cloud.assistant.v1.model.MessageResponse;

public class silohay {
	//static Calendario time = new Calendario();
	//static ObtenerInformacion data = new ObtenerInformacion();
	static Watson w = Watson.getSingletonInstance();


	public static void main(String[] args){
	 try {
	//	System.out.print(w.askWatsonMe("hoy"));
		 MessageResponse response;
		 response = w.askWatsonMe("id actividad");
		 String h =  w.getFecha(response);
		 System.out.print(h);
		//System.out.print(w.askWatson("comentar"));
	 }catch( Exception SQLException ){
		 System.out.println(SQLException);
	 }
		
	}
		
		
		
	

}
