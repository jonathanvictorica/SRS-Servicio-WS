package com.utn.frba.srs.round.domain;

import com.utn.frba.srs.domain.model.Ubication;

import lombok.Data;

@Data
public class RoundRoute {

	private Long id;

	private int routeOrder;

	private Ubication ubication;

}
