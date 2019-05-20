package org.tec.tobix.logicaIntegracion;

import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import logicaIntegracion.AlmacenarBitacora;
import logicaIntegracion.Bitacora;


public class XML extends Bitacora 
{	
	private static String rutaArchivo;
	
	public XML(AlmacenarBitacora biblioteca) 
	{
		this.biblioteca = biblioteca;
		this.biblioteca.agregarBitacora((Bitacora)this);	
	}


	@Override
	public void update() throws Exception 
	{
		String nombre_archivo = "XML";
		ArrayList key = new ArrayList();
		ArrayList value = new ArrayList();
    
		while(this.biblioteca.rs.next()) 
		{
			key.add("Fecha");
			value.add(this.biblioteca.rs.getDate(1));
			key.add("Hora");
			value.add(this.biblioteca.rs.getTime(2));
			key.add("Accion");
			value.add(this.biblioteca.rs.getString(3));	
		}
    
	    try
	    {
			generate(nombre_archivo, key, value);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void generate(String name, ArrayList<String> key,ArrayList<String> value) throws Exception
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
		     
		        rutaArchivo = "C:\\Bitacoras\\"+name+".xml";
		        
		        Result result = new StreamResult(new java.io.File(rutaArchivo)); //nombre del archivo
		        Transformer transformer = TransformerFactory.newInstance().newTransformer();
		        transformer.transform(source, result);
		     
		    }
		}

}