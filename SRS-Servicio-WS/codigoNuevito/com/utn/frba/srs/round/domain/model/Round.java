package com.utn.frba.srs.round.domain.model;

import java.util.List;
import java.util.UUID;

import com.utn.frba.srs.round.domain.repository.RoundRepository;
import com.utn.frba.srs.shared.domain.AggregateRoot;
import com.utn.frba.srs.shared.infraestructure.persistence.entity.Ubication;

import lombok.Data;

@Data
public class Round extends AggregateRoot {

	private UUID id;

	private UUID subsidiaryId;

	private String name;

	private String description;

	private List<RoundCheckpoint> checkpoints;

	private List<RoundRoute> routes;

	private Ubication ubication;

	private String zoomUbication = "0";

	private Integer roundTime;

	private static RoundRepository roundRepository;

	public static void injectRepository(RoundRepository roundRepository) {
		Round.roundRepository = roundRepository;

	}

	
	public static void create(Round round) {
		if (round.id != null && roundRepository.existsById(round.id)) {
			roundRepository.deleteCheckpointsAndRoutes(round.id);
		}
		roundRepository.save(round);
	}

	public static void delete(Long id) {
		roundRepository.delete(id);
	}

	public static Round findById(Long id) {
		return roundRepository.findById(id).orElse(null);
	}

	public static List<Round> findBySubsidiary(Long subsidiaryId) {
		return roundRepository.findBySubsidiaryId(subsidiaryId);
	}

	public static Round findBySubsidiaryAndName(Long subsidiaryId, String roundName) {
		return roundRepository.findBySubsidiaryIdAndName(subsidiaryId, roundName);
	}

	

}
