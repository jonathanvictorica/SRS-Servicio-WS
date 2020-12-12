package com.utn.frba.srs.domain.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Data;

@Data
@Entity
@Table(name = "SECURITY003_FuncionalityRol",uniqueConstraints = { @UniqueConstraint(name = "uk_rol_funcionality", columnNames = { "rol_id","funcionality_id" }) }, indexes = {
		@Index(name = "idx_rol", columnList = "rol_id") })
public class FuncionalityRol implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	

	@ManyToOne(fetch = FetchType.EAGER)
	private SystemUserRol rol;
	

	@ManyToOne(fetch = FetchType.EAGER)
	private SystemFuncionality funcionality;

	
	

}
