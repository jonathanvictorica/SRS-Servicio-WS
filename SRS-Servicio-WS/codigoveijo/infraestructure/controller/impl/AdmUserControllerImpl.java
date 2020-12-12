package com.utn.frba.srs.infraestructure.controller.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.utn.frba.srs.application5.ActionsSystemUserUseCasePort;
import com.utn.frba.srs.application5.AdmSystemUserUseCasePort;
import com.utn.frba.srs.application5.QuerySystemUserRoleUseCasePort;
import com.utn.frba.srs.application5.QuerySystemUserUseCasePort;
import com.utn.frba.srs.infraestructure.controller.AdmUserController;
import com.utn.frba.srs.infraestructure.controller.dto.RequestGeneric;
import com.utn.frba.srs.infraestructure.controller.dto.ResponseGeneric;
import com.utn.frba.srs.infraestructure.controller.dto.RolUsuarioDTO;
import com.utn.frba.srs.infraestructure.controller.dto.UserDTO;
import com.utn.frba.srs.infraestructure.controller.mapper.RolMapper;
import com.utn.frba.srs.infraestructure.controller.mapper.UserMapper;
import com.utn.frba.srs.shared.domain.SRSException;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(path = "/v1")
@Api(tags = "AdmUser", description = ("AdmUser"))
public class AdmUserControllerImpl extends GenericWS implements AdmUserController {

	@Autowired
	private AdmSystemUserUseCasePort admSystemUserUseCasePort;

	@Autowired
	private ActionsSystemUserUseCasePort actionsSystemUserUseCasePort;

	@Autowired
	private QuerySystemUserUseCasePort querySystemUserUseCasePort;

	@Autowired
	private QuerySystemUserRoleUseCasePort querySystemUserRoleUseCasePort;

	private UserMapper userMapper = Mappers.getMapper(UserMapper.class);
	private RolMapper rolMapper = Mappers.getMapper(RolMapper.class);

	@Override
	public void create(RequestGeneric<UserDTO> userDTO) throws SRSException {
		admSystemUserUseCasePort.create(userDTO.getData());
	}

	@Override
	public void update(RequestGeneric<UserDTO> userDTO) throws SRSException {
		admSystemUserUseCasePort.update(userDTO.getData());

	}

	@Override
	public void delete(Long id) throws SRSException {
		admSystemUserUseCasePort.delete(id);
	}

	@Override
	public ResponseGeneric<List<UserDTO>> findBySecurityCompany(Long securityCompanyId) throws SRSException {
		ResponseGeneric<List<UserDTO>> response = new ResponseGeneric<>();
		response.setData(querySystemUserUseCasePort.findBySecurityCompany(securityCompanyId).stream()
				.map(a -> userMapper.transformer(a)).collect(Collectors.toList()));
		return response;
	}

	@Override
	public ResponseGeneric<UserDTO> findById(Long id) throws SRSException {

		ResponseGeneric<UserDTO> response = new ResponseGeneric<>();
		response.setData(userMapper.transformer(querySystemUserUseCasePort.findById(id)));
		return response;
	}

	@Override
	public ResponseGeneric<UserDTO> findByDocumentNumber(String documentNumber) throws SRSException {
		ResponseGeneric<UserDTO> response = new ResponseGeneric<>();
		response.setData(userMapper.transformer(querySystemUserUseCasePort.findByDocumentNumber(documentNumber)));
		return response;

	}

	@Override
	public ResponseGeneric<List<UserDTO>> findByRol(String rolName) throws SRSException {
		ResponseGeneric<List<UserDTO>> response = new ResponseGeneric<>();
		response.setData(querySystemUserUseCasePort.findByRol(rolName).stream().map(a -> userMapper.transformer(a))
				.collect(Collectors.toList()));
		return response;
	}

	@Override
	public ResponseGeneric<List<UserDTO>> findBlockedUsers() throws SRSException {
		ResponseGeneric<List<UserDTO>> response = new ResponseGeneric<>();
		response.setData(querySystemUserUseCasePort.findBlockedUsers().stream().map(a -> userMapper.transformer(a))
				.collect(Collectors.toList()));
		return response;
	}

	@Override
	public ResponseGeneric<List<RolUsuarioDTO>> listarRoles() throws SRSException {
		ResponseGeneric<List<RolUsuarioDTO>> response = new ResponseGeneric<>();
		response.setData(querySystemUserRoleUseCasePort.allRoles().stream().map(a -> rolMapper.transformer(a))
				.collect(Collectors.toList()));
		return response;
	}

	@Override
	public void unlockUser(Long id) throws SRSException {
		actionsSystemUserUseCasePort.unlockUser(id);

	}

	@Override
	public void changePassword(Long userId, String password) throws SRSException {
		actionsSystemUserUseCasePort.changePassword(userId, password);

	}

	@Override
	public ResponseGeneric<UserDTO> validateCredential(String nick, String password) throws SRSException {
		ResponseGeneric<UserDTO> response = new ResponseGeneric<>();
		response.setData(userMapper.transformer(actionsSystemUserUseCasePort.validateCredential(nick, password)));
		return response;
	}

}
