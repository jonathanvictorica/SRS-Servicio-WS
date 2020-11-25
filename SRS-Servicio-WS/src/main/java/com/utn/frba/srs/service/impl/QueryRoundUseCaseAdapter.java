package com.utn.frba.srs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utn.frba.srs.exception.NotFoundException;
import com.utn.frba.srs.model.Round;
import com.utn.frba.srs.repository.RoundRepository;
import com.utn.frba.srs.service.QueryRoundUseCasePort;

@Service
public class QueryRoundUseCaseAdapter implements QueryRoundUseCasePort {

	@Autowired
	private RoundRepository roundRepository;

	@Override
	public Round findById(Long id) throws NotFoundException {
		return roundRepository.findById(id).orElseThrow(() -> new NotFoundException(id + ""));
	}

	@Override
	public List<Round> findBySubsidiary(Long subsidiaryId) {
		return roundRepository.findBySubsidiary_id(subsidiaryId);

	}

	@Override
	public Round findBySubsidiaryAndName(Long subsidiaryId, String roundName) throws NotFoundException {
		return roundRepository.findBySubsidiary_idAndName(subsidiaryId, roundName)
				.orElseThrow(() -> new NotFoundException(subsidiaryId + " - " + roundName));
	}

	@Override
	public List<Round> findBySecurityCompanyCustomer(Long securityCompanyCustomerId) {
		return roundRepository.findBySubsidiary_SecurityCompanyCustomer_id(securityCompanyCustomerId);

	}

}
