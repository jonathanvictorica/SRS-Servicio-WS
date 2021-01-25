package com.utn.frba.srs.subsidiary.infraestructure.persistence.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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

import com.utn.frba.srs.shared.infraestructure.persistence.entity.Domicile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "OPERATIONS004_Subsidiary", uniqueConstraints = {
		@UniqueConstraint(name = "uk_securityCompanyCustomer_name", columnNames = { "securityCompanyCustomer_id",
				"name" }), }, indexes = {
						@Index(name = "idx_securityCompanyCustomer_name", columnList = "securityCompanyCustomer_id,name") })
@NoArgsConstructor
@AllArgsConstructor
public class SubsidiaryEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Size(max = 25)
	@Column(nullable = false)
	private String name;

	@NotNull
	@Size(max = 125)
	@Column(nullable = false)
	private String description;

	@Column(nullable = false,name = "securityCompanyCustomer_id")
	private Long securityCompanyCustomerId;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Domicile domicile;

	@NotNull
	private Boolean active = true;
}
