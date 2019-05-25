package org.tec.tobix.logicaIntegracion;


import java.sql.ResultSet;
import java.util.ArrayList;



public class AlmacenarBitacora{
	private Bitacora bitacora= new XML();	
	public AlmacenarBitacora(Bitacora bitacora) 
	{
		this.bitacora = bitacora;
	}

	public void update() throws Exception
	{
		cambiarMecanismoBitacora(new XML());
		this.bitacora.update();
		cambiarMecanismoBitacora(new CSV());
		this.bitacora.update();
		cambiarMecanismoBitacora(new Posicional());
		this.bitacora.update();
	}
	public void cambiarMecanismoBitacora(Bitacora bitacora)
	{
		this.bitacora = bitacora;
	}
	
	

}