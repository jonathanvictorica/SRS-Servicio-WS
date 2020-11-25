package com.utn.frba.srs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utn.frba.srs.controller.dto.EmpresaDTO;
import com.utn.frba.srs.exception.SRSException;
import com.utn.frba.srs.model.SecurityCompany;
import com.utn.frba.srs.model.SystemUser;
import com.utn.frba.srs.repository.SecurityCompanyRepository;
import com.utn.frba.srs.repository.SystemUserRepository;
import com.utn.frba.srs.service.AdmSecurityCompanyUseCasePort;
import com.utn.frba.srs.utils.BugCatalog;

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
		SecurityCompany securityCompany = new SecurityCompany(request, user);
		securityCompanyRepository.save(securityCompany);
	}

	@Override
	public void update(EmpresaDTO request) throws SRSException {
		// TODO Auto-generated method stub
		
	}


}
