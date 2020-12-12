package com.utn.frba.srs.domain.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class Audit implements Serializable, Cloneable {

	private static final long serialVersionUID = 1L;
	@NotNull
	@Column(nullable = false)
	private Date creationDate = new Date();

	@ManyToOne(optional = false)
	@NotNull
	private SystemUser creationUser;

	private Date modifierDateLast;

	@ManyToOne(optional = true)
	private SystemUser modifierUserLast;

	@Override
	public Audit clone() {
		return new Audit(creationDate, creationUser, modifierDateLast, modifierUserLast);
	}

}
