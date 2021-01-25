package com.utn.fbra.srs.domain.model.ronda;

import com.utn.fbra.srs.domain.model.rondaEjecucion.VigiladorVO;
import com.utn.fbra.srs.domain.vo.DescripcionVO;
import com.utn.fbra.srs.domain.vo.FechaHoraVO;
import com.utn.fbra.srs.domain.vo.IdVO;
import com.utn.fbra.srs.domain.vo.UbicacionVO;

public class EventoRondaIncidenteVO extends EventoRondaVO {

	private DescripcionVO descripcion;
	private UbicacionVO ubicacion;

	public EventoRondaIncidenteVO(IdVO eventoRondaId, VigiladorVO usuario, FechaHoraVO fechaHora,
			DescripcionVO descripcion, UbicacionVO ubicacion) {
		super(eventoRondaId, usuario, fechaHora);
		this.descripcion = descripcion;
		this.ubicacion = ubicacion;
	}

	@Override
	public String getTipoEvento() {
		return "INCIDENTE";
	}
}
