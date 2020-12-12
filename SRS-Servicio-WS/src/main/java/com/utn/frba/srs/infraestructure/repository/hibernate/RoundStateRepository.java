package com.utn.frba.srs.infraestructure.repository.hibernate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import round.domain.RoundState;

@Repository
public interface RoundStateRepository extends JpaRepository<RoundState, Long> {

}
