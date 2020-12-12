package com.utn.frba.srs.round.infraestructure.persistence.adapter;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utn.frba.srs.round.domain.Round;
import com.utn.frba.srs.round.domain.RoundCheckpoint;
import com.utn.frba.srs.round.domain.RoundRepository;
import com.utn.frba.srs.round.domain.RoundRoute;
import com.utn.frba.srs.round.infraestructure.persistence.hibernate.entity.RoundCheckpointEntity;
import com.utn.frba.srs.round.infraestructure.persistence.hibernate.entity.RoundEntity;
import com.utn.frba.srs.round.infraestructure.persistence.hibernate.entity.RoundRouteEntity;
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
		hibernateRoundRepository.updateRountState(id,"DES");
		
	}

}

@Mapper
interface EntityMapper {

	public abstract RoundEntity roundToRoundEntity(Round round);

	public abstract RoundCheckpointEntity roundCheckpointToRoundCheckpointEntity(RoundCheckpoint roundCheckpoint);

	public abstract RoundRouteEntity roundRouteToRoundRouteEntity(RoundRoute roundRoute);
	
	

}
