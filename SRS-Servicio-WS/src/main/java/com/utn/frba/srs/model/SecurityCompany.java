package com.utn.frba.srs.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.utn.frba.srs.controller.dto.EmpresaDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "OPERATIONS002_SecurityCompany",uniqueConstraints = {
		@UniqueConstraint(name = "uk_documentType_documentNumber", columnNames = { "documentType", "documentNumber" }),
		@UniqueConstraint(name = "uk_businessName", columnNames = { "businessName" }) }, indexes = {
				@Index(name = "idx_documentType_documentNumber", columnList = "documentType,documentNumber"),
				@Index(name = "idx_businessName", columnList = "businessName") })
public class SecurityCompany implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	@NotNull
	@Size(max = 100)
	@Column(nullable = false)
	private String businessName;

	@NotNull
	@Size(max = 4)
	@Column(nullable = false)
	private String documentType;

	@NotNull
	@Size(max = 15)
	@Column(nullable = false)
	private String documentNumber;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Domicile domicile;

	@NotNull
	@Column(nullable = false)
	private Boolean active = true;

	@Embedded
	private Audit audit;

	public SecurityCompany(EmpresaDTO request, SystemUser usuarioOperador) {
		// TODO Auto-generated constructor stub
	}

	public SecurityCompany(Long companyId) {
		this.id = companyId;
	}

}