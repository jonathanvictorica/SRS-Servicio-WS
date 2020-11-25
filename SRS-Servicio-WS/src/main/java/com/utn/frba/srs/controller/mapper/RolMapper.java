package com.utn.frba.srs.controller.mapper;

import org.mapstruct.Mapper;

import com.utn.frba.srs.controller.dto.RolUsuarioDTO;
import com.utn.frba.srs.model.SystemUserRol;
@Mapper
public abstract class RolMapper {
	public abstract RolUsuarioDTO transformer(SystemUserRol rol);

}
