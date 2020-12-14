package com.utn.frba.srs.shared.infraestructure.persistence.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class Audit implements Serializable {

	private static final long serialVersionUID = 1L;
	@NotNull
	@Column(nullable = false)
	private Date creationDate = new Date();

	private Long creationUser_id;

	private Date modifierDateLast;

	private Long modifierUser_id;

}
