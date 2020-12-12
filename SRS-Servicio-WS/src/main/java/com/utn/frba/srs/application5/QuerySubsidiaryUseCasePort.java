package com.utn.frba.srs.application5;

import java.util.List;

import com.utn.frba.srs.domain.exception.NotFoundException;
import com.utn.frba.srs.domain.model.Subsidiary;

public interface QuerySubsidiaryUseCasePort {

	Subsidiary findById(Long id) throws NotFoundException;

	Subsidiary findByCustomerIdByName(Long customerId, String name) throws NotFoundException;

	List<Subsidiary> findBySecurityCompany(Long customerId);

}
