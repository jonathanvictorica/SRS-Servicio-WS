package com.utn.frba.srs.controller.dto;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class RoundDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private SubsidiaryDTO subsidiary;

	private String name;

	private String description;

	private RoundStateDTO roundState;

	private List<CheckpointRoundDTO> checkpoints;

	private List<RouteRoundDTO> routes;

	private UbicationDTO ubication;

	private String zoomUbication = "0";

	private Integer roundTime;

	@NotNull
	@ApiModelProperty(example = "1")
	private Long userId;

	@Data
	public static class SubsidiaryDTO implements Serializable {

		private static final long serialVersionUID = 1L;

		private Long id;

	}

	@Data
	public static class RoundStateDTO implements Serializable {

		private static final long serialVersionUID = 1L;

		private String name;

	}

	@Data
	public static class CheckpointRoundDTO implements Serializable {

		private static final long serialVersionUID = 1L;

		private Long id;

		private Long checkpointId;

		private Integer executionOrder;

	}

	@Data
	public static class RouteRoundDTO implements Serializable {

		private static final long serialVersionUID = 1L;

		private int routeOrder;

		private UbicationDTO ubication;

	}

	@Data
	public static class UbicationDTO implements Serializable {

		private static final long serialVersionUID = 1L;
		@NotNull
		@ApiModelProperty(example = "11111111")
		private String latitude;

		@NotNull
		@ApiModelProperty(example = "222222222")
		private String longitude;
	}

}
