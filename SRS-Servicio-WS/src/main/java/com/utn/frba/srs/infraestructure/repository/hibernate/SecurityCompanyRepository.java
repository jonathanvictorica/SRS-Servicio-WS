package com.utn.frba.srs.infraestructure.repository.hibernate;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.utn.frba.srs.domain.model.SecurityCompany;

@Repository
public interface SecurityCompanyRepository extends CrudRepository<SecurityCompany, Long> {

	Optional<SecurityCompany> findByDocumentTypeAndDocumentNumber(String documentType, String documentNumber);

}
