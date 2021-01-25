package com.utn.fbra.srs.infraestructure.persistence.hibernate.repository;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.utn.fbra.srs.domain.model.ronda.RondaAR;
import com.utn.fbra.srs.domain.repository.RondaRepository;
import com.utn.fbra.srs.domain.vo.IdVO;

public class RondaHibernate implements RondaRepository {

	
	@Override
	public void registrar(RondaAR ronda) {
		// TODO Auto-generated method stub

	}

	@Override
	public void modificar(RondaAR ronda) {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminar(RondaAR ronda) {
		// TODO Auto-generated method stub

	}

	@Override
	public RondaAR findById(IdVO id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RondaAR> findByClienteID(IdVO clienteId) {
		// TODO Auto-generated method stub
		return null;
	}

}
