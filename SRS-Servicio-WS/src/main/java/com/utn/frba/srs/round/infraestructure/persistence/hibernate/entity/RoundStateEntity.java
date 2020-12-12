package com.utn.frba.srs.round.infraestructure.persistence.hibernate.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "CATALOGUE001_RoundState",uniqueConstraints = {
		@UniqueConstraint(name = "uk_name", columnNames = { "name" }) }, indexes = {
				@Index(name = "idx_name", columnList = "name") })
@NoArgsConstructor
@AllArgsConstructor
public class RoundStateEntity implements Serializable{

	
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
    @Column(nullable = false)
	private Boolean active=true;
	
	public RoundStateEntity(String name) {
		this.name=name;
	}

	

}
