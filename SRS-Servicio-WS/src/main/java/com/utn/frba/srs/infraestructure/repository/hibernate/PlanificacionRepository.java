package com.utn.frba.srs.infraestructure.repository.hibernate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.utn.frba.srs.domain.model.Planning;

@Repository
public interface PlanificacionRepository extends JpaRepository<Planning, Long> {

}
