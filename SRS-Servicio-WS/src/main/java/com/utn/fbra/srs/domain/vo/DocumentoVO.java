package com.utn.fbra.srs.domain.vo;

import com.utn.fbra.srs.shared.domain.ValueObject;

public class DocumentoVO extends ValueObject {

	private TipoDocumentoVO tipoDocumento;
	private Long numeroDocumento;

	public DocumentoVO(TipoDocumentoVO tipoDocumento, Long numeroDocumento) {
		super();
		this.tipoDocumento = tipoDocumento;
		this.numeroDocumento = numeroDocumento;
	}

	public TipoDocumentoVO getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(TipoDocumentoVO tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public Long getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(Long numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

}
