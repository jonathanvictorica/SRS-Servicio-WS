package com.utn.frba.srs.service;

import java.util.List;

import com.utn.frba.srs.model.SystemUser;

public interface QuerySystemUserUseCasePort {

	List<SystemUser> findBySecurityCompany(Long securityCompanyId);

	SystemUser findById(Long id);

	SystemUser findByDocumentNumber(String documentNumber);

	List<SystemUser> findByRol(String rolName);

	List<SystemUser> findBlockedUsers();

}
