package com.utn.fbra.srs.infraestructure.persistence.hibernate.entity;

import javax.persistence.Column;
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

import com.utn.fbra.srs.domain.model.ronda.RondaCheckpointVO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "OPERATIONS006_CheckpointRound", uniqueConstraints = {
		@UniqueConstraint(name = "uk_round_checkpoint", columnNames = { "round_id", "checkpoint_id" }) }, indexes = {
				@Index(name = "idx_round_checkpoint", columnList = "round_id,checkpoint_id") })
public class RoundCheckpointEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	private RoundEntity round;

	@ManyToOne(fetch = FetchType.EAGER)
	private CheckpointEntity checkpoint;

	@Positive
	private Integer executionOrder;

	@NotNull
	@Column(nullable = false)
	private Boolean active = true;

	public static RondaCheckpointVO fromEntity(RoundCheckpointEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	public static RoundCheckpointEntity fromAggregateRoot(RondaCheckpointVO aggregateRoot) {
		// TODO Auto-generated method stub
		return null;
	}

}
