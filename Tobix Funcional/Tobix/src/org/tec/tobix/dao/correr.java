package org.tec.tobix.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Time;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

import org.tec.tobix.logicaNegocio.Encargado;
import org.tec.tobix.logicaNegocio.Persona;

public class correr {
	static String ruta="C:\\Users\\dayav\\OneDrive\\Escritorio\\Book1.csv";
	  public static final String separador=";";
	  public static final String slash="\"";
	public static void main(String[] args) throws SQLException, ParseException, IOException {
		ObtenerInformacion ob=new ObtenerInformacion();
		BufferedReader br = null;
		String array = null;
	      try {
	    	  br =new BufferedReader(new FileReader(ruta));
	         String line = br.readLine();
	         while (null!=line) {
	            String [] fields = line.split(separador);
	            array=Arrays.toString(fields);  
	            fields = divisionCSV(fields);
	            line = br.readLine();
	         }System.out.println(array);
	        		 } catch (Exception e) { 
	      }
	     
	      finally {
	         if (null!=br) {
	            br.close();
	         }}}
	 private static String[] divisionCSV(String[] fields) {
	      String result[] = new String[fields.length];
	      for (int i=0;i<result.length;i++){
	         result[i] = fields[i].replaceAll("^"+slash, "").replaceAll(slash+"$", "");}
	      
	      return result;
	   }
}
