package com.utn.frba.srs.round.application;

import java.io.Serializable;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utn.frba.srs.round.application.CreateRoundHandler.CreateRoundCommand;
import com.utn.frba.srs.round.domain.model.Round;
import com.utn.frba.srs.round.domain.repository.RoundRepository;
import com.utn.frba.srs.shared.domain.DomainEventBUS;
import com.utn.frba.srs.shared.domain.crqs.Command;
import com.utn.frba.srs.shared.domain.crqs.CommandHandler;

import lombok.Data;

@Service
public class CreateRoundHandler implements CommandHandler<CreateRoundCommand> {

	private RoundCreateCommandMapper roundMapper = Mappers.getMapper(RoundCreateCommandMapper.class);
	private DomainEventBUS bus;

	@Autowired
	private CreateRoundHandler(RoundRepository roundRepository, DomainEventBUS bus) {
		Round.injectRepository(roundRepository);
		this.bus = bus;
	}

	public void invoke(CreateRoundCommand data) {
		Round newRound = roundMapper.fromCreateRoundCommand(data);		
		Round.create(newRound);
		bus.publish(newRound.pullEventDomain());
	}

	@Data
	public static class CreateRoundCommand implements Serializable, Command {

		private static final long serialVersionUID = 1L;
		private Long id;
		private Long subsidiaryId;
		private String name;
		private String description;
		private List<CreateRoundCommand.RoundCheckpoint> checkpoints;
		private List<CreateRoundCommand.RoundRoute> routes;
		private Ubication ubication;
		private String zoomUbication = "0";
		private Integer roundTime;

		@Data
		public static class RoundCheckpoint implements Serializable {

			private static final long serialVersionUID = 1L;
			private CreateRoundCommand.RoundCheckpoint.Checkpoint checkpoint;
			private Integer executionOrder;

			@Data
			public static class Checkpoint implements Serializable {

				private static final long serialVersionUID = 1L;
				private Long id;

			}
		}

		@Data
		public static class RoundRoute implements Serializable {

			private static final long serialVersionUID = 1L;
			private int routeOrder;
			private CreateRoundCommand.Ubication ubication;

		}

		@Data
		public static class Ubication implements Serializable {

			private static final long serialVersionUID = 1L;
			private String latitude;
			private String longitude;
		}
	}

}

@Mapper
interface RoundCreateCommandMapper {
	public abstract Round fromCreateRoundCommand(CreateRoundCommand data);

}
