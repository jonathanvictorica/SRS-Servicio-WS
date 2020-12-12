package com.utn.frba.srs.infraestructure.controller.mapper;

import org.mapstruct.Mapper;

import com.utn.frba.srs.infraestructure.controller.dto.RolUsuarioDTO;
import com.utn.frba.srs.user.infraestructure.persistence.hibernate.entity.SystemUserRol;
@Mapper
public abstract class RolMapper {
	public abstract RolUsuarioDTO transformer(SystemUserRol rol);

}
