package org.tec.tobix.logicaNegocio;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

import org.tec.tobix.dao.*;
import org.tec.tobix.logicaIntegracion.ToneAnalyzerService;

public class Actividad implements Ordenable{

	private String tipo;
	private String nombre;
	private Date fecha;
	private String horaInicio;
	private String horaFin;
	private String descripcion;
	private InsertarInformacion insertar = new InsertarInformacion();
	private ArrayList<Persona> encargados= new ArrayList<Persona>();
	private ArrayList<Persona> asistentes= new ArrayList<Persona>();
	private ArrayList<Comentario> comentarios = new ArrayList<>();
	private ObtenerInformacion obtener = new ObtenerInformacion();
	/**
	 * Constructor de la clase Actividad, llama al metodo encargado de insertar las actividades a la BD
	 * @param nombre
	 * @param fecha
	 * @param horaInicio
	 * @param horaFin
	 * @param descripcion
	 * @throws SQLException 
	 */
	
	public Actividad() {
		
	}
	public Actividad(String tipo, String nombre, Date fecha, String horaInicio, String horaFin, String descripcion) throws SQLException {
		this.setNombre(nombre);
		this.setFecha(fecha);
		this.setHoraInicio(horaInicio);
		this.setHoraFin(horaFin);
		this.setDescripcion(descripcion);
		this.setTipo(tipo);
		insertar.insertarActividades(tipo, nombre, fecha, horaInicio, horaFin, descripcion);
	}
	/**
	 * Metodo que asigna participantes a las actividades
	 * @param indAct
	 * @param participante
	 * @throws SQLException 
	 */
	public void asignarParticipante(int indAct,Persona participante) throws SQLException {
		this.asistentes.add(participante);
		insertar.insertarParticipantes(participante.getIdentificacion(),indAct);
	}
	/**
	 * Metodo que asigna el encargado a una actividad
	 * @param indAct
	 * @param participante
	 * @throws SQLException 
	 */
public void asignarEncargado(int indAct,Persona participante) throws SQLException {
	this.encargados.add(participante);
	insertar.insertarEncargados(participante.getIdentificacion(),indAct);
	}
/**
 * Metodo que calcula los asistentes a una actividad
 * @return 
 * @throws SQLException 
 */
public int calcularAsistentes(int idActividad) throws SQLException {
	int cont=0;
	ResultSet rs=obtener.selectParticipantes(idActividad);
	while(rs.next()) {
		cont++;     
	}return cont;
}
public ResultSet listarSegunComentario() throws SQLException {
	ResultSet rs =obtener.listarActividadesPorComentarios();
	return rs;
}
public ResultSet listarSegunParticipantes() throws SQLException {
	ResultSet rs =obtener.listarActividadesPorParticipantes();
	return rs;
}
public ResultSet listarSegunParticipantesConfirmados() throws SQLException {
	ResultSet rs =obtener.listarActividadesPorParticipantesConfirmados();
	return rs;
}
public ArrayList analisisComentario(int actividad) throws SQLException {
	ResultSet rs=obtener.selectComentarios(actividad);
	ArrayList<String> sentimientos = new ArrayList<>();
	ArrayList<ArrayList> comentarios = new ArrayList<>();
	int contador=1; 
		while (rs.next()) {
			String comentario=rs.getString(1);
			ToneAnalyzerService TA= new ToneAnalyzerService();
			String sentimiento = TA.determinarSentimiento(comentario);
			sentimientos.add(comentario);
			sentimientos.add(sentimiento);
			comentarios.add(sentimientos);
	        sentimientos = new ArrayList<>();
		}
		return comentarios;
		}
/**
 * Metodo que asigna participantes a las actividades
 * @param participante
 * @throws SQLException 
 */
public void asignarParticipante(String participante, int idActividad) throws SQLException {
	insertar.insertarParticipantes(participante, idActividad);
}

/**
 * Metodo que confirma la asistencia de un participante a una actividad
 * @param participante
 * @throws SQLException 
 */
public void confirmarParticipante(int act, String identificacion) throws SQLException {
	insertar.insertarParticipantesConfirmados(identificacion,act);
	
}
/**
 * Metodo que consulta los participantes de una actividad 
 * @return
 * @throws SQLException 
 */
public ResultSet consultarParticipante(int act) throws SQLException {
	ResultSet rs= obtener.selectParticipantes(act);
	return rs; 
	
}
public ResultSet consultarEncargado(int act) throws SQLException {
	ResultSet rs= obtener.selectEncargados(act);
	return rs; 
	
}
public void consultarComentariosFelices() throws SQLException {
	ResultSet rs= obtener.selectActividadIDNombre();
	 while(rs.next()) {
		int idActividad= rs.getInt(1);
		String nombre= rs.getString(2);
}}
public void calcularInicio(int idActividad) {

}
	
/**
 * El metodo asocia comentarios del usuario a una actividad
 * @param descripcion
 * @throws SQLException
 */
public void agregarComentario(int idActividad,String descripcion) throws SQLException {
	Comentario comentario= new Comentario(descripcion);
	comentarios.add(comentario);
	insertar.insertarComentario(idActividad, descripcion);
}

