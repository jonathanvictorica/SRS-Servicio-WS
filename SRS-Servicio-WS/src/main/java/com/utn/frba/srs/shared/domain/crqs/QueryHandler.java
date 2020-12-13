package com.utn.frba.srs.shared.domain.crqs;

public interface QueryHandler<T,U extends Query<T>> {

    T ask(U query) throws Exception;
}