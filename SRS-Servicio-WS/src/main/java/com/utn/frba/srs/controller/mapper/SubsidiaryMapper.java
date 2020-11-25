package com.utn.frba.srs.controller.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.utn.frba.srs.controller.dto.SubsidiaryDTO;
import com.utn.frba.srs.model.Subsidiary;

@Mapper
public abstract class SubsidiaryMapper {

	public abstract SubsidiaryDTO transformer(Subsidiary user);

	
	@Mappings({
		@Mapping(target = "securityCompanyCustomer.id", source = "securityCompanyId"),
		@Mapping(target = "audit.creationUser.id", source = "userId")})
	public abstract Subsidiary transformerInverse(SubsidiaryDTO data);

}
