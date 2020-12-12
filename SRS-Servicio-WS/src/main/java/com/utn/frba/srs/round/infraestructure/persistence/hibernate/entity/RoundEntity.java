package com.utn.frba.srs.round.infraestructure.persistence.hibernate.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.utn.frba.srs.shared.infraestructure.persistence.entity.Audit;
import com.utn.frba.srs.shared.infraestructure.persistence.entity.Ubication;
import com.utn.frba.srs.subsidiary.infraestructure.persistence.hibernate.entity.Subsidiary;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "OPERATIONS005_Round", uniqueConstraints = {
		@UniqueConstraint(name = "uk_subsidiary_name", columnNames = { "subsidiary_id", "name" }) }, indexes = {
				@Index(name = "idx_subsidiary", columnList = "subsidiary_id") })
public class RoundEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.EAGER)
	private Subsidiary subsidiary;

	@NotNull
	@Size(max = 25)
	@Column(nullable = false)
	private String name;

	@NotNull
	@Size(max = 125)
	@Column(nullable = false)
	private String description;

	@ManyToOne
	private RoundStateEntity roundState;

	@OneToMany(mappedBy = "round", cascade = { CascadeType.PERSIST })
	@Fetch(FetchMode.SUBSELECT)
	private List<RoundCheckpointEntity> checkpoints;

	@OneToMany(mappedBy = "round", cascade = { CascadeType.PERSIST })
	@Fetch(FetchMode.SUBSELECT)
	private List<RoundRouteEntity> routes;

	@Embedded
	private Ubication ubication;

	@NotNull
	@Size(max = 25)
	@Column(nullable = false)
	private String zoomUbication = "0";

	@Positive
	private Integer roundTime;

	@Embedded
	private Audit audit;

	@NotNull
	@Column(nullable = false)
	private Boolean active = true;

	public void complet() {
		this.audit.setCreationDate(new Date());
		if (checkpoints != null) {
			this.checkpoints.stream().forEach(a -> a.setRound(this));
			this.checkpoints.stream().forEach(a -> a.setAudit(this.audit.clone()));
		}
		if (routes != null) {
			this.routes.stream().forEach(a -> a.setRound(this));
		}
		this.roundState = new RoundStateEntity("ACTIVE");
	}

}
