package com.utn.frba.srs.application5;

import com.utn.frba.srs.domain.exception.SRSException;
import com.utn.frba.srs.infraestructure.controller.dto.EmpresaDTO;

public interface AdmSecurityCompanyUseCasePort {

	void create(EmpresaDTO request) throws SRSException;

	void update(EmpresaDTO request) throws SRSException;

}
