package com.utn.frba.srs.infraestructure.repository.hibernate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.utn.frba.srs.shared.infraestructure.persistence.entity.Domicile;

@Repository
public interface DomicilioRepository extends JpaRepository<Domicile, Long> {

}
