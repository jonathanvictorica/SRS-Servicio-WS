package com.utn.frba.srs.application5;

import com.utn.frba.srs.domain.exception.NotFoundException;
import com.utn.frba.srs.domain.model.Subsidiary;

public interface AdmSubsidiaryUseCasePort {

	void create(Subsidiary data);

	void update(Subsidiary data);

	void delete(Long id);

	void updateUbication(Long subsidiaryId, String latitude, String longitude) throws NotFoundException;

}
