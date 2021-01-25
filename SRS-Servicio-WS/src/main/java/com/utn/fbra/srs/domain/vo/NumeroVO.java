package com.utn.fbra.srs.domain.vo;

import com.utn.fbra.srs.shared.domain.ValueObject;

public class NumeroVO extends ValueObject {

	private int numero = 0;

	public void incrementar(int i) {
		numero += i;

	}

	public void setear(int i) {
		numero = i;

	}

}
