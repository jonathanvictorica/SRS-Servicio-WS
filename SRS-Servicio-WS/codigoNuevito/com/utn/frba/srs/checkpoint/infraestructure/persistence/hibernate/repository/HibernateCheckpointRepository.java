package com.utn.frba.srs.checkpoint.infraestructure.persistence.hibernate.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.utn.frba.srs.checkpoint.domain.Checkpoint;
import com.utn.frba.srs.checkpoint.domain.CheckpointRepository;
import com.utn.frba.srs.checkpoint.infraestructure.persistence.hibernate.entity.CheckpointEntity;
import com.utn.frba.srs.shared.domain.NotFoundException;

@Service
public class HibernateCheckpointRepository implements CheckpointRepository {

	private EntityMapper mapper = Mappers.getMapper(EntityMapper.class);

	@Autowired
	private CheckpointJpaRepository checkpointJpaRepository;

	@Override
	public void save(Checkpoint checkpoint) {
		checkpointJpaRepository.save(mapper.checkpointToCheckpointEntity(checkpoint));
	}

	@Override
	public Optional<Checkpoint> findByNfcIdentification(String nfcIdentification) {
		return Optional.ofNullable(mapper
				.checkpointEntityToCheckpoint(checkpointJpaRepository.findByNfcIdentification(nfcIdentification)));
	}

	@Override
	public void deleteById(UUID id) {
		checkpointJpaRepository.deleteById(id);

	}

	@Override
	public Optional<Checkpoint> findById(UUID id) throws NotFoundException {
		return Optional
				.ofNullable(mapper.checkpointEntityToCheckpoint(checkpointJpaRepository.findById(id).orElseGet(null)));
	}

	@Override
	public void updateUbication(Checkpoint checkpoint) {
		checkpointJpaRepository.updateUbication(mapper.checkpointToCheckpointEntity(checkpoint));

	}

	@Override
	public List<Checkpoint> findByCriteria(UUID id) {
		return checkpointJpaRepository.findByCriteria(id).stream().map(a -> mapper.checkpointEntityToCheckpoint(a))
				.collect(Collectors.toList());
	}

}

@Mapper
interface EntityMapper {

	public abstract CheckpointEntity checkpointToCheckpointEntity(Checkpoint round);

	public abstract Checkpoint checkpointEntityToCheckpoint(CheckpointEntity findById);

}

@Repository
interface CheckpointJpaRepository extends JpaRepository<CheckpointEntity, UUID> {

	CheckpointEntity findByNfcIdentification(String nfcIdentification);

	List<CheckpointEntity> findByCriteria(UUID id);

	void updateUbication(CheckpointEntity checkpointToCheckpointEntity);

}
