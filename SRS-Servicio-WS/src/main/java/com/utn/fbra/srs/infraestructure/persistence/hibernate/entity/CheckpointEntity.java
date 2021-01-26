package com.utn.fbra.srs.infraestructure.persistence.hibernate.entity;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
	@Column(columnDefinition = "varchar(36)")
	private UUID id;

	@NotNull
	@Size(max = 25)
	@Column(nullable = false)
	private String nfcIdentification;

	@Embedded
	private Ubication ubication;

	private UUID subsidiaryId;

}
