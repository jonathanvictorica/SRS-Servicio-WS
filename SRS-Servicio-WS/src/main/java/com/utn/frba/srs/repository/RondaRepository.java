package com.utn.frba.srs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.utn.frba.srs.model.Round;

@Repository
public interface RondaRepository extends JpaRepository<Round, Long> {

}
