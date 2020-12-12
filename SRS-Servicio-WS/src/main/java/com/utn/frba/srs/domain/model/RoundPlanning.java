package com.utn.frba.srs.domain.model;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import com.utn.frba.srs.round.domain.Round;

import lombok.Data;

@Data
@Entity
@Table(name = "OPERATIONS008_RoundPlanning",uniqueConstraints = { @UniqueConstraint(name = "uk_round_weekDayName_initialTime", columnNames = { "round_id",
		"weekDayName", "initialTime" }) }, indexes = { @Index(name = "idx_round", columnList = "round_id") })
public class RoundPlanning implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	private Round round;

	@Size(max = 20)
	@NotNull
	private String weekDayName;

	@NotNull
	private Time initialTime;

	private java.sql.Date executionDate;

	@NotNull
	@PositiveOrZero
	private Integer toleranceMinutes = 10;

	private Boolean isRecurrent = true;

	@ManyToOne(fetch = FetchType.EAGER)
	private SystemUser pannerUser;
	private Date assignmentDate;

}
