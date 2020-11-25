package com.utn.frba.srs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utn.frba.srs.exception.NotFoundException;
import com.utn.frba.srs.model.Subsidiary;
import com.utn.frba.srs.model.Ubication;
import com.utn.frba.srs.repository.SubsidiaryRepository;
import com.utn.frba.srs.service.AdmSubsidiaryUseCasePort;

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
