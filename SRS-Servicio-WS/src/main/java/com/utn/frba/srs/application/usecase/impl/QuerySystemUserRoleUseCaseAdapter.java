package com.utn.frba.srs.application.usecase.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utn.frba.srs.application5.QuerySystemUserRoleUseCasePort;
import com.utn.frba.srs.domain.model.SystemUserRol;
import com.utn.frba.srs.infraestructure.repository.hibernate.SystemUserRolRepository;

@Service
public class QuerySystemUserRoleUseCaseAdapter implements QuerySystemUserRoleUseCasePort {

	@Autowired
	private SystemUserRolRepository systemUserRolRepository;
	
	@Override
	public List<SystemUserRol> allRoles() {
		return systemUserRolRepository.findAll();
	}

}
