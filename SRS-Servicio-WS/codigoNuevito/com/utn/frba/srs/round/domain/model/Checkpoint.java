package com.utn.frba.srs.round.domain.model;

import java.util.UUID;

import com.utn.frba.srs.shared.infraestructure.persistence.entity.Ubication;

import lombok.Data;

@Data
public class Checkpoint {
	private UUID id;

	private String nfcIdentification;

	private Ubication ubication;
}
