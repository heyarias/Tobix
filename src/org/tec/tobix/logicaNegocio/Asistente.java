package org.tec.tobix.logicaNegocio;
import org.tec.tobix.dao.InsertarInformacion;
import org.tec.tobix.dao.ObtenerInformacion;

import java.sql.ResultSet;
import java.sql.SQLException;



public class Asistente extends Persona {
	private String contrasenna;
	private InsertarInformacion insertar=new InsertarInformacion();
	private ObtenerInformacion obtener= new ObtenerInformacion() ;

	

	public Asistente(String contrasenna,String identificacion, String sexo, String email, String nombre, String apellido1, String apellido2, String entidadProcedencia) throws SQLException {
		super(identificacion,sexo,email,nombre,apellido1,apellido2,entidadProcedencia);
		this.setContrasenna(contrasenna);
		insertar.insertarUsuario(identificacion, contrasenna);
		
	}
	 public String toString() {
		 String msg;
		 msg = super.toString();
		msg += "Contrasena: "+ getContrasenna()+ "\n";
			 return msg;
	 }
	
	/**
	 * @return the contrasenna
	 */
	public String getContrasenna() {
		return contrasenna;
	}

	/**
	 * @param contrasenna the contrasenna to set
	 */
	public void setContrasenna(String contrasenna) {
		this.contrasenna = contrasenna;
	}
}
