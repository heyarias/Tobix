package org.tec.tobix.logicaNegocio;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.tec.tobix.dao.InsertarInformacion;
import org.tec.tobix.dao.ObtenerInformacion;

public abstract class Persona {

 private String identificacion;
 private String sexo;
 private String email;
 private String nombre;
 private String apellido1;
 private String apellido2;
 private String entidadProcedencia;
 private InsertarInformacion insertar= new InsertarInformacion();
 private ObtenerInformacion obtener= new ObtenerInformacion();
 
 /**
  * Constructor de la clase persona, inserta en la BD en la tabla persona
  * @param identificacion
  * @param sexo
  * @param email
  * @param nombre
  * @param apellido1
  * @param apellido2
  * @param entidadProcedencia
  * @throws SQLException
  */
 public Persona(String identificacion, String sexo, String email, String nombre, String apellido1, String apellido2, String entidadProcedencia) throws SQLException {
	 insertar=new InsertarInformacion();
	 this.setIdentificacion(identificacion);
	 this.setSexo(sexo);
	 this.setEmail(email);
	 this.setNombre(nombre);
	 this.setApellido1(apellido1);
	 this.setApellido2(apellido2);
	 this.setEntidadProcedencia(entidadProcedencia);
	 insertar.insertarPersona(identificacion, nombre, apellido1, apellido2, email, sexo, entidadProcedencia);
 }
/**
 * Consulta las actividades asociadas a una persona 
 * @return
 * @throws SQLException 
 */



 /**
  * Retorna la informacion relacionada con una persona.
  * return msg: Valor de retorno de la informacion
  */

 public String toString() {
	 String msg;
	 msg = "Identificacion: "+ getIdentificacion() + "\n";
		msg += "Nombre: "+ getNombre()+" "+getApellido1()+" "+getApellido2() + "\n";
		msg += "Sexo: "+ getSexo() + "\n";
		msg += "Email: "+ getEmail() + "\n";
		msg += "Sexo: "+ getEntidadProcedencia() + "\n";
		 return msg;
 }
/**
 * @return the identificacion
 */
public String getIdentificacion() {
	return identificacion;
}
/**
 * @param identificacion the identificacion to set
 */
public void setIdentificacion(String identificacion) {
	this.identificacion = identificacion;
}
/**
 * @return the sexo
 */
public String getSexo() {
	return sexo;
}
/**
 * @param sexo the sexo to set
 */
public void setSexo(String sexo) {
	this.sexo = sexo;
}
/**
 * @return the email
 */
public String getEmail() {
	return email;
}
/**
 * @param email the email to set
 */
public void setEmail(String email) {
	this.email = email;
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
 * @return the apellido1
 */
public String getApellido1() {
	return apellido1;
}
/**
 * @param apellido1 the apellido1 to set
 */
public void setApellido1(String apellido1) {
	this.apellido1 = apellido1;
}
/**
 * @return the apellido2
 */
public String getApellido2() {
	return apellido2;
}
/**
 * @param apellido2 the apellido2 to set
 */
public void setApellido2(String apellido2) {
	this.apellido2 = apellido2;
}
/**
 * @return the entidadProcedencia
 */
public String getEntidadProcedencia() {
	return entidadProcedencia;
}
/**
 * @param entidadProcedencia the entidadProcedencia to set
 */
public void setEntidadProcedencia(String entidadProcedencia) {
	this.entidadProcedencia = entidadProcedencia;
}
}
