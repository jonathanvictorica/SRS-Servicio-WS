package com.utn.frba.srs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utn.frba.srs.model.Round;
import com.utn.frba.srs.repository.RoundRepository;
import com.utn.frba.srs.service.AdmRoundUseCasePort;

@Service
public class AdmRoundUseCaseAdapter implements AdmRoundUseCasePort {

	@Autowired
	private RoundRepository roundRepository;

	@Override
	public void create(Round data) {
		roundRepository.save(data);
	}

	@Override
	public void delete(Long id) {
		roundRepository.deleteById(id);
	}

}
