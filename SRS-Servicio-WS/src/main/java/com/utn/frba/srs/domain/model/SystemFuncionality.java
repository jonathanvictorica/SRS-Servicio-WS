package com.utn.frba.srs.domain.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
@Table(name = "SECURITY001_SystemFuncionality",uniqueConstraints = {
		@UniqueConstraint(name = "uk_name", columnNames = { "name" }) }, indexes = {
				@Index(name = "idx_name", columnList = "name") })
public class SystemFuncionality implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
    @Size(max = 25)
    @Column(nullable = false)
	private String name;
	
	@NotNull
    @Size(max = 125)
    @Column(nullable = false)
	private String description;
	
	
}
