package com.utn.frba.srs.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.utn.frba.srs.utils.Ubication;

import lombok.Data;

@Data
@Entity
@Table(name = "OPERATIONS001_Checkpoint",uniqueConstraints = { @UniqueConstraint(name = "uk_nfcIdentification", columnNames = { "nfcIdentification" }) }, indexes = {
		@Index(name = "idx_nfcIdentification", columnList = "nfcIdentification") })
public class Checkpoint implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	@NotNull
	@Size(max = 25)
	@Column(nullable = false)
	private String nfcIdentification;

	@Embedded
	private Ubication ubication;

	@Embedded
	private Audit audit;

	@ManyToOne(fetch = FetchType.EAGER)
	private Subsidiary subsidiary;

}
