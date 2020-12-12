package com.utn.frba.srs.user.infraestructure.persistence.hibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.utn.frba.srs.user.infraestructure.persistence.hibernate.entity.FuncionalityRol;

@Repository
public interface RolFuncionalidadRepository extends JpaRepository<FuncionalityRol, Long> {

}
