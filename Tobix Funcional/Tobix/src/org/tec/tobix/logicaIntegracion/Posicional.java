package org.tec.tobix.logicaIntegracion;


import java.io.FileWriter;
import java.sql.ResultSet;

import org.tec.tobix.dao.ObtenerInformacion;

public class Posicional  extends Bitacora 
{	
	
	ObtenerInformacion obtener= new ObtenerInformacion();
	public Posicional() 
	{
		this.setRuta("C:\\Bitacoras\\Posicional.txt");
		
	}	
	@Override
	public void update() throws Exception
	{	ResultSet res= obtener.selectHistorial();
		FileWriter escribir = new FileWriter(this.getRuta(),true);
		String msg = null;
		while (res.next())
		{
			msg += "Fecha: "+res.getString(1)+",Hora: "+res.getString(2)
				+  ",Accion: "+res.getString(3);
		}
		escribir.write(msg);
		escribir.close();
	}
}
	
	


