package com.utn.frba.srs.infraestructure.controller.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.utn.frba.srs.infraestructure.controller.dto.RoundDTO;
import com.utn.frba.srs.round.domain.Round;

@Mapper
public abstract class RoundMapper {
	public abstract RoundDTO transformer(Round round);

	@Mappings({ @Mapping(target = "audit.creationUser.id", source = "userId") })
	public abstract Round transformerInverse(RoundDTO data);

}
