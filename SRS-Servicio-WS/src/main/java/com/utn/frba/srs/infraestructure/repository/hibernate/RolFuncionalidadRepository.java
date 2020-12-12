package com.utn.frba.srs.infraestructure.repository.hibernate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.utn.frba.srs.user.domain.infraestructure.persistence.hibernate.entity.FuncionalityRol;

@Repository
public interface RolFuncionalidadRepository extends JpaRepository<FuncionalityRol, Long> {

}
