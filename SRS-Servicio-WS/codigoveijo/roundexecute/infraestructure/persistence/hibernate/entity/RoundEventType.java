package com.utn.frba.srs.roundexecute.infraestructure.persistence.hibernate.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
@Table(name = "CATALOGUE002_RoundEventType", uniqueConstraints = {
		@UniqueConstraint(name = "uk_name", columnNames = { "name" }) }, indexes = {
				@Index(name = "idx_name", columnList = "name") })
public class RoundEventType implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@NotNull
	@Size(max = 25)
	@Column(nullable = false)
	private String name;

	@NotNull
	@Size(max = 125)
	@Column(nullable = false)
	private String description;

	@NotNull
	private Boolean active = true;

}
