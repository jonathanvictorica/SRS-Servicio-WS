package com.utn.frba.srs.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.NotNull;

import com.utn.frba.srs.utils.FechaUtils;

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
	private Date creationDate;

	@ManyToOne(optional = false)
	@NotNull
	// TODO: Para evitar referencias circulares
//	 @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
//    @JsonIdentityReference(alwaysAsId = true)
	private SystemUser creationUser;
	private Date modifierDateLast;

	@ManyToOne(optional = true)
	private SystemUser modifierUserLast;

	
	@PrePersist
	public void updateCreationDate() {
		this.creationDate=new Date();
	}
	
	@PreUpdate
	public void updateModifierDate() {
		this.modifierDateLast=new Date();
	}
}
