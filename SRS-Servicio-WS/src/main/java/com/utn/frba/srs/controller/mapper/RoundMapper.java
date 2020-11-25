package com.utn.frba.srs.controller.mapper;

import org.mapstruct.Mapper;

import com.utn.frba.srs.controller.dto.RoundDTO;
import com.utn.frba.srs.model.Round;
@Mapper
public abstract class RoundMapper {
	public abstract RoundDTO transformer(Round round);
	
	public abstract Round transformerInverse(RoundDTO data);

}
