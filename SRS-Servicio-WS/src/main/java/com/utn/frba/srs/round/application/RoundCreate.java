package com.utn.frba.srs.round.application;

import java.io.Serializable;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utn.frba.srs.round.application.RoundCreate.RoundCreateCommand;
import com.utn.frba.srs.round.domain.Round;
import com.utn.frba.srs.round.domain.RoundRepository;

import lombok.Data;

@Service
public class RoundCreate {

	private Round round;

	private RoundCreateCommandMapper roundMapper = Mappers.getMapper(RoundCreateCommandMapper.class);

	@Autowired
	private RoundCreate(RoundRepository roundRepository) {
		round = new Round(roundRepository);
	}

	public void invoke(RoundCreateCommand data) {
		round.create(roundMapper.roundCreateCommandToRound(data));
	}
	
	
	@Data
	public static class RoundCreateCommand implements Serializable {

		private static final long serialVersionUID = 1L;

		private String name;

		private String description;

		private List<RoundCreateCommand.RoundCheckpointDTO> checkpoints;

		private List<RoundCreateCommand.RoundRouteDTO> routes;

		private UbicationDTO ubication;

		private String zoomUbication = "0";

		private Integer roundTime;

		private Long userId;

		@Data
		public static class RoundSubsidiaryDTO implements Serializable {

			private static final long serialVersionUID = 1L;

			private Long id;

		}

		@Data
		public static class RoundStateDTO implements Serializable {

			private static final long serialVersionUID = 1L;

			private String name;

		}

		@Data
		public static class RoundCheckpointDTO implements Serializable {

			private static final long serialVersionUID = 1L;

			private RoundCreateCommand.RoundCheckpointDTO.CheckpointDTO checkpoint;

			private Integer executionOrder;

			@Data
			public static class CheckpointDTO implements Serializable {
				private static final long serialVersionUID = 1L;

				private Long id;

			}

		}

		@Data
		public static class RoundRouteDTO implements Serializable {

			private static final long serialVersionUID = 1L;

			private int routeOrder;

			private UbicationDTO ubication;

		}

		@Data
		public static class UbicationDTO implements Serializable {

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


