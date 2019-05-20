package org.tec.tobix.logicaIntegracion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;
import java.sql.SQLException;

import org.json.JSONObject;
import org.tec.tobix.dao.ObtenerInformacion;
import org.tec.tobix.util.Calendario;
import org.tec.tobix.logicaIntegracion.ToneAnalyzerService;
import org.tec.tobix.logicaNegocio.Actividad;

import com.ibm.db2.jcc.am.ResultSet;
import com.ibm.watson.developer_cloud.assistant.v1.model.MessageResponse;

public class silohay {
	//static Calendario time = new Calendario();
	//static ObtenerInformacion data = new ObtenerInformacion();



	public static void main(String[] args) throws SQLException{
		LanguageTranslatorApp LT= new LanguageTranslatorApp();
		LT.correr();
	}
		
		
		
	

}
