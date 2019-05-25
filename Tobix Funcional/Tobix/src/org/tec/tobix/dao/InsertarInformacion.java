package org.tec.tobix.dao;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.Date;

import org.tec.tobix.util.Bitacora;

public class InsertarInformacion {
	Conexion con ;
	String accion = "Insertar ";
	Bitacora bitacora = new Bitacora();
	public InsertarInformacion() 
	{
		this.con = Conexion.getInstance();		
	}
	public void EjecutarQuery(String query) throws SQLException {
		Statement stmt= con.getConnection().createStatement();
		stmt.executeUpdate(query);
		stmt.close();
		insertarBitacora();
	}
	public void insertarBloque(String edicion,Date fecha, String franjaHorario) throws SQLException  {
		String query="insert into Bloque(edicion,fecha,franjaHorario) values('"+edicion+"','"+fecha+"','"+franjaHorario+"')";	
		EjecutarQuery(query);
		accion += " bloque";
	}
	public void insertarTematica(String nombre, String descripcion) throws SQLException  {
		String query="insert into Tematica(nombre,descripcion) values('"+nombre+"','"+descripcion+"')";	
		EjecutarQuery(query);
		accion += " tematica";
	}
	public void insertarComentario(String idActividad , String comentario) throws SQLException  {
		String query = "insert into Comentario(idActividad,comentario) values("+idActividad+",'"+comentario+"')";	
		EjecutarQuery(query);
		accion += " comentario";
	}
	public void insertarPersona(String identificacion, String nombre, String apellido, String apellido2, String email, String sexo, String entidad) throws SQLException  {
		String query = "insert into Persona(id,nombre,apellido1,apellido2,email,sexo,entidadProcedencia) values('"+identificacion+"','"+nombre+"','"+apellido+"','"+apellido2+"','"+email+"','"+sexo+"','"+entidad+"')";	
		EjecutarQuery(query);
		accion += " persona";
	}
	public void insertarEncargado(String identificacion, int annoExperiencia) throws SQLException  {
		String query = "insert into Encargado(idPersona,aniosExperiencia) values('"+identificacion+"',"+annoExperiencia+")";	
		EjecutarQuery(query);
		accion += " encargado";
	}
	public void insertarUsuario(String identificacion, String contrasenia) throws SQLException  {
		String query = "insert into Usuario(idUsuario,contrasenia) values('"+identificacion+"','"+contrasenia+"')";	
		EjecutarQuery(query);
		accion += " usuario";
	}
	public void insertarUsuarioAlLogIn(String tipo, String contrasenia, String email) throws SQLException  {
		String queryLogIn = "insert into Login(email,contrasenia,tipo) values('"+email + "','"+contrasenia+"','" + tipo + "')";	
		EjecutarQuery(queryLogIn);
		
	}
	public void insertarActXComentario(int idActividad, String comentario) throws SQLException  {
		String query="insert into Comentario(idActividad,comentario) values("+idActividad+",'"+comentario+"')";	
		EjecutarQuery(query);
	}
	public void insertarActividades(String tipo, String nombre,Date fecha, String horaInicio,String horaFinal, String descripcion ) throws SQLException  {
		String query="insert into Actividad(tipo,nombre,fecha,horaInicio,horaFinal,descripcion) values('"+tipo+"','"+nombre+"','"+fecha+"','"+horaInicio+"','"+horaFinal+"','"+descripcion+"')";	
		EjecutarQuery(query);
		accion += " actividad";
	}
	public void insertarActividadXBloque(int idActividad, int idBloque) throws SQLException  {
		String query="insert into BloqueXActividad(idBloque,idActividad) values("+idBloque+","+idActividad+")";	
		EjecutarQuery(query);
		accion += " actividad a bloque";
	}
	public void insertarParticipantes(String identificacion, int idActividad) throws SQLException  {
		String query="insert into ActividadXParticipantes(idPersona,idActividad) values("+identificacion+","+idActividad+")";	
		EjecutarQuery(query);
		accion += " participantes";
	}
	public void insertarEncargados(String identificacion, int idActividad) throws SQLException  {
		String query="insert into Encargados(idPersona,idActividad) values("+identificacion+","+idActividad+")";	
		EjecutarQuery(query);
		accion += " encargados a actividad";
	}
	public void insertarParticipantesConfirmados(String identificacion, int idActividad) throws SQLException  {
		String query="insert into ActividadXParticipantesConfirmados(idPersona,idActividad) values("+identificacion+","+idActividad+")";	
		EjecutarQuery(query);
		accion += " confirmados";
	}
	public void insertarLogIn(String email, String contrasenna, String tipo) throws SQLException  {
		String query="insert into Login(email,contrasenia,tipo) values('"+email+"','"+contrasenna+"','"+tipo+"')";	
		EjecutarQuery(query);
	}
	public void insertarBitacora() throws SQLException {
		String query = bitacora.queryBitacora();
		query += accion+"')";
		Statement stmt= con.getConnection().createStatement();
		stmt.executeUpdate(query);
		stmt.close();
	}
	public String getAccion() {
		return accion;
	}
	
	

}
