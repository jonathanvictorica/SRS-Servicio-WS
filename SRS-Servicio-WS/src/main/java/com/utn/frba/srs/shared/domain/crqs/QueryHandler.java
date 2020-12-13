package com.utn.frba.srs.shared.domain.crqs;

public interface QueryHandler<T,U extends Query<T>> {

    T handle(U query) throws Exception;
}