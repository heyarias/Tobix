package org.tec.tobix.logicaNegocio;

public class Comentario {

	private  String descripcion;
	
	/**
	 * Constructor de la clase Comentario
	 * @param descripcion
	 */
	public Comentario(String descripcion) {
		this.setDescripcion(descripcion);
	}
	 public String toString() {
		 String msg;
		 msg = "Descripcion: "+ getDescripcion() + "\n";
			 return msg;
	 }

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
