package org.tec.tobix.dao;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.Date;

public class InsertarInformacion {
	Conexion con ;
	
	public InsertarInformacion() 
	{
		this.con = Conexion.getInstance();		
	}
	public void EjecutarQuery(String query) throws SQLException {
		System.out.println("Aqui3");
	
		Statement stmt= con.getConnection().createStatement();
		System.out.println("Aqui4");
		stmt.executeUpdate(query);
		System.out.println("Aqui");
		stmt.close();
	}
	public void insertarBloque(String edicion,Date fecha, String franjaHorario) throws SQLException  {
		String query="insert into Bloque(edicion,fecha,franjaHorario) values('"+edicion+"','"+fecha+"','"+franjaHorario+"')";	
		EjecutarQuery(query);
	}
	public void insertarTematica(String nombre, String descripcion) throws SQLException  {
		String query="insert into Tematica(nombre,descripcion) values('"+nombre+"','"+descripcion+"')";	
		EjecutarQuery(query);
	}
	public void insertarComentario(int idActividad , String comentario) throws SQLException  {
		String query="insert into Comentario(idActividad,comentario) values("+idActividad+",'"+comentario+"')";	
		EjecutarQuery(query);
	}
	public void insertarPersona(String identificacion, String nombre, String apellido, String apellido2, String email, String sexo, String entidad) throws SQLException  {
		System.out.println("Aqui");
		String query="insert into Persona(id,nombre,apellido1,apellido2,email,sexo,entidadProcedencia) values('"+identificacion+"','"+nombre+"','"+apellido+"','"+apellido2+"','"+email+"','"+sexo+"','"+entidad+"')";	
		System.out.println("Aqui2");
		EjecutarQuery(query);
	}
	public void insertarEncargado(String identificacion, int annoExperiencia) throws SQLException  {
		String query="insert into Encargado(idPersona,aniosExperiencia) values('"+identificacion+"',"+annoExperiencia+")";	
		EjecutarQuery(query);
	}
	public void insertarUsuario(String identificacion, String contrasenia) throws SQLException  {
		String query="insert into Usuario(idUsuario,contrasenia) values('"+identificacion+"','"+contrasenia+"')";	
		EjecutarQuery(query);
	}
	public void insertarActXComentario(int idActividad, String comentario) throws SQLException  {
		String query="insert into Comentario(idActividad,comentario) values("+idActividad+",'"+comentario+"')";	
		EjecutarQuery(query);
	}
	public void insertarActividades(String tipo, String nombre,Date fecha, String horaInicio,String horaFinal, String descripcion ) throws SQLException  {
		String query="insert into Actividad(tipo,nombre,fecha,horaInicio,horaFinal,descripcion) values('"+tipo+"','"+nombre+"','"+fecha+"','"+horaInicio+"','"+horaFinal+"','"+descripcion+"')";	
		EjecutarQuery(query);
	}
	public void insertarActividadXBloque(int idActividad, int idBloque) throws SQLException  {
		String query="insert into BloqueXActividad(idBloque,idActividad) values("+idBloque+","+idActividad+")";	
		EjecutarQuery(query);
	}
	public void insertarParticipantes(String identificacion, int idActividad) throws SQLException  {
		String query="insert into ActividadXParticipantes(idPersona,idActividad) values("+identificacion+","+idActividad+")";	
		EjecutarQuery(query);
	}
	public void insertarEncargados(String identificacion, int idActividad) throws SQLException  {
		String query="insert into Encargados(idPersona,idActividad) values("+identificacion+","+idActividad+")";	
		EjecutarQuery(query);
	}
	public void insertarParticipantesConfirmados(String identificacion, int idActividad) throws SQLException  {
		String query="insert into ActividadXParticipantesConfirmados(idPersona,idActividad) values("+identificacion+","+idActividad+")";	
		EjecutarQuery(query);
	}
	public void insertarLogIn(String email, String contrasenna, String tipo) throws SQLException  {
		String query="insert into Login(email,contrasenia,tipo) values('"+email+"','"+contrasenna+"','"+tipo+"')";	
		EjecutarQuery(query);
	}
	

	
	

}
