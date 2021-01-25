package com.utn.fbra.srs.domain.model;

import com.utn.fbra.srs.domain.repository.ClienteEmpSegRepository;
import com.utn.fbra.srs.domain.repository.RepositoryFactory;
import com.utn.fbra.srs.domain.vo.DocumentoVO;
import com.utn.fbra.srs.domain.vo.DomicilioVO;
import com.utn.fbra.srs.domain.vo.IdVO;
import com.utn.fbra.srs.domain.vo.MailVO;
import com.utn.fbra.srs.domain.vo.NombreVO;
import com.utn.fbra.srs.shared.domain.AggregateRoot;

public class ClienteEmpSegAR extends AggregateRoot {
	private IdVO clienteEmpSegId;
	private NombreVO codigoNFC;
	private DocumentoVO documento;
    private MailVO mail;
	private DomicilioVO domicilio;
    
	private IdVO empSegId;
	
	private static ClienteEmpSegRepository getClienteEmpSegRepository() {
		return (ClienteEmpSegRepository) RepositoryFactory.create("ClienteEmpSegRepository");
	}

}
