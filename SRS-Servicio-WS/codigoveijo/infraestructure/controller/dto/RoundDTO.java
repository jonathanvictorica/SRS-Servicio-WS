package com.utn.frba.srs.infraestructure.controller.dto;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class RoundDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	@NotNull
	private RoundSubsidiaryDTO subsidiary;

	@NotNull
	@ApiModelProperty(example = "Nombre")
	private String name;

	@NotNull
	@ApiModelProperty(example = "descripcion")
	private String description;

	private RoundStateDTO roundState;

	@NotNull
	private List<RoundDTO.RoundCheckpointDTO> checkpoints;

	@NotNull
	private List<RoundDTO.RoundRouteDTO> routes;

	@NotNull
	private UbicationDTO ubication;

	@NotNull
	@ApiModelProperty(example = "0")
	private String zoomUbication = "0";

	@NotNull
	@ApiModelProperty(example = "1")
	private Integer roundTime;

	@NotNull
	@ApiModelProperty(example = "1")
	private Long userId;

	@Data
	public static class RoundSubsidiaryDTO implements Serializable {

		private static final long serialVersionUID = 1L;

		@NotNull
		@ApiModelProperty(example = "1")
		private Long id;

	}

	@Data
	public static class RoundStateDTO implements Serializable {

		private static final long serialVersionUID = 1L;

		@ApiModelProperty
		private String name;

	}

	@Data
	public static class RoundCheckpointDTO implements Serializable {

		private static final long serialVersionUID = 1L;

		@NotNull
		private RoundDTO.RoundCheckpointDTO.CheckpointDTO checkpoint;

		@ApiModelProperty(example = "1")
		@NotNull
		private Integer executionOrder;

		@Data
		public static class CheckpointDTO implements Serializable {
			private static final long serialVersionUID = 1L;

			@ApiModelProperty(example = "1")
			@NotNull
			private Long id;

		}

	}

	@Data
	public static class RoundRouteDTO implements Serializable {

		private static final long serialVersionUID = 1L;

		@ApiModelProperty(example = "1")
		@NotNull
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
