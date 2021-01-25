package com.utn.frba.srs.round.infraestructure.persistence.hibernate.entity;

import java.io.Serializable;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import com.utn.frba.srs.shared.infraestructure.persistence.entity.Ubication;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "OPERATIONS007_RouteRound", uniqueConstraints = {
		@UniqueConstraint(name = "uk_round_routeOrder", columnNames = { "round_id", "routeOrder" }) }, indexes = {
				@Index(name = "idx_round", columnList = "round_id") })
public class RoundRouteEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	private RoundEntity round;

	@PositiveOrZero
	@NotNull
	private int routeOrder;

	@Embedded
	private Ubication ubication;

}
