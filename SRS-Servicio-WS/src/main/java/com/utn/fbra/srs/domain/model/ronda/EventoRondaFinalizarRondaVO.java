package com.utn.fbra.srs.domain.model.ronda;

import com.utn.fbra.srs.domain.model.rondaEjecucion.VigiladorVO;
import com.utn.fbra.srs.domain.vo.FechaHoraVO;
import com.utn.fbra.srs.domain.vo.IdVO;

public class EventoRondaFinalizarRondaVO extends EventoRondaVO {

	public EventoRondaFinalizarRondaVO(IdVO eventoRondaId, VigiladorVO usuario, FechaHoraVO fechaHora) {
		super(eventoRondaId, usuario, fechaHora);
	}

	@Override
	public String getTipoEvento() {
		return "FINALIZAR_RONDA";
	}

}
