package com.utn.fbra.srs.shared.domain;

import com.utn.fbra.srs.domain.DomainException;

public interface Repository<E extends AggregateRoot,I> {
	void registrar(E ronda);

	void modificar(E ronda);

	void eliminar(E ronda);

	E buscarPorId(I id) throws DomainException;
}
