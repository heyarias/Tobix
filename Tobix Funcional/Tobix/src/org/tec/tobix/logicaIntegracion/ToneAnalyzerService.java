package org.tec.tobix.logicaIntegracion;

import java.util.ArrayList;

import com.ibm.watson.developer_cloud.service.security.IamOptions;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.ToneAnalyzer;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.ToneAnalysis;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.ToneOptions;

public class ToneAnalyzerService {
	private static ToneAnalyzer ToneAnalyzer() {
		IamOptions options = new IamOptions.Builder()
				  .apiKey("8ujvx-B3Qu_VtCEftiI7-kWkhGasbHBqN940hW4qXocY")
				  .build();

				ToneAnalyzer toneAnalyzer = new ToneAnalyzer("2017-09-21", options);
				toneAnalyzer.setEndPoint("https://gateway.watsonplatform.net/tone-analyzer/api");
				return toneAnalyzer;

	}
	public static ArrayList<String> determinarSentimiento(String comentario) {
			ToneAnalyzer toneAnalyzer= ToneAnalyzer();
				String text = comentario;
				ToneOptions toneOptions = new ToneOptions.Builder()
				.sentences(true)
				  .text(text)
				  .build();
				ToneAnalysis toneAnalysis = toneAnalyzer.tone(toneOptions).execute();
				System.out.println("Sentences tone");
				
				System.out.println("salio");
		return extraerSentimientoPrincipal(toneAnalysis);
	}
	
	public ArrayList<String> detectarFrases(String comentario) {
		ArrayList<String> frase= new ArrayList();
		ArrayList<String> sentimiento= new ArrayList();
		ArrayList<ArrayList> res= new ArrayList();
		
		ToneAnalyzer toneAnalyzer= ToneAnalyzer();
				String text = comentario;
				ToneOptions toneOptions = new ToneOptions.Builder()
				.sentences(true)
				  .text(text)
				  .build();
				ToneAnalysis toneAnalysis = toneAnalyzer.tone(toneOptions).execute();
				 System.out.println("se cae");
				
				 for(int i=0; i<=toneAnalysis.getSentencesTone().size()-1;i++) {
					 frase.add(toneAnalysis.getSentencesTone().get(i).getText());
					 System.out.println(toneAnalysis.getSentencesTone().get(i).getTones().get(0).getToneName());
					 sentimiento.add(toneAnalysis.getSentencesTone().get(i).getTones().get(0).getToneName());
				 }
				//res.add(frase);
				//res.add(sentimiento);
				//System.out.println(res.get(1));
				//System.out.println(res.get(0));		
		return sentimiento;
	}
	private static ArrayList<String> extraerSentimientoPrincipal(ToneAnalysis tone) {
		System.out.println("Entro1");
		String toneString = tone.toString();
		ArrayList<String> sentimientos = new ArrayList();
		toneString = toneString.replaceAll(" ", "");
		toneString = toneString.replaceAll(" ", "");
		System.out.println(toneString);
		String[] toneDivi = toneString.split(",");
		for(int i=1; i<toneDivi.length; i=i+3) {
			toneString = toneDivi[i].split(":")[0];
			
			sentimientos.add(toneString);
			
			//ArrayConSentimientos
		}
		
		return sentimientos;
	}
	public ArrayList<String> determinarSentimientos(String comentario) {
		ArrayList<String> sentimientos= determinarSentimiento(comentario);
		System.out.println(sentimientos);
		definirSentimiento(sentimientos);
		return sentimientos;//ArrayConSentimientos
	
	}
	public String cantSentimientos(String comentario) {
		ArrayList<String> sentimientos= determinarSentimiento(comentario);
		int[] cantidadSentimientos= new int[8];
		String sentimiento =definirSentimientoPrincipal( sentimientos);
		return sentimiento;}
	
	
	
	private static String definirSentimiento(ArrayList<String> sentimientos) {
		int contF=0;
		int contE=0;
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
			else {
				System.out.println(sentimientos.get(i)); //Extrae las frases
			}
		}
		return "tentative";
	}
	
	
	private static int[] calcularParticipacionSentimiento(ArrayList<String> sentimientos, int[] cantidadSentimientos)
	{
		
		for(int i=0; i<sentimientos.size(); i++) {
			if(sentimientos.get(i).substring(1, sentimientos.get(i).length()-1).equals("anger")) {
				cantidadSentimientos[0] +=1;
			}
			if(sentimientos.get(i).substring(1, sentimientos.get(i).length()-1).equals("fear")) {
				cantidadSentimientos[1] +=1;
			}
			if(sentimientos.get(i).substring(1, sentimientos.get(i).length()-1).equals("joy")) {
				System.out.println("felicidad");
				cantidadSentimientos[2] +=1;
			}
			if(sentimientos.get(i).substring(1, sentimientos.get(i).length()-1).equals("sadness")) {
				cantidadSentimientos[3] +=1;
			}
			if(sentimientos.get(i).substring(1, sentimientos.get(i).length()-1).equals("analytical")) {
				cantidadSentimientos[4] +=1;
			}
			if(sentimientos.get(i).substring(1, sentimientos.get(i).length()-1).equals("confident")) {
				cantidadSentimientos[5] +=1;
			}
			if(sentimientos.get(i).substring(1, sentimientos.get(i).length()-1).equals("tentative")) {
				cantidadSentimientos[6] +=1;
			}
			else {

			}
			
		}
		return cantidadSentimientos;
	}
	public static String definirSentimientoPrincipal(ArrayList<String> sentimientos) {
		int[] cantidadSentimientos= calcularParticipacionSentimiento(sentimientos,new int[8]);
		String[] nombreSentimiento = {"anger","fear","joy","sadness","analytical","confident","tentative"};
		String sentimientoPrincipal = "anger"; 
		int mayor=0;
		for(int i=1; i<7; i++) {
			if(cantidadSentimientos[i]>mayor) {
				mayor=i;
				sentimientoPrincipal = nombreSentimiento[mayor];
			}
		}
		return sentimientoPrincipal;
	}
}
