package com.utn.frba.srs.round.infraestructure.persistence.hibernate.repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.utn.frba.srs.round.domain.model.Round;
import com.utn.frba.srs.round.domain.repository.RoundRepository;
import com.utn.frba.srs.round.infraestructure.persistence.hibernate.entity.RoundEntity;

@Service
public class HibernateRoundRepository implements RoundRepository {

	private EntityMapper entityFactory = Mappers.getMapper(EntityMapper.class);

	@Autowired
	private RoundJpaRepository hibernateRoundRepository;

	@Override
	public boolean existsById(Long id) {
		return hibernateRoundRepository.existsById(id);
	}

	@Override
	public void deleteCheckpointsAndRoutes(Long id) {
		hibernateRoundRepository.deleteCheckpoints(id);
		hibernateRoundRepository.deleteRoutes(id);
	}

	@Override
	public void save(Round data) {
		hibernateRoundRepository.save(entityFactory.roundToRoundEntity(data));
	}

	@Override
	public void delete(Long id) {
		hibernateRoundRepository.deleteById(id, false);

	}

	@Override
	public Optional<Round> findById(Long id) {
		return Optional
				.ofNullable(entityFactory.roundEntityToRound(hibernateRoundRepository.findById(id).orElse(null)));
	}

	@Override
	public List<Round> findBySubsidiaryId(Long subsidiaryId) {
		return hibernateRoundRepository.findBySubsidiaryId(subsidiaryId).stream()
				.map(a -> entityFactory.roundEntityToRound(a)).collect(Collectors.toList());
	}

	@Override
	public Round findBySubsidiaryIdAndName(Long subsidiaryId, String roundName) {
		return entityFactory
				.roundEntityToRound(hibernateRoundRepository.findBySubsidiaryIdAndName(subsidiaryId, roundName));
	}

}

@Mapper
interface EntityMapper {

	public abstract RoundEntity roundToRoundEntity(Round round);

	public abstract Round roundEntityToRound(RoundEntity round);

}

@Repository
interface RoundJpaRepository extends JpaRepository<RoundEntity, Long> {

	@Query("delete from RoundCheckpointEntity where round.id = ?1 ")
	@Modifying
	void deleteCheckpoints(Long roundId);

	@Query("delete from RoundRouteEntity where round.id = ?1 ")
	@Modifying
	void deleteRoutes(Long roundId);

	@Query("update RoundEntity set active = ?2 where id = ?1")
	@Modifying(clearAutomatically = true)
	@Transactional
	void deleteById(Long id, Boolean active);

	List<RoundEntity> findBySubsidiaryId(Long subsidiaryId);

	RoundEntity findBySubsidiaryIdAndName(Long subsidiaryId, String roundName);

}
