package com.utn.frba.srs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.utn.frba.srs.model.ServiceLogger;

@Repository
public interface LogueoServicioOperacionRepository extends JpaRepository<ServiceLogger, Long> {

}
