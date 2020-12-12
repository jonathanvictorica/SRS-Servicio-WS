package com.utn.frba.srs.roundexecute.infraestructure.persistence.hibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.utn.frba.srs.roundexecute.infraestructure.persistence.hibernate.entity.RoundPlanning;

@Repository
public interface RondaPlanificacionRepository extends JpaRepository<RoundPlanning, Long> {

}
