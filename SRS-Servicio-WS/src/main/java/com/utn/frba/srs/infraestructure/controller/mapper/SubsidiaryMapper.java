package com.utn.frba.srs.infraestructure.controller.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.utn.frba.srs.domain.model.Subsidiary;
import com.utn.frba.srs.infraestructure.controller.dto.SubsidiaryDTO;

@Mapper
public abstract class SubsidiaryMapper {

	public abstract SubsidiaryDTO transformer(Subsidiary user);

	
	@Mappings({
		@Mapping(target = "securityCompanyCustomer.id", source = "securityCompanyId"),
		@Mapping(target = "audit.creationUser.id", source = "userId")})
	public abstract Subsidiary transformerInverse(SubsidiaryDTO data);

}
