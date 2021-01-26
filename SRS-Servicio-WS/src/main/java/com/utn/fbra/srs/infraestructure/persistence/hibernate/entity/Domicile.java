package com.utn.fbra.srs.infraestructure.persistence.hibernate.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "OPERATIONS009_Domicile")
public class Domicile implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
    @Size(max = 100)
    @Column(nullable = false)
	private String streetName;
	
	@NotNull
    @Size(max = 6)
    @Column(nullable = false)
	private String streetNumber;
	
	@NotNull
    @Size(max = 50)
    @Column(nullable = false)
	private String departamentName;
	
	@NotNull
    @Size(max = 3)
    @Column(nullable = false)
	private String floorNumber;
	
	@NotNull
    @Size(max = 50)
    @Column(nullable = false)
	private String cityName;
	
	@NotNull
    @Size(max = 50)
    @Column(nullable = false)
	private String partyName;
	
	@NotNull
    @Size(max = 50)
    @Column(nullable = false)
	private String provinceName;
	
	@NotNull
    @Size(max = 50)
    @Column(nullable = false)
	private String countryName = "Argentina";
	
	@Embedded
	private Ubication ubication;

}
