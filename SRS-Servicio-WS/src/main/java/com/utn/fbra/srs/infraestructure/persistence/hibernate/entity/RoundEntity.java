package com.utn.fbra.srs.infraestructure.persistence.hibernate.entity;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.utn.fbra.srs.domain.model.ronda.RondaAR;
import com.utn.fbra.srs.domain.vo.IdVO;
import com.utn.fbra.srs.domain.vo.NombreVO;

import lombok.Data;

@Data
@Entity
@Table(name = "OPERATIONS005_Round", uniqueConstraints = {
		@UniqueConstraint(name = "uk_cliente_name", columnNames = { "cliente_id", "name" }) }, indexes = {
				@Index(name = "idx_cliente", columnList = "cliente_id") })
public class RoundEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private UUID id;

	@Column(nullable = false, name = "cliente_id")
	private UUID clienteID;

	@NotNull
	@Size(max = 25)
	@Column(nullable = false)
	private String name;

	@OneToMany(mappedBy = "round", cascade = { CascadeType.PERSIST })
	@Fetch(FetchMode.SUBSELECT)
	private Set<RoundCheckpointEntity> checkpoints;

	@OneToMany(mappedBy = "round", cascade = { CascadeType.PERSIST })
	@Fetch(FetchMode.SUBSELECT)
	private Set<RoundRouteEntity> routes;

	@NotNull
	@Column(nullable = false)
	private Boolean active = true;

	public static RondaAR fromEntity(RoundEntity entity) {
		try {
			RondaAR ronda = new RondaAR(new IdVO(entity.id), new NombreVO(entity.name), new IdVO(entity.clienteID));
			ronda.modificarCheckpoints(
					entity.checkpoints.stream().map(RoundCheckpointEntity::fromEntity).collect(Collectors.toList()));
			ronda.modificarRutas(entity.routes.stream().map(RoundRouteEntity::fromEntity).collect(Collectors.toList()));
			return ronda;
		} catch (Exception e) {
			return null;
		}
	}

	public static RoundEntity fromAggregateRoot(RondaAR aggregateRoot) {
		RoundEntity roundEntity = new RoundEntity();
		roundEntity.id = aggregateRoot.getRondaId().getId();
		roundEntity.active = true;
		roundEntity.checkpoints = aggregateRoot.getCheckpoints().stream().map(RoundCheckpointEntity::fromAggregateRoot)
				.collect(Collectors.toSet());
		roundEntity.name = aggregateRoot.getNombre().getValor();
		roundEntity.routes = aggregateRoot.getRutas().stream().map(RoundRouteEntity::fromAggregateRoot)
				.collect(Collectors.toSet());
		roundEntity.clienteID = aggregateRoot.getClienteEmpSegID().getId();
		return roundEntity;
	}

}
