package org.tec.tobix.logicaIntegracion;


import java.sql.ResultSet;
import java.util.ArrayList;



public class AlmacenarBitacora{
	private Bitacora bitacora;	
	public AlmacenarBitacora(Bitacora bitacora) 
	{
		this.bitacora = bitacora;
	}

	
	public void update(String ruta) throws Exception
	{
		cambiarMecanismoBitacora(new XML(ruta));
		this.bitacora.update();
		cambiarMecanismoBitacora(new CSV(ruta));
		this.bitacora.update();
		cambiarMecanismoBitacora(new Posicional(ruta));
		this.bitacora.update();
	}
	public ArrayList<String> leer() {
		return bitacora.leer();
	}
	public void cambiarMecanismoBitacora(Bitacora bitacora)
	{
		this.bitacora = bitacora;
	}
	
	

}