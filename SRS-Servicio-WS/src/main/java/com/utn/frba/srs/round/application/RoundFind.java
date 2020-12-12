package com.utn.frba.srs.round.application;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utn.frba.srs.round.application.RoundFind.RoundQuery;
import com.utn.frba.srs.round.domain.Round;
import com.utn.frba.srs.round.domain.RoundRepository;

import lombok.Data;

@Service
public class RoundFind {

	private Round round;

	private RoundQueryMapper roundMapper = Mappers.getMapper(RoundQueryMapper.class);

	@Autowired
	private RoundFind(RoundRepository roundRepository) {
		round = new Round(roundRepository);
	}

	public RoundQuery findById(Long id) {
		return roundMapper.roundToRoundQuery(round.findById(id));
	}

	public List<RoundQuery> findBySubsidiary(Long subsidiaryId) {
		return round.findBySubsidiary(subsidiaryId).stream().map(a -> roundMapper.roundToRoundQuery(a))
				.collect(Collectors.toList());
	}

	public RoundQuery findBySubsidiaryAndName(Long subsidiaryId, String roundName) {
		return roundMapper.roundToRoundQuery(round.findBySubsidiaryAndName(subsidiaryId, roundName));
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
