package org.tec.tobix.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteInformacion {

		Conexion con;
		
		public DeleteInformacion() 
		{
		  this.con = Conexion.getInstance();	
		}
		public void deleteParticipante(int idActividad, String idPersona) throws SQLException{
			String delect="delete from ActividadXParticipantes where idActividad="+idActividad +"and idPersona='"+idPersona+"'";
			ejecutarQuery(delect);}
		public void deleteParticipanteConfirmados(int idActividad, String idPersona) throws SQLException{
			String delect="delete from ActividadXParticipantesConfirmados where idActividad="+idActividad +"and idPersona='"+idPersona+"'";
			ejecutarQuery(delect);}
	
		public void ejecutarQuery(String query) throws SQLException {
			System.out.println("Aqui3");
		
			Statement stmt= con.getConnection().createStatement();
			System.out.println("Aqui4");
			stmt.executeUpdate(query);
			System.out.println("Aqui");
			stmt.close();
		}
		
}
