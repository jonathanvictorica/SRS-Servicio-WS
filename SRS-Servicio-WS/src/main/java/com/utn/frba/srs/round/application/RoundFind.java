package com.utn.frba.srs.round.application;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utn.frba.srs.infraestructure.controller.dto.RoundDTO;
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
		return roundMapper.roundToRoundQuery(round.findBySubsidiaryAndName(subsidiaryId,roundName));		
	}

	public List<RoundQuery> findBySecurityCompanyCustomer(Long securityCompanyCustomerId) {
		return round.findBySecurityCompanyCustomer(securityCompanyCustomerId).stream()
				.map(a -> roundMapper.roundToRoundQuery(a)).collect(Collectors.toList());
	}

	@Data
	public static class RoundQuery implements Serializable {

		private static final long serialVersionUID = 1L;

		private String name;

		private String description;

		private List<RoundDTO.RoundCheckpointDTO> checkpoints;

		private List<RoundDTO.RoundRouteDTO> routes;

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

			private RoundDTO.RoundCheckpointDTO.CheckpointDTO checkpoint;

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
interface RoundQueryMapper {
	public abstract RoundQuery roundToRoundQuery(Round data);

}
