package org.tec.tobix.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class translate {

	 public static String translate(String text) throws IOException {
	        String urlStr = "https://script.google.com/macros/s/AKfycbxJs7cPvgUExkXAabHNJekVmV4dyvimpiN6f2I-o0mMqPs4jA0/exec" +
	                "?q=" + URLEncoder.encode(text, "UTF-8") +
	                "&target=" + "en" +
	                "&source=" + "es";
	        URL url = new URL(urlStr);
	        StringBuilder response = new StringBuilder();
	        HttpURLConnection con = (HttpURLConnection) url.openConnection();
	        con.setRequestProperty("User-Agent", "Mozilla/5.0");
	        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
	        String inputLine;
	        while ((inputLine = in.readLine()) != null) {
	            response.append(inputLine);
	        }
	        in.close();
	        return response.toString();
	    }
}
