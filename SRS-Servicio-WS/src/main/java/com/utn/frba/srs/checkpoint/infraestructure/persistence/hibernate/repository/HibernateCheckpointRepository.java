package com.utn.frba.srs.checkpoint.infraestructure.persistence.hibernate.repository;

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
	public Checkpoint findByNfcIdentification(String nfcIdentification) {
		return mapper.checkpointEntityToCheckpoint(checkpointJpaRepository.findByNfcIdentification(nfcIdentification));
	}

	@Override
	public void deleteById(Long id) {
		checkpointJpaRepository.deleteById(id);

	}

	@Override
	public Checkpoint findById(Long id) throws NotFoundException {

		return mapper
				.checkpointEntityToCheckpoint(checkpointJpaRepository.findById(id).orElseThrow(NotFoundException::new));
	}

}

@Mapper
interface EntityMapper {

	public abstract CheckpointEntity checkpointToCheckpointEntity(Checkpoint round);

	public abstract Checkpoint checkpointEntityToCheckpoint(CheckpointEntity findById);

}

@Repository
interface CheckpointJpaRepository extends JpaRepository<CheckpointEntity, Long> {

	CheckpointEntity findByNfcIdentification(String nfcIdentification);

}
