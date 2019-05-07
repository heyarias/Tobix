package org.tec.tobix.logicaIntegracion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

import org.tec.tobix.dao.ObtenerInformacion;
import org.tec.tobix.util.Calendario;

import com.ibm.db2.jcc.am.ResultSet;
import com.ibm.watson.developer_cloud.assistant.v1.model.MessageResponse;

public class silohay {
	static Calendario time = new Calendario();
	static ObtenerInformacion data = new ObtenerInformacion();


	public static void main(String[] args) throws SQLException, IOException {
		//System.out.print( time.getHoraActual("9:00:00"));
		String r = data.selectLogIn("heey.arias@gmail.com","hazel");
		System.out.print(r);
		
	}
		
		
		
	

}
