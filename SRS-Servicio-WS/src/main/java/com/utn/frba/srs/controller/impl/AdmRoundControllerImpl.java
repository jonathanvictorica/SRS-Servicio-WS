package com.utn.frba.srs.controller.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.utn.frba.srs.controller.AdmRoundController;
import com.utn.frba.srs.controller.dto.RequestGeneric;
import com.utn.frba.srs.controller.dto.ResponseGeneric;
import com.utn.frba.srs.controller.dto.RoundDTO;
import com.utn.frba.srs.controller.mapper.RoundMapper;
import com.utn.frba.srs.exception.SRSException;
import com.utn.frba.srs.service.AdmRoundUseCasePort;
import com.utn.frba.srs.service.QueryRoundUseCasePort;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(path = "/v1")
@Api(tags = "AdmRound", description = ("AdmRound"))
public class AdmRoundControllerImpl extends GenericWS implements AdmRoundController {

	@Autowired
	private AdmRoundUseCasePort admRoundUseCasePort;
	
	@Autowired
	private QueryRoundUseCasePort queryRoundUseCasePort;
	
	private RoundMapper roundMapper = Mappers.getMapper(RoundMapper.class);
	
	@Override
	public void create(RequestGeneric<RoundDTO> request) throws SRSException {
		admRoundUseCasePort.create(roundMapper.transformerInverse(request.getData()));
		
	}

	@Override
	public void delete(Long id) throws SRSException {
		admRoundUseCasePort.delete(id);
		
	}

	@Override
	public ResponseGeneric<RoundDTO> findById(Long id) throws SRSException {
		ResponseGeneric<RoundDTO> response = new ResponseGeneric<>();
		response.setData(roundMapper.transformer(queryRoundUseCasePort.findById(id)));
		return response;
	}

	@Override
	public ResponseGeneric<List<RoundDTO>> findBySubsidiary(Long subsidiaryId) throws SRSException {
		ResponseGeneric<List<RoundDTO>> response = new ResponseGeneric<>();
		response.setData(queryRoundUseCasePort.findBySubsidiary(subsidiaryId).stream().map(a -> roundMapper.transformer(a))
				.collect(Collectors.toList()));
		return response;
	}

	@Override
	public ResponseGeneric<RoundDTO> findBySubsidiaryAndRoundName(Long subsidiaryId, String roundName)
			throws SRSException {
		ResponseGeneric<RoundDTO> response = new ResponseGeneric<>();
		response.setData(roundMapper.transformer(queryRoundUseCasePort.findBySubsidiaryAndName(subsidiaryId,roundName)));
		return response;
	}

	@Override
	public ResponseGeneric<List<RoundDTO>> findBySecurityCompanyCustomer(Long securityCompanyCustomerId)
			throws SRSException {
		ResponseGeneric<List<RoundDTO>> response = new ResponseGeneric<>();
		response.setData(queryRoundUseCasePort.findBySecurityCompanyCustomer(securityCompanyCustomerId).stream().map(a -> roundMapper.transformer(a))
				.collect(Collectors.toList()));
		return response;
	}



	
}
