package com.utn.frba.srs.infraestructure.controller.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class SubsidiaryDTO implements Serializable {

	private Long id;

	@NotNull
	@Size(max = 25)
	@ApiModelProperty(example = "name")
	private String name;

	@NotNull
	@Size(max = 125)
	@ApiModelProperty(example = "description")
	private String description;

	@NotNull
	@ApiModelProperty(example = "1")
	private Long securityCompanyId;
	
	@NotNull
	@ApiModelProperty(example = "1")
	private Long userId;

	private DomicileDTO domicile;

	@Data
	public static class DomicileDTO implements Serializable {
		@NotNull
		@Size(max = 100)
		@ApiModelProperty(example = "streetName")
		private String streetName;

		@NotNull
		@Size(max = 6)
		@ApiModelProperty(example = "123")
		private String streetNumber;

		@NotNull
		@Size(max = 50)
		@ApiModelProperty(example = "departamentName")
		private String departamentName;

		@NotNull
		@Size(max = 3)
		@ApiModelProperty(example = "10")
		private String floorNumber;

		@NotNull
		@Size(max = 50)
		@ApiModelProperty(example = "cityName")
		private String cityName;

		@NotNull
		@Size(max = 50)
		@ApiModelProperty(example = "partyName")
		private String partyName;

		@NotNull
		@Size(max = 50)
		@ApiModelProperty(example = "provinceName")
		private String provinceName;

		private UbicationDTO ubication;

		@Data
		public static class UbicationDTO implements Serializable  {
			@NotNull
			@ApiModelProperty(example = "11111111")
			private String latitude;

			@NotNull
			@ApiModelProperty(example = "222222222")
			private String longitude;
		}

	}

}
