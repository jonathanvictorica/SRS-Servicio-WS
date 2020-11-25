package com.utn.frba.srs.utils;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class Ubication {
	@Column
	private String latitude;
	@Column
	private String longitude;

}
