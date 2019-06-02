package org.tec.tobix.logicaIntegracion;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.tec.tobix.dao.ObtenerInformacion;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;



public class XML extends Bitacora 
{	
	ObtenerInformacion obtener= new ObtenerInformacion();
	private static String rutaArchivo;
	
	
	public XML(String rutaR) 
	{
		this.setRuta(rutaR);
		System.out.println(this.getRuta());
	}


	@Override
	public void update() throws Exception 
	{
		ResultSet res = obtener.selectHistorial();
		String nombre_archivo = "XML";
		ArrayList key = new ArrayList();
		ArrayList value = new ArrayList();
    
		while(res.next()) 
		{
			key.add("Fecha");
			value.add(res.getString(1));
			key.add("Hora");
			value.add(res.getString(2));
			key.add("Accion");
			value.add(res.getString(3));	
		}
	    try
	    {
			generate(nombre_archivo, key, value,this.getRuta());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private static void generate(String name, ArrayList<String> key,ArrayList<String> value, String ruta) throws Exception
	{
		    if(key.isEmpty() || value.isEmpty() || key.size()!=value.size())
		    {
		        System.out.println("ERROR empty ArrayList");
		        return;
		    }
		    else{
		    	
		        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		        DocumentBuilder builder = factory.newDocumentBuilder();
		        DOMImplementation implementation = builder.getDOMImplementation();
		        Document document = implementation.createDocument(null, name, null);
		        document.setXmlVersion("1.0");
		        //Main Node
		        Element raiz = document.getDocumentElement();
		        //Por cada key creamos un item que contendrá la key y el value
		        for(int i=0; i<key.size();i++){
		            //Item Node
		            Element itemNode = document.createElement("Bitácora"); 
		            //Key Node
		            Element keyNode = document.createElement("Dato"); 
		            Text nodeKeyValue = document.createTextNode(key.get(i));
		            keyNode.appendChild(nodeKeyValue);      
		            //Value Node
		            Element valueNode = document.createElement("Valor"); 
		            Text nodeValueValue = document.createTextNode(value.get(i));                
		            valueNode.appendChild(nodeValueValue);
		            //append keyNode and valueNode to itemNode
		            itemNode.appendChild(keyNode);
		            itemNode.appendChild(valueNode);
		            //append itemNode to raiz
		            raiz.appendChild(itemNode); //pegamos el elemento a la raiz "Documento"
		        }                
		        //Generate XML
		        Source source = new DOMSource(raiz);
		        //Indicamos donde lo queremos almacenar
		        rutaArchivo =ruta+"XML.xml";
		        
		        Result result = new StreamResult(new java.io.File(rutaArchivo)); //nombre del archivo
		        Transformer transformer = TransformerFactory.newInstance().newTransformer();
		        transformer.transform(source, result);
		     
		    }}
		    public ArrayList<String> leer() {
		    	
		    	ArrayList<String> array= new ArrayList();
				BufferedReader br = null;
			      try {
			    	  br =new BufferedReader(new FileReader(this.getRuta()+"XML.xml"));
			    	  array.add(br.readLine());
			    //Se crea un SAXBuilder para poder parsear el archivo
			    }finally{
			    	System.out.println(array);
			    	System.out.println("JAAA");
			    	return array;	
			    }}


		
		}

