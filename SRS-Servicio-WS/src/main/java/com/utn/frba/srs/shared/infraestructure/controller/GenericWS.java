package com.utn.frba.srs.shared.infraestructure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.utn.frba.srs.shared.domain.crqs.CommandBus;

@CrossOrigin("*")
public class GenericWS {

	@Autowired
	@Qualifier("AsynSpringCommandBus")
	protected CommandBus commandBusAsync;
	
	@Autowired
	protected CommandBus commandBusSync;
}
