package com.utn.frba.srs.service;

import java.util.List;

import com.utn.frba.srs.controller.dto.RolUsuarioDTO;
import com.utn.frba.srs.model.SystemUserRol;

public interface QuerySystemUserRoleUseCasePort {

	List<SystemUserRol> allRoles();

}
