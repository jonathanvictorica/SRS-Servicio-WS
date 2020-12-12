package com.utn.frba.srs.round.domain;

import java.util.List;

import com.utn.frba.srs.shared.infraestructure.persistence.entity.Ubication;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Round {

	private Long id;

	private Long subsidiaryId;

	private String name;

	private String description;

	private String codeStatusRound;

	private List<RoundCheckpoint> checkpoints;

	private List<RoundRoute> routes;

	private Ubication ubication;

	private String zoomUbication = "0";

	private Integer roundTime;

	private RoundRepository roundRepository;

	public Round(RoundRepository roundRepository) {
		this.roundRepository = roundRepository;
	}

	public void create(Round round) {
		if (roundRepository.existsById(id)) {
			roundRepository.deleteCheckpointsAndRoutes(id);
		}
		roundRepository.save(round);
	}

	public void delete(String id, String identificadorUsuario) {
		roundRepository.delete(id);
	}

}
