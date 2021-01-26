package com.utn.fbra.srs.domain.repository;

import java.util.List;

import com.utn.fbra.srs.domain.model.ronda.RondaAR;
import com.utn.fbra.srs.domain.vo.IdVO;
import com.utn.fbra.srs.shared.domain.Repository;

public interface RondaRepository extends Repository<RondaAR, IdVO> {

	List<RondaAR> buscarPorClienteID(IdVO clienteId);

}
