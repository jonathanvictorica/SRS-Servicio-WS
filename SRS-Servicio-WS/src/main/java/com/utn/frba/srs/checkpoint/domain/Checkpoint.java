package com.utn.frba.srs.checkpoint.domain;

import java.io.Serializable;

import com.utn.frba.srs.shared.domain.NotFoundException;

import lombok.Data;

@Data
public class Checkpoint {

	private Long id;

	private String nfcIdentification;

	private Checkpoint.Ubication ubication;

	private Long subsidiaryId;

	private CheckpointRepository checkpointRepository;

	public Checkpoint(CheckpointRepository checkpointRepository) {
		super();
		this.checkpointRepository = checkpointRepository;
	}
	
	public Checkpoint() {
		
	}

	@Data
	public static class Ubication implements Serializable {

		private static final long serialVersionUID = 1L;
		private String latitude;
		private String longitude;

	}

	public void create(Checkpoint checkpoint) {
		Checkpoint checkExiste = checkpointRepository.findByNfcIdentification(checkpoint.nfcIdentification);
		if (checkExiste != null) {
			checkpoint.setId(checkExiste.getId());
		}
		checkpointRepository.save(checkpoint);

	}

	public void delete(Long id) {
		checkpointRepository.deleteById(id);
		
	}

	public Checkpoint findById(Long id) throws NotFoundException {
		return checkpointRepository.findById(id);
	}

}
