package com.utn.frba.srs.service;

import com.utn.frba.srs.model.Round;

public interface AdmRoundUseCasePort {

	void create(Round transformerInverse);

	void delete(Long id);

}
