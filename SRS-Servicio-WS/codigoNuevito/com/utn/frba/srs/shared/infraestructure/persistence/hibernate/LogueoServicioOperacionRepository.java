package com.utn.frba.srs.shared.infraestructure.persistence.hibernate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.utn.frba.srs.shared.infraestructure.persistence.entity.ServiceLogger;

@Repository
public interface LogueoServicioOperacionRepository extends JpaRepository<ServiceLogger, Long> {

}
