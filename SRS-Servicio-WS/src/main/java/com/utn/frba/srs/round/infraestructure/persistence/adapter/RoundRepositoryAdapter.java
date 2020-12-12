package com.utn.frba.srs.round.infraestructure.persistence.adapter;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utn.frba.srs.round.domain.Round;
import com.utn.frba.srs.round.domain.RoundRepository;
import com.utn.frba.srs.round.infraestructure.persistence.hibernate.entity.RoundEntity;
import com.utn.frba.srs.round.infraestructure.persistence.hibernate.repository.HibernateRoundRepository;

@Service
public class RoundRepositoryAdapter implements RoundRepository {

	private EntityMapper entityFactory = Mappers.getMapper(EntityMapper.class);

	@Autowired
	private HibernateRoundRepository hibernateRoundRepository;

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
	public void delete(String id) {
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

	public abstract Round roundEntityToRound(RoundEntity findById);

}
