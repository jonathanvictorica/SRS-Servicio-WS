package com.utn.fbra.srs.domain.model;

import com.utn.fbra.srs.domain.repository.EmpresaSeguridadRepository;
import com.utn.fbra.srs.domain.repository.RepositoryFactory;
import com.utn.fbra.srs.domain.vo.DocumentoVO;
import com.utn.fbra.srs.domain.vo.DomicilioVO;
import com.utn.fbra.srs.domain.vo.IdVO;
import com.utn.fbra.srs.domain.vo.MailVO;
import com.utn.fbra.srs.domain.vo.NombreVO;
import com.utn.fbra.srs.shared.domain.AggregateRoot;

public class EmpresaSeguridadAR extends AggregateRoot {
	private IdVO empSegId;
	private NombreVO codigoNFC;
	private DocumentoVO documento;
    private MailVO mail;
	private DomicilioVO domicilio;

	
	private static EmpresaSeguridadRepository getEmpresaSeguridadRepository() {
		return (EmpresaSeguridadRepository) RepositoryFactory.create("EmpresaSeguridadRepository");
	}
}
