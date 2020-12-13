package com.utn.frba.srs.shared.domain.crqs;

public interface CommandBus {

	  void invoke(Command command) throws Exception ;
}
