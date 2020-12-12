package com.utn.frba.srs.application5;

import java.util.List;

import com.utn.frba.srs.domain.model.SystemUser;

public interface QuerySystemUserUseCasePort {

	List<SystemUser> findBySecurityCompany(Long securityCompanyId);

	SystemUser findById(Long id);

	SystemUser findByDocumentNumber(String documentNumber);

	List<SystemUser> findByRol(String rolName);

	List<SystemUser> findBlockedUsers();

}
