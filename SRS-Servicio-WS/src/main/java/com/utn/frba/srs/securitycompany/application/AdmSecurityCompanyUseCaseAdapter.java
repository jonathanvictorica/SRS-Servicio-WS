package com.utn.frba.srs.securitycompany.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utn.frba.srs.application5.AdmSecurityCompanyUseCasePort;
import com.utn.frba.srs.infraestructure.controller.dto.EmpresaDTO;
import com.utn.frba.srs.infraestructure.repository.hibernate.SecurityCompanyRepository;
import com.utn.frba.srs.infraestructure.repository.hibernate.SystemUserRepository;
import com.utn.frba.srs.securitycompany.infraestructure.persistence.hibernate.entity.SecurityCompany;
import com.utn.frba.srs.shared.domain.BugCatalog;
import com.utn.frba.srs.shared.domain.SRSException;
import com.utn.frba.srs.user.domain.infraestructure.persistence.hibernate.entity.SystemUser;

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
