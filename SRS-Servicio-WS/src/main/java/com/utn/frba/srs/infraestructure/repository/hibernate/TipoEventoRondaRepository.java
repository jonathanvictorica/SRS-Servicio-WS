package com.utn.frba.srs.infraestructure.repository.hibernate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.utn.frba.srs.domain.model.RoundEventType;

@Repository
public interface TipoEventoRondaRepository extends JpaRepository<RoundEventType, Long> {

}
