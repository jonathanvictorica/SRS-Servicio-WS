package com.utn.frba.srs.round.application;

import java.io.Serializable;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utn.frba.srs.round.application.RoundCreateHandler.RoundCreateCommand;
import com.utn.frba.srs.round.domain.Round;
import com.utn.frba.srs.round.domain.RoundRepository;
import com.utn.frba.srs.shared.domain.crqs.Command;
import com.utn.frba.srs.shared.domain.crqs.CommandHandler;

import lombok.Data;

@Service
public class RoundCreateHandler implements CommandHandler<RoundCreateCommand>{

	private Round round;

	private RoundCreateCommandMapper roundMapper = Mappers.getMapper(RoundCreateCommandMapper.class);

	@Autowired
	private RoundCreateHandler(RoundRepository roundRepository) {
		round = new Round(roundRepository);
	}

	public void invoke(RoundCreateCommand data) {
		round.create(roundMapper.roundCreateCommandToRound(data));
	}

	@Data
	public static class RoundCreateCommand implements Serializable, Command {

		private static final long serialVersionUID = 1L;
	
		private Long id;

		private Long subsidiaryId;

		private String name;

		private String description;

		private List<RoundCreateCommand.RoundCheckpoint> checkpoints;

		private List<RoundCreateCommand.RoundRoute> routes;

		private Ubication ubication;

		private String zoomUbication = "0";

		private Integer roundTime;

		@Data
		public static class RoundCheckpoint implements Serializable {

			private static final long serialVersionUID = 1L;

			private RoundCreateCommand.RoundCheckpoint.Checkpoint checkpoint;

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

			private RoundCreateCommand.Ubication ubication;

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
	public abstract Round roundCreateCommandToRound(RoundCreateCommand data);

}