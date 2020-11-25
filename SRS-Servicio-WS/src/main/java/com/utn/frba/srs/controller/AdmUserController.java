package com.utn.frba.srs.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.utn.frba.srs.controller.dto.RequestGeneric;
import com.utn.frba.srs.controller.dto.ResponseGeneric;
import com.utn.frba.srs.controller.dto.RolUsuarioDTO;
import com.utn.frba.srs.controller.dto.UserDTO;
import com.utn.frba.srs.exception.SRSException;
import com.utn.frba.srs.model.SystemUser;

public interface AdmUserController {
	@PostMapping(path = "/usuario")
	public void create(@Valid @RequestBody RequestGeneric<UserDTO> request) throws SRSException;

	@PutMapping(path = "/usuario")
	public void update(@RequestBody RequestGeneric<UserDTO> request) throws SRSException;

	@DeleteMapping(path = "/usuario/{id}")
	public void delete(@PathVariable("id") Long id) throws SRSException;

	@GetMapping(path = "/usuarios/idEmpresa/{idEmpresa}")
	public ResponseGeneric<List<UserDTO>> findBySecurityCompany(@PathVariable("idEmpresa") Long idEmpresa)
			throws SRSException;

	@GetMapping(path = "/usuario/{id}")
	public ResponseGeneric<UserDTO> findById(@PathVariable("id") Long id) throws SRSException;

	@GetMapping(path = "/usuario/numeroDocumento/{numeroDocumento}")
	public ResponseGeneric<UserDTO> findByDocumentNumber(@PathVariable("numeroDocumento") String numeroDocumento)
			throws SRSException;

	@GetMapping(path = "/usuarios/{nombreRol}")
	public ResponseGeneric<List<UserDTO>> findByRol(@PathVariable("nombreRol") String nombreRol)
			throws SRSException;

	@GetMapping(path = "/usuarios/roles")
	public ResponseGeneric<List<RolUsuarioDTO>> listarRoles() throws SRSException;

	@PutMapping(path = "/usuario/{id}")
	public void unlockUser(@PathVariable("id") Long id) throws SRSException;

	@PutMapping(path = "/usuario/{id}/{nuevaClave}")
	public void changePassword(@PathVariable("id") Long id, @PathVariable("nuevaClave") String nuevaClave) throws SRSException;

	@GetMapping(path = "/usuarios/{nickUsuario}/{clave}")
	public ResponseGeneric<UserDTO> validateCredential(@PathVariable("nickUsuario") String nickUsuario,
			@PathVariable("clave") String clave) throws SRSException;

	@GetMapping(path = "/usuarios/bloqueados")
	public ResponseGeneric<List<UserDTO>> findBlockedUsers() throws SRSException;

}
