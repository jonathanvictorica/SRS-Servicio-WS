package com.utn.frba.srs.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.utn.frba.srs.utils.FechaUltils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class Audit implements Serializable{

	private static final long serialVersionUID = 1L;
	@NotNull
	@Column(nullable = false)
	private Date creationDate;

	@ManyToOne(optional=false)
	@NotNull
	private SystemUser creationUser;
	private Date modifierDateLast;

	@ManyToOne(optional=true)	
	private SystemUser modifierUserLast;

	public void logModificar(SystemUser usuarioOperador) {
		this.modifierDateLast=(FechaUltils.getFechaHoy());
		this.modifierUserLast=usuarioOperador;

	}

	public void logCrear(SystemUser usuarioOperador) {
		this.creationDate=(FechaUltils.getFechaHoy());
		this.creationUser=usuarioOperador;

	}

}
