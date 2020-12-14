package com.utn.frba.srs.checkpoint.application;

import java.io.Serializable;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utn.frba.srs.checkpoint.application.CheckpointFindByIdHandler.CheckpointFindByIdQuery;
import com.utn.frba.srs.checkpoint.application.CheckpointFindByIdHandler.CheckpointQuery;
import com.utn.frba.srs.checkpoint.domain.Checkpoint;
import com.utn.frba.srs.checkpoint.domain.CheckpointRepository;
import com.utn.frba.srs.shared.domain.DomainException;
import com.utn.frba.srs.shared.domain.crqs.Query;
import com.utn.frba.srs.shared.domain.crqs.QueryHandler;

import lombok.AllArgsConstructor;
import lombok.Data;

@Service
public class CheckpointFindByIdHandler implements QueryHandler<CheckpointQuery, CheckpointFindByIdQuery> {
	protected Checkpoint checkpoint;

	protected CheckpointQueryMapper mapper = Mappers.getMapper(CheckpointQueryMapper.class);

	@Autowired
	private CheckpointFindByIdHandler(CheckpointRepository checkpointRepository) {
		checkpoint = new Checkpoint(checkpointRepository);
	}

	@Override
	public CheckpointQuery ask(CheckpointFindByIdQuery query) throws DomainException {
		return mapper.roundToCheckpointQuery(checkpoint.findById(query.getId()));
	}

	@Data
	@AllArgsConstructor
	public static class CheckpointFindByIdQuery implements Query<CheckpointQuery> {
		private Long id;
	}

	@Data
	public static class CheckpointQuery implements Serializable {

		private static final long serialVersionUID = 1L;

		private Long id;

		private String nfcIdentification;

		private CheckpointQuery.Ubication ubication;

		private Long subsidiaryId;
		
		@Data
		public static class Ubication implements Serializable {

			private static final long serialVersionUID = 1L;
			private String latitude;
			private String longitude;

		}

	}

}


@Mapper
interface CheckpointQueryMapper {
	public abstract CheckpointQuery roundToCheckpointQuery(Checkpoint data);

}
