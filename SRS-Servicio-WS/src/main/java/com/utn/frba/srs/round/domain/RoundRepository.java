package com.utn.frba.srs.round.domain;

public interface RoundRepository {

	boolean existsById(Long id);

	void deleteCheckpointsAndRoutes(Long id);

	void save(Round data);

	void delete(String id);

}
