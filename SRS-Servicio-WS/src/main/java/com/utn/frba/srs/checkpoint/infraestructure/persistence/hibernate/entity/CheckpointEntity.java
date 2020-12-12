package com.utn.frba.srs.checkpoint.infraestructure.persistence.hibernate.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.utn.frba.srs.shared.infraestructure.persistence.entity.Ubication;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "OPERATIONS001_Checkpoint", uniqueConstraints = {
		@UniqueConstraint(name = "uk_nfcIdentification", columnNames = { "nfcIdentification" }) }, indexes = {
				@Index(name = "idx_nfcIdentification", columnList = "nfcIdentification") })
@AllArgsConstructor
@NoArgsConstructor
public class CheckpointEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Size(max = 25)
	@Column(nullable = false)
	private String nfcIdentification;

	@Embedded
	private Ubication ubication;

	private Long subsidiary_id;

}
