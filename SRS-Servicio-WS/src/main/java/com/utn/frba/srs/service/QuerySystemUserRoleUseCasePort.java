package com.utn.frba.srs.service;

import java.util.List;

import com.utn.frba.srs.controller.dto.RolUsuarioDTO;

public interface QuerySystemUserRoleUseCasePort {

	List<RolUsuarioDTO> allRoles();

}
