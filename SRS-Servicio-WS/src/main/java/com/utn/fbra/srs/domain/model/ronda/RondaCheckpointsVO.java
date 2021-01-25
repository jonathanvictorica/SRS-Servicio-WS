package com.utn.fbra.srs.domain.model.ronda;

import java.util.ArrayList;
import java.util.List;

import com.utn.fbra.srs.domain.DomainException;
import com.utn.fbra.srs.shared.domain.ValueObject;

public class RondaCheckpointsVO extends ValueObject {

	private List<RondaCheckpointVO> checkpointsRonda;

	public RondaCheckpointsVO() {
		this.checkpointsRonda = new ArrayList<>();
	}

	public void agregarCheckpoint(RondaCheckpointVO checkpoint) {
		this.checkpointsRonda.add(checkpoint);

	}

	public void eliminarCheckpoint(RondaCheckpointVO checkpoint) {
		this.checkpointsRonda.remove(checkpoint);

	}

	public void modificarCheckpoints(List<RondaCheckpointVO> checkpoints) {
		this.checkpointsRonda.clear();
		this.checkpointsRonda.addAll(checkpoints);
	}

	public void validarCheckpoints() throws DomainException {
		if (this.checkpointsRonda.size() < 2) {
			throw new DomainException("La ronda debe tener al menos 2 checkpoints");
		}

	}

	public List<RondaCheckpointVO> getCheckpoints() {
		return this.checkpointsRonda;
	}

}
