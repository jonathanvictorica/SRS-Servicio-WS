package com.utn.frba.srs.subsidiary.infraestructure.persistence.repository;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.utn.frba.srs.subsidiary.domain.Subsidiary;
import com.utn.frba.srs.subsidiary.domain.SubsidiaryRepository;
import com.utn.frba.srs.subsidiary.infraestructure.persistence.entity.SubsidiaryEntity;

@Service
public class HibernateSubsidiaryRepository implements SubsidiaryRepository {

	private EntityMapper entityFactory = Mappers.getMapper(EntityMapper.class);

	@Autowired
	private SubsidiaryJpaRepository hibernateSubsidiaryRepository;

	@Override
	public Subsidiary findById(Long id) {
		return entityFactory.subsidiaryEntityToSubsidiary(hibernateSubsidiaryRepository.findById(id).orElse(null));
	}

}

@Mapper
interface EntityMapper {

	public abstract SubsidiaryEntity subsidiaryToSubsidiaryEntity(Subsidiary round);

	public abstract Subsidiary subsidiaryEntityToSubsidiary(SubsidiaryEntity round);

}

@Repository
interface SubsidiaryJpaRepository extends JpaRepository<SubsidiaryEntity, Long> {

}
