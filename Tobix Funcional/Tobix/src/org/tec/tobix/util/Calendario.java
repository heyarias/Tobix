package org.tec.tobix.util;

import java.util.Calendar;

public class Calendario {


	public static int duracionMinutos(String hora1, String hora2) {
		System.out.println(hora1);
		System.out.println(hora2);
		String[] horaDividida = hora2.split(":");
		String[] horaNuevaDividida = hora1.split(":");
		int horas = (Integer.parseInt(horaDividida[0]) - Integer.parseInt(horaNuevaDividida[0]));
		int minutos = Integer.parseInt(horaDividida[1]) + Integer.parseInt(horaNuevaDividida[1]);
		int minutosreales = horas* 60 + minutos;
		System.out.println("Los minutos reales son: "+ minutosreales);
		return minutosreales;
	}
	
	public static String horaVrsHora(String Hora) {
		Calendar calendario = Calendar.getInstance();
        int hora = calendario.get(Calendar.HOUR_OF_DAY);
        int minutos = calendario.get(Calendar.MINUTE);
        int segundos = calendario.get(Calendar.SECOND);
        System.out.println(hora + ":" + minutos + ":" + segundos);
        String[] horaTotalConsulta = Hora.split(":");
        int horaConsulta = Integer.parseInt(horaTotalConsulta[0]);
        int minutosConsulta = Integer.parseInt(horaTotalConsulta[1]);
        int segundosConsulta = Integer.parseInt(horaTotalConsulta[2]);
        if(hora <= horaConsulta) {
        	if(minutos <= minutosConsulta ) {
        		if(segundos <= segundosConsulta) {
        			return "MAYOR";
        		}
        	}
        }
        return "MENOR";
	}
	
	
	public static boolean diaVrsDia(String dia) {
		Calendar fecha = Calendar.getInstance();
        int anoActual = fecha.get(Calendar.YEAR);
        int mesActual = fecha.get(Calendar.MONTH) + 1;
        int diaActual = fecha.get(Calendar.DAY_OF_MONTH);
        System.out.println(dia);
        String[] fechaConsulta = dia.split("-");
        int anoConsulta = Integer.parseInt(fechaConsulta[0]);
        int mesConsulta = Integer.parseInt(fechaConsulta[1]);
        int diaConsulta = Integer.parseInt(fechaConsulta[2]);
        if(anoActual <= anoConsulta) {
        	if(mesActual <= mesConsulta ) {
        		if(diaActual <= diaConsulta) {
        			return true;
        		}
        	}
        }
        return false;
	}

	

}
