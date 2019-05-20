package org.tec.tobix.logicaIntegracion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Scanner;

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
		
		 while (true) {
			 Scanner scanner = new Scanner(System. in);
			 System.out.print("Digite su mensaje");
		     String ask = scanner. nextLine();
		     System.out.print(ask);
		     if (ask == "adios") {
				 break;
			 }
		     response = w.askWatsonMe(ask);
		     System.out.println(response);
			/* String h =  w.getFecha(response);
			 System.out.print(h);*/
		     /*String h = w.getVariable(response);
		     System.out.print(h);*/
			 System.out.println(w.getWatsonMessage());
			 
		 }
		
	     


		//System.out.print(w.askWatson("comentar"));
	 }catch( Exception SQLException ){
		 System.out.println(SQLException);
	 }
		
	}
		
		
		
	

}
