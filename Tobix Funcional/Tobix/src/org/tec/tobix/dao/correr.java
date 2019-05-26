package org.tec.tobix.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.sql.Time;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.stream.StreamSource;

import org.jdom.input.SAXBuilder;
import org.tec.tobix.logicaIntegracion.Bitacora;
import org.tec.tobix.logicaIntegracion.CSV;
import org.tec.tobix.logicaIntegracion.Posicional;
import org.tec.tobix.logicaIntegracion.XML;
import org.tec.tobix.logicaNegocio.Encargado;
import org.tec.tobix.logicaNegocio.Persona;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class correr {
	
	public static void main(String[] args) throws Exception {
		 
		ArrayList<String> array= new ArrayList();
			BufferedReader br = null;
		      try {
		    	  br =new BufferedReader(new FileReader("C:\\\\Users\\\\dayav\\\\OneDrive\\\\Escritorio\\\\XML.xml"));
		    	  array.add(br.readLine());
		    //Se crea un SAXBuilder para poder parsear el archivo
		    }finally{
		    	
		    	return array;
		    }}}