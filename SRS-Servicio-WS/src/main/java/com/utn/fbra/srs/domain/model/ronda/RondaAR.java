package com.utn.fbra.srs.domain.model.ronda;

import java.util.List;

import com.utn.fbra.srs.domain.DomainException;
import com.utn.fbra.srs.domain.repository.RepositoryFactory;
import com.utn.fbra.srs.domain.repository.RondaRepository;
import com.utn.fbra.srs.domain.vo.IdVO;
import com.utn.fbra.srs.domain.vo.NombreVO;
import com.utn.fbra.srs.shared.domain.AggregateRoot;

public class RondaAR extends AggregateRoot {

	private IdVO rondaId;
	private NombreVO nombre;
	private RondaCheckpointsVO checkpoints;
	private RondaRutasVO rutas;
	private IdVO clienteEmpSegID;

	private static RondaRepository getRondaRepository() {
		return (RondaRepository) RepositoryFactory.create("RondaRepository");
	}

	public RondaAR(IdVO rondaId, NombreVO nombre, IdVO clienteEmpSegID) {
		super();
		this.rondaId = rondaId;
		this.nombre = nombre;
		this.clienteEmpSegID = clienteEmpSegID;
		this.checkpoints = new RondaCheckpointsVO();
		this.rutas = new RondaRutasVO();
	}

	public static RondaAR buscarPorID(IdVO id) throws DomainException {
		return getRondaRepository().buscarPorId(id);
	}

	public static List<RondaAR> listarPorClienteID(IdVO clienteId) {
		return getRondaRepository().buscarPorClienteID(clienteId);
	}

	public void agregarCheckpoint(RondaCheckpointVO checkpoint) {
		this.checkpoints.agregarCheckpoint(checkpoint);
	}

	public void eliminarCheckpoint(RondaCheckpointVO checkpoint) {
		this.checkpoints.eliminarCheckpoint(checkpoint);
	}

	public void modificarCheckpoints(List<RondaCheckpointVO> checkpoints) {
		this.checkpoints.modificarCheckpoints(checkpoints);
	}

	public void modificarRutas(List<RondaRutaVO> rutas) {
		this.rutas.modificarRutas(rutas);
	}

	public void cambiarNombre(NombreVO nombre) {
		this.nombre = nombre;
	}

	private void validarRonda() throws DomainException {
		this.checkpoints.validarCheckpoints();
		this.rutas.validarCaminoRonda();
	}

	public void registrar() throws DomainException {
		this.validarRonda();
		getRondaRepository().registrar(this);
	}

	public void modificar() throws DomainException {
		this.validarRonda();
		getRondaRepository().modificar(this);
	}

	public void eliminar() {
		getRondaRepository().eliminar(this);
	}

	public IdVO getRondaId() {
		return rondaId;
	}

	public NombreVO getNombre() {
		return nombre;
	}

	public List<RondaCheckpointVO> getCheckpoints() {
		return this.checkpoints.getCheckpoints();
	}

	public List<RondaRutaVO> getRutas() {
		return this.rutas.getRutas();
	}

	public IdVO getClienteEmpSegID() {
		return clienteEmpSegID;
	}

}
