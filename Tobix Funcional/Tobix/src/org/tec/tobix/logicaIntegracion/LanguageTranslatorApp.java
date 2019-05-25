package org.tec.tobix.logicaIntegracion;

import com.ibm.watson.developer_cloud.language_translator.v3.LanguageTranslator;
import com.ibm.watson.developer_cloud.service.security.IamOptions;

public class LanguageTranslatorApp{

	public LanguageTranslatorApp() {
	}
	public void correr() {
		IamOptions options = new IamOptions.Builder()
			    .apiKey("-wofsKND_z2Z_3pgiB863M5IVRQ6nUDv4HPntojNmDss")
			    .url("https://gateway.watsonplatform.net/language-translator/api")
			    .build();

			LanguageTranslator languageTranslator = new LanguageTranslator("2017-09-21", options);
	}

}
