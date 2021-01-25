package com.utn.fbra.srs.shared.application;

import java.util.List;

public interface QueryUseCase<E,ID> {

	public E buscarPorId(ID id) throws Exception;
	
	public List<E> listarTodos() throws Exception;
	
}
