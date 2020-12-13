package com.utn.frba.srs.checkpoint.domain;

import com.utn.frba.srs.shared.domain.NotFoundException;

public interface CheckpointRepository {

	void save(Checkpoint checkpoint);

	Checkpoint findByNfcIdentification(String nfcIdentification);

	void deleteById(Long id);

	Checkpoint findById(Long id) throws NotFoundException;

}
