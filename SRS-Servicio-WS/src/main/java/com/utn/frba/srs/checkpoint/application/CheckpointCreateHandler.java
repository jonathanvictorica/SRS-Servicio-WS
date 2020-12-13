package com.utn.frba.srs.checkpoint.application;

import java.io.Serializable;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utn.frba.srs.checkpoint.application.CheckpointCreateHandler.CheckpointCreateCommand;
import com.utn.frba.srs.checkpoint.domain.Checkpoint;
import com.utn.frba.srs.checkpoint.domain.CheckpointRepository;
import com.utn.frba.srs.shared.domain.crqs.Command;
import com.utn.frba.srs.shared.domain.crqs.CommandHandler;

import lombok.Data;

@Service
public class CheckpointCreateHandler implements CommandHandler<CheckpointCreateCommand> {

	private Checkpoint checkpoint;

	private CheckpointCreateCommandMapper checkpointMapper = Mappers.getMapper(CheckpointCreateCommandMapper.class);

	@Autowired
	private CheckpointCreateHandler(CheckpointRepository checkpointRepository) {
		checkpoint = new Checkpoint(checkpointRepository);
	}

	public void invoke(CheckpointCreateCommand data) {
		checkpoint.create(checkpointMapper.checkpointCreateCommandToCheckpoint(data));
	}

	@Data
	public static class CheckpointCreateCommand implements Serializable, Command {

		private static final long serialVersionUID = 1L;
		private Long id;

		private String nfcIdentification;

		private CheckpointCreateCommand.Ubication ubication;

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
interface CheckpointCreateCommandMapper {
	public abstract Checkpoint checkpointCreateCommandToCheckpoint(CheckpointCreateCommand data);

}