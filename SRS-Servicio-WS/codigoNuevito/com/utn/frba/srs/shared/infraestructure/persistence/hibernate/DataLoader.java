package com.utn.frba.srs.shared.infraestructure.persistence.hibernate;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		
	}
//	@Autowired
//	private SystemUserRolRepository systemUserRolRepository;
//	@Autowired
//	private SystemUserRepository systemUserRepository;
//	@Autowired
//	private SecurityCompanyRepository securityCompanyRepository;
//	@Autowired
//	private ClienteEmpresaSeguridadRepository clienteEmpresaSeguridadRepository;
//	@Autowired
//	private CheckPointRepository checkPointRepository;
//	@Autowired
//	private SubsidiaryRepository subsidiaryRepository;
//	
//	@Autowired
//	private RoundStateRepository roundStateRepository;

//	public void run(ApplicationArguments args) {
//		if (systemUserRolRepository.findById(1L).isPresent()) {
//			return;
//		}
//		
//		cargarTablasParametricas();
//
//		SystemUserRol rol = new SystemUserRol(null, "Supervisor", "Supervisor de Rodnas", 1, null);
//		SystemUser user = new SystemUser(null, null, "jonathan", "Victorica", "DNI", "4566666", "jonathan.m@gmail.com",
//				rol, null, null, "jony", "jony", 0, false, true);
//		
//		Audit audit = new Audit(new Date(), user, null, null);
//		Domicile domicile = new Domicile(null, "calle", "12",
//				"departamento", "1", "ciudad", "dpto", "provincia", "argentina", null); 
//		
//		Domicile domicile2 = new Domicile(null, "calle", "12",
//				"departamento", "1", "ciudad", "dpto", "provincia", "argentina", null); 
//		
//		Domicile domicile3 = new Domicile(null, "calle", "12",
//				"departamento", "1", "ciudad", "dpto", "provincia", "argentina", null); 
//
//		SecurityCompany securityCompany = new SecurityCompany(null, "Empresa", "CUIT", "2012121212", domicile, true,
//				audit);
//
//		SecurityCompanyCustomer securityCompanyCustomer = new SecurityCompanyCustomer(
//				null, securityCompany, "Empresa Cliente", "CUIT", "966666",domicile2,
//				true, audit);
//		
//		Subsidiary subsidiary = new Subsidiary(null,"Sucursal","Sucursal Description",securityCompanyCustomer,domicile3,audit,true);
//		
//		Checkpoint checkpoint= new Checkpoint(null,"NFC",new Ubication("12222", "52222"),audit,subsidiary);
//
//		systemUserRolRepository.save(rol);
//		systemUserRepository.save(user);
//		securityCompanyRepository.save(securityCompany);
//		
//		clienteEmpresaSeguridadRepository.save(securityCompanyCustomer);	
//		subsidiaryRepository.save(subsidiary);
//		checkPointRepository.save(checkpoint);
//	}
//
//	private void cargarTablasParametricas() {
//		roundStateRepository.save(new RoundStateEntity("ACTIVE","Round active",true));
//		roundStateRepository.save(new RoundStateEntity("DESACTIVE","Round desactive",true));
//	}
}