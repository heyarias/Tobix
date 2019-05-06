package org.tec.tobix.logicaNegocio;

import java.sql.SQLException;

import org.tec.tobix.dao.InsertarInformacion;

public class Tematica {
	private String nombre; 
	private String descripcion;
	 private InsertarInformacion insertar= new InsertarInformacion();
	/**
	 * Constructor de la clase tematica 
	 * @param nombre
	 * @param descripcion
	 * @throws SQLException 
	 */
	public Tematica(String nombre, String descripcion ) throws SQLException {
		this.setNombre(nombre);
		this.setDescripcion(descripcion);	
		insertar.insertarTematica(nombre, descripcion);
	
	}
	 public String toString() {
		 String msg;
		 msg = "Nombre: "+ getNombre() + "\n";
			msg += "Descripcion: "+ getDescripcion()+ "\n";
			 return msg;
	 }
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
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
