package com.utn.frba.srs.model;

import java.io.Serializable;

import javax.persistence.Column;
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
import javax.validation.constraints.Positive;

import lombok.Data;

@Data
@Entity
@Table(name = "OPERATIONS006_CheckpointRound",uniqueConstraints = {
		@UniqueConstraint(name = "uk_round_checkpoint", columnNames = { "round_id", "checkpoint_id" }) }, indexes = {
				@Index(name = "idx_round_checkpoint", columnList = "round_id,checkpoint_id") })
public class CheckpointRound implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne(fetch = FetchType.EAGER)
	private Round round;

	@ManyToOne(fetch = FetchType.EAGER)
	private Checkpoint checkpoint;

	@Positive
	private Integer executionOrder;

	@Embedded
	private Audit audit;

	@NotNull
	@Column(nullable = false)
	private Boolean active = true;

}
