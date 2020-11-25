package com.utn.frba.srs.model;

import java.io.Serializable;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import com.utn.frba.srs.utils.Ubication;

import lombok.Data;

@Data
@Entity
@Table(name = "OPERATIONS007_RouteRound",uniqueConstraints = { @UniqueConstraint(name = "uk_round_routeOrder", columnNames = { "round_id",
		"routeOrder" }) }, indexes = { @Index(name = "idx_round", columnList = "round_id") })
public class RouteRound implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long id;
	

	@ManyToOne(fetch = FetchType.EAGER)
	private Round round;
	
	@PositiveOrZero
	@NotNull
	private int routeOrder;
	
	@Embedded
	private Ubication ubication;

}
