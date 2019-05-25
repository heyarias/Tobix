package org.tec.tobix.logicaIntegracion;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Arrays;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.tec.tobix.dao.ObtenerInformacion;


public class CSV extends Bitacora {
	
	
	private static int cont=0;
	ObtenerInformacion obtener= new ObtenerInformacion();
	 public static final String separador=";";
	  public static final String slash="\"";
	public CSV() 
	{
		this.setRuta("C:\\Bitacoras\\CSV.csv");
		
	}
	

	public void update() throws Exception 
	{
		ResultSet res = obtener.selectHistorial();
	    File archivoCSV = new File(this.getRuta());
	    if(archivoCSV.exists()) archivoCSV.delete();
	    archivoCSV.createNewFile();
	    Workbook libro = new HSSFWorkbook();
	    FileOutputStream archivo = new FileOutputStream(archivoCSV);
	    Sheet hoja = libro.createSheet("Bitácora CSV");  /*Se crea la hoja de trabajo*/
        asignarEncabezado(hoja);
        agregarFilas(res,hoja);
	    libro.write(archivo);
	    archivo.close();  	    
	}
	private void asignarEncabezado(Sheet hoja) {
		 Row encabezado = hoja.createRow(1);
		Cell celda = encabezado.createCell(1);
        celda.setCellValue("Fecha");
        Cell celda1 = encabezado.createCell(2);
        celda1.setCellValue("Hora");
        Cell celda2 = encabezado.createCell(3);
        celda2.setCellValue("Acción");
	}
	private void agregarFilas(ResultSet res, Sheet hoja) throws SQLException {
		while(res.next()) {
		Row fila = hoja.createRow(cont);
        Cell celda3 = fila.createCell(1);
        celda3.setCellValue(res.getString(1));
        Cell celda4 = fila.createCell(2);
        celda4.setCellValue(res.getString(2));
        Cell celda5 = fila.createCell(3);
        celda5.setCellValue(res.getString(3));
        cont++;
		}
	}
	public String leerCSV() throws SQLException, ParseException, IOException {
		ObtenerInformacion ob=new ObtenerInformacion();
		BufferedReader br = null;
		String array=null;
	      try {br =new BufferedReader(new FileReader(this.getRuta()));
	         String line = br.readLine();
	         while (null!=line) {
	            String [] fields = line.split(separador);
	            array=Arrays.toString(fields);  
	            fields = divisionCSV(fields);
	            line = br.readLine();
	         }System.out.println(array);
	         return array;
	        		 } catch (Exception e) { }
	     finally {
	         if (null!=br) {
	            br.close();}}return array;}
	
	 private static String[] divisionCSV(String[] fields) {
	      String result[] = new String[fields.length];
	      for (int i=0;i<result.length;i++){
	         result[i] = fields[i].replaceAll("^"+slash, "").replaceAll(slash+"$", "");}      
	      return result;}
}



	
	


