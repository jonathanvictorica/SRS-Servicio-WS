package com.utn.frba.srs.infraestructure.configuration;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.utn.frba.srs.domain.model.Audit;
import com.utn.frba.srs.domain.model.Checkpoint;
import com.utn.frba.srs.domain.model.Domicile;
import com.utn.frba.srs.domain.model.SecurityCompany;
import com.utn.frba.srs.domain.model.SecurityCompanyCustomer;
import com.utn.frba.srs.domain.model.Subsidiary;
import com.utn.frba.srs.domain.model.SystemUser;
import com.utn.frba.srs.domain.model.SystemUserRol;
import com.utn.frba.srs.domain.model.Ubication;
import com.utn.frba.srs.infraestructure.repository.hibernate.CheckPointRepository;
import com.utn.frba.srs.infraestructure.repository.hibernate.ClienteEmpresaSeguridadRepository;
import com.utn.frba.srs.infraestructure.repository.hibernate.RoundStateRepository;
import com.utn.frba.srs.infraestructure.repository.hibernate.SecurityCompanyRepository;
import com.utn.frba.srs.infraestructure.repository.hibernate.SubsidiaryRepository;
import com.utn.frba.srs.infraestructure.repository.hibernate.SystemUserRepository;
import com.utn.frba.srs.infraestructure.repository.hibernate.SystemUserRolRepository;

import round.domain.RoundState;

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
	@Autowired
	private CheckPointRepository checkPointRepository;
	@Autowired
	private SubsidiaryRepository subsidiaryRepository;
	
	@Autowired
	private RoundStateRepository roundStateRepository;

	public void run(ApplicationArguments args) {
		if (systemUserRolRepository.findById(1L).isPresent()) {
			return;
		}
		
		cargarTablasParametricas();

		SystemUserRol rol = new SystemUserRol(null, "Supervisor", "Supervisor de Rodnas", 1, null);
		SystemUser user = new SystemUser(null, null, "jonathan", "Victorica", "DNI", "4566666", "jonathan.m@gmail.com",
				rol, null, null, "jony", "jony", 0, false, true);
		
		Audit audit = new Audit(new Date(), user, null, null);
		Domicile domicile = new Domicile(null, "calle", "12",
				"departamento", "1", "ciudad", "dpto", "provincia", "argentina", null); 
		
		Domicile domicile2 = new Domicile(null, "calle", "12",
				"departamento", "1", "ciudad", "dpto", "provincia", "argentina", null); 
		
		Domicile domicile3 = new Domicile(null, "calle", "12",
				"departamento", "1", "ciudad", "dpto", "provincia", "argentina", null); 

		SecurityCompany securityCompany = new SecurityCompany(null, "Empresa", "CUIT", "2012121212", domicile, true,
				audit);

		SecurityCompanyCustomer securityCompanyCustomer = new SecurityCompanyCustomer(
				null, securityCompany, "Empresa Cliente", "CUIT", "966666",domicile2,
				true, audit);
		
		Subsidiary subsidiary = new Subsidiary(null,"Sucursal","Sucursal Description",securityCompanyCustomer,domicile3,audit,true);
		
		Checkpoint checkpoint= new Checkpoint(null,"NFC",new Ubication("12222", "52222"),audit,subsidiary);

		systemUserRolRepository.save(rol);
		systemUserRepository.save(user);
		securityCompanyRepository.save(securityCompany);
		
		clienteEmpresaSeguridadRepository.save(securityCompanyCustomer);	
		subsidiaryRepository.save(subsidiary);
		checkPointRepository.save(checkpoint);
	}

	private void cargarTablasParametricas() {
		roundStateRepository.save(new RoundState("ACTIVE","Round active",true));
		roundStateRepository.save(new RoundState("DESACTIVE","Round desactive",true));
	}
}