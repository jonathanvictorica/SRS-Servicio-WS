package com.utn.frba.srs.subsidiary.domain;

import java.util.Optional;

import com.utn.frba.srs.shared.domain.NotFoundException;

import lombok.Data;

@Data
public class Subsidiary {

	private Long id;

	private SubsidiaryRepository repository;

	public Subsidiary() {
		super();
	}

	public Subsidiary(SubsidiaryRepository repository) {
		this.repository = repository;
	}

	public Subsidiary findById(Long id) throws NotFoundException {
		return Optional.ofNullable(repository.findById(id)).orElseThrow(NotFoundException::new);
	}

}
