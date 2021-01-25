package com.utn.fbra.srs.domain.vo;

import java.util.UUID;

import com.utn.fbra.srs.shared.domain.ValueObject;

public class IdVO extends ValueObject{

	private UUID id;

	public IdVO(UUID id) {
		super();
		this.id = id;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}
	
	
}
