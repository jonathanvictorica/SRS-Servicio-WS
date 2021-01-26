package com.utn.fbra.srs.infraestructure.persistence.hibernate.repository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.utn.fbra.srs.domain.DomainException;
import com.utn.fbra.srs.domain.model.ronda.RondaAR;
import com.utn.fbra.srs.domain.repository.RondaRepository;
import com.utn.fbra.srs.domain.vo.IdVO;
import com.utn.fbra.srs.infraestructure.persistence.hibernate.entity.RoundEntity;

public class RondaHibernate extends GenericHibernate<RoundEntity, UUID> implements RondaRepository {

	private RepositoryHibernate repository;

	@Autowired
	public RondaHibernate(RepositoryHibernate repository) {
		super();
		this.repository = repository;
	}

	@Override
	public void registrar(RondaAR ronda) {
		repository.save(RoundEntity.fromAggregateRoot(ronda));
	}

	@Override
	public void modificar(RondaAR ronda) {
		repository.save(RoundEntity.fromAggregateRoot(ronda));

	}

	@Override
	public void eliminar(RondaAR ronda) {
		repository.delete(RoundEntity.fromAggregateRoot(ronda));
	}

	@Override
	public RondaAR buscarPorId(IdVO id) throws DomainException {
		return RoundEntity.fromEntity(repository.findById(id.getId()).orElse(null));
	}

	@Override
	public List<RondaAR> buscarPorClienteID(IdVO clienteId) {
		return repository.findByClienteID(clienteId.getId()).stream().map(RoundEntity::fromEntity)
				.collect(Collectors.toList());
	}

}

interface RepositoryHibernate extends JpaRepository<RoundEntity, UUID>, CrudRepository<RoundEntity, UUID> {

	List<RoundEntity> findByClienteID(UUID id);

}
