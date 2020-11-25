package com.utn.frba.srs.configuration;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.utn.frba.srs.model.Audit;
import com.utn.frba.srs.model.Domicile;
import com.utn.frba.srs.model.SecurityCompany;
import com.utn.frba.srs.model.SecurityCompanyCustomer;
import com.utn.frba.srs.model.SystemUser;
import com.utn.frba.srs.model.SystemUserRol;
import com.utn.frba.srs.repository.ClienteEmpresaSeguridadRepository;
import com.utn.frba.srs.repository.SecurityCompanyRepository;
import com.utn.frba.srs.repository.SystemUserRepository;
import com.utn.frba.srs.repository.SystemUserRolRepository;

@Component
public class DataLoader implements ApplicationRunner {
	@Autowired
	private SystemUserRolRepository systemUserRolRepository;
	@Autowired
	private SystemUserRepository systemUserRepository;
	@Autowired
	private SecurityCompanyRepository securityCompanyRepository;
	@Autowired
	private ClienteEmpresaSeguridadRepository clienteEmpresaSeguridadRepository;

	public void run(ApplicationArguments args) {
		if (systemUserRolRepository.findById(1L).isPresent()) {
			return;
		}

		SystemUserRol rol = new SystemUserRol(null, "Supervisor", "Supervisor de Rodnas", 1, null);
		SystemUser user = new SystemUser(null, null, "jonathan", "Victorica", "DNI", "4566666", "jonathan.m@gmail.com",
				rol, null, null, "jony", "jony", 0, false, true);

		SecurityCompany securityCompany = new SecurityCompany(null, "Empresa", "CUIT", "2012121212", new Domicile(null,
				"calle", "12", "departamento", "1", "ciudad", "dpto", "provincia", "argentina", null), true,
				new Audit(new Date(), user, null, null));

		SecurityCompanyCustomer securityCompanyCustomer = new SecurityCompanyCustomer(
				null, securityCompany, "Empresa Cliente", "CUIT", "966666", new Domicile(null, "calle", "12",
						"departamento", "1", "ciudad", "dpto", "provincia", "argentina", null),
				true, new Audit(new Date(), user, null, null));

		systemUserRolRepository.save(rol);
		systemUserRepository.save(user);
		securityCompanyRepository.save(securityCompany);
		clienteEmpresaSeguridadRepository.save(securityCompanyCustomer);
	}
}