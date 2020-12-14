package com.utn.frba.srs.shared.domain.crqs;

import com.utn.frba.srs.shared.domain.DomainException;

public interface QueryHandler<T,U extends Query<T>> {

    T ask(U query) throws DomainException;
}