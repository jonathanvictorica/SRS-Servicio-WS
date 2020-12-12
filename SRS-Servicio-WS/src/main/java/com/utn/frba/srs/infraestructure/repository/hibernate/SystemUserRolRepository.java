package com.utn.frba.srs.infraestructure.repository.hibernate;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.utn.frba.srs.domain.model.SystemUserRol;

@Repository
public interface SystemUserRolRepository extends JpaRepository<SystemUserRol, Long> {

	Optional<SystemUserRol> findByName(String unit);

}
