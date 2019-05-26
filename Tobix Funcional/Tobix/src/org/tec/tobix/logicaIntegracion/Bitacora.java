package org.tec.tobix.logicaIntegracion;

import java.util.ArrayList;

public abstract class Bitacora {
			//request.getRealPath("service.json");
			
			private String ruta;
			public abstract void  update() throws Exception;
			public abstract ArrayList<String> leer();
			public String getRuta() {
				return ruta;
			}
			public void setRuta(String ruta) {
				this.ruta = ruta;
			}
			
		}
