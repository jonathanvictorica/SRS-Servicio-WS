package com.utn.frba.srs.service;

import java.util.List;

import com.utn.frba.srs.exception.NotFoundException;
import com.utn.frba.srs.model.Round;

public interface QueryRoundUseCasePort {

	Round findById(Long id) throws NotFoundException;

	List<Round> findBySubsidiary(Long subsidiaryId);

	Round findBySubsidiaryAndName(Long subsidiaryId, String roundName) throws NotFoundException;

	List<Round> findBySecurityCompanyCustomer(Long securityCompanyCustomerId);

}
