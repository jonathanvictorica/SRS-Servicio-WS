package com.utn.frba.srs.service;

import org.springframework.validation.annotation.Validated;

import com.utn.frba.srs.controller.dto.UserDTO;
import com.utn.frba.srs.exception.SRSException;

public interface AdmSystemUserUseCasePort {

	void create(@Validated UserDTO userDTO) throws SRSException;

	void update(@Validated UserDTO userDTO) throws SRSException;

	void delete(Long id) throws SRSException;

}
