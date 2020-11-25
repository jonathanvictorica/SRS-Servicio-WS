package com.utn.frba.srs.controller.mapper;

import java.util.ArrayList;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;

import com.utn.frba.srs.controller.dto.UserDTO;
import com.utn.frba.srs.model.SystemUser;

@Mapper
public abstract class UserMapper {

	@Mappings({
			@Mapping(target = "roles", ignore = true) })
	public abstract UserDTO transformer(SystemUser user);

	@AfterMapping
	protected void setRoles(SystemUser user, @MappingTarget UserDTO userDTO) {
		userDTO.setRoles(new ArrayList<>());
		userDTO.getRoles().add(user.getRoleLevel1() != null ? user.getRoleLevel1().getName() : "");
		userDTO.getRoles().add(user.getRoleLevel2() != null ? user.getRoleLevel2().getName() : "");
		userDTO.getRoles().add(user.getRoleLevel3() != null ? user.getRoleLevel3().getName() : "");

	}
}
