package com.utn.fbra.srs.domain.model.rondaEjecucion;

import java.util.List;

import com.utn.fbra.srs.domain.model.ronda.EstadoRondaVO;
import com.utn.fbra.srs.domain.model.ronda.EventoRondaVO;
import com.utn.fbra.srs.domain.model.ronda.RondaAR;
import com.utn.fbra.srs.domain.repository.RepositoryFactory;
import com.utn.fbra.srs.domain.repository.RondaEjecucionRepository;
import com.utn.fbra.srs.domain.vo.FechaHoraVO;
import com.utn.fbra.srs.domain.vo.IdVO;
import com.utn.fbra.srs.domain.vo.NumeroVO;
import com.utn.fbra.srs.domain.vo.UbicacionVO;
import com.utn.fbra.srs.shared.domain.AggregateRoot;

public class RondaEjecucionAR extends AggregateRoot {

	private IdVO rondaEjecucionID;
	private VigiladorVO vigiladorID;
	private RondaAR ronda;
	private List<EventoRondaVO> eventosRonda;
	private EstadoRondaVO estadoRonda;
	private FechaHoraVO fechaHoraPlanificada;
	private UbicacionVO ubicacionVigilador;
	private NumeroVO milisegundosEjecucion;

	private static RondaEjecucionRepository getRondaEjecucionRepository() {
		return (RondaEjecucionRepository) RepositoryFactory.create("RondaEjecucionRepository");
	}

	public void iniciarRonda() {

	}

	public void finalizarRonda() {

	}

	public void notificarUbicacionVigilador(UbicacionVO ubicacion) {

	}

	public void notificarIncidente() {

	}

	public void marcharCheckpoint() {

	}
	
	public void marcarRondaRevisadaPorSupervisor() {
		
	}

	public boolean esRondaSinEjecutar() {
		return false;
	}

	private boolean validarRondaCompletada() {
		return true;
	}

	private boolean validarRondaSinIncidentes() {
		return false;
	}
	
	

}
