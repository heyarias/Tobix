package org.tec.tobix.logicaIntegracion;

import java.util.ArrayList;

import com.ibm.watson.developer_cloud.service.security.IamOptions;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.ToneAnalyzer;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.ToneAnalysis;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.ToneOptions;

public class ToneAnalyzerService {
	public static String determinarSentimiento(String comentario) {
		IamOptions options = new IamOptions.Builder()
				  .apiKey("8ujvx-B3Qu_VtCEftiI7-kWkhGasbHBqN940hW4qXocY")
				  .build();

				ToneAnalyzer toneAnalyzer = new ToneAnalyzer("2017-09-21", options);
				toneAnalyzer.setEndPoint("https://gateway.watsonplatform.net/tone-analyzer/api");

				String text = comentario;

				ToneOptions toneOptions = new ToneOptions.Builder()
				  .text(text)
				  .build();

				ToneAnalysis toneAnalysis = toneAnalyzer.tone(toneOptions).execute();
		return extraerSentimientoPrincipal(toneAnalysis);
	}
	private static String extraerSentimientoPrincipal(ToneAnalysis tone) {
		String toneString = tone.toString();
		ArrayList<String> sentimientos = new ArrayList();
		toneString = toneString.replaceAll(" ", "");
		String[] toneDivi = toneString.split(",");
		for(int i=1; i<toneDivi.length; i=i+3) {
			toneString = toneDivi[i].split(":")[1];
			sentimientos.add(toneString);
		}
		
		return definirSentimiento(sentimientos);
	}
	private static String definirSentimiento(ArrayList<String> sentimientos) {
		
		for(int i=0;i<sentimientos.size();i++) {
			if(sentimientos.get(i).equals("anger")) {
				System.out.println("anger");
				return "enojo";
			}
			if(sentimientos.get(i).equals("fear")) {
				System.out.println("fear");
				return "miedo";
				
			}
			if(sentimientos.get(i).equals("joy")) {
				System.out.println("joy");
				return "Alegria";
			}
			if(sentimientos.get(i).equals("sadness")) {
				System.out.println("sadness");
				return "Tristeza";
			}
			if(sentimientos.get(i).equals("analytical")) {
				System.out.println("analytical");
				return "analitico";
			}
			if(sentimientos.get(i).equals("confident")) {
				System.out.println("confident");
				return "confiado";
			}
			if(sentimientos.get(i).equals("tentative")) {
				System.out.println("tentative");
				return "tentative";
			}
		}
		return "tentative";
	}
	
	private static int[] calcularParticipacionSentimiento(ArrayList<String> sentimientos, int[] cantidadSentimientos) {
		for(int i=0; i<sentimientos.size(); i++) {
			if(sentimientos.get(i).equals("anger")) {
				cantidadSentimientos[0] +=1;
			}
			if(sentimientos.get(i).equals("fear")) {
				cantidadSentimientos[1] +=1;
			}
			if(sentimientos.get(i).equals("joy")) {
				cantidadSentimientos[2] +=1;
			}
			if(sentimientos.get(i).equals("sadness")) {
				cantidadSentimientos[3] +=1;
			}
			if(sentimientos.get(i).equals("analytical")) {
				cantidadSentimientos[4] +=1;
			}
			if(sentimientos.get(i).equals("confident")) {
				cantidadSentimientos[5] +=1;
			}
			if(sentimientos.get(i).equals("tentative")) {
				cantidadSentimientos[6] +=1;
			}
		}
		return cantidadSentimientos;
	}
	public static String definirSentimientoPrincipal(ArrayList<String> sentimientos) {
		int[] cantidadSentimientos= calcularParticipacionSentimiento(sentimientos,new int[7]);
		String[] nombreSentimiento = {"anger","fear","joy","sadness","analytical","confident","tentative"};
		
		String sentimientoPrincipal = "anger"; 
		for(int i=1; i<8; i++) {
			if(cantidadSentimientos[i]>cantidadSentimientos[i-1]) {
				sentimientoPrincipal = nombreSentimiento[i];
			}
		}
		return sentimientoPrincipal;
	}
}
