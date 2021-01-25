package com.utn.fbra.srs.domain.vo;

import java.util.List;

public class PerfilVO {

	private String nombrePerfil;
	private List<FuncionalidadVO> funcionalidades;

	public PerfilVO(String nombrePerfil) {
		super();
		this.nombrePerfil = nombrePerfil;
	}

}
