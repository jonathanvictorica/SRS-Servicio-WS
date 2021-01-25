package com.utn.fbra.srs.domain.model.ronda;

import com.utn.fbra.srs.domain.model.rondaEjecucion.VigiladorVO;
import com.utn.fbra.srs.domain.vo.FechaHoraVO;
import com.utn.fbra.srs.domain.vo.IdVO;

public abstract class EventoRondaVO {

	private IdVO eventoRondaId;
	private VigiladorVO usuario;
	private FechaHoraVO fechaHora;

	public abstract String getTipoEvento();

	public EventoRondaVO(IdVO eventoRondaId, VigiladorVO usuario, FechaHoraVO fechaHora) {
		super();
		this.eventoRondaId = eventoRondaId;
		this.usuario = usuario;
		this.fechaHora = fechaHora;
	}
	
	

}
