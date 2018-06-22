package com.aula114.model;

import java.util.Date;

public class Autor {

	@Override
	public String toString() {
		return nombre_completo + "\nFecha de nacimiento: " + fecha_nac;
	}

	private String nombre_completo;
	private Date fecha_nac;

	public String getNombre_completo() {
		return nombre_completo;
	}

	public void setNombre_completo(String nombre_completo) {
		this.nombre_completo = nombre_completo;
	}

	public Date getFecha_nac() {
		return fecha_nac;
	}

	public void setFecha_nac(Date fecha_nac) {
		this.fecha_nac = fecha_nac;
	}
}
