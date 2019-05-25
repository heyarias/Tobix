package org.tec.tobix.logicaIntegracion;

import java.io.FileWriter;

import logicaIntegracion.AlmacenarBitacora;
import logicaIntegracion.Bitacora;

public class Posicional  extends Bitacora 
{	
	private String rutaArchivo;
	
	public Posicional(AlmacenarBitacora biblioteca) 
	{
		this.rutaArchivo = "C:\\Bitacoras\\Posicional.txt";
		this.biblioteca = biblioteca;
		this.biblioteca.agregarBitacora((Bitacora)this);
	}	

	@Override
	public void update() throws Exception
	{
		FileWriter escribir = new FileWriter(this.rutaArchivo,true);
		
		String msg = null;
		
		while (this.biblioteca.rs.next())
		{
			msg += "Fecha: "+this.biblioteca.rs.getString(0)+",Hora: "+this.biblioteca.rs.getString(1)
				+  ",Accion: "+this.biblioteca.rs.getString(2);
		}
		escribir.write(msg);
		escribir.close();
	}
}
	
	


