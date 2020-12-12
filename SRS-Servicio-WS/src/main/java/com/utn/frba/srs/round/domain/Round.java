package com.utn.frba.srs.round.domain;

import java.util.List;

import com.utn.frba.srs.shared.domain.NotFoundException;
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

	public Round findById(Long id) {
		return roundRepository.findById(id).orElseThrow(() -> new NotFoundException(id + ""));
	}

	public List<Round> findBySubsidiary(Long subsidiaryId) {
		return roundRepository.findBySubsidiary_id(subsidiaryId);
	}

	public List<Round> findBySecurityCompanyCustomer(Long securityCompanyCustomerId) {
		return roundRepository.findBySubsidiary_SecurityCompanyCustomer_id(securityCompanyCustomerId);

	}

	public Round findBySubsidiaryAndName(Long subsidiaryId, String roundName) {
		return roundRepository.findBySubsidiary_idAndName(subsidiaryId, roundName);
	}

}
