package com.utn.frba.srs.application5;

import org.springframework.validation.annotation.Validated;

import com.utn.frba.srs.infraestructure.controller.dto.UserDTO;

public interface AdmSystemUserUseCasePort {

	void create(@Validated UserDTO userDTO) ;

	void update(@Validated UserDTO userDTO) ;

	void delete(Long id) ;

}
