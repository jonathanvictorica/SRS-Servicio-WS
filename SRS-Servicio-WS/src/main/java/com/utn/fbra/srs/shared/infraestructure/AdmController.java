package com.utn.fbra.srs.shared.infraestructure;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

public interface AdmController<RC, RM, RE> {

	@PostMapping(path = "/crear")
	public void crear(RC request) throws Exception;

	@PutMapping(path = "/modificar")
	public void modificar(RM request) throws Exception;

	@DeleteMapping(path = "/eliminar")
	public void eliminar(RE request) throws Exception;

}
