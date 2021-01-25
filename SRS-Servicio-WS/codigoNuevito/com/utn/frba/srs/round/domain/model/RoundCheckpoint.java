package com.utn.frba.srs.round.domain.model;

import java.util.UUID;

import lombok.Data;

@Data
public class RoundCheckpoint {

	private UUID id;

	private Checkpoint checkpoint;

	private Integer executionOrder;

}
