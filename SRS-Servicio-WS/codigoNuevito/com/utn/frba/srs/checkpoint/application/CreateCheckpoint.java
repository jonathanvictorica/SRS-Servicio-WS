package com.utn.frba.srs.checkpoint.application;

import java.io.Serializable;
import java.util.UUID;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utn.frba.srs.checkpoint.application.CreateCheckpoint.CreateCheckpointCommand;
import com.utn.frba.srs.checkpoint.domain.Checkpoint;
import com.utn.frba.srs.checkpoint.domain.CheckpointRepository;
import com.utn.frba.srs.checkpoint.domain.NfcIdentificationExists;
import com.utn.frba.srs.shared.domain.DomainEventBUS;
import com.utn.frba.srs.shared.domain.DomainException;
import com.utn.frba.srs.shared.domain.crqs.Command;
import com.utn.frba.srs.shared.domain.crqs.CommandHandler;
import com.utn.frba.srs.shared.domain.crqs.QueryBus;
import com.utn.frba.srs.subsidiary.application.FindSubsidiaryByIdHandler;

import lombok.Data;

@Service
public class CreateCheckpoint implements CommandHandler<CreateCheckpointCommand> {

	private CheckpointCreateCommandMapper checkpointMapper = Mappers.getMapper(CheckpointCreateCommandMapper.class);

	private CheckpointRepository checkpointRepository;
	private QueryBus queryBus;
	private DomainEventBUS domainEventBUS;

	@Autowired
	public CreateCheckpoint(CheckpointRepository checkpointRepository, QueryBus queryBus,
			DomainEventBUS domainEventBUS) {
		super();
		this.checkpointRepository = checkpointRepository;
		this.queryBus = queryBus;
		this.domainEventBUS = domainEventBUS;
	}

	public void invoke(CreateCheckpointCommand data) throws DomainException {
		Checkpoint checkpoint = checkpointMapper.fromCheckpointCreateCommand(data);

		queryBus.ask(new FindSubsidiaryByIdHandler.FindSubsidiaryByIdQuery(checkpoint.getSubsidiaryId()));

		checkpointRepository.findByNfcIdentification(checkpoint.getNfcIdentification())
				.orElseThrow(NfcIdentificationExists::new);
		
		checkpointRepository.save(checkpoint);

		checkpoint.createCheckpointCreatedDomainEvent();
		domainEventBUS.publish(checkpoint.pullEventDomain());
	}

	@Data
	public static class CreateCheckpointCommand implements Serializable, Command {

		private static final long serialVersionUID = 1L;
		private UUID id;
		private String nfcIdentification;
		private CreateCheckpointCommand.Ubication ubication;
		private UUID subsidiaryId;

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
	public abstract Checkpoint fromCheckpointCreateCommand(CreateCheckpointCommand data);

}