	/**
	 * Obtiene e imprime la informacion asociada a una persona
	 * return msg: Retorna la informacion asociada a una persona
	 */
	 public String toString() {
		 String msg;
		 msg = "Fecha: "+ getFecha() + "\n";
			msg += "Nombre: "+ getNombre() + "\n";
			msg += "Descripcion: "+ getDescripcion() + "\n";
			msg += "Hora de Inicio: "+ getHoraInicio() + "\n";
			msg += "Hora de Finalizacion: "+ getHoraFin() + "\n";
			 return msg;
	 }
	
	
	/**
	 * Retorna el valor almacenado en tipo
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * Asigna el valor a tipo
	 * @param tipo the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

		
	/**
	 * Retorna el valor almacenado en nombre
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Asigna el valor al atributo nombre
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Retorna el valor almacenado en Fecha
	 * @return the fecha
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * Asigna el valor al atributo Fecha 
	 * @param fecha the fecha to set
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	/**
	 * Retorna el valor almacenado en el atributo horaInicio
	 * @return the horaInicio
	 */
	public String getHoraInicio() {
		return horaInicio;
	}

	/**
	 * Asigna el valor a hora inicio
	 * @param horaInicio2 the horaInicio to set
	 */
	public void setHoraInicio(String horaInicio2) {
		this.horaInicio = horaInicio2;
	}

	/**
	 * Retorna el valor almacenado en el atributo hora fin
	 * @return the horaFin
	 */
	public String getHoraFin() {
		return horaFin;
	}

	/**
	 * Asigna el valor 
	 * @param horaFin the horaFin to set
	 */
	public void setHoraFin(String horaFin) {
		this.horaFin = horaFin;
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
	
	public ArrayList obtenerInfoActividad() throws SQLException {
		ArrayList<Integer> ActividadID = new ArrayList<>();
		ResultSet rs=obtener.selectActividadIDNombre();
		while (rs.next()) {
			ActividadID.add(rs.getInt(1));
		}
		return ActividadID;
	}
	
	public int determinarComentariosFelices(ResultSet rs) throws SQLException {
		ArrayList<Integer> ActividadID = new ArrayList<>();
		int contFelices=0;
		while (rs.next()) {
			ToneAnalyzerService TA= new ToneAnalyzerService();
			String sentimiento=TA.determinarSentimiento(rs.getString(1));
			if (sentimiento=="joy") {
				contFelices++;
			}
			
		return contFelices;
		}
		return contFelices;
		}
	public int DeterminarComentariosEnojados(ResultSet rs) throws SQLException {
		ArrayList<Integer> ActividadID = new ArrayList<>();
		int contEnojados=0;
		while (rs.next()) {
			ToneAnalyzerService TA= new ToneAnalyzerService();
			String sentimiento=TA.determinarSentimiento(rs.getString(1));
			if (sentimiento=="anger") {
				contEnojados++;
			}
			
		return contEnojados;}
		return contEnojados;}
	
	public void analisisComentariosFelices(int actividad) throws SQLException {
		
		ArrayList<Integer> ActividadID= obtenerInfoActividad();
		int contador=0;
		ArrayList<Integer> cantidad= new ArrayList<>();
		while(contador< ActividadID.size()) {
		ResultSet rs2= obtener.selectComentarios(ActividadID.get(contador));
		int cont = determinarComentariosFelices(rs2);
		cantidad.add(cont);
		ordenamiento(cantidad,ActividadID);}}
	public void analisisComentariosEnojados(int actividad) throws SQLException {
		
		ArrayList<Integer> ActividadID= obtenerInfoActividad();
		int contador=0;
		ArrayList<Integer> cantidad= new ArrayList<>();
		while(contador< ActividadID.size()) {
			ResultSet rs2= obtener.selectComentarios(ActividadID.get(contador));
			int cont=DeterminarComentariosEnojados(rs2);
			cantidad.add(cont);
			ordenamiento(cantidad,ActividadID);
			}
		}



	public ArrayList<Integer> ordenamiento(ArrayList<Integer> sentimientos2, ArrayList<Integer> sentimientos1) {

		int i=0;
	    int max = i;
	    int maxN=i;
	    for (int j = i + 1 ; j< sentimientos2.size() ; j++) {

	        if (sentimientos2.get(j)> sentimientos2.get(max)) {
	            int ant = i;  
	            int valor=sentimientos2.get(i);
	            int valorN=sentimientos1.get(i);
	            int antN= i;
	            sentimientos2.set(i, sentimientos2.get(j));
	            sentimientos1.set(i, sentimientos1.get(j));
	            sentimientos2.set(j, valor);
	            sentimientos1.set(j, valorN);
	            i=ant ;
	            max=j;
	            j=ant+1;
	            j=j-1;
	           }
	        else {
	        	i++;
	        	
	        }
	      }
	    int contador3=0;
	    while(contador3< sentimientos1.size()) {
	    	System.out.println(sentimientos1.get(contador3));
	    	System.out.println(sentimientos2.get(contador3));
	    }
	    ArrayList array= new ArrayList<>();
	    array.add(sentimientos1);
	    array.add(sentimientos2);
	    
	    return array;
	    }
	
	

	
}
