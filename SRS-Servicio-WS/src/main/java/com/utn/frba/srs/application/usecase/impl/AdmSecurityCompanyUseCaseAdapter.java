package com.utn.frba.srs.application.usecase.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utn.frba.srs.application5.AdmSecurityCompanyUseCasePort;
import com.utn.frba.srs.domain.exception.SRSException;
import com.utn.frba.srs.domain.model.SecurityCompany;
import com.utn.frba.srs.domain.model.SystemUser;
import com.utn.frba.srs.domain.util.BugCatalog;
import com.utn.frba.srs.infraestructure.controller.dto.EmpresaDTO;
import com.utn.frba.srs.infraestructure.repository.hibernate.SecurityCompanyRepository;
import com.utn.frba.srs.infraestructure.repository.hibernate.SystemUserRepository;

@Service
public class AdmSecurityCompanyUseCaseAdapter implements AdmSecurityCompanyUseCasePort {

	@Autowired
	private SecurityCompanyRepository securityCompanyRepository;

	@Autowired
	private SystemUserRepository systemUserRepository;

	@Override
	public void create(EmpresaDTO request) throws SRSException {
		if (securityCompanyRepository
				.findByDocumentTypeAndDocumentNumber(request.getDocumentType(), request.getDocumentNumber())
				.isPresent()) {
			throw new SRSException(BugCatalog.EMPRESA_SEGURIDAD_EXISTE);
		}
		SystemUser user = systemUserRepository.findById(request.getUserId())
				.orElseThrow(() -> new SRSException(BugCatalog.USUARIO_NO_EXISTE));
		SecurityCompany securityCompany = null;
		securityCompanyRepository.save(securityCompany);
	}

	@Override
	public void update(EmpresaDTO request) throws SRSException {
		// TODO Auto-generated method stub
		
	}


}
