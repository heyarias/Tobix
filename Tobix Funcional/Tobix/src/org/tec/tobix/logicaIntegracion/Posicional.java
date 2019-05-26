package org.tec.tobix.logicaIntegracion;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import org.tec.tobix.dao.ObtenerInformacion;

public class Posicional  extends Bitacora 
{	
	
	ObtenerInformacion obtener= new ObtenerInformacion();
	public Posicional() 
	{
		this.setRuta("C:\\Users\\dayav\\OneDrive\\Escritorio\\Posicional.txt");
		
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
	public  ArrayList<String> leer()  {
        File file = null;
        FileReader fileReader = null;
        BufferedReader buffered = null;
        ArrayList<String> lineas= new ArrayList();
        try {
			file = new File ("C:\\Users\\dayav\\OneDrive\\Escritorio\\Semestre VII\\Diseño\\ScripProgra.txt");
			fileReader = new FileReader (file);
			buffered= new BufferedReader(fileReader);
			String linea;
			while((linea=buffered.readLine())!=null) {
			lineas.add(linea);}
        	return lineas;
        }
        catch(Exception e){
           e.printStackTrace();
        }finally{
           try{
              if( null != fileReader ){
                 fileReader.close();}
           }catch (Exception e2){

              e2.printStackTrace();
}}return lineas;}}
	

	
	


