package com.utn.fbra.srs.domain.model.ronda;

import com.utn.fbra.srs.domain.model.rondaEjecucion.VigiladorVO;
import com.utn.fbra.srs.domain.vo.FechaHoraVO;
import com.utn.fbra.srs.domain.vo.IdVO;

public class EventoRondaIniciarRondaVO extends EventoRondaVO {

	
	
	public EventoRondaIniciarRondaVO(IdVO eventoRondaId, VigiladorVO usuario, FechaHoraVO fechaHora) {
		super(eventoRondaId, usuario, fechaHora);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getTipoEvento() {
		return "INICIAR_RONDA";
	}
}
