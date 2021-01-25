package com.utn.frba.srs.checkpoint.domain;

import com.utn.frba.srs.shared.domain.DomainEvent;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CheckpointCreatedDomainEvent extends DomainEvent{

	private String id;
}
