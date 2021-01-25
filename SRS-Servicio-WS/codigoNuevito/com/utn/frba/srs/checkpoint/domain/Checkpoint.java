package com.utn.frba.srs.checkpoint.domain;

import java.util.UUID;

import com.utn.frba.srs.shared.domain.AggregateRoot;

import lombok.Data;

@Data
public class Checkpoint extends AggregateRoot {

	private UUID id;

	private String nfcIdentification;

	private UbicationVO ubication;

	private UUID subsidiaryId;

	public void createCheckpointCreatedDomainEvent() {
		super.events.add(new CheckpointCreatedDomainEvent(id.toString()));
	}

}
