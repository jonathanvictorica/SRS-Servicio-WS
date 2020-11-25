package com.utn.frba.srs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.utn.frba.srs.model.RoundState;

@Repository
public interface EstadoRondaRepository extends JpaRepository<RoundState, Long> {

}
