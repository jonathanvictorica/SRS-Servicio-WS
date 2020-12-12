package com.utn.frba.srs.infraestructure.repository.hibernate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.utn.frba.srs.round.domain.RoundCheckpoint;

@Repository
public interface CheckpointRoundRepository extends JpaRepository<RoundCheckpoint, Long> {

	@Modifying
	@Query("delete from CheckpointRound t where t.id = (select k.id from Round k where k.id= ?1)")
	void deleteByRoundId(Long id);

}
