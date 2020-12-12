package com.utn.frba.srs.roundexecute.infraestructure.persistence.hibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.utn.frba.srs.roundexecute.infraestructure.persistence.hibernate.entity.RoundEventType;

@Repository
public interface TipoEventoRondaRepository extends JpaRepository<RoundEventType, Long> {

}
