package com.utn.frba.srs.shared.infraestructure.persistence.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class ServiceLogger implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String servicio;
	private String operacion;
	private String usuario;
	private String canal;
	private String token;
	private Date fechaInicio;
	private Date fechaFin;
	private String request;
	private String response;
	private String severidad;
	private String codigo;
	private String mensaje;
	private String urlServicioOperacion;

	

}
