package com.utn.frba.srs.round.application;

import java.io.Serializable;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.utn.frba.srs.round.application.FindRound.RoundQuery;
import com.utn.frba.srs.round.domain.model.Round;
import com.utn.frba.srs.round.domain.repository.RoundRepository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public abstract class FindRound {

	
	protected RoundQueryMapper roundMapper = Mappers.getMapper(RoundQueryMapper.class);

	protected FindRound(RoundRepository roundRepository) {
		Round.injectRepository(roundRepository);
	}

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class RoundListQuery implements Serializable {
		private static final long serialVersionUID = 1L;
		private List<RoundQuery> rounds;
	}

	@Data
	public static class RoundQuery implements Serializable {

		private static final long serialVersionUID = 1L;

		private Long id;

		private Long subsidiaryId;

		private String name;

		private String description;

		private List<RoundQuery.RoundCheckpoint> checkpoints;

		private List<RoundQuery.RoundRoute> routes;

		private Ubication ubication;

		private String zoomUbication = "0";

		private Integer roundTime;

		@Data
		public static class RoundCheckpoint implements Serializable {

			private static final long serialVersionUID = 1L;

			private Long id;

			private RoundQuery.RoundCheckpoint.Checkpoint checkpoint;

			private Integer executionOrder;

			@Data
			public static class Checkpoint implements Serializable {

				private static final long serialVersionUID = 1L;

				private Long id;

				private String nfcIdentification;

				private Ubication ubication;
			}
		}

		@Data
		public static class RoundRoute implements Serializable {

			private static final long serialVersionUID = 1L;

			private Long id;

			private int routeOrder;

			private RoundQuery.Ubication ubication;

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
interface RoundQueryMapper {
	public abstract RoundQuery roundToRoundQuery(Round data);

}
