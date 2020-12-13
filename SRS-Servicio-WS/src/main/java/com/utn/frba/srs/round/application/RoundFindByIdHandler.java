package com.utn.frba.srs.round.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utn.frba.srs.round.application.RoundFind.RoundQuery;
import com.utn.frba.srs.round.application.RoundFindByIdHandler.RoundFindByIdQuery;
import com.utn.frba.srs.round.domain.RoundRepository;
import com.utn.frba.srs.shared.domain.crqs.Query;
import com.utn.frba.srs.shared.domain.crqs.QueryHandler;

import lombok.AllArgsConstructor;
import lombok.Data;

@Service
public class RoundFindByIdHandler extends RoundFind implements QueryHandler<RoundQuery, RoundFindByIdQuery> {

	@Autowired
	public RoundFindByIdHandler(RoundRepository roundRepository) {
		super(roundRepository);
	}

	@Override
	public RoundQuery ask(RoundFindByIdQuery query) throws Exception {
		return roundMapper.roundToRoundQuery(round.findById(query.getId()));
	}

	@Data
	@AllArgsConstructor
	public static class RoundFindByIdQuery implements Query<RoundQuery> {
		private Long id;
	}

}
