package com.utn.frba.srs.roundexecute.infraestructure.persistence.hibernate.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.utn.frba.srs.user.infraestructure.persistence.hibernate.entity.SystemUser;

import lombok.Data;

@Data
@Entity
@Table(name = "OPERATIONS012_EventExecutionRound",indexes = { @Index(name = "idx_executeRound", columnList = "executeround_id") })
public class EventExecutionRound implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.EAGER)
	private ExecutionRound executeRound;

	@ManyToOne(fetch = FetchType.EAGER)
	private RoundEventType eventType;

	private String nfcIdentificationCheckpoint = "";
	private String longitudeCheckpoint = "";
	private String latitudeCheckpoint = "";
	private String zoomUbicationCheckpoint = "";
	private Integer executionOrderCheckpoint = 0;

	@ManyToOne(fetch = FetchType.EAGER)
	private SystemUser user;
	private Date eventDateTime;

	@Size(max = 225)
	private String vigilantComentary;

	@ManyToOne(fetch = FetchType.EAGER)
	private IncidentEventExecutionRound incident;

	// En caso que un supervisor tenga que revisar la ronda se llenan estos campos

	@ManyToOne(fetch = FetchType.EAGER)
	private SystemUser revisoryUser;

	@Size(max = 225)
	private String revisoryUserComentary;
	private Date revisoryDate;

}
