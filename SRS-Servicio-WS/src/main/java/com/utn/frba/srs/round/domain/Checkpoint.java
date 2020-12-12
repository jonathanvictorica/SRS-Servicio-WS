package com.utn.frba.srs.round.domain;

import com.utn.frba.srs.shared.infraestructure.persistence.entity.Ubication;

import lombok.Data;

@Data
public class Checkpoint {
	private Long id;

	private String nfcIdentification;

	private Ubication ubication;
}
