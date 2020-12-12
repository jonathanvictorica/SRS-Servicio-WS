package com.utn.frba.srs.user.infraestructure.persistence.hibernate.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.utn.frba.srs.user.infraestructure.persistence.hibernate.entity.SystemUserRol;

@Repository
public interface SystemUserRolRepository extends JpaRepository<SystemUserRol, Long> {

	Optional<SystemUserRol> findByName(String unit);

}
