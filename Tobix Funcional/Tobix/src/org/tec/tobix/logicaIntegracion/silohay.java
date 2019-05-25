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
import org.tec.tobix.util.translate;
import org.tec.tobix.logicaIntegracion.ToneAnalyzerService;
import org.tec.tobix.logicaNegocio.Actividad;

import com.ibm.db2.jcc.am.ResultSet;
import com.ibm.watson.developer_cloud.assistant.v1.model.MessageResponse;

public class silohay {
	
	static translate t = new translate();
	public static void main(String[] args) throws IOException, SQLException{

	//String text = translate.translate("Su participacion a la actividad 7 ha sido confirmada."+"\n" +"Gracias por elegirnos ");
	//System.out.println(text);
	ToneAnalyzerService act= new ToneAnalyzerService();
	act.detectarFrases("I hate so much this ugly experience. The places was awful, but all the colors presents was perfects");
	}
	
	}