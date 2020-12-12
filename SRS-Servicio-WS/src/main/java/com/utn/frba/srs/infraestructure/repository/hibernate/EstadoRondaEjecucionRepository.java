package com.utn.frba.srs.infraestructure.repository.hibernate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.utn.frba.srs.checkpoint.infraestructure.persistence.hibernate.entity.Checkpoint;

@Repository
public interface EstadoRondaEjecucionRepository extends JpaRepository<Checkpoint, Long> {

}
