package com.utn.frba.srs.user.application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.utn.frba.srs.application5.AdmSystemUserUseCasePort;
import com.utn.frba.srs.infraestructure.controller.dto.UserDTO;
import com.utn.frba.srs.securitycompany.infraestructure.persistence.hibernate.entity.SecurityCompany;
import com.utn.frba.srs.shared.domain.BugCatalog;
import com.utn.frba.srs.shared.domain.SRSException;
import com.utn.frba.srs.user.infraestructure.persistence.hibernate.entity.SystemUser;
import com.utn.frba.srs.user.infraestructure.persistence.hibernate.entity.SystemUserRol;
import com.utn.frba.srs.user.infraestructure.persistence.hibernate.repository.SystemUserRepository;
import com.utn.frba.srs.user.infraestructure.persistence.hibernate.repository.SystemUserRolRepository;

@Service
public class AdmSystemUserUseCaseAdapter implements AdmSystemUserUseCasePort {

	@Autowired
	private SystemUserRepository systemUserRepository;
	@Autowired
	private SystemUserRolRepository systemUserRolRepository;

	@Override
	public void create(UserDTO userDTO) {
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
	public void update(UserDTO userDTO) {
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
	public void delete(Long id)  {
		systemUserRepository.deleteById(id);
	}
}
