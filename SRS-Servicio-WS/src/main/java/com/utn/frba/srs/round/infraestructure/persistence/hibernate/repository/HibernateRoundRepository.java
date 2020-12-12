package com.utn.frba.srs.round.infraestructure.persistence.hibernate.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.utn.frba.srs.round.infraestructure.persistence.hibernate.entity.RoundEntity;

public interface HibernateRoundRepository extends JpaRepository<RoundEntity, Long> {

	@Query("delete from RoundCheckpointEntity where round.id = ?1 ")
	@Modifying
	void deleteCheckpoints(Long roundId);
	
	@Query("delete from RoundRouteEntity where round.id = ?1 ")
	@Modifying
	void deleteRoutes(Long roundId);

	@Query("update RoundEntity set s where round.roundState = ?2 ")
	@Modifying
	void updateRountState(String id, String string);

	List<RoundEntity> findBySubsidiary_id(Long subsidiaryId);

	List<RoundEntity> findBySubsidiary_SecurityCompanyCustomer_id(Long securityCompanyCustomerId);

	RoundEntity findBySubsidiary_idAndName(Long subsidiaryId, String roundName);

	
}
