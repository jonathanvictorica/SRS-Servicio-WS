package com.utn.frba.srs.service;

import com.utn.frba.srs.exception.NotFoundException;
import com.utn.frba.srs.model.Subsidiary;

public interface AdmSubsidiaryUseCasePort {

	void create(Subsidiary data);

	void update(Subsidiary data);

	void delete(Long id);

	void updateUbication(Long subsidiaryId, String latitude, String longitude) throws NotFoundException;

}
