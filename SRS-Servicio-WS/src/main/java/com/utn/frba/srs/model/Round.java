package com.utn.frba.srs.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
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

import com.utn.frba.srs.utils.Ubication;

import lombok.Data;

@Data
@Entity
@Table(name = "OPERATIONS005_Round",uniqueConstraints = {
		@UniqueConstraint(name = "uk_subsidiary_name", columnNames = { "subsidiary_id", "name" }) }, indexes = {
				@Index(name = "idx_subsidiary", columnList = "subsidiary_id") })
public class Round implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
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
	private RoundState roundState;

	@OneToMany(mappedBy = "round", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	private List<CheckpointRound> checkpoints;

	@OneToMany(mappedBy = "round", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	private List<RouteRound> routes;

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

}
