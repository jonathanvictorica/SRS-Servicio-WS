package com.utn.fbra.srs.domain.model.ronda;

import com.utn.fbra.srs.domain.vo.IdVO;
import com.utn.fbra.srs.domain.vo.NumeroVO;
import com.utn.fbra.srs.domain.vo.UbicacionVO;
import com.utn.fbra.srs.shared.domain.ValueObject;

public class RondaCheckpointVO extends ValueObject {

	private IdVO checkpointId;
	private UbicacionVO ubicacion;
	private NumeroVO ordenEjecucion;

	private RondaCheckpointVO(IdVO checkpointId, UbicacionVO ubicacion, NumeroVO ordenEjecucion) {
		super();
		this.checkpointId = checkpointId;
		this.ubicacion = ubicacion;
		this.ordenEjecucion = ordenEjecucion;
	}

	public static RondaCheckpointVO crear(IdVO checkpointId, UbicacionVO ubicacion, NumeroVO ordenEjecucion) {
		RondaCheckpointVO checkpoint = new RondaCheckpointVO(checkpointId, ubicacion, ordenEjecucion);
		return checkpoint;
	}

}
