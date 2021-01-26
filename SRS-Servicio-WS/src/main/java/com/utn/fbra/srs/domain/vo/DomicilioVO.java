package com.utn.fbra.srs.domain.vo;

import com.utn.fbra.srs.shared.domain.ValueObject;

public class DomicilioVO  extends ValueObject  {

	
	private String provincia;
	private String ciudad;
	private String calle;
	private String altura;
	private String piso;
	private String departamento;
	public DomicilioVO(String provincia, String ciudad, String calle, String altura, String piso, String departamento) {
		super();
		this.provincia = provincia;
		this.ciudad = ciudad;
		this.calle = calle;
		this.altura = altura;
		this.piso = piso;
		this.departamento = departamento;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public String getAltura() {
		return altura;
	}
	public void setAltura(String altura) {
		this.altura = altura;
	}
	public String getPiso() {
		return piso;
	}
	public void setPiso(String piso) {
		this.piso = piso;
	}
	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	
	
	
}
