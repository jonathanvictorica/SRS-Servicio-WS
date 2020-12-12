package com.utn.frba.srs.user.infraestructure.persistence.hibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.utn.frba.srs.user.infraestructure.persistence.hibernate.entity.SystemFuncionality;

@Repository
public interface FuncionalidadSistemaRepository extends JpaRepository<SystemFuncionality, Long> {

}
