package com.utn.frba.srs.infraestructure.repository.hibernate;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.utn.frba.srs.round.domain.Round;

@Repository
public interface RoundRepository extends JpaRepository<Round, Long> {

	Optional<Round> findBySubsidiary_idAndName(Long subsidiaryId, String roundName);

	List<Round> findBySubsidiary_id(Long subsidiaryId);

	List<Round> findBySubsidiary_SecurityCompanyCustomer_id(Long securityCompanyCustomerId);

	void deleteCheckpointsAndRoutes(Long id);

}
