package com.utn.fbra.srs.domain.vo;

public class FlagVO {

	public static final FlagVO TRUE = new FlagVO(true);

	public static final FlagVO FALSE = new FlagVO(false);

	public FlagVO(boolean b) {
		this.flag = b;
	}

	private Boolean flag;
}
