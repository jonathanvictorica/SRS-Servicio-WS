package com.utn.frba.srs.application.usecase.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utn.frba.srs.application5.AdmSubsidiaryUseCasePort;
import com.utn.frba.srs.domain.exception.NotFoundException;
import com.utn.frba.srs.domain.model.Subsidiary;
import com.utn.frba.srs.domain.model.Ubication;
import com.utn.frba.srs.infraestructure.repository.hibernate.SubsidiaryRepository;

@Service
public class AdmSubsidiaryUseCaseAdapter implements AdmSubsidiaryUseCasePort {

	@Autowired
	private SubsidiaryRepository subsidiaryRepository;

	@Override
	public void create(Subsidiary data) {
		subsidiaryRepository.save(data);

	}

	@Override
	public void update(Subsidiary data) {
		subsidiaryRepository.save(data);

	}

	@Override
	public void delete(Long id) {
		subsidiaryRepository.deleteById(id);

	}

	@Override
	public void updateUbication(Long subsidiaryId, String latitude, String longitude) throws NotFoundException {
		Subsidiary subsidiary = subsidiaryRepository.findById(subsidiaryId)
				.orElseThrow(() -> new NotFoundException(subsidiaryId + ""));
		subsidiary.getDomicile().setUbication(new Ubication(latitude,longitude));
		subsidiaryRepository.save(subsidiary);
	}

}
