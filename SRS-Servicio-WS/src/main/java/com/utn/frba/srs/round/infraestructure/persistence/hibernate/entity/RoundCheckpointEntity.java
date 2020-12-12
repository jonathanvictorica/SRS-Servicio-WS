package com.utn.frba.srs.round.infraestructure.persistence.hibernate.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
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
import javax.validation.constraints.Positive;

import com.utn.frba.srs.domain.model.Audit;
import com.utn.frba.srs.domain.model.Checkpoint;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "OPERATIONS006_CheckpointRound",uniqueConstraints = {
		@UniqueConstraint(name = "uk_round_checkpoint", columnNames = { "round_id", "checkpoint_id" }) }, indexes = {
				@Index(name = "idx_round_checkpoint", columnList = "round_id,checkpoint_id") })
public class RoundCheckpointEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.EAGER)
	private RoundEntity round;

	@ManyToOne(fetch = FetchType.EAGER)
	private Checkpoint checkpoint;

	@Positive
	private Integer executionOrder;

	@Embedded
	private Audit audit= new Audit();

	@NotNull
	@Column(nullable = false)
	private Boolean active = true;

}
