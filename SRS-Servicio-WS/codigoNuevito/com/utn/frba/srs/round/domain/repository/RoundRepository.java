package com.utn.frba.srs.round.domain.repository;

import java.util.List;
import java.util.Optional;

import com.utn.frba.srs.round.domain.model.Round;

public interface RoundRepository {

	boolean existsById(Long id);

	void deleteCheckpointsAndRoutes(Long id);

	void save(Round data);

	void delete(Long id);

	Optional<Round> findById(Long id);

	List<Round> findBySubsidiaryId(Long subsidiaryId);

	Round findBySubsidiaryIdAndName(Long subsidiaryId, String roundName);

}
