package com.utn.frba.srs.user.infraestructure.persistence.hibernate.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.utn.frba.srs.infraestructure.controller.dto.UserDTO;
import com.utn.frba.srs.securitycompany.infraestructure.persistence.hibernate.entity.SecurityCompany;
import com.utn.frba.srs.shared.domain.SRSException;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "SECURITY004_SystemUser", uniqueConstraints = {
		@UniqueConstraint(name = "uk_documentType_documentNumber", columnNames = { "documentType", "documentNumber" }),
		@UniqueConstraint(name = "uk_nick", columnNames = { "nick" }) }, indexes = {
				@Index(name = "idx_documentType_documentNumber", columnList = "documentType,documentNumber"),
				@Index(name = "idx_nick", columnList = "nick") })
@NoArgsConstructor
@AllArgsConstructor
public class SystemUser implements Serializable{

	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY,optional = true)
	private SecurityCompany securityCompany;

	
	@NotNull(message = "{user.name.empty}")
	@Size(max = 50, message = "{user.name.size}")
	@Column(nullable = false)
	private String name;

	
	@NotNull(message = "{user.lastName.empty}")
	@Size(max = 50, message = "{user.lastName.size}")
	@Column(nullable = false)
	private String lastName;

	
	@NotNull(message = "{user.documentType.empty}")
	@Size(max = 4, message = "{user.documentType.size}")
	@Column(nullable = false)
	private String documentType;

	@NotNull
	@Size(max = 15)
	@Column(nullable = false)
	private String documentNumber;

	@NotNull
	@Size(max = 150)
	@Column(nullable = false)
	private String mail = "";

	
	@ManyToOne(fetch = FetchType.EAGER,optional = true )
	private SystemUserRol roleLevel1;

	@ManyToOne(fetch = FetchType.EAGER,optional = true)
	private SystemUserRol roleLevel2;

	@ManyToOne(fetch = FetchType.EAGER,optional = true)
	private SystemUserRol roleLevel3;

	/**
	 * Datos para la autenticacion del usuario final
	 */

	
	@NotNull
	@Size(max = 50)
	@Column(nullable = false)
	private String nick;

	
	@JsonIgnore
	@NotNull
	@Size(max = 50)
	@Column(nullable = false)
	private String password = "";

	@JsonIgnore
	@NotNull
	@PositiveOrZero
	@Column(nullable = false)
	private Integer fallidedIntentCount = 0;

	@JsonIgnore
	@NotNull
	@Column(nullable = false)
	private Boolean bloqueadedUser = false;

	@JsonIgnore
	@NotNull
	@Column(nullable = false)
	private Boolean active = true;

	public SystemUser(UserDTO userDTO, List<SystemUserRol> roles, SecurityCompany securityCompany) {
		this.name = userDTO.getName();
		this.lastName = userDTO.getLastName();
		this.securityCompany = securityCompany;
		this.mail = userDTO.getMail();
		this.nick = userDTO.getNick();
		this.documentNumber = userDTO.getDocumentNumber();
		this.documentType = userDTO.getDocumentType();
		this.roleLevel1 = roles.get(0);
		this.roleLevel2 = roles.size() > 1 ? roles.get(1) : null;
		this.roleLevel3 = roles.size() > 2 ? roles.get(2) : null;

	}

	public List<String> obtenerRoles() {
		List<String> roles = new ArrayList<>();
		if (roleLevel1 != null) {
			roles.add(roleLevel1.getName());
		}
		if (roleLevel2 != null) {
			roles.add(roleLevel2.getName());
		}
		if (roleLevel3 != null) {
			roles.add(roleLevel3.getName());
		}
		return roles;
	}

	public void acomodarRoles(List<SystemUserRol> roles) {
		if (roles == null)
			return;

		this.roleLevel1 = null;
		this.roleLevel2 = null;
		this.roleLevel3 = null;
		if (!roles.isEmpty())
			this.roleLevel1 = roles.get(0);
		if (roles.size() > 1)
			this.roleLevel2 = roles.get(1);
		if (roles.size() > 2)
			this.roleLevel3 = roles.get(2);

	}

	public void updating(UserDTO userDTO, List<SystemUserRol> roles) {
		this.name = userDTO.getName();
		this.lastName = userDTO.getLastName();
		this.mail = userDTO.getMail();
		this.nick = userDTO.getNick();
		this.documentNumber = userDTO.getDocumentNumber();
		this.documentType = userDTO.getDocumentType();
		this.roleLevel1 = roles.get(0);
		this.roleLevel2 = roles.size() > 1 ? roles.get(1) : null;
		this.roleLevel3 = roles.size() > 2 ? roles.get(2) : null;

	}

	public SystemUser(Long id) {
		super();
		this.id = id;
	}

	public void validatePassword(String password) throws SRSException {
		if(this.password.equals(password)) {
			throw new SRSException("La password no coincide");
		}
		
	}

}
