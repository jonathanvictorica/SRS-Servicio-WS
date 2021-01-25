package com.utn.frba.srs.shared.domain.crqs;

import com.utn.frba.srs.shared.domain.DomainException;

public interface CommandBus {

	  void invoke(Command command) throws DomainException ;
}
