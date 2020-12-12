package com.utn.frba.srs.user.application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utn.frba.srs.application5.QuerySystemUserUseCasePort;
import com.utn.frba.srs.infraestructure.repository.hibernate.SystemUserRepository;
import com.utn.frba.srs.user.domain.infraestructure.persistence.hibernate.entity.SystemUser;

@Service
public class QuerySystemUserUseCaseAdapter implements QuerySystemUserUseCasePort {

	@Autowired
	private SystemUserRepository systemUserRepository;

	@Override
	public List<SystemUser> findBySecurityCompany(Long securityCompanyId) {
		return systemUserRepository.findBySecurityCompany(securityCompanyId);
	}

	@Override
	public SystemUser findById(Long id) {
		return systemUserRepository.findById(id).orElse(null);

	}

	@Override
	public SystemUser findByDocumentNumber(String documentNumber) {
		return systemUserRepository.findByDocumentNumber(documentNumber).orElse(null);
	}

	@Override
	public List<SystemUser> findByRol(String rolName) {
		List<SystemUser> users = new ArrayList<>();
		users.addAll(systemUserRepository.findByRoleLevel1(rolName).orElse(Collections.emptyList()));
		users.addAll(systemUserRepository.findByRoleLevel2(rolName).orElse(Collections.emptyList()));
		users.addAll(systemUserRepository.findByRoleLevel3(rolName).orElse(Collections.emptyList()));
		return users;
	}

	@Override
	public List<SystemUser> findBlockedUsers() {
		return systemUserRepository.findByBloqueadedUser(true);
	}

}
