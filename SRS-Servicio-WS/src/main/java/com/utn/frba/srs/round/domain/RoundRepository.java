package com.utn.frba.srs.round.domain;

import java.util.List;
import java.util.Optional;

public interface RoundRepository {

	boolean existsById(Long id);

	void deleteCheckpointsAndRoutes(Long id);

	void save(Round data);

	void delete(String id);

	Optional<Round> findById(Long id);

	List<Round> findBySubsidiary_id(Long subsidiaryId);

	List<Round> findBySubsidiary_SecurityCompanyCustomer_id(Long securityCompanyCustomerId);

	Round findBySubsidiary_idAndName(Long subsidiaryId, String roundName);

}
