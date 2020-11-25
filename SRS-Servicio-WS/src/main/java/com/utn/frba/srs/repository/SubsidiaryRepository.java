package com.utn.frba.srs.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.utn.frba.srs.model.Subsidiary;

@Repository
public interface SubsidiaryRepository extends JpaRepository<Subsidiary, Long> {
	
	Optional<Subsidiary> findBySecurityCompanyCustomer_IdAndName(Long customerId, String name);

	List<Subsidiary> findBySecurityCompanyCustomer_Id(Long customerId);

}
