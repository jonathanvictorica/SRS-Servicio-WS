package com.utn.frba.srs.infraestructure.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.utn.frba.srs.infraestructure.controller.dto.RequestGeneric;
import com.utn.frba.srs.infraestructure.controller.dto.ResponseGeneric;
import com.utn.frba.srs.infraestructure.controller.dto.RoundDTO;
import com.utn.frba.srs.shared.domain.SRSException;

public interface AdmRoundController {

	@PostMapping(path = "/round")
	public void create(@RequestBody RequestGeneric<RoundDTO> request) throws SRSException;

	@DeleteMapping(path = "/round")
	public void delete(@PathVariable("id") Long id) throws SRSException;

	@GetMapping(path = "/round/{id}")
	public ResponseGeneric<RoundDTO> findById(@PathVariable("id") Long id) throws SRSException;

	@GetMapping(path = "/rounds/{subsidiaryId}")
	public ResponseGeneric<List<RoundDTO>> findBySubsidiary(@PathVariable("subsidiaryId") Long subsidiaryId)
			throws SRSException;

	@GetMapping(path = "/round/{subsidiaryId}/{roundName}")
	public ResponseGeneric<RoundDTO> findBySubsidiaryAndRoundName(@PathVariable("subsidiaryId") Long subsidiaryId,
			@PathVariable("roundName") String roundName) throws SRSException;

	@GetMapping(path = "/round/{securityCompanyCustomerId}")
	public ResponseGeneric<List<RoundDTO>> findBySecurityCompanyCustomer(
			@PathVariable("securityCompanyCustomerId") Long securityCompanyCustomerId) throws SRSException;

}
