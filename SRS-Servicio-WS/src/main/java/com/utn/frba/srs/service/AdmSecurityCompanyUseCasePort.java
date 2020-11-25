package com.utn.frba.srs.service;

import com.utn.frba.srs.controller.dto.EmpresaDTO;
import com.utn.frba.srs.exception.SRSException;

public interface AdmSecurityCompanyUseCasePort {

	void create(EmpresaDTO request) throws SRSException;

	void update(EmpresaDTO request) throws SRSException;

}
