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

	@Query("update RoundEntity set active = ?2 where id = ?1")
	@Modifying
	void deleteById(String id, Boolean active);

	List<RoundEntity> findBySubsidiaryId(Long subsidiaryId);

	RoundEntity findBySubsidiaryIdAndName(Long subsidiaryId, String roundName);

}
