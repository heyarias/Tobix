package org.tec.tobix.logicaNegocio;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.tec.tobix.dao.InsertarInformacion;

public class Encargado extends Persona {

	private int annosExperiencia;
	 private InsertarInformacion insertar= new InsertarInformacion();
	public Encargado(int annosExperiencia,String identificacion, String sexo, String email, String nombre, String apellido1, String apellido2, String entidadProcedencia) throws SQLException {
		super(identificacion,sexo,email,nombre,apellido1,apellido2,entidadProcedencia);
		this.setAnnosExperiencia(annosExperiencia);
		insertar.insertarEncargado(identificacion, annosExperiencia);
		
	}
	/**
	 * Metodo que retorna los datos asociados a un encargado
	 * return msg: retorna los datos asociados a un encargado
	 */
	public String toString() {
		 String msg;
		 msg = super.toString();
			msg += "Annos Experiencia: "+ getAnnosExperiencia() + "\n";
			 return msg;
	 }

	/**
	 * @return the annosExperiencia
	 */
	public int getAnnosExperiencia() {
		return annosExperiencia;
	}

	/**
	 * @param annosExperiencia the annosExperiencia to set
	 */
	public void setAnnosExperiencia(int annosExperiencia) {
		this.annosExperiencia = annosExperiencia;
	}
	
}
