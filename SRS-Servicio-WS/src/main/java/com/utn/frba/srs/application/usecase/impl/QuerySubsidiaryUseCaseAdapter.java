package com.utn.frba.srs.application.usecase.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utn.frba.srs.application5.QuerySubsidiaryUseCasePort;
import com.utn.frba.srs.domain.exception.NotFoundException;
import com.utn.frba.srs.domain.model.Subsidiary;
import com.utn.frba.srs.infraestructure.repository.hibernate.SubsidiaryRepository;

@Service
public class QuerySubsidiaryUseCaseAdapter implements QuerySubsidiaryUseCasePort {

	@Autowired
	private SubsidiaryRepository subsidiaryRepository;
	
	@Override
	public Subsidiary findById(Long id) throws NotFoundException {
	     return subsidiaryRepository.findById(id).orElseThrow(() -> new NotFoundException(id + ""));
	}

	@Override
	public Subsidiary findByCustomerIdByName(Long customerId, String name) throws NotFoundException {
		 return subsidiaryRepository.findBySecurityCompanyCustomer_IdAndName(customerId,name).orElseThrow(() -> new NotFoundException(customerId+"-"+name));
	}

	@Override
	public List<Subsidiary> findBySecurityCompany(Long customerId) {
		return subsidiaryRepository.findBySecurityCompanyCustomer_Id(customerId);
	}

}
