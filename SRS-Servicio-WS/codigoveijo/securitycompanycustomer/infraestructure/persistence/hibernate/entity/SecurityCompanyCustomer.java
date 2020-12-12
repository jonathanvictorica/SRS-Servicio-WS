package com.utn.frba.srs.securitycompanycustomer.infraestructure.persistence.hibernate.entity;

import java.io.Serializable;

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
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.utn.frba.srs.securitycompany.infraestructure.persistence.hibernate.entity.SecurityCompany;
import com.utn.frba.srs.shared.infraestructure.persistence.entity.Audit;
import com.utn.frba.srs.shared.infraestructure.persistence.entity.Domicile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "OPERATIONS003_SecurityCompanyCustomer",uniqueConstraints = {
		@UniqueConstraint(name = "uk_documentType_documentNumber", columnNames = { "documentType", "documentNumber" }),
		@UniqueConstraint(name = "uk_businessName", columnNames = { "businessName" }) }, indexes = {
				@Index(name = "idx_documentType_documentNumber", columnList = "documentType,documentNumber"),
				@Index(name = "idx_businessName", columnList = "businessName"),
				@Index(name = "idx_securityCompany", columnList = "securityCompany_id")				
})
@AllArgsConstructor
@NoArgsConstructor
public class SecurityCompanyCustomer implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.EAGER)
	private SecurityCompany securityCompany;

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

	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private Domicile domicile;
	
	@NotNull
    @Column(nullable = false)
	private Boolean active = true;
	@Embedded
	private Audit audit;

}
