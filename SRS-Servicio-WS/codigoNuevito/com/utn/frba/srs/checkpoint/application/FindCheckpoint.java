package com.utn.frba.srs.checkpoint.application;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utn.frba.srs.checkpoint.application.FindCheckpoint.CheckpointCriteriaQuery;
import com.utn.frba.srs.checkpoint.application.FindCheckpoint.CheckpointsQuery;
import com.utn.frba.srs.checkpoint.application.FindCheckpoint.CheckpointsQuery.CheckpointQuery;
import com.utn.frba.srs.checkpoint.domain.Checkpoint;
import com.utn.frba.srs.checkpoint.domain.CheckpointRepository;
import com.utn.frba.srs.shared.domain.DomainException;
import com.utn.frba.srs.shared.domain.crqs.Query;
import com.utn.frba.srs.shared.domain.crqs.QueryHandler;

import lombok.AllArgsConstructor;
import lombok.Data;

@Service
public class FindCheckpoint implements QueryHandler<CheckpointsQuery, CheckpointCriteriaQuery> {

	protected CheckpointQueryMapper mapper = Mappers.getMapper(CheckpointQueryMapper.class);

	private CheckpointRepository checkpointRepository;

	@Autowired
	public FindCheckpoint(CheckpointRepository checkpointRepository) {
		super();
		this.checkpointRepository = checkpointRepository;
	}

	@Override
	public CheckpointsQuery ask(CheckpointCriteriaQuery query) throws DomainException {
		List<Checkpoint> checkpoints = checkpointRepository.findByCriteria(query.getId());
		return new CheckpointsQuery(checkpoints.stream().map(a -> mapper.fromCheckpoint(a)).collect(Collectors.toList()));
	}

	@Data
	@AllArgsConstructor
	public static class CheckpointCriteriaQuery implements Query<CheckpointsQuery> {
		private UUID id;
	}

	@Data
	@AllArgsConstructor
	public static class CheckpointsQuery implements Serializable {

		private List<CheckpointQuery> checkpoints;

		@Data
		public static class CheckpointQuery implements Serializable {

			private static final long serialVersionUID = 1L;

			private UUID id;

			private String nfcIdentification;

			private CheckpointQuery.Ubication ubication;

			private UUID subsidiaryId;

			@Data
			public static class Ubication implements Serializable {

				private static final long serialVersionUID = 1L;
				private String latitude;
				private String longitude;

			}

		}
	}

}

@Mapper
interface CheckpointQueryMapper {
	public abstract CheckpointQuery fromCheckpoint(Checkpoint data);

}
