package com.utn.frba.srs.checkpoint.domain;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.utn.frba.srs.shared.domain.NotFoundException;

public interface CheckpointRepository {

	void save(Checkpoint checkpoint);

	Optional<Checkpoint> findByNfcIdentification(String nfcIdentification);

	void deleteById(UUID id);

	Optional<Checkpoint> findById(UUID id) throws NotFoundException;

	void updateUbication(Checkpoint checkpoint);

	List<Checkpoint> findByCriteria(UUID id);

	

}
