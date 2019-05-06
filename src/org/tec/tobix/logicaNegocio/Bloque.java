package org.tec.tobix.logicaNegocio;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import org.tec.tobix.dao.InsertarInformacion;
import org.tec.tobix.dao.ObtenerInformacion;

public class Bloque {
	private String edicion;
	private Date fecha;
	private String franja;
	public ArrayList<Actividad> actividades= new ArrayList<>();
	private Tematica tematica;
	private InsertarInformacion insertar=new InsertarInformacion();
	private ObtenerInformacion obtener= new ObtenerInformacion();
	
	/**
	 * Constructor de la clase Bloque, ingresa los datos a la BD
	 * @param edicion
	 * @param fecha
	 * @param franja
	 * @throws SQLException
	 */
	public Bloque(String edicion, Date fecha, String franja) throws SQLException {
		this.setEdicion(edicion);
		this.setFecha(fecha);
		this.setFranja(franja);
		insertar.insertarBloque(edicion,fecha, franja);
	}
	public void agregarActividad(Actividad actividad, int idBloque) throws SQLException {
		int idActividad=obtener.selectIdActividad(actividad.getNombre(), actividad.getTipo());
		insertar.insertarActividadXBloque(idActividad, idBloque);
	}
	/**
	 * Retorna el valor almacenado en Edicion
	 * @return edicion
	 */
	public String getEdicion() {
		return edicion;
	}
/**
 * Asigna el valor asociado a la edicion
 * @param edicion
 */
	public void setEdicion(String edicion) {
		this.edicion = edicion;
	}
/**
 * Obtiene el valor asignaso a fecha
 * @return fecha
 */
	public Date getFecha() {
		return fecha;
	}
/**
 * Asigna el valor al atributo Fecha
 * @param fecha
 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
/**
 * Retorna el valor almacenado en fecha
 * @return franja;
 */
	public String getFranja() {
		return franja;
	}
/**
 * Asigna el valor a la franja horaria
 * @param franja
 */
	public void setFranja(String franja) {
		this.franja = franja;
	}
	/**
	 * Retorna los valores almacenados en los atributos de bloque 
	 * return msg.
	 */
	public String toString() {
		String msg;
		msg = "Pertenece a la edicion: "+ getEdicion() + "\n";
		msg += "En la fecha: "+ getFecha() + "\n";
		msg += "Su franja horaria es: "+ getFranja() + "\n";
		return msg;
		
	}

	}
