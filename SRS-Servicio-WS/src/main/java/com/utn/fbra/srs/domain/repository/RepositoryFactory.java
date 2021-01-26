package com.utn.fbra.srs.domain.repository;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utn.fbra.srs.shared.domain.Repository;

@Service
public class RepositoryFactory {

	@Autowired
	private static CheckpointRepository checkpointRepository;
	@Autowired
	private static ClienteEmpSegRepository clienteEmpSegRepository;
	@Autowired
	private static EmpresaSeguridadRepository empresaSeguridadRepository;
	@Autowired
	private static RondaEjecucionRepository rondaEjecucionRepository;
	@Autowired
	private static RondaRepository rondaRepository;
	@Autowired
	private static UsuarioRepository usuarioRepository;

	private static HashMap<String, Repository> repositorios = null;

	public static Repository create(String nombre) {
		if (repositorios == null) {
			inicializacion();
		}
		return repositorios.get(nombre);
	}

	private static void inicializacion() {
		repositorios = new HashMap<>();
		repositorios.put("checkpointRepository", checkpointRepository);
		repositorios.put("clienteEmpSegRepository", clienteEmpSegRepository);
		repositorios.put("empresaSeguridadRepository", empresaSeguridadRepository);
		repositorios.put("rondaEjecucionRepository", rondaEjecucionRepository);
		repositorios.put("rondaRepository", rondaRepository);
		repositorios.put("usuarioRepository", usuarioRepository);

	}

}
