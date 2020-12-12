package com.utn.frba.srs.user.application;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utn.frba.srs.application5.QuerySystemUserRoleUseCasePort;
import com.utn.frba.srs.infraestructure.repository.hibernate.SystemUserRolRepository;
import com.utn.frba.srs.user.domain.infraestructure.persistence.hibernate.entity.SystemUserRol;

@Service
public class QuerySystemUserRoleUseCaseAdapter implements QuerySystemUserRoleUseCasePort {

	@Autowired
	private SystemUserRolRepository systemUserRolRepository;
	
	@Override
	public List<SystemUserRol> allRoles() {
		return systemUserRolRepository.findAll();
	}

}
