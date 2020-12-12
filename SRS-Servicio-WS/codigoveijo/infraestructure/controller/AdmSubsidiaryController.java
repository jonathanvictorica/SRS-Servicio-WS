package com.utn.frba.srs.infraestructure.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.utn.frba.srs.infraestructure.controller.dto.RequestGeneric;
import com.utn.frba.srs.infraestructure.controller.dto.ResponseGeneric;
import com.utn.frba.srs.infraestructure.controller.dto.SubsidiaryDTO;
import com.utn.frba.srs.shared.domain.SRSException;

public interface AdmSubsidiaryController {

	@PostMapping(path = "/subsidiary")
	public void create(@RequestBody RequestGeneric<SubsidiaryDTO> request) throws SRSException;

	@PutMapping(path = "/subsidiary")
	public void update(@RequestBody RequestGeneric<SubsidiaryDTO> request) throws SRSException;

	@DeleteMapping(path = "/subsidiary/{id}")
	public void delete(@PathVariable("id") Long id) throws SRSException;

	@GetMapping(path = "/subsidiary/{id}")
	public ResponseGeneric<SubsidiaryDTO> findById(@PathVariable("id") Long id) throws SRSException;

	@GetMapping(path = "/subsidiary/{customerId}/{name}")
	public ResponseGeneric<SubsidiaryDTO> findByCustomerIdByName(@PathVariable("customerId") Long customerId,
			@PathVariable("nombre") String name) throws SRSException;

	@GetMapping(path = "/subsidiaryes/{customerId}")
	public ResponseGeneric<List<SubsidiaryDTO>> findBySecurityCompany(@PathVariable("customerId") Long customerId);

	@PutMapping(path = "/subsidiary/{idsubsidiary}/{lantitud}/{longitud}")
	public void updateUbication(@PathVariable("subsidiaryId") Long subsidiaryId,
			@PathVariable("latitude") String latitude, @PathVariable("longitude") String longitude)
			throws SRSException;

}
