package com.utn.frba.srs.securitycompanycustomer.infraestructure.persistence.hibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.utn.frba.srs.securitycompanycustomer.infraestructure.persistence.hibernate.entity.SecurityCompanyCustomer;

@Repository
public interface ClienteEmpresaSeguridadRepository extends JpaRepository<SecurityCompanyCustomer, Long> {

}
