package com.utn.frba.srs.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.utn.frba.srs.controller.dto.UserDTO;
import com.utn.frba.srs.exception.SRSException;
import com.utn.frba.srs.model.SecurityCompany;
import com.utn.frba.srs.model.SystemUser;
import com.utn.frba.srs.model.SystemUserRol;
import com.utn.frba.srs.repository.SystemUserRepository;
import com.utn.frba.srs.repository.SystemUserRolRepository;
import com.utn.frba.srs.service.AdmSystemUserUseCasePort;
import com.utn.frba.srs.utils.BugCatalog;

@Service
public class AdmSystemUserUseCaseAdapter implements AdmSystemUserUseCasePort {

	@Autowired
	private SystemUserRepository systemUserRepository;
	@Autowired
	private SystemUserRolRepository systemUserRolRepository;

	@Override
	public void create(UserDTO userDTO) throws SRSException {
		List<SystemUserRol> roles = new ArrayList<>();

		if (CollectionUtils.isEmpty(userDTO.getRoles())) {
			throw new SRSException(BugCatalog.ROL_USUARIO_NO_EXISTE);
		}
		for (String unit : userDTO.getRoles()) {
			SystemUserRol rol = systemUserRolRepository.findByName(unit)
					.orElseThrow(() -> new SRSException(BugCatalog.ROL_USUARIO_NO_EXISTE));
			roles.add(rol);
		}
		SystemUserRol.deleteDuplicateRoles(roles);
		Collections.sort(roles);
		SystemUser systemUser = new SystemUser(userDTO, roles, new SecurityCompany(userDTO.getCompanyId()));
		systemUserRepository.save(systemUser);
	}

	@Override
	public void update(UserDTO userDTO) throws SRSException {
		List<SystemUserRol> roles = new ArrayList<>();

		SystemUser user = systemUserRepository.findById(userDTO.getId())
				.orElseThrow(() -> new SRSException(BugCatalog.USUARIO_NO_EXISTE));

		if (CollectionUtils.isEmpty(userDTO.getRoles())) {
			throw new SRSException(BugCatalog.ROL_USUARIO_NO_EXISTE);
		}
		for (String unit : userDTO.getRoles()) {
			SystemUserRol rol = systemUserRolRepository.findByName(unit)
					.orElseThrow(() -> new SRSException(BugCatalog.ROL_USUARIO_NO_EXISTE));
			roles.add(rol);
		}
		SystemUserRol.deleteDuplicateRoles(roles);
		Collections.sort(roles);
		user.updating(userDTO, roles);
		systemUserRepository.save(user);
	}

	@Override
	public void delete(Long id) throws SRSException {
		systemUserRepository.deleteById(id);
	}
}
