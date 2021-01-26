package com.utn.fbra.srs.domain.model.checkpoint;

import java.util.List;

import com.utn.fbra.srs.domain.DomainException;
import com.utn.fbra.srs.domain.repository.CheckpointRepository;
import com.utn.fbra.srs.domain.repository.RepositoryFactory;
import com.utn.fbra.srs.domain.vo.IdVO;
import com.utn.fbra.srs.domain.vo.NombreVO;
import com.utn.fbra.srs.domain.vo.NumeroVO;
import com.utn.fbra.srs.domain.vo.UbicacionVO;
import com.utn.fbra.srs.shared.domain.AggregateRoot;

public class CheckpointAR extends AggregateRoot {
	private IdVO checkpointId;
	private NombreVO codigoNFC;
	private UbicacionVO ubicacion;
	private IdVO clienteID;

	public CheckpointAR(IdVO checkpointId, NombreVO codigoNFC, UbicacionVO ubicacion, IdVO clienteID) {
		super();
		this.checkpointId = checkpointId;
		this.codigoNFC = codigoNFC;
		this.ubicacion = ubicacion;
		this.clienteID = clienteID;
	}

	private static CheckpointRepository getCheckpointRepository() {
		return (CheckpointRepository) RepositoryFactory.create("CheckpointRepository");
	}

	public static CheckpointAR buscarPorID(IdVO id) throws DomainException {
		return getCheckpointRepository().buscarPorId(id);
	}

	public static List<CheckpointAR> listarPorClienteID(IdVO clienteId) {
		return getCheckpointRepository().findByClienteID(clienteId);
	}
	
	public static List<CheckpointAR> listarPorUbicacionRadioClienteID(UbicacionVO ubicacionCentral, NumeroVO radio,IdVO clienteId) {
		return getCheckpointRepository().findByUbicacionAndRadioAndClienteID(ubicacionCentral,radio,clienteId);
	}

	public void registrar() throws DomainException {
		getCheckpointRepository().registrar(this);
	}

	public void modificar() throws DomainException {
		getCheckpointRepository().modificar(this);
	}

	public void eliminar() {
		getCheckpointRepository().eliminar(this);
	}

	public IdVO getCheckpointId() {
		return checkpointId;
	}

	public NombreVO getCodigoNFC() {
		return codigoNFC;
	}

	public UbicacionVO getUbicacion() {
		return ubicacion;
	}

	public IdVO getClienteID() {
		return clienteID;
	}

}
