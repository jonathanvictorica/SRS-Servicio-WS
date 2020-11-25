package com.utn.frba.srs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.utn.frba.srs.model.IncidentEventExecutionRound;

@Repository
public interface RondaEjecucionEventoIncidenteRepository extends JpaRepository<IncidentEventExecutionRound, Long> {

}