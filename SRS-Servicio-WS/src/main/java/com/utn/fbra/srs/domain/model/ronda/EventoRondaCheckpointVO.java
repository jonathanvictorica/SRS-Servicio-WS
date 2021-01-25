package com.utn.fbra.srs.domain.model.ronda;

import com.utn.fbra.srs.domain.model.checkpoint.CheckpointAR;
import com.utn.fbra.srs.domain.model.rondaEjecucion.VigiladorVO;
import com.utn.fbra.srs.domain.vo.FechaHoraVO;
import com.utn.fbra.srs.domain.vo.IdVO;

public class EventoRondaCheckpointVO extends EventoRondaVO {

	private CheckpointAR checkpoint;

	public EventoRondaCheckpointVO(IdVO eventoRondaId, VigiladorVO usuario, FechaHoraVO fechaHora,
			CheckpointAR checkpoint) {
		super(eventoRondaId, usuario, fechaHora);
		this.checkpoint = checkpoint;
	}

	@Override
	public String getTipoEvento() {
		return "CHECKPOINT";
	}

}
