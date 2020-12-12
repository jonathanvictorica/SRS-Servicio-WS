package com.utn.frba.srs.application5;

import java.util.List;

import com.utn.frba.srs.domain.exception.NotFoundException;
import com.utn.frba.srs.round.domain.Round;

public interface QueryRoundUseCasePort {

	Round findById(Long id) throws NotFoundException;

	List<Round> findBySubsidiary(Long subsidiaryId);

	Round findBySubsidiaryAndName(Long subsidiaryId, String roundName) throws NotFoundException;

	List<Round> findBySecurityCompanyCustomer(Long securityCompanyCustomerId);

}
