package com.utn.frba.srs.infraestructure.controller.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.utn.frba.srs.application5.AdmSubsidiaryUseCasePort;
import com.utn.frba.srs.application5.QuerySubsidiaryUseCasePort;
import com.utn.frba.srs.domain.exception.SRSException;
import com.utn.frba.srs.infraestructure.controller.AdmSubsidiaryController;
import com.utn.frba.srs.infraestructure.controller.dto.RequestGeneric;
import com.utn.frba.srs.infraestructure.controller.dto.ResponseGeneric;
import com.utn.frba.srs.infraestructure.controller.dto.SubsidiaryDTO;
import com.utn.frba.srs.infraestructure.controller.mapper.SubsidiaryMapper;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(path = "/v1")
@Api(tags = "AdmSubsidiary", description = ("AdmSubsidiary"))
public class AdmSubsidiaryControllerImpl extends GenericWS implements AdmSubsidiaryController {

	@Autowired
	private AdmSubsidiaryUseCasePort admSubsidiaryUseCasePort;
	
	@Autowired
	private QuerySubsidiaryUseCasePort querySubsidiaryUseCasePort;
	
	private SubsidiaryMapper subsidiaryMapper = Mappers.getMapper(SubsidiaryMapper.class);
	
	
	@Override
	public void create(RequestGeneric<SubsidiaryDTO> request) throws SRSException {
		admSubsidiaryUseCasePort.create(subsidiaryMapper.transformerInverse(request.getData()));
		
	}

	@Override
	public void update(RequestGeneric<SubsidiaryDTO> request) throws SRSException {
		admSubsidiaryUseCasePort.update(subsidiaryMapper.transformerInverse(request.getData()));
		
	}

	@Override
	public void delete(Long id) throws SRSException {
		admSubsidiaryUseCasePort.delete(id);
		
	}
	
	@Override
	public void updateUbication(Long subsidiaryId, String latitude, String longitude)
			throws SRSException {
		admSubsidiaryUseCasePort.updateUbication(subsidiaryId,latitude, longitude);
	}

	@Override
	public ResponseGeneric<SubsidiaryDTO> findById(Long id) throws SRSException {
		ResponseGeneric<SubsidiaryDTO> response = new ResponseGeneric<>();
		response.setData(subsidiaryMapper.transformer(querySubsidiaryUseCasePort.findById(id)));
		return response;
	}

	@Override
	public ResponseGeneric<SubsidiaryDTO> findByCustomerIdByName(Long customerId, String name)
			throws SRSException {
		ResponseGeneric<SubsidiaryDTO> response = new ResponseGeneric<>();
		response.setData(subsidiaryMapper.transformer(querySubsidiaryUseCasePort.findByCustomerIdByName(customerId,name)));
		return response;
	}

	@Override
	public ResponseGeneric<List<SubsidiaryDTO>> findBySecurityCompany(Long customerId) {
		ResponseGeneric<List<SubsidiaryDTO>> response = new ResponseGeneric<>();
		response.setData(querySubsidiaryUseCasePort.findBySecurityCompany(customerId).stream().map(a -> subsidiaryMapper.transformer(a))
				.collect(Collectors.toList()));
		return response;
	}

	

}
