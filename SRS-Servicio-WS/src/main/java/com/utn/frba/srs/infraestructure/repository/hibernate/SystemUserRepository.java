package com.utn.frba.srs.infraestructure.repository.hibernate;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.utn.frba.srs.domain.model.SystemUser;

@Repository
public interface SystemUserRepository extends CrudRepository<SystemUser, Long> {

	Optional<SystemUser> findByDocumentTypeAndDocumentNumber(String documentType, String documentNumber);

	Optional<SystemUser> findByNick(String nick);

	List<SystemUser> findBySecurityCompany(Long securityCompanyId);

	Optional<SystemUser> findByDocumentNumber(String documentNumber);

	List<SystemUser> findByBloqueadedUser(boolean esBloqueado);

	Optional<List<SystemUser>> findByRoleLevel1(String rolName);

	Optional<List<SystemUser>> findByRoleLevel2(String rolName);

	Optional<List<SystemUser>> findByRoleLevel3(String rolName);

}
