package org.tec.tobix.logicaIntegracion;

import java.io.File;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import logicaIntegracion.AlmacenarBitacora;
import logicaIntegracion.Bitacora;

public class CSV extends Bitacora {
	
	private String rutaArchivo;
	public CSV(AlmacenarBitacora biblioteca) 
	{
		this.rutaArchivo = "C:\\Bitacoras\\CSV.csv";
		this.biblioteca = biblioteca;
		this.biblioteca.agregarBitacora((Bitacora)this);
	}
	

	public void update() throws Exception 
	{
		/*Se crea el objeto de tipo File con la ruta del archivo*/
	    File archivoCSV = new File(rutaArchivo);
	    /*Si el archivo existe se elimina*/
	    if(archivoCSV.exists()) archivoCSV.delete();
	    /*Se crea el archivo*/
	    archivoCSV.createNewFile();
	    
	    /*Se crea el libro de excel usando el objeto de tipo Workbook*/
	    Workbook libro = new HSSFWorkbook();
	    
	    /*Se inicializa el flujo de datos con el archivo CSV*/
	    FileOutputStream archivo = new FileOutputStream(archivoCSV);
	    
	    /*Utilizamos la clase Sheet para crear una nueva hoja de trabajo dentro del libro que creamos anteriormente*/
	    Sheet hoja = libro.createSheet("Bitácora CSV");
	   	    
	    /*La clase Row nos permitirÃ¡ crear las filas*/
        Row encabezado = hoja.createRow(1);

        Cell celda = encabezado.createCell(1);
        celda.setCellValue("Fecha");
        
        Cell celda1 = encabezado.createCell(2);
        celda1.setCellValue("Hora");
        
        Cell celda2 = encabezado.createCell(3);
        celda2.setCellValue("Acción");
        
        int cont = 2;

	    while(this.biblioteca.rs.next())
	    {
	    	Row fila = hoja.createRow(cont);
	        Cell celda3 = fila.createCell(1);
	        celda3.setCellValue(this.biblioteca.rs.getString(1));
	        
	        Cell celda4 = fila.createCell(2);
	        celda4.setCellValue(this.biblioteca.rs.getString(2));
	        
	        Cell celda5 = fila.createCell(3);
	        celda5.setCellValue(this.biblioteca.rs.getString(3));
	    	
	        cont ++;
	    }
	    
	    /*Escribimos en el libro*/
	    libro.write(archivo);
	    
	    /*Cerramos el flujo de datos*/
	    archivo.close();  	    
	}
	

}
