package com.utn.frba.srs.round.domain;

import com.utn.frba.srs.domain.model.Ubication;

import lombok.Data;

@Data
public class RoundCheckpoint {

	private Long id;

	private Long checkpointId;

	private String nfcIdentification;

	private Ubication ubication;

	private Integer executionOrder;

}