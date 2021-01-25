package com.utn.fbra.srs.domain.model.rondaEjecucion;

import com.utn.fbra.srs.domain.vo.ComentarioVO;
import com.utn.fbra.srs.domain.vo.FechaHoraVO;
import com.utn.fbra.srs.shared.domain.AggregateRoot;

public class RondaEjecucionRevisionAR extends AggregateRoot	{

	private RondaEjecucionAR rondaEjecucion;
	private SupervisorVO supervisor;
	private ComentarioVO comentario;
	private FechaHoraVO fechaHora;
	
}
