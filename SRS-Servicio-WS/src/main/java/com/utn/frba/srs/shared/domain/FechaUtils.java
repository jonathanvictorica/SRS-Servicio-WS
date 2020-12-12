package com.utn.frba.srs.shared.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class FechaUtils {
	private static int cantidadHorasDiferencia = 0;

	public void setHorasDiferencia(int cantidadHoras) {
		FechaUtils.cantidadHorasDiferencia = cantidadHoras;
	}

	public static String obtenerDia(Date fecha) {

		Calendar calendar = GregorianCalendar.getInstance();

		calendar.setTime(fecha);
		int dia = calendar.get(Calendar.DAY_OF_WEEK);
		if (dia == 1) {
			return "DOMINGO";
		} else if (dia == 2) {
			return "LUNES";
		} else if (dia == 3) {
			return "MARTES";
		} else if (dia == 4) {
			return "MIERCOLES";
		} else if (dia == 5) {
			return "JUEVES";
		} else if (dia == 6) {
			return "VIERNES";
		} else if (dia == 7) {
			return "SABADO";
		}
		return null;
	}

	public static java.util.Date getFechaHoy() {

		return restarHoras(Calendar.getInstance().getTime(), FechaUtils.cantidadHorasDiferencia);
	}

	public static java.sql.Date convert(Date fecha) {
		return new java.sql.Date(fecha.getTime());
	}

	public static Date restarHoras(java.util.Date fechaHoy, int cantidadHorasRestar) {
		Calendar fecha = Calendar.getInstance();
		fecha.setTime(fechaHoy);
		fecha.add(Calendar.HOUR, cantidadHorasRestar * -1);
		return fecha.getTime();
	}

	public static String convertirFormato(Date fechaCaducidad, String formato) {
		SimpleDateFormat sdf = new SimpleDateFormat(formato);
		return sdf.format(fechaCaducidad);
	}

	public static int cantidadHorasDiferencia(Date fechaHoraEvento, Date fechaHoy) {
//		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd H:m:s");

		Date fechaInicial = fechaHoraEvento;
		Date fechaFinal = fechaHoy;

		int diferencia = (int) ((fechaFinal.getTime() - fechaInicial.getTime()) / 1000);

		int dias = 0;
		int horas = 0;
//		int minutos = 0;
		if (diferencia > 86400) {
			dias = (int) Math.floor(diferencia / 86400);
			diferencia = diferencia - (dias * 86400);
		}
		if (diferencia > 3600) {
			horas = (int) Math.floor(diferencia / 3600);
			diferencia = diferencia - (horas * 3600);
		}
		return horas;
//		if (diferencia > 60) {
//			minutos = (int) Math.floor(diferencia / 60);
//			diferencia = diferencia - (minutos * 60);
//		}
	}

	public static Date getTime(String hora) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY HH:mm:ss");
		try {
			return sdf.parse(hora);
		} catch (ParseException e) {
			return null;
		}
	}

}
