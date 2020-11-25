package com.utn.frba.srs.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.utn.frba.srs.model.SystemUserRol;

@Repository
public interface SystemUserRolRepository extends JpaRepository<SystemUserRol, Long> {

	Optional<SystemUserRol> findByName(String unit);

}
