package com.utn.frba.srs.checkpoint.domain;

import com.utn.frba.srs.shared.domain.DomainException;

public class NfcIdentificationExists extends DomainException {

	public NfcIdentificationExists() {
		super("Ya existe el NFC informado");
	}

}
