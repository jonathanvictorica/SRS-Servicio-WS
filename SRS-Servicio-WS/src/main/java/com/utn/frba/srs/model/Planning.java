package com.utn.frba.srs.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
@Table(name = "OPERATIONS010_Planning", indexes = {
		@Index(name = "idx_round", columnList = "round_id") })
public class Planning implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long id;
	

	@ManyToOne(fetch = FetchType.EAGER)
	private Round round;
	
	@NotNull
    @Column(nullable = false)
	private Date asignationDateTime;
	private Date initialDateTime;
	

	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private ExecutionRound executionRound;
	private int toleranceMinutes;

	
	
}
