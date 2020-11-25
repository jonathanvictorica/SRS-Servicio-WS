package com.utn.frba.srs.configuration;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.utn.frba.srs.model.Audit;
import com.utn.frba.srs.model.Domicile;
import com.utn.frba.srs.model.SecurityCompany;
import com.utn.frba.srs.model.SystemUser;
import com.utn.frba.srs.model.SystemUserRol;
import com.utn.frba.srs.repository.SecurityCompanyRepository;
import com.utn.frba.srs.repository.SystemUserRolRepository;

@Component
public class DataLoader implements ApplicationRunner {
	@Autowired
	private SystemUserRolRepository systemUserRolRepository;
	@Autowired
	private SecurityCompanyRepository securityCompanyRepository;

	public void run(ApplicationArguments args) {
		if (systemUserRolRepository.findById(1L).isPresent()) {
			return;
		}

		systemUserRolRepository.save(new SystemUserRol(null, "Supervisor", "Supervisor de Rodnas", 1, null));

		securityCompanyRepository.save(new SecurityCompany(
				null, "Empresa", "CUIT", "2012121212", new Domicile(null, "calle", "12", "departamento", "1", "ciudad",
						"dpto", "provincia", "argentina", null),
				true, new Audit(new Date(), new SystemUser(1L), null, null)));
	}
}