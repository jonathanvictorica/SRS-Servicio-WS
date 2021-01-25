package com.utn.frba.srs.checkpoint.application;

import java.io.Serializable;
import java.util.UUID;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utn.frba.srs.checkpoint.application.UpdateCheckpointUbication.UpdateCheckpointUbicationCommand;
import com.utn.frba.srs.checkpoint.domain.Checkpoint;
import com.utn.frba.srs.checkpoint.domain.CheckpointRepository;
import com.utn.frba.srs.shared.domain.DomainException;
import com.utn.frba.srs.shared.domain.NotFoundException;
import com.utn.frba.srs.shared.domain.crqs.Command;
import com.utn.frba.srs.shared.domain.crqs.CommandHandler;

import lombok.Data;

@Service
public class UpdateCheckpointUbication implements CommandHandler<UpdateCheckpointUbicationCommand> {

	private UpdateCheckpointUbicationCommandMapper checkpointMapper = Mappers
			.getMapper(UpdateCheckpointUbicationCommandMapper.class);

	private CheckpointRepository checkpointRepository;

	@Autowired
	public UpdateCheckpointUbication(CheckpointRepository checkpointRepository) {
		super();
		this.checkpointRepository = checkpointRepository;
	}

	public void invoke(UpdateCheckpointUbicationCommand data) throws DomainException {
		Checkpoint checkpoint = checkpointMapper.fromUpdateCheckpointUbicationCommand(data);
		checkpointRepository.findById(checkpoint.getId()).orElseThrow(NotFoundException::new);
		checkpointRepository.updateUbication(checkpoint);
	}

	@Data
	public static class UpdateCheckpointUbicationCommand implements Serializable, Command {

		private static final long serialVersionUID = 1L;
		private UUID id;
		private UpdateCheckpointUbicationCommand.Ubication ubication;

		@Data
		public static class Ubication implements Serializable {

			private static final long serialVersionUID = 1L;
			private String latitude;
			private String longitude;

		}
	}

}

@Mapper
interface UpdateCheckpointUbicationCommandMapper {
	public abstract Checkpoint fromUpdateCheckpointUbicationCommand(UpdateCheckpointUbicationCommand data);

}