package org.tec.tobix.logicaIntegracion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
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
	
	public static void main(String[] args) throws Exception{
		ToneAnalyzerService tone= new ToneAnalyzerService();
	
		Actividad act=new Actividad();
		ArrayList<String> f = act.analisisComentario(2);
		int i = 0;
		while(i<f.size()) {
			String comentario = f.get(i);
			System.out.println( comentario);
			ArrayList sentimientos = tone.detectarFrases("It was a very good day. The people was angry, but i was great");	
			String mensaje = "Comentario: "+ comentario + "Sentimientos: "; 
			i++;
			int y = 0;
			while(y < sentimientos.size()) {
				mensaje += sentimientos.get(y) + ", "; 
				y++;}
		
	}}}
	
	