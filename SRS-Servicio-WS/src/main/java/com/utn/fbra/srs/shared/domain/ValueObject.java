package com.utn.fbra.srs.shared.domain;

public abstract class ValueObject<E> {

	protected E valor;

	public E getValor() {
		return valor;
	}

	public void setValor(E valor) {
		this.valor = valor;
	}
	
	
}
