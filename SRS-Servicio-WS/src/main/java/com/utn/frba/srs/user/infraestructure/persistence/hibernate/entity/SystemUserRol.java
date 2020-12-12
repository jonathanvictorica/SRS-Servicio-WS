package com.utn.frba.srs.user.infraestructure.persistence.hibernate.entity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "SECURITY002_SystemUserRol", uniqueConstraints = {
		@UniqueConstraint(name = "uk_name", columnNames = { "name" }) }, indexes = {
				@Index(name = "idx_name", columnList = "name") })
public class SystemUserRol implements Comparable<SystemUserRol>, Serializable {

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

	@NotNull
	@Positive
	@Column(nullable = false)
	private Integer level;

	@OneToMany(mappedBy = "rol", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	private List<FuncionalityRol> funcionalidades;

	@Override
	public int compareTo(SystemUserRol o) {

		return this.level.compareTo(o.level);
	}

	public static void deleteDuplicateRoles(List<SystemUserRol> roles) {
		Map<String, SystemUserRol> rolesSimples = new HashMap<String, SystemUserRol>();
		for (SystemUserRol rol : roles) {
			if (rol != null) {
				rolesSimples.put(rol.name, rol);
			}
		}
		roles.clear();
		roles.addAll(rolesSimples.values());

	}

}
