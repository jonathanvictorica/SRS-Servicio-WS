package com.utn.fbra.srs.domain.repository;

import com.utn.fbra.srs.shared.domain.AggregateRoot;

public interface Repository<E extends AggregateRoot,I> {
	void registrar(E ronda);

	void modificar(E ronda);

	void eliminar(E ronda);

	E findById(I id);
}
