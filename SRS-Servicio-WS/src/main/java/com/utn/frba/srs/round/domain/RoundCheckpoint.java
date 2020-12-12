package com.utn.frba.srs.round.domain;

import lombok.Data;

@Data
public class RoundCheckpoint {

	private Long id;

	private Checkpoint checkpoint;

	private Integer executionOrder;

}
