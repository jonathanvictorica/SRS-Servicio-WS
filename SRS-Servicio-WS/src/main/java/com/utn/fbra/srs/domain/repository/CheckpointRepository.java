package com.utn.fbra.srs.domain.repository;

import java.util.List;

import com.utn.fbra.srs.domain.model.checkpoint.CheckpointAR;
import com.utn.fbra.srs.domain.vo.IdVO;
import com.utn.fbra.srs.domain.vo.NumeroVO;
import com.utn.fbra.srs.domain.vo.UbicacionVO;

public interface CheckpointRepository extends Repository<CheckpointAR,IdVO> {
	

	List<CheckpointAR> findByClienteID(IdVO clienteId);

	List<CheckpointAR> findByUbicacionAndRadioAndClienteID(UbicacionVO ubicacionCentral, NumeroVO radio, IdVO clienteId);
}
