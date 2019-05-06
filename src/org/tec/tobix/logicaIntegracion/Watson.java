package org.tec.tobix.logicaIntegracion;

import java.util.logging.LogManager;

import org.json.JSONArray;
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
			LogManager.getLogManager().reset();
			// Set up Assistant service.
			this.option = new IamOptions.Builder()
				    .apiKey("P3l7eKorVPnyC_Di_bUMlUpF-pb9tBh5ouycErv31lVP")
				    .build();
			this.service = new Assistant("2017-09-21", this.option);
		    this.workspaceID = "b3e2886c-9664-4b67-81c7-43530a11a31b";
			// Start assistant with empty message.
			this.options = new MessageOptions.Builder(this.workspaceID).build();
			this.response = this.service.message(this.options).execute();	
		}

		
		catch (Exception e) 
	    {
			System.out.println("NO LO CREA");
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
	
	public String getOutput(MessageResponse response)
	{
		JSONObject jsonResponse = new JSONObject(response);
		JSONArray outputObj = new JSONObject(jsonResponse.get("output").toString()).getJSONArray("text");
		int large = outputObj.length();
		return outputObj.getString(large-1);
	}
	
	public String getTipoEvento(MessageResponse response)
	{
		JSONObject jsonResponse = new JSONObject(response);
		JSONObject outputObj = new JSONObject(jsonResponse.get("context").toString());
		String tipoEvento = null;
		if(outputObj.has("tipoEvento")) 
		{
			tipoEvento = outputObj.get("tipoEvento").toString();
		}
		return tipoEvento;
	}
	

	
	
	public String getAccion(MessageResponse response)
	{
		JSONObject jsonResponse = new JSONObject(response);
		System.out.println(response);
		JSONObject outputObj = new JSONObject(jsonResponse.get("context").toString());
		String tipoEvento = null;
		if(outputObj.has("accion")) 
		{
			tipoEvento = outputObj.get("accion").toString();
		}
		return tipoEvento;
	}
	
	public String getFecha(MessageResponse response)
	{
		JSONObject jsonResponse = new JSONObject(response);
		JSONObject outputObj = new JSONObject(jsonResponse.get("context").toString());
		String date = null;
		if(outputObj.has("date")) 
		{
			date = outputObj.get("date").toString();
		}
		return date;
	}
	
	public String getEncargado(MessageResponse response)
	{
		JSONObject jsonResponse = new JSONObject(response);
		JSONObject outputObj = new JSONObject(jsonResponse.get("context").toString());
		String encargado = null;
		if(outputObj.has("encargado")) 
		{
			encargado = outputObj.get("encargado").toString();
		}
		return encargado;
	}
	
	public String getFranja(MessageResponse response)
	{
		JSONObject jsonResponse = new JSONObject(response);
		JSONObject outputObj = new JSONObject(jsonResponse.get("context").toString());
		String franja = null;
		if(outputObj.has("franja")) 
		{
			franja = outputObj.get("franja").toString();
		}
		return franja;
	}
	public String getIdActividad(MessageResponse response)
	{
		JSONObject jsonResponse = new JSONObject(response);
		JSONObject outputObj = new JSONObject(jsonResponse.get("context").toString());
		String idActividad = null;
		if(outputObj.has("idEvento")) 
		{
			idActividad = outputObj.get("idEvento").toString();
		}
		return idActividad;
	}
	
	public String getIdPersona(MessageResponse response)
	{
		JSONObject jsonResponse = new JSONObject(response);
		JSONObject outputObj = new JSONObject(jsonResponse.get("context").toString());
		String idPersona = null;
		if(outputObj.has("idPersona")) 
		{
			idPersona = outputObj.get("idPersona").toString();
		}
		return idPersona;
	}
	
	public String getConfirmado(MessageResponse response)
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
	
	public Object askWatson(String ask)
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
	public String getWatsonMessage() {
	    MessageResponse msg = null;
	
		String mensaje;	
		msg = (MessageResponse) chat.startWatson();
		mensaje = chat.getOutput(msg);	
		return mensaje;
		
	}

}
