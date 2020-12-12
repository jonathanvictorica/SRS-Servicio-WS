package com.utn.frba.srs.domain.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import lombok.Data;
@Data
@Entity
public class AplicationUser implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
    @Size(max = 25)
    @Column(nullable = false)
	private String name;
	
	@NotNull
    @Size(max = 225)
    @Column(nullable = false)
	private String password;
	
	@NotNull
    @Size(max = 25)
    @Column(nullable = false)
	private String channel;
	
	@PositiveOrZero
	@NotNull
	private int fallideIntentCount=0;
	private Date fallideIntentDateLast=null;
	
	@NotNull
	private boolean active=true;

	
}
