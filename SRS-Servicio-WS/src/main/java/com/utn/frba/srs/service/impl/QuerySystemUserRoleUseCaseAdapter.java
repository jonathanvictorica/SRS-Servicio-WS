package com.utn.frba.srs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utn.frba.srs.model.SystemUserRol;
import com.utn.frba.srs.repository.SystemUserRolRepository;
import com.utn.frba.srs.service.QuerySystemUserRoleUseCasePort;

@Service
public class QuerySystemUserRoleUseCaseAdapter implements QuerySystemUserRoleUseCasePort {

	@Autowired
	private SystemUserRolRepository systemUserRolRepository;
	
	@Override
	public List<SystemUserRol> allRoles() {
		return systemUserRolRepository.findAll();
	}

}
