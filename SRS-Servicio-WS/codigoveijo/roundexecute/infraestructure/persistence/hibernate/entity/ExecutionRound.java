package com.utn.frba.srs.roundexecute.infraestructure.persistence.hibernate.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.utn.frba.srs.round.domain.Round;
import com.utn.frba.srs.user.infraestructure.persistence.hibernate.entity.SystemUser;

import lombok.Data;

@Data
@Entity
@Table(name = "OPERATIONS011_ExecutionRound",indexes = { @Index(name = "idx_round", columnList = "round_id") })
public class ExecutionRound implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.EAGER)
	private Round round;

	@OneToMany(mappedBy = "executeRound", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	private List<EventExecutionRound> events;

	@Size(max = 225)
	private String executionDetails = null;

	@ManyToOne(fetch = FetchType.EAGER)
	private SystemUser revisoryUser;

	@Size(max = 225)
	private String revisoryUserComentary;
	private Date revisoryDate;

	private Boolean fallidedExecutionRoundIndicator = false;
	private Boolean indicentRoundIndicator = false;
	private Boolean finalisedRoundIndicator = false;
	private Boolean executedRoundIndicator = true;

	@ManyToOne(fetch = FetchType.EAGER)
	private ExecutionRoundState roundState;

}
