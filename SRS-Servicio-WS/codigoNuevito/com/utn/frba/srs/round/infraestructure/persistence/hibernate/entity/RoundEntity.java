package com.utn.frba.srs.round.infraestructure.persistence.hibernate.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.utn.frba.srs.shared.infraestructure.persistence.entity.Ubication;

import lombok.Data;

@Data
@Entity
@Table(name = "OPERATIONS005_Round", uniqueConstraints = {
		@UniqueConstraint(name = "uk_subsidiary_name", columnNames = { "subsidiary_id", "name" }) }, indexes = {
				@Index(name = "idx_subsidiary", columnList = "subsidiary_id") })
public class RoundEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, name = "subsidiary_id")
	private Long subsidiaryId;

	@NotNull
	@Size(max = 25)
	@Column(nullable = false)
	private String name;

	@NotNull
	@Size(max = 125)
	@Column(nullable = false)
	private String description;

	@OneToMany(mappedBy = "round", cascade = { CascadeType.PERSIST })
	@Fetch(FetchMode.SUBSELECT)
	private Set<RoundCheckpointEntity> checkpoints;

	@OneToMany(mappedBy = "round", cascade = { CascadeType.PERSIST })
	@Fetch(FetchMode.SUBSELECT)
	private Set<RoundRouteEntity> routes;

	@Embedded
	private Ubication ubication;

	@NotNull
	@Size(max = 25)
	@Column(nullable = false)
	private String zoomUbication = "0";

	@Positive
	private Integer roundTime;

	@NotNull
	@Column(nullable = false)
	private Boolean active = true;

	@PrePersist
	@PreUpdate
	public void complet() {
		if (checkpoints != null) {
			this.checkpoints.stream().forEach(a -> a.setRound(this));
		}
		if (routes != null) {
			this.routes.stream().forEach(a -> a.setRound(this));
		}
	}

}
