package org.tec.tobix.util;

import java.sql.Statement;

import org.tec.tobix.dao.InsertarInformacion;

public class Bitacora {
	Calendario calendar = new Calendario();
	//InsertarInformacion data = new InsertarInformacion();
	public Bitacora() {
		
	}
	public String queryBitacora() {
		String fecha = calendar.getFechaActual();
		String hora = calendar.getHoraActual();
		//String accion = data.getAccion(); 
		String query="insert into bitacora (fecha, hora, accion) values('"+fecha+"','"+hora+"','";			
		return query;
	}

}
