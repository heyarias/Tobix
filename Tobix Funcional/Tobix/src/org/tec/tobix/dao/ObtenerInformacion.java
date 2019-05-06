package org.tec.tobix.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.Statement;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ObtenerInformacion {
		Conexion con;
		
		public ObtenerInformacion() 
		{
		  this.con = Conexion.getInstance();	
		}
		public void selectTematica() throws SQLException{
			String select="select * from Tematica";
			ResultSet rs=ejecutarSelect(select);}
		
		
		public void selectActividad() throws SQLException {
			String select="select * from Actividad";
			ResultSet rs=ejecutarSelect(select);
		}
		public void selectEncargado() throws SQLException {
			String select="select * from Encargado";
			ResultSet rs=ejecutarSelect(select);
		}
		public void selectUsuario() throws SQLException {
			String select="select * from Usuario";
			ResultSet rs=ejecutarSelect(select);
		}
		public int selectIdActividad(String nombre, String tipo) throws SQLException {
			String select="select idActividad from Actividad where nombre='"+nombre+"' and tipo=+'"+tipo+"'";
			ResultSet rs=ejecutarSelect(select);
			return rs.getInt(1);
		}

		public ResultSet selectActividadTipo(String tipo) throws SQLException {
				String select="select * from Actividad where tipo=+'"+tipo+"'";
				ResultSet rs=ejecutarSelect(select);
				return rs;
		}
		public ResultSet selectParticipantes(int idActividad) throws SQLException {
			String select="select nombre from Persona join Participantes on idPersona=idPersona where idActividad="+idActividad;
			ResultSet rs=ejecutarSelect(select);
			return rs;}
		public ResultSet selectActividadIDNombre() throws SQLException {
			String select="select idActividad, nombre from Actividad";
			ResultSet rs=ejecutarSelect(select);
			return rs;		}
		public ResultSet selectComentarios(int idActividad) throws SQLException {
			String select="select comentario from Comentario where idActividad="+idActividad;
			ResultSet rs=ejecutarSelect(select);
			return rs;}
	
		public ResultSet selectActividadesPorParticipante(String identificacion) throws SQLException {
			String select="select Actividad.idActividad, Actividad.nombre from Persona join ActividadXParticipantesConfirmados on id=idPersona join Actividad on ActividadXParticipantesConfirmados.idActividad=Actividad.idActividad where Persona.id='"+identificacion+"'";
			ResultSet rs=ejecutarSelect(select);
			return rs;}
		public ResultSet selectActividadPorID(int idActividad) throws SQLException {
			String select="select idActividad, nombre from Actividad where idActividad= "+idActividad;
			ResultSet rs=ejecutarSelect(select);
			return rs;}
		public ResultSet selectDatosActividadPorID(int idActividad) throws SQLException {
			String select="select idActividad, nombre,horaFinal from Actividad where idActividad= "+idActividad;
			ResultSet rs=ejecutarSelect(select);
			return rs;}
		public Date selectFechaBloque(int idBloque) throws SQLException {
			String select="select fecha from Bloque where idBloque= "+idBloque;
			ResultSet rs=ejecutarSelect(select);
			Date fecha= rs.getDate(1);
			return fecha;}
		public String selectActConsultaWatson(int idActividad) throws SQLException {
			String select="select horaFinal from Actividad where idActividad='"+idActividad+"'";
			ResultSet rs=ejecutarSelect(select);
			String hora="j";
			while(rs.next()) {
			    hora=rs.getString(1);
				return hora;
			}
			return hora;
			}
		public String getEmail(String id) throws SQLException {
			String select ="select email from Persona where id ='"+id+"'";
			ResultSet rs = ejecutarSelect(select);
			String email ="heey.arias@gmail.com";
			while(rs.next()) {
			    email  = rs.getString(1);
				return email;
			}
			return email;
			}
		public java.util.Date selectHoraInicio(int idActividad) throws SQLException, ParseException {
			String select="select horaInicio from Actividad where idActividad='"+idActividad+"'";
			ResultSet rs = ejecutarSelect(select);
			    String hora = rs.getString(1);
			   DateFormat dateFormat = new SimpleDateFormat ("hh:mm:ss");
				String hora1 = hora;
				java.util.Date date1;
				date1 = dateFormat.parse(hora1);
				System.out.println(date1);
				return date1;
		}
		
		public ResultSet selectWatsonActividadesFranja(String franja) throws SQLException {
			String select="select  Bloque.idBloque,franjaHorario, Actividad.fecha,tipo,horaInicio, horaFinal,Persona.nombre, Persona.Apellido1, Persona.Apellido2,Persona.EntidadProcedencia   \r\n" + 
					"from Actividad join ActividadXEncargados on Actividad.idActividad=ActividadXEncargados.idActividad \r\n" + 
					"join Encargado on Encargado.idPersona= ActividadXEncargados.idPersona JOIN PERSONA \r\n" + 
					"on Persona.id= Encargado.idPersona join BloqueXActividad \r\n" + 
					"on Actividad.idActividad=BloqueXActividad.idActividad \r\n" + 
					"join Bloque on BloqueXActividad.idBloque=Bloque.idBloque where franjaHorario='"+franja+"'";
			ResultSet rs=ejecutarSelect(select);
			return rs;
		}
		
		public ResultSet selectWatsonActividadesEmpresa(String empresa) throws SQLException {
			String select="select  Bloque.idBloque,franjaHorario, Actividad.fecha,tipo,horaInicio, horaFinal,Persona.nombre, Persona.Apellido1, Persona.Apellido2,Persona.EntidadProcedencia   \r\n" + 
					"from Actividad join ActividadXEncargados on Actividad.idActividad=ActividadXEncargados.idActividad \r\n" + 
					"join Encargado on Encargado.idPersona= ActividadXEncargados.idPersona JOIN PERSONA \r\n" + 
					"on Persona.id= Encargado.idPersona join BloqueXActividad \r\n" + 
					"on Actividad.idActividad=BloqueXActividad.idActividad \r\n" + 
					"join Bloque on BloqueXActividad.idBloque=Bloque.idBloque where entidadProcedencia= '"+empresa+"'";
			ResultSet rs=ejecutarSelect(select);
			return rs;}
		public ResultSet selectWatsonActividadesTematica(String tematica) throws SQLException {
			String select="select Bloque.idBloque,franjaHorario, Actividad.fecha,tipo,horaInicio, horaFinal,Persona.nombre, Persona.Apellido1, Persona.Apellido2,Persona.EntidadProcedencia  from Actividad join BloqueXActividad \r\n" + 
					"on Actividad.idActividad=BloqueXActividad.idActividad \r\n" + 
					"join Bloque on BloqueXActividad.idBloque=Bloque.idBloque \r\n" + 
					"join TematicaXBloque on Bloque.IdBloque= TematicaXBloque.idBloque \r\n" + 
					"join Tematica on Tematica.idTematica=TematicaXBloque.idTematica  \r\n" + 
					" join ActividadXEncargados on ActividadXEncargados.idPersona= Actividad.idActividad join Encargado on ActividadXEncargados.idPersona= Encargado.idPersona join Persona on Encargado.idPersona= Persona.id where Tematica.nombre='"+tematica+"'";
			ResultSet rs=ejecutarSelect(select);
			return rs;}
		
		public ResultSet selectWatsonActividadesFecha(String date) throws SQLException {
			String select="select  Bloque.idBloque,franjaHorario, Actividad.fecha,tipo,horaInicio, horaFinal,Persona.nombre, Persona.Apellido1, Persona.Apellido2,Persona.EntidadProcedencia   \r\n" + 
					"from Actividad join ActividadXEncargados on Actividad.idActividad=ActividadXEncargados.idActividad \r\n" + 
					"join Encargado on Encargado.idPersona= ActividadXEncargados.idPersona JOIN PERSONA \r\n" + 
					"on Persona.id= Encargado.idPersona join BloqueXActividad \r\n" + 
					"on Actividad.idActividad=BloqueXActividad.idActividad \r\n" + 
					"join Bloque on BloqueXActividad.idBloque=Bloque.idBloque where tipo='"+date+"'";
			ResultSet rs=ejecutarSelect(select);
			return rs;
		}
		///No le cai encima
		public ResultSet selectWatsonActividadesFecha(Date date) throws SQLException {
			String select="select  Bloque.idBloque,franjaHorario, Actividad.fecha,tipo,horaInicio, horaFinal,Persona.nombre, Persona.Apellido1, Persona.Apellido2,Persona.EntidadProcedencia   \r\n" + 
					"from Actividad join ActividadXEncargados on Actividad.idActividad=ActividadXEncargados.idActividad \r\n" + 
					"join Encargado on Encargado.idPersona= ActividadXEncargados.idPersona JOIN PERSONA \r\n" + 
					"on Persona.id= Encargado.idPersona join BloqueXActividad \r\n" + 
					"on Actividad.idActividad=BloqueXActividad.idActividad \r\n" + 
					"join Bloque on BloqueXActividad.idBloque=Bloque.idBloque where fecha='"+date+"'";
			ResultSet rs=ejecutarSelect(select);
			return rs;
		
		}
		public ResultSet selectEncargados(int idActividad) throws SQLException {
			String select="select  Bloque.idBloque,franjaHorario, Actividad.fecha,tipo,horaInicio, horaFinal,Persona.nombre, Persona.Apellido1, Persona.Apellido2,Persona.EntidadProcedencia   \r\n" + 
					"from Actividad join ActividadXEncargados on Actividad.idActividad=ActividadXEncargados.idActividad \r\n" + 
					"join Encargado on Encargado.idPersona= ActividadXEncargados.idPersona JOIN PERSONA \r\n" + 
					"on Persona.id= Encargado.idPersona join BloqueXActividad \r\n" + 
					"on Actividad.idActividad=BloqueXActividad.idActividad \r\n" + 
					"join Bloque on BloqueXActividad.idBloque=Bloque.idBloque where idActividad="+idActividad;
			ResultSet rs=ejecutarSelect(select);
			return rs;
		}
		
		public ResultSet listarActividadesPorComentarios() throws SQLException {
			String select="select nombre, Comentario.idActividad, count(comentario) as cantidad from Actividad join comentario on Actividad.idActividad= comentario.idActividad group by Comentario.idActividad,nombre order by cantidad DESC";
			ResultSet rs=ejecutarSelect(select);
			return rs;
		}
		
		public ResultSet listarActividadesPorParticipantes() throws SQLException {
			String select="select nombre, ActividadXParticipantes.idActividad, count(idPersona) as cantidad from Actividad join ActividadXParticipantes on Actividad.idActividad= ActividadXParticipantes.idActividad group by ActividadXParticipantes.idActividad,nombre order by cantidad DESC";
			ResultSet rs=ejecutarSelect(select);
			return rs;
		}
		
		public ResultSet listarActividadesPorParticipantesConfirmados() throws SQLException {
			String select="select nombre, ActividadXParticipantesConfirmados.idActividad, count(idPersona) as cantidad from Actividad join ActividadXParticipantesConfirmados on Actividad.idActividad= ActividadXParticipantesConfirmados.idActividad group by ActividadXParticipantesConfirmados.idActividad,nombre order by cantidad DESC";
			ResultSet rs=ejecutarSelect(select);
			return rs;
		}
		public ResultSet selectLogIn(String email, String contrasenia) throws SQLException {
			String select="select tipo from Login where email= '"+email+"' and contrasenia='"+contrasenia+"'";
			ResultSet rs=ejecutarSelect(select);
			return rs;}
		
		public ResultSet ejecutarSelect(String query) throws SQLException {
			Statement stmt= con.getConnection().createStatement();
			ResultSet rs;
			System.out.println(query);
			rs = stmt.executeQuery(query);
			return rs;
		}
		


}
