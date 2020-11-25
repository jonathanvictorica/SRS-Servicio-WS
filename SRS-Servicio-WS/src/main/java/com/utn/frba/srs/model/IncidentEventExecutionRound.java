package com.utn.frba.srs.model;

import java.io.Serializable;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.utn.frba.srs.utils.Ubication;

import lombok.Data;

@Data
@Entity
@Table(name = "OPERATIONS013_IncidentEventExecutionRound")
public class IncidentEventExecutionRound implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne(fetch = FetchType.EAGER)
	private EventExecutionRound eventExecutionRound;

	@Embedded
	private Ubication ubication;
	private String zoom = "";

	@Size(max = 225)
	private String details;
	@ManyToOne(fetch = FetchType.EAGER)
	private EventSeverity eventSeverity;

	@ManyToOne(fetch = FetchType.EAGER)
	private IncidentState incidentState;

}
