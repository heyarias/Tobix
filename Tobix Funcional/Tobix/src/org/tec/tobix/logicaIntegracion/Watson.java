package org.tec.tobix.logicaIntegracion;

import java.util.logging.LogManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import com.ibm.watson.developer_cloud.assistant.v1.Assistant;
import com.ibm.watson.developer_cloud.assistant.v1.model.Context;
import com.ibm.watson.developer_cloud.assistant.v1.model.InputData;
import com.ibm.watson.developer_cloud.assistant.v1.model.MessageOptions;
import com.ibm.watson.developer_cloud.assistant.v1.model.MessageResponse;
import com.ibm.watson.developer_cloud.service.security.IamOptions;

public class Watson {
	
	private String serviceID;
	private String user;
	private String pass;
	private String workspaceID;
	private Assistant service;
	private MessageOptions options;
	private Context context; 
	private MessageResponse response;
	private IamOptions option;
	private static Watson chat;
	
	private Watson()
	{		
		try
		{//Set up Assistant service.
			System.out.println("Private Watson");
			LogManager.getLogManager().reset();
			// Set up Assistant service.
			System.out.println("LogManager");
			this.option = new IamOptions.Builder()
				    .apiKey("P3l7eKorVPnyC_Di_bUMlUpF-pb9tBh5ouycErv31lVP")
				    .build();
			System.out.println(option);
			System.out.println("IamOptions");
			this.service = new Assistant("2017-09-21", this.option);
			System.out.println("Assistant");
		    this.workspaceID = "b3e2886c-9664-4b67-81c7-43530a11a31b";
			// Start assistant with empty message.
			this.options = new MessageOptions.Builder(this.workspaceID).build();
			
			this.response = this.service.message(this.options).execute();	
			System.out.println("response");
		}

		
		catch (Exception e) 
	    {
			System.out.println("NO LO CREA");
			System.out.println(e);
			e.printStackTrace();
		} 
	   } 
	
		
	public static Watson getSingletonInstance()
	{
		if(chat == null)
		{			
			chat = new Watson();
		}
		return chat;
	}
	
	public String getOutput(MessageResponse response) throws JSONException
	{
		JSONObject jsonResponse = new JSONObject(response);
		JSONArray outputObj = new JSONObject(jsonResponse.get("output").toString()).getJSONArray("text");
		int large = outputObj.length();
		return outputObj.getString(large-1);
	}
	
	
	public String getResultado(MessageResponse response) throws JSONException
	{
		JSONObject jsonResponse = new JSONObject(response);
		JSONArray outputObj = (JSONArray) jsonResponse.get("entities");
		JSONObject o = null;
		String date = null;
		if(jsonResponse.has("entities")) 
		{
			o = outputObj.getJSONObject(0);
			date = o.getString("value");
		
			//System.out.println("entities");
		}
		return date;
	}
	public String getVariable(MessageResponse response) throws JSONException
	{
		JSONObject jsonResponse = new JSONObject(response);
		JSONArray outputObj = (JSONArray) jsonResponse.get("entities");
		JSONObject o = null;
		String date = null;
		if(jsonResponse.has("entities")) 
		{
			o = outputObj.getJSONObject(0);
			date = o.getString("entity");
		}
		//System.out.println(response);
		return date;
	}
	public String getTipoEvento(MessageResponse response) throws JSONException
	{
		JSONObject jsonResponse = new JSONObject(response);
		JSONObject outputObj;
		
			outputObj = new JSONObject(jsonResponse.get("context").toString());
	
		String evento = null;
		if(outputObj.has("tipoEvento")) 
		{
			evento = outputObj.get("tipoEvento").toString();
			System.out.println(evento);
		}
		return evento;
	}
	
	public String getFranja(MessageResponse response) throws JSONException
	{
		JSONObject jsonResponse = new JSONObject(response);
		JSONObject outputObj;
		
			outputObj = new JSONObject(jsonResponse.get("context").toString());
	
		String  franja = null;
		if(outputObj.has("franja")) 
		{
			franja = outputObj.get("franja").toString();
			System.out.println(franja);
		}
		return franja;
	}
	public String getEncargado(MessageResponse response) throws JSONException
	{
		JSONObject jsonResponse = new JSONObject(response);
		JSONObject outputObj = new JSONObject(jsonResponse.get("context").toString());
		String encargado = null;
		if(outputObj.has("encargado")) 
		{
			encargado = outputObj.get("encargado").toString();
			System.out.println(encargado);
		}
		
		return encargado;
	}
	
	public String getEmpresa(MessageResponse response) throws JSONException
	{
		JSONObject jsonResponse = new JSONObject(response);
		JSONObject outputObj = new JSONObject(jsonResponse.get("context").toString());
		String empresa = null;
		if(outputObj.has("empresa")) 
		{
			empresa = outputObj.get("empresa").toString();
			System.out.println(empresa);
		}
		
		return empresa;
	}
	
	public String getTematica(MessageResponse response) throws JSONException
	{
		JSONObject jsonResponse = new JSONObject(response);
		JSONObject outputObj = new JSONObject(jsonResponse.get("context").toString());
		String tematica = null;
		if(outputObj.has("tematica")) 
		{
			tematica = outputObj.get("tematica").toString();
			System.out.println(tematica);
		}
		
		return tematica;
	}
	
	public String getFecha(MessageResponse response) throws JSONException
	{
		JSONObject jsonResponse = new JSONObject(response);
		JSONObject outputObj = new JSONObject(jsonResponse.get("context").toString());
		String fecha = null;
		if(outputObj.has("sys-date")) 
		{
			fecha = outputObj.get("sys-date").toString();
			System.out.println(fecha);
		}
		
		return fecha;
	}
	public String getConfirmado(MessageResponse response) throws JSONException
	{
		JSONObject jsonResponse = new JSONObject(response);
		JSONObject outputObj = new JSONObject(jsonResponse.get("context").toString());
		String confirmado = null;
		if(outputObj.has("afirmativo")) 
		{
			confirmado = outputObj.get("afirmativo").toString();
		}
		return confirmado;
	}
	public Object startWatson()
	{
		return this.response;
	}
	
	public Object askWatson(String ask) throws JSONException
	{		
		this.context = this.response.getContext();
		InputData input = new InputData.Builder(ask).build();
		
		this.options = new MessageOptions.Builder(this.workspaceID)
				.input(input)
				.context(this.context)
				.build();

		this.response = this.service.message(this.options)
				.execute();
		
		return getOutput(this.response);
	}
	
	public MessageResponse askWatsonMe(String ask)
	{		
		this.context = this.response.getContext();
		InputData input = new InputData.Builder(ask).build();
		
		this.options = new MessageOptions.Builder(this.workspaceID)
				.input(input)
				.context(this.context)
				.build();

		this.response = this.service.message(this.options)
				.execute();
		
		return this.response;
	}
	public String getWatsonMessage() throws JSONException {
	    MessageResponse msg = null;
	
		String mensaje;	
		msg = (MessageResponse) chat.startWatson();
		mensaje = chat.getOutput(msg);	
		return mensaje;
		
	}

}
