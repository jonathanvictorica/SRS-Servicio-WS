package com.utn.frba.srs.service;

import java.util.List;

import com.utn.frba.srs.exception.NotFoundException;
import com.utn.frba.srs.model.Subsidiary;

public interface QuerySubsidiaryUseCasePort {

	Subsidiary findById(Long id) throws NotFoundException;

	Subsidiary findByCustomerIdByName(Long customerId, String name) throws NotFoundException;

	List<Subsidiary> findBySecurityCompany(Long customerId);

}
