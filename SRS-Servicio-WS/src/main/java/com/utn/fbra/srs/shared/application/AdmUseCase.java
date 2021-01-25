package com.utn.fbra.srs.shared.application;

public interface AdmUseCase<RC,RM,RE> {

	public void crear(RC request) throws Exception;
	
	public void modificar(RM request) throws Exception;
	
	public void eliminar(RE request) throws Exception;
}
