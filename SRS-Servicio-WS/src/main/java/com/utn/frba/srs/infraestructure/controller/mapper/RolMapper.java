package com.utn.frba.srs.infraestructure.controller.mapper;

import org.mapstruct.Mapper;

import com.utn.frba.srs.domain.model.SystemUserRol;
import com.utn.frba.srs.infraestructure.controller.dto.RolUsuarioDTO;
@Mapper
public abstract class RolMapper {
	public abstract RolUsuarioDTO transformer(SystemUserRol rol);

}